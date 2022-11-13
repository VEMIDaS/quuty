/*
 * Copyright(c) 2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.domain.dto;

import javax.annotation.Generated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * カラム取得 パラメータクラス.<br/>
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Generated(value = {"jp.vemi.ste.domain.engine.TemplateEngineProcessor"}, comments = "Generated from /mirel/service:220309A")
public class GetColumnsParameter {
  String projectId;
}
