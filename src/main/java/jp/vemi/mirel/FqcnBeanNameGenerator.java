/*
 * Copyright(c) 2022 vemi/mirelplatform.
 */

package jp.vemi.mirel;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * コンポーネント名をFQCNに変換するBeanNameGenerator
 */
public class FqcnBeanNameGenerator extends AnnotationBeanNameGenerator {

  /*
   * 完全修飾しを返す
   */
  @Override
  protected String buildDefaultBeanName(BeanDefinition definition) {
    return definition.getBeanClassName();
  }
}
