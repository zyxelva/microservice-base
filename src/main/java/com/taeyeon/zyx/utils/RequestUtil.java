package com.taeyeon.zyx.utils;

/**
 * @author zyx
 * @date 2018/9/27 027 17:44
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestUtil {
    private static final boolean debug = false;
    private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);
    public static List<String> domainList = new LinkedList();
    public static List<String> abnormalDomainList;
    private static final Pattern IS_LICIT_IP_PATTERN;

    public RequestUtil() {
    }

    public static boolean isSecEscapeURL(String url) {
        if (url.startsWith("/")) {
            return true;
        } else {
            String domain = null;

            try {
                domain = parseDomain(url);
            } catch (MalformedURLException var4) {
                return false;
            }

            Iterator i$ = domainList.iterator();

            String tdomain;
            do {
                if (!i$.hasNext()) {
                    return false;
                }

                tdomain = (String)i$.next();
            } while(!domain.endsWith(tdomain));

            return true;
        }
    }

    public static String getRequestUri(HttpServletRequest request) {
        return request.getHeader("REQUEST_URI");
    }

    public static int getAppid(HttpServletRequest request) {
        String str = request.getParameter("appid");
        if (StringUtils.isEmpty(str)) {
            str = request.getParameter("from");
        }

        int app = NumberUtils.toInt(str);
        if (app <= 0) {
            app = 1;
        }

        return app;
    }

    public static String getUrl(HttpServletRequest request) {
        StringBuffer sb = request.getRequestURL();
        String queryString = request.getQueryString();
        if (StringUtils.isNotEmpty(queryString)) {
            sb.append('?').append(queryString);
        }

        return sb.toString();
    }

    public static String getRealIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isEmpty(ip)) {
            return request.getRemoteAddr();
        } else {
            ip = ip.replace(", 121.9.221.251", "");
            ip = ip.replace(", 121.9.221.186", "");
            ip = ip.replace(", 218.30.84.103", "");
            int index = ip.lastIndexOf(44);
            String lastip = ip.substring(index + 1).trim();
            return !"127.0.0.1".equals(lastip) && isLicitIp(lastip) ? lastip : request.getRemoteAddr();
        }
    }

    public static String getUsernameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Cookie[] arr$ = cookies;
            int len$ = cookies.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Cookie cookie = arr$[i$];
                if ("username".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }

        return "";
    }

    public static boolean isLicitIp(String ip) {
        if (StringUtils.isEmpty(ip)) {
            return false;
        } else {
            Matcher m = IS_LICIT_IP_PATTERN.matcher(ip);
            return m.find();
        }
    }

    public static boolean isHttps(HttpServletRequest request) {
        boolean isHttps = isSsl(request);
        return isHttps;
    }

    public static boolean isSsl(HttpServletRequest request) {
        boolean isSsl = "true".equalsIgnoreCase(request.getHeader("ssl"));
        return isSsl;
    }

    public static String getProtocol(HttpServletRequest request) {
        boolean isSsl = isSsl(request);
        String protocol;
        if (isSsl) {
            protocol = "https";
        } else {
            protocol = "http";
        }

        return protocol;
    }

    public static String getUserAgent(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        return userAgent;
    }

    public static String getXRealIP(HttpServletRequest request) {
        String xRealIP = request.getHeader("X-Real-IP");
        return xRealIP;
    }

    public static String getXForwardedFor(HttpServletRequest request) {
        String xForwardedFor = request.getHeader("X-Forwarded-For");
        return xForwardedFor;
    }

    public static String getRedirect(HttpServletRequest request, String url) {
        if (StringUtils.isEmpty(url)) {
            throw new NullPointerException("url参数不能为空.");
        } else if (url.startsWith("http")) {
            return url;
        } else {
            boolean isSsl = isSsl(request);
            if (!isSsl) {
                return url;
            } else {
                String path;
                if (!url.startsWith("/")) {
                    path = request.getServletPath();
                    int index = path.lastIndexOf(47);
                    if (index != -1) {
                        url = path.substring(0, index + 1) + url;
                    }
                }

                path = request.getServerName();
                return "https://" + path + url;
            }
        }
    }

    public static void printHeaders(HttpServletRequest request) {
        Enumeration<String> e = request.getHeaderNames();
        StringBuilder buf = new StringBuilder();

        while(e.hasMoreElements()) {
            String name = (String)e.nextElement();
            String value = request.getHeader(name);
            buf.append(name).append("=").append(value).append(";");
        }

        logger.info(String.format("request header:%s", buf.toString()));
    }

    public static String getDomain(HttpServletRequest request) {
        boolean isHttps = isHttps(request);
        return isHttps ? "https://" + request.getServerName() : "http://" + request.getServerName();
    }

    public static String getRequestRefererDomain(HttpServletRequest req) {
        String refererURL = req.getHeader("Referer");
        String domain = "";

        try {
            domain = parseDomain(refererURL);
        } catch (MalformedURLException var4) {
            ;
        }

        return domain;
    }

    public static boolean isValidRequestRefererDomain(HttpServletRequest req) {
        boolean validFlag = false;
        String domain = getRequestRefererDomain(req);
        if (StringUtils.isEmpty(domain)) {
            validFlag = false;
        } else {
            Iterator itr = domainList.iterator();

            while(itr.hasNext()) {
                validFlag = domain.endsWith((String)itr.next());
                if (validFlag) {
                    break;
                }
            }
        }

        return validFlag;
    }

    public static boolean isAbnormalRequestRefererDomain(HttpServletRequest req) {
        String domain = getRequestRefererDomain(req);
        return isAbnormalRequestDomainHelper(domain);
    }

    public static boolean isAbnormalRequestDomain(String url) {
        String domain;
        try {
            domain = parseDomain(url);
        } catch (MalformedURLException var3) {
            return false;
        }

        return isAbnormalRequestDomainHelper(domain);
    }

    public static boolean isAbnormalRequestDomainHelper(String domain) {
        boolean validFlag = false;
        if (StringUtils.isEmpty(domain)) {
            validFlag = true;
        } else {
            Iterator itr = abnormalDomainList.iterator();

            while(itr.hasNext()) {
                validFlag = domain.endsWith((String)itr.next());
                if (validFlag) {
                    break;
                }
            }
        }

        return validFlag;
    }

    public static void responseSysBusy(HttpServletResponse resp) throws IOException {
        resp.sendError(403, "Busy,please try again later...");
    }

    public static String parseDomain(String url) throws MalformedURLException {
        if (StringUtils.isEmpty(url)) {
            return "";
        } else {
            try {
                url = URLDecoder.decode(url, "UTF-8");
            } catch (UnsupportedEncodingException var2) {
                if (!url.startsWith("http") && !url.startsWith("https")) {
                    return "";
                }

                url = url.replaceAll("%3A", ":").replaceAll("%2F", "/");
            } catch (IllegalArgumentException var3) {
                throw new MalformedURLException("invalid url:" + url);
            } catch (Exception var4) {
                throw new MalformedURLException("URLDecoder unknow exception,reason:" + var4.getMessage());
            }

            return (new URL(url)).getHost();
        }
    }

    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

    public static boolean isAcceptJson(HttpServletRequest request) {
        return request.getHeader("Accept") != null && request.getHeader("Accept").contains("application/json");
    }

    public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException {
        String url = "&username=flyingsky658&yyno=670150469&appid=5036&regType=inner";
        System.out.println(parseDomain(url));
    }

    static {
        domainList.add("duowan.com");
        domainList.add("yy.com");
        domainList.add("5253.com");
        domainList.add("kuaikuai.cn");
        domainList.add("100.com");
        abnormalDomainList = new LinkedList();
        abnormalDomainList.add("5253.com");
        IS_LICIT_IP_PATTERN = Pattern.compile("^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$");
    }
}

