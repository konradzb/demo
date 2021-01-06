package com.example.demo.security;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum ApplicationUserPermission {
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write");

    private final String permission;

    public String getPermission() {
        return permission;
    }
}
