package com.thoughtworks.fam.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter
{
    @Value("${Access-Control-Allow-Origin}")
    private String allowOrigin;

    // CHECKSTYLE:OFF RedundantThrowsCheck
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletResponse response = (HttpServletResponse) res;
        allowOrigin = "http://localhost:3000";
        response.setHeader("Access-Control-Allow-Origin", allowOrigin);
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, PUT, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
                "origin, content-type, accept, x-requested-with");
        response.setHeader("Content-Type", "application/json");
        chain.doFilter(req, res);
    }
    // CHECKSTYLE:ON

    public void init(FilterConfig filterConfig)
    {
    }

    public void destroy()
    {
    }

}
