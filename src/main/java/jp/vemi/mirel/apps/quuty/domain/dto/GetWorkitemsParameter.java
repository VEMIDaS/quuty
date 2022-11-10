/*
 * Copyright(c) 2015-2022 VEMIDaS
 */
package jp.vemi.mirel.apps.quuty.domain.dto;

import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 作業項目の取得 パラメータクラス.<br/>
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Generated(value = {"jp.vemi.ste.domain.engine.TemplateEngineProcessor"}, comments = "Generated from /mirel/service:220309A")
public class GetWorkitemsParameter {
  /**
   * params
   */
  public List<Map<String, Object>> params;
}
