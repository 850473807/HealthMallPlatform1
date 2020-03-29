package com.health.model;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ContextModel {
    private static Map<String, Map<String, Object>> context = new HashMap<>();

    public static Map<String, String> getCode(HttpServletRequest request) {
        Map<String, Object> context = getContext(request);

        return context.get("code") == null ? null : (Map<String, String>) context.get("code");
    }

    public static Map<String, Object> getContext(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        Map<String, Object> map = context.get(remoteAddr);
        if (map == null) {
            map = new HashMap<>();
            context.put(remoteAddr, map);
        }
        return map;
    }
}
