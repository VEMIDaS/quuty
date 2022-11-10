/*
 * Copyright(c) 2015-2022 VEMIDaS
 */
package jp.vemi.mirel.apps.quuty.domain.service;

import javax.annotation.Generated;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.vemi.mirel.apps.quuty.domain.dto.GetWorkitemsParameter;
import jp.vemi.mirel.apps.quuty.domain.dto.GetWorkitemsResult;
import jp.vemi.mirel.foundation.web.api.dto.ApiRequest;
import jp.vemi.mirel.foundation.web.api.dto.ApiResponse;

/**
 * {@link GetWorkitemsService 作業項目の取得} の具象です。
 */
@Service
@Transactional
@Generated(value = {"jp.vemi.ste.domain.engine.TemplateEngineProcessor"}, comments = "Generated from /mirel/service:220309A")
public class GetWorkitemsServiceImp implements GetWorkitemsService {

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse<GetWorkitemsResult> invoke(ApiRequest<GetWorkitemsParameter> parameter) {

        ApiResponse<GetWorkitemsResult> resp = ApiResponse.<GetWorkitemsResult>builder().build();

        // TODO implementation.
        resp.setModel(GetWorkitemsResult.builder().build());

        return resp;

    }
}
