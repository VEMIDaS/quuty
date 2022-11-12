/*
 * Copyright(c) 2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.domain.service;

import javax.annotation.Generated;

import jp.vemi.mirel.apps.quuty.domain.dto.GetColumnsParameter;
import jp.vemi.mirel.apps.quuty.domain.dto.GetColumnsResult;
import jp.vemi.mirel.foundation.web.api.dto.ApiRequest;
import jp.vemi.mirel.foundation.web.api.dto.ApiResponse;

/**
 * {@link GetColumnsService カラム取得}.<br/>
 */
@Generated(value = {"jp.vemi.ste.domain.engine.TemplateEngineProcessor"}, comments = "Generated from /mirel/service:220309A")
public interface GetColumnsService {

    /**
     * invoke.<br/>
     * @param parameter
     * @return result
     */
    public abstract ApiResponse<GetColumnsResult> invoke(ApiRequest<GetColumnsParameter> parameter);
}
