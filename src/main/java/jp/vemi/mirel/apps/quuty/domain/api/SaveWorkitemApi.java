/*
 * Copyright(c) 2015-2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.domain.api;

import java.util.Map;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.vemi.framework.exeption.MirelSystemException;
import jp.vemi.framework.util.InstanceUtil;
import jp.vemi.mirel.apps.quuty.domain.dto.SaveWorkitemParameter;
import jp.vemi.mirel.apps.quuty.domain.service.SaveWorkitemService;
import jp.vemi.mirel.foundation.web.api.dto.ApiRequest;
import jp.vemi.mirel.foundation.web.api.dto.ApiResponse;

/**
 * 作業項目の登録.<br/>
 */
@Service
@Generated(value = {"jp.vemi.ste.domain.engine.TemplateEngineProcessor"}, comments = "Generated from /mirel/service:220309A")
public class SaveWorkitemApi extends AbstractQuutyApi {

    @Autowired
    protected SaveWorkitemService service;

    public ApiResponse<?> service(Map<String, Object> request) {

        Map<String, Object> requestContent = InstanceUtil.forceCast(request.get("content"));
        if (null == requestContent) {
            throw new MirelSystemException(new IllegalArgumentException("parameter request content."));
        }

        SaveWorkitemParameter parameter = SaveWorkitemParameter.builder()
                // mapping //
                // sample
                // .entityId((String) requestContent.get("entityId"))
                // build
                .build();

        ApiResponse<?> response = service.invoke(ApiRequest.<SaveWorkitemParameter>builder().model(parameter).build());
        return response;
    }

}
