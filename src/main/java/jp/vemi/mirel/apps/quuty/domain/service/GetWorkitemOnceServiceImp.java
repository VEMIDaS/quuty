/*
 * Copyright(c) 2015-2022 VEMIDaS
 */
package jp.vemi.mirel.apps.quuty.domain.service;

import javax.annotation.Generated;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.vemi.mirel.apps.quuty.domain.dto.GetWorkitemOnceParameter;
import jp.vemi.mirel.apps.quuty.domain.dto.GetWorkitemOnceResult;
import jp.vemi.mirel.foundation.web.api.dto.ApiRequest;
import jp.vemi.mirel.foundation.web.api.dto.ApiResponse;

/**
 * {@link GetWorkitemOnceService 1件の作業項目の取得} の具象です。
 */
@Service
@Transactional
@Generated(value = {"jp.vemi.ste.domain.engine.TemplateEngineProcessor"}, comments = "Generated from /mirel/service:220309A")
public class GetWorkitemOnceServiceImp implements GetWorkitemOnceService {

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse<GetWorkitemOnceResult> invoke(ApiRequest<GetWorkitemOnceParameter> parameter) {

        ApiResponse<GetWorkitemOnceResult> resp = ApiResponse.<GetWorkitemOnceResult>builder().build();

        // TODO implementation.
        resp.setModel(GetWorkitemOnceResult.builder().build());

        return resp;

    }
}
