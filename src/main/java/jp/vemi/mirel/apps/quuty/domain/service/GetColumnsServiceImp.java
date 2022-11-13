/*
 * Copyright(c) 2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.domain.service;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.vemi.mirel.apps.quuty.domain.dto.GetColumnsParameter;
import jp.vemi.mirel.apps.quuty.domain.dto.GetColumnsResult;
import jp.vemi.mirel.apps.quuty.domain.facade.QuutyWorkitemEngine;
import jp.vemi.mirel.foundation.web.api.dto.ApiRequest;
import jp.vemi.mirel.foundation.web.api.dto.ApiResponse;

/**
 * {@link GetColumnsService カラム取得} の具象です。
 */
@Service
@Transactional
@Generated(value = {"jp.vemi.ste.domain.engine.TemplateEngineProcessor"}, comments = "Generated from /mirel/service:220309A")
public class GetColumnsServiceImp implements GetColumnsService {

    /** {@link QuutyWorkitemEngine} */
    @Autowired()
    QuutyWorkitemEngine quutyWorkitemEngine;

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse<GetColumnsResult> invoke(ApiRequest<GetColumnsParameter> parameter) {

        quutyWorkitemEngine.getColuimns(parameter.getModel().getProjectId());

        ApiResponse<GetColumnsResult> resp = ApiResponse.<GetColumnsResult>builder().build();
        resp.setModel(GetColumnsResult.builder().build());

        return resp;

    }
}
