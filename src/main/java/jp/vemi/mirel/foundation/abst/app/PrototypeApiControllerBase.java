package jp.vemi.mirel.foundation.abst.app;

import com.google.common.base.CaseFormat;

public abstract class PrototypeApiControllerBase {

  private static String FQCN_BASE = "jp.vemi.mirel.apps";

  protected static String getApiFqcnName(String appId, String apiName) {
    String uccApiName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, apiName);
    return FQCN_BASE + "." + appId + "." + "domain.api." + uccApiName + "Api";
  }
}
