/*
 * Copyright(c) 2022 mirelplatform.
 */
package jp.vemi.framework.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import jp.vemi.mirel.foundation.web.api.dto.ApiResponse;

@RestController
@RequestMapping("auth2/")
public class MirelSecurityController {

  @Autowired
  MirelUserDetailsService service;

  @RequestMapping("/login")
  public ResponseEntity<ApiResponse<?>> login(@RequestBody Map<String, Object> request) {
    try {
      Object userCdObject = request.get("userCd");
      String userCd = userCdObject instanceof String ? (String) userCdObject : "";
      // UserDetails userDetails =
      service.loadUserByUsername(userCd);
      return new ResponseEntity<>(ApiResponse.builder().build(), HttpStatus.OK);
    } catch (RuntimeException e) {
      e.printStackTrace();
      return new ResponseEntity<>(ApiResponse.builder().errs(
          Lists.newArrayList(e.getLocalizedMessage())).build(),
          HttpStatus.OK);
    }
  }
}
