package com.taeyeon.zyx.filter;

/**
 * @author zyx
 * @date 2018/9/27 027 17:47
 */
/**
 * 多玩游戏 ©2005-2010. 多玩通行证系统 udb.duowan.com
 *
 * @(#)LoginFilter.java V0.0.1 2010-3-19
 */

import com.taeyeon.zyx.utils.RequestUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 资源文件分离
 *
 * @author linyoulong
 */
public class ResourceBaseUrlFilter extends HttpServlet implements Filter {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

//    @Value("${edu100.web.cdn}")
//    private String cdnUrl;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;

        if (RequestUtil.isHttps(request)) {
            request.setAttribute("httphead", "https://");
        } else {
            request.setAttribute("httphead", "http://");
        }

        request.setAttribute("resourcesBaseUrl", ((HttpServletRequest) req).getContextPath());
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
