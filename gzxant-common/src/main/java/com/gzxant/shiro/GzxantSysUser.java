package com.gzxant.shiro;

import java.util.Map;

import org.apache.shiro.SecurityUtils;

import com.gzxant.util.data.JsonUtil;

/**
 * Created by chen on 2017/7/28.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: shiro 用户封装的工具类
 */
public class GzxantSysUser {
    /**
     * 取出Shiro中的当前用户LoginName.
     */
    public static String name() {
        return ShiroUser().getName();
    }
    public static String photo() {
        return ShiroUser().getPhoto();
    }

    public static Long id() {
        return ShiroUser().getId();
    }

    public static String loginName() {
        return ShiroUser().getUsername();
    }

    public static Long companyId() {
        return ShiroUser().getCompanyId();
    }

    public static ShiroUser ShiroUser() {
        Object obj = SecurityUtils.getSubject().getPrincipal();
        ShiroUser user = null;
        if (obj instanceof com.gzxant.shiro.ShiroUser) {
            user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        } else {
            // 为什么会不能强转，因为不同类加载器，还是session不同导致的
            @SuppressWarnings("unchecked")
            Map<String, Object> map = JsonUtil.stringToCollect(JsonUtil.toJSONString(obj));
            Long id = Long.parseLong(String.valueOf(map.get("id")));
            String username = String.valueOf(map.get("username"));
            String name = String.valueOf(map.get("name"));
            String photo = String.valueOf(map.get("photo"));
            Long companyId = Long.parseLong(String.valueOf(map.get("companyId")));
            user = new ShiroUser(id, username, name, photo, companyId);
        }

        return user;
    }
}
