/*
 * Copyright(c) 2022 VEMIDaS.
 */
package jp.vemi.mirel.apps.quuty.application;

import java.util.Map;

import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.vemi.mirel.apps.quuty.domain.api.AbstractQuutyApi;
import jp.vemi.mirel.foundation.abst.app.PrototypeApiControllerBase;
import jp.vemi.mirel.foundation.web.api.dto.ApiResponse;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("apps/quuty/api")
public class QuutyApiController extends PrototypeApiControllerBase {

    @Autowired()
    private Map<String, AbstractQuutyApi> apis;

    // このコントローラーは開発用の汎用コントローラです。
    // 実際のエンタープライズ版では、正しく RESTful API を実装される必要があります。
    @RequestMapping("/{path}")
    public ResponseEntity<ApiResponse<?>> index(@RequestBody Map<String, Object> request,
            @PathVariable String path) {

        String apiName = getApiFqcnName("quuty", path);

        if (false == apis.containsKey(apiName)) {
            return new ResponseEntity<>(ApiResponse.builder().errs(
                    Lists.newArrayList(apiName + " api not found.")).build(),
                    HttpStatus.OK);
        }

        AbstractQuutyApi api = apis.get(apiName);
        System.out.println(request);

        ApiResponse<?> body;
        try {
            body = api.service(request);

        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity<>(ApiResponse.builder().errs(
                    Lists.newArrayList(e.getLocalizedMessage())).build(),
                    HttpStatus.OK);
        }

        // init state
        HttpStatus status = HttpStatus.OK;
        ResponseEntity<ApiResponse<?>> rentity = new ResponseEntity<>(body, status);

        System.out.println(rentity);
        return rentity;
    }
}
