package com.aloneness.spring.cloud.alibaba.sso.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.aloneness.spring.cloud.alibaba.sso.domain.SysUser;
import com.aloneness.spring.cloud.alibaba.sso.service.LoginService;
import com.aloneness.spring.cloud.alibaba.sso.service.RedisService;
import com.aloneness.spring.cloud.alibaba.sso.util.CookieUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 单点登录
 */
@Controller
public class LoginController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private LoginService loginService;

    @GetMapping("login")
    public String login(@RequestParam(required = false) String url,
                        HttpServletRequest request,
                        Model model) {
        String authorization = CookieUtil.getCookieValue(request, "Authorization");
        if (StrUtil.isEmpty(authorization)) {
            authorization = request.getHeader("Authorization");
        }

        if (StrUtil.isEmpty(authorization)) {
            if (StrUtil.isNotEmpty(url)) {
                model.addAttribute("url", url);
            }
            return "login";
        }

        String loginCode = redisService.get(authorization);
        if (StrUtil.isEmpty(loginCode)) {
            if (StrUtil.isNotEmpty(url)) {
                model.addAttribute("url", url);
            }
            return "login";
        }

        String userJsonStr = redisService.get(loginCode);
        if (StrUtil.isEmpty(userJsonStr)) {
            if (StrUtil.isNotEmpty(url)) {
                model.addAttribute("url", url);
            }
            return "login";
        }

        SysUser user = JSONUtil.toBean(userJsonStr, SysUser.class);
        if (StrUtil.isNotEmpty(url)) {
            return "redirect:" + url;
        }

        model.addAttribute("sysUser", user);
        return "index";
    }

    /**
     * 表单登录
     *
     * @param loginCode
     * @param password
     * @param url
     * @param request
     * @param response
     * @param redirectAttributes
     * @return
     */
    @PostMapping("login")
    public String login(@RequestParam(required = true) String loginCode,
                        @RequestParam(required = true) String password,
                        @RequestParam(required = false) String url,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        RedirectAttributes redirectAttributes) {
        SysUser user = loginService.login(loginCode, password);

        if (ObjectUtil.isNull(user)) {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误，请重新登录");
        } else {
            String token = IdUtil.simpleUUID();
            CookieUtil.setCookie(request, response, "Authorization", token, 60 * 60 * 24);
            String result = redisService.put(token, loginCode, 60 * 60 * 24);
            if (StringUtils.isNotEmpty(url)) {
                return "redirect:" + url + "?token=" + loginCode;
            }
        }
        return "redirect:/login?token=" + loginCode;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response,
                         @RequestParam(required = false) String url,
                         Model model) {
        try {
            CookieUtil.deleteCookie(request, response, "Authorization");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return login(url, request, model);
    }
}
