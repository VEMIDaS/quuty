/*
 * Copyright(c) 2015-2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.domain.dto;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 作業項目の登録 結果クラス.<br/>
 */
@Setter
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Generated(value = {"jp.vemi.ste.domain.engine.TemplateEngineProcessor"}, comments = "Generated from /mirel/service:220309A")
public class SaveWorkitemResult {


  /**
  * {@inheritDoc}
  */
  @Override
  public String toString() {
      return ToStringBuilder.reflectionToString(this);
  }

}
