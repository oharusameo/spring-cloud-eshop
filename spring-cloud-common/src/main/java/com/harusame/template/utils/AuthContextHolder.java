package com.harusame.template.utils;

import org.springframework.stereotype.Component;

@Component
public class AuthContextHolder {
    private static ThreadLocal<Integer> userIdThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<Integer> tenantIdThreadLocal = new ThreadLocal<>();

    public static void setUserId(Integer userId) {
        userIdThreadLocal.set(userId);
    }

    public static Integer getUserId() {
        return userIdThreadLocal.get();
    }

    public static void setTenantId(Integer tenantId) {
        tenantIdThreadLocal.set(tenantId);
    }

    public static Integer getTenantId() {
        return tenantIdThreadLocal.get();
    }

    public static void removeUserId() {
        userIdThreadLocal.remove();
    }

    public static void removeTenantId() {
        tenantIdThreadLocal.remove();
    }
}
