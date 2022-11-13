/*
 * Copyright(c) 2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.domain.facade;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import jp.vemi.framework.exeption.MirelApplicationException;
import jp.vemi.mirel.apps.quuty.domain.dao.entity.MWorkitemColumn;
import jp.vemi.mirel.apps.quuty.domain.dao.entity.TWorkitem;
import jp.vemi.mirel.apps.quuty.domain.dao.entity.TWorkitemData;
import jp.vemi.mirel.apps.quuty.domain.dao.repository.MWorkitemColumnRepository;
import jp.vemi.mirel.apps.quuty.domain.dao.repository.MWorkitemTypeRepository;
import jp.vemi.mirel.apps.quuty.domain.dao.repository.TWorkitemDataRepository;
import jp.vemi.mirel.apps.quuty.domain.dao.repository.TWorkitemRepository;
import jp.vemi.mirel.apps.quuty.domain.facade.enumeration.ColumnType;

@Service
public class QuutyWorkitemEngine {

  /** {@link TWorkitemRepository} */
  @Autowired()
  TWorkitemRepository tWorkitemRepository;

  /** {@link TWorkitemData} */
  @Autowired
  TWorkitemDataRepository tWorkitemDataRepository;

  /** {@link MWorkitemTypeRepository} */
  @Autowired()
  MWorkitemTypeRepository mWorkitemTypeRepository;

  /** {@link MWorkitemColumnRepository} */
  @Autowired
  MWorkitemColumnRepository mWorkitemColumnRepository;

  /** {@link DozerBeanMapper Mapper.} */
  DozerBeanMapper mapper = new DozerBeanMapper();

  /**
   * Workitemの取得.<br/>
   * 
   * @param projectId  プロジェクトID
   * @param workitemId 作業項目ID
   * @return
   */
  public Map<String, Object> get(String projectId, String workitemId) {

    // Get workitem.
    Example<TWorkitem> tWorkitemExample = Example
        .of(TWorkitem.builder().projectId(projectId).workitemId(workitemId).build());
    Optional<TWorkitem> tWorkitemOp = tWorkitemRepository.findOne(tWorkitemExample);
    if (false == tWorkitemOp.isPresent()) {
      throw new MirelApplicationException();
    }

    // Convert to map.
    TWorkitem tWorkitem = tWorkitemOp.get();
    @SuppressWarnings("unchecked")
    Map<String, Object> transaction = mapper.map(tWorkitem, Map.class);

    // Define column type.
    Example<MWorkitemColumn> mWorkitemColumnExample = Example
        .of(MWorkitemColumn.builder().pk(MWorkitemColumn.PK.builder().projectId(projectId).build()).build());
    List<MWorkitemColumn> mWorkitemColumns = mWorkitemColumnRepository.findAll(mWorkitemColumnExample);
    Map<String, ColumnType> columnDefs = Maps.newHashMap();
    for (MWorkitemColumn mWorkitemColumn : mWorkitemColumns) {
      columnDefs.put(mWorkitemColumn.getPk().getColumnId(), mWorkitemColumn.getColumnType());
    }

    // Get addictional data.
    Example<TWorkitemData> tWorkitemDataExample = Example
        .of(TWorkitemData.builder()
            .pk(TWorkitemData.PK.builder().id(tWorkitem.getId()).revision(tWorkitem.getRevision()).build()).build());
    List<TWorkitemData> tWorkitemDatas = tWorkitemDataRepository.findAll(tWorkitemDataExample);
    for (TWorkitemData tWorkitemData : tWorkitemDatas) {
      ColumnType columnType = columnDefs.get(tWorkitemData.getColumnCd());
      Object data = byteDataToObject(columnType, tWorkitemData.getData());
      transaction.put(tWorkitemData.getColumnCd(), data);
    }

    return transaction;
  }

  /**
   * カラムの取得.<br/>
   * 
   * @param projectId プロジェクトID
   * @return {@link List<Map<String, Object>> カラム情報}
   */
  public List<Map<String, Object>> getColuimns(String projectId) {

    Example<MWorkitemColumn> example = Example
        .of(MWorkitemColumn.builder().pk(MWorkitemColumn.PK.builder().projectId(projectId).build()).build());
    List<MWorkitemColumn> mWorkitemColumns = mWorkitemColumnRepository.findAll(example);

    List<Map<String, Object>> maps = Lists.newArrayList();

    for (MWorkitemColumn mWorkitemColumn : mWorkitemColumns) {
      maps.add(columnToMap(mWorkitemColumn));
    }

    return maps;
  }

  /**
   * Mapへの変換.<br/>
   * 
   * @param mWorkitemColumn {@link MWorkitemColumn}
   * @return {@link Map<String, Object>}
   */
  private Map<String, Object> columnToMap(MWorkitemColumn mWorkitemColumn) {
    Map<String, Object> map = Maps.newLinkedHashMap();
    map.put("key", mWorkitemColumn.getPk().getColumnId());
    map.put("name", mWorkitemColumn.getColumnName());
    map.put("fieldName", mWorkitemColumn.getColumnName());
    map.put("minWidth", 100);
    map.put("maxWidth", 200);
    map.put("isResizable", true);
    return map;
  }

  private Object byteDataToObject(ColumnType columnType, byte[] data) {

    // No define -> Null.
    if (null == columnType) {
      return null;
    }

    // No data -> null.
    if (0 == data.length) {
      return null;
    }

    // convert.
    switch (columnType) {
      case TEXT_SINGLE_LINE:
      case PICKING_LIST_STRING:
      case PICKING_LIST_INTEGER:
      case INTEGER:
      case USER:
        return new String(data);
      case BOOLEAN:
        return ("true").equals(new String(data));
      case TEXT_MULTI_LINES:
        return convertMultiLines(data);
      default:
        return null;
    }
  }

  private Object convertMultiLines(byte[] data) {
    return data;
  }
}
