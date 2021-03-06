/*
 * @Author: sevncz.wen
 * @Date: 2020-05-18 18:04:26
 * @Last Modified by: sevncz.wen
 * @Last Modified time: 2020-05-18 18:07:31
 */
package com.puhuilink.qbs.core.web.controller.auth;

import java.util.HashMap;
import java.util.Map;

import com.puhuilink.qbs.core.base.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.http.HttpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "Security相关接口")
@RequestMapping("/api/auth")
public class SecurityController {

    @GetMapping(value = "/swagger/login")
    @ApiOperation(value = "Swagger接口文档专用登录接口 方便测试")
    public Result swaggerLogin(@RequestParam String username, @RequestParam String password,
                               @ApiParam("图片验证码ID") @RequestParam(required = false) String captchaId,
                               @ApiParam("验证码") @RequestParam(required = false) String code,
                               @ApiParam("记住密码") @RequestParam(required = false, defaultValue = "true") Boolean saveLogin,
                               @ApiParam("可自定义登录接口地址") @RequestParam(required = false, defaultValue = "http://127.0.0.1:8888/login") String loginUrl) {

        Map<String, Object> params = new HashMap<>(16);
        params.put("username", username);
        params.put("password", password);
        params.put("captchaId", captchaId);
        params.put("code", code);
        params.put("saveLogin", saveLogin);
        return Result.ok().data(HttpUtil.post(loginUrl, params));
    }
}
