/*
 * Copyright(c) 2022 mirelplatform.
 */
package jp.vemi.mirel.apps.quuty.domain.api;

import java.util.Map;

import jp.vemi.framework.exeption.MirelSystemException;
import jp.vemi.framework.util.InstanceUtil;
import jp.vemi.mirel.foundation.web.api.dto.ApiIfBase;
import jp.vemi.mirel.foundation.web.api.dto.ApiResponse;

public class AbstractQuutyApi implements ApiIfBase {
  protected static Map<String, Object> requestContent(Map<String, Object> request) {

    Map<String, Object> requestContent = InstanceUtil.forceCast(request.get("content"));
    if (null == requestContent) {
      throw new MirelSystemException(new IllegalArgumentException("parameter request content."));
    }

    return requestContent;
  }

  @Override
  public ApiResponse<?> service(Map<String, Object> request) {
    throw new MirelSystemException();
  }

}
