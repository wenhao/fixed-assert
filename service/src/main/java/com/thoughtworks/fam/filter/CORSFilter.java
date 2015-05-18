package com.thoughtworks.fam.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import com.thoughtworks.fam.constant.HeaderKeys;

@Component
@ConfigurationProperties(prefix = "cors")
public class CORSFilter implements Filter
{
    private String allowOrigin;
    private String allowMethods;
    private String contentType;
    private String allowHeaders;
    private String maxAge;

    // CHECKSTYLE:OFF RedundantThrowsCheck
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader(HeaderKeys.ALLOW_ORIGIN, allowOrigin);
        response.setHeader(HeaderKeys.ALLOW_METHODS, allowMethods);
        response.setHeader(HeaderKeys.MAX_AGE, maxAge);
        response.setHeader(HeaderKeys.ALLOW_HEADERS, allowHeaders);
        response.setHeader(HeaderKeys.CONTENT_TYPE, contentType);
        chain.doFilter(req, res);
    }
    // CHECKSTYLE:ON

    public void init(FilterConfig filterConfig)
    {
    }

    public void destroy()
    {
    }

    public void setAllowOrigin(String allowOrigin)
    {
        this.allowOrigin = allowOrigin;
    }

    public void setAllowMethods(String allowMethods)
    {
        this.allowMethods = allowMethods;
    }

    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    public void setAllowHeaders(String allowHeaders)
    {
        this.allowHeaders = allowHeaders;
    }

    public void setMaxAge(String maxAge)
    {
        this.maxAge = maxAge;
    }
}
