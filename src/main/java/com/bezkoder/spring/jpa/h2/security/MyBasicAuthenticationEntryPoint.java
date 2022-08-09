package com.bezkoder.spring.jpa.h2.security;

import org.json.simple.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@Component
public class MyBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException {
        response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        final PrintWriter writer = response.getWriter();
//        writer.println("HTTP Status " + HttpServletResponse.SC_UNAUTHORIZED + " - " + authException.getMessage());
        HashMap<String, String> map = new HashMap();
        map.put("message", authException.getMessage());
        map.put("status", HttpServletResponse.SC_UNAUTHORIZED + "");
        JSONObject error = new JSONObject(map);
        writer.println(error);
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("Baeldung");
        super.afterPropertiesSet();
    }

}
