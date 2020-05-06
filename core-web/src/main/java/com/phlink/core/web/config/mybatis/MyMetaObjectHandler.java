package com.phlink.core.web.config.mybatis;

import java.util.Date;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.phlink.core.web.security.model.SecurityUser;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String username = "";
            if(authentication.getPrincipal() instanceof SecurityUser) {
                SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
                username = securityUser.getUsername();
            }
            if(authentication.getPrincipal() instanceof String) {
                username = (String) authentication.getPrincipal();
            }
            // UserDetails user = (UserDetails) authentication.getPrincipal();
            // String username = (String) authentication.getPrincipal();
            this.setFieldValByName("createBy", username, metaObject);
        }
        this.setFieldValByName("createTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            UserDetails user = (UserDetails) authentication.getPrincipal();
            this.setFieldValByName("updateBy", user.getUsername(), metaObject);
        }
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
