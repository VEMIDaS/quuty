/*
 * Copyright(c) 2015-2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.domain.service;

import javax.annotation.Generated;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.vemi.mirel.apps.quuty.domain.dto.SaveWorkitemParameter;
import jp.vemi.mirel.apps.quuty.domain.dto.SaveWorkitemResult;
import jp.vemi.mirel.foundation.web.api.dto.ApiRequest;
import jp.vemi.mirel.foundation.web.api.dto.ApiResponse;

/**
 * {@link SaveWorkitemService 作業項目の登録} の具象です。
 */
@Service
@Transactional
@Generated(value = {"jp.vemi.ste.domain.engine.TemplateEngineProcessor"}, comments = "Generated from /mirel/service:220309A")
public class SaveWorkitemServiceImp implements SaveWorkitemService {

    /**
     * {@inheritDoc}
     */
    @Override
    public ApiResponse<SaveWorkitemResult> invoke(ApiRequest<SaveWorkitemParameter> parameter) {

        ApiResponse<SaveWorkitemResult> resp = ApiResponse.<SaveWorkitemResult>builder().build();

        // TODO implementation.
        resp.setModel(SaveWorkitemResult.builder().build());

        return resp;

    }
}
