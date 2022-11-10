/*
 * Copyright(c) 2015-2022 VEMIDaS
 */
package jp.vemi.mirel.apps.quuty.domain.api;

import java.util.Map;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.vemi.framework.exeption.MirelSystemException;
import jp.vemi.framework.util.InstanceUtil;
import jp.vemi.mirel.apps.quuty.domain.dto.GetWorkitemsParameter;
import jp.vemi.mirel.apps.quuty.domain.service.GetWorkitemsService;
import jp.vemi.mirel.foundation.web.api.dto.ApiRequest;
import jp.vemi.mirel.foundation.web.api.dto.ApiResponse;

/**
 * 作業項目の取得.<br/>
 */
@Service
@Generated(value = {"jp.vemi.ste.domain.engine.TemplateEngineProcessor"}, comments = "Generated from /mirel/service:220309A")
public class GetWorkitemsApi extends AbstractQuutyApi {

    @Autowired
    protected GetWorkitemsService service;

    public ApiResponse<?> service(Map<String, Object> request) {

        Map<String, Object> requestContent = InstanceUtil.forceCast(request.get("content"));
        if (null == requestContent) {
            throw new MirelSystemException(new IllegalArgumentException("parameter request content."));
        }

        GetWorkitemsParameter parameter = GetWorkitemsParameter.builder()
                // mapping //
                // sample
                // .entityId((String) requestContent.get("entityId"))
                // build
                .build();

        ApiResponse<?> response = service.invoke(ApiRequest.<GetWorkitemsParameter>builder().model(parameter).build());
        return response;
    }

}
