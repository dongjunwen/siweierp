package com.fangxin.siwei.fangzhi.shiro;

import com.alibaba.fastjson.JSONObject;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date:2017/10/23 0023 18:12
 * @Author lu.dong
 * @Description：
 **/
public class AccessFilter extends AuthorizationFilter {
    private static final Logger logger= LoggerFactory.getLogger(AccessFilter.class);
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = ShiroUtils.getSubject();
        if (null != subject.getPrincipals()) {
            return true;
        }
        return false;
    }

    /**
     * 会话超时或权限校验未通过的，统一返回401，由前端页面弹窗提示
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
            throws IOException {

        HttpServletResponse httpResponse ;
        HttpServletRequest httpRequest;
        Map<String, Object> map = new HashMap<String, Object>();
        httpResponse = WebUtils.toHttp(response);
        httpRequest = WebUtils.toHttp(request);
       /* if(isLoginRequest(httpRequest, httpResponse)){
            return true;
        }*/
        if(ShiroUtils.isLogin()){
            return true;
        } else{
            WebUtils.saveRequest(request);
            map.put("requestUri", httpRequest.getRequestURI());
            map.put("requestUrl", httpRequest.getRequestURL());
            httpResponse.setStatus(200, "redirect");
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json; charset=utf-8");
            // String reqPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
            // 获取原始请求来源地址 不带请求路径 http://localhost:8080/fileDemo.html--》http://localhost:8080
            String reqOriginRealPath = httpRequest.getHeader("Referer");
            String reqPath="*";
            if(reqOriginRealPath!=null){
                int len=reqOriginRealPath.indexOf("/",7);
                reqPath= reqOriginRealPath.substring(0,len);
                logger.info("Referer:{},reqPath:{}",reqOriginRealPath,reqPath);
            }else {
                reqPath=httpRequest.getHeader("Origin");
            }
            httpResponse.setHeader("Access-Control-Allow-Origin", reqPath);
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
            httpResponse.setHeader("Access-Control-Max-Age", "86400");
            httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
            httpResponse.setHeader("XDomainRequestAllowed","1");
            PrintWriter out = null;
            try{
                out = httpResponse.getWriter();
                Result<String> _result = Result.newError(ResultCode.USER_NO_LOGGED_IN);
                _result.setMessage("尚未登录");
                //_result.setData(httpResponse.toString());
                out.append(JSONObject.toJSONString(_result));
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                if (out != null) {
                    out.close();
                }
            }
            return false;
        }
    }

       /* if (isAjax((HttpServletRequest) request)) {
            Result<String> notAllow=Result.newError(ResultCode.FOR_UNAUTHORIZED);
            String errMsg=JSONObject.toJSON(notAllow).toString();
            WebUtils.toHttp(response).sendError(401);
        } else {
            String unauthorizedUrl = getUnauthorizedUrl();
            if (StringUtils.hasText(unauthorizedUrl)) {
                WebUtils.issueRedirect(request, response, unauthorizedUrl);
            } else {
                WebUtils.toHttp(response).sendError(401);
            }
        }

        return false;*/
    private boolean isAjax(HttpServletRequest request) {
        String header = request.getHeader("x-requested-with");
        if (null != header && "XMLHttpRequest".endsWith(header)) {
            return true;
        }
        return false;
    }
}
