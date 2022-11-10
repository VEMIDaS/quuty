/*
 * Copyright(c) 2015-2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.domain.service;

import javax.annotation.Generated;

import jp.vemi.mirel.apps.quuty.domain.dto.SaveWorkitemParameter;
import jp.vemi.mirel.apps.quuty.domain.dto.SaveWorkitemResult;
import jp.vemi.mirel.foundation.web.api.dto.ApiRequest;
import jp.vemi.mirel.foundation.web.api.dto.ApiResponse;

/**
 * {@link SaveWorkitemService 作業項目の登録}.<br/>
 */
@Generated(value = {"jp.vemi.ste.domain.engine.TemplateEngineProcessor"}, comments = "Generated from /mirel/service:220309A")
public interface SaveWorkitemService {

    /**
     * invoke.<br/>
     * @param parameter
     * @return result
     */
    public abstract ApiResponse<SaveWorkitemResult> invoke(ApiRequest<SaveWorkitemParameter> parameter);
}
