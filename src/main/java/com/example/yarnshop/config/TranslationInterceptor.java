package com.example.yarnshop.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.WebUtils;

import java.util.Locale;

public class TranslationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if (localeResolver == null) {
            throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
        }
        Locale locale = localeResolver.resolveLocale(request);
        if (!"bg_BG".equals(locale.toString())) { // Check if the locale is not already Bulgarian
            localeResolver.setLocale(request, response, new Locale("bg", "BG")); // Set the locale to Bulgarian
            WebUtils.setSessionAttribute(request, "org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE", new Locale("bg", "BG")); // Set the session attribute to Bulgarian
        }
        return true;
    }
}
