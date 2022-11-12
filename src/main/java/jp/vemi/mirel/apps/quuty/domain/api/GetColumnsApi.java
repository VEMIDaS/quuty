/*
 * Copyright(c) 2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.domain.api;

import java.util.Map;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.vemi.framework.exeption.MirelSystemException;
import jp.vemi.framework.util.InstanceUtil;
import jp.vemi.mirel.apps.quuty.domain.dto.GetColumnsParameter;
import jp.vemi.mirel.apps.quuty.domain.service.GetColumnsService;
import jp.vemi.mirel.foundation.web.api.dto.ApiRequest;
import jp.vemi.mirel.foundation.web.api.dto.ApiResponse;

/**
 * カラム取得.<br/>
 */
@Service
@Generated(value = {"jp.vemi.ste.domain.engine.TemplateEngineProcessor"}, comments = "Generated from /mirel/service:220309A")
public class GetColumnsApi extends AbstractQuutyApi {

    @Autowired
    protected GetColumnsService service;

    public ApiResponse<?> service(Map<String, Object> request) {

        Map<String, Object> requestContent = InstanceUtil.forceCast(request.get("content"));
        if (null == requestContent) {
            throw new MirelSystemException(new IllegalArgumentException("parameter request content."));
        }

        GetColumnsParameter parameter = GetColumnsParameter.builder()
                // mapping //
                // sample
                // .entityId((String) requestContent.get("entityId"))
                // build
                .build();

        ApiResponse<?> response = service.invoke(ApiRequest.<GetColumnsParameter>builder().model(parameter).build());
        return response;
    }

}
