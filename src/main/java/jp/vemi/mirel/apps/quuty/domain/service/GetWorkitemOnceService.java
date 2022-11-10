/*
 * Copyright(c) 2015-2022 VEMIDaS
 */
package jp.vemi.mirel.apps.quuty.domain.service;

import javax.annotation.Generated;

import jp.vemi.mirel.apps.quuty.domain.dto.GetWorkitemOnceParameter;
import jp.vemi.mirel.apps.quuty.domain.dto.GetWorkitemOnceResult;
import jp.vemi.mirel.foundation.web.api.dto.ApiRequest;
import jp.vemi.mirel.foundation.web.api.dto.ApiResponse;

/**
 * {@link GetWorkitemOnceService 1件の作業項目の取得}.<br/>
 */
@Generated(value = {"jp.vemi.ste.domain.engine.TemplateEngineProcessor"}, comments = "Generated from /mirel/service:220309A")
public interface GetWorkitemOnceService {

    /**
     * invoke.<br/>
     * @param parameter
     * @return result
     */
    public abstract ApiResponse<GetWorkitemOnceResult> invoke(ApiRequest<GetWorkitemOnceParameter> parameter);
}
