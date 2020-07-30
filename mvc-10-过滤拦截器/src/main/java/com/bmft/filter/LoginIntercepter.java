package com.bmft.filter;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 实现接口 Interceptor 和Filter 一样实现拦截
 * 拦截器的配置在  spring-mvc.xml 中配置即可
 *
 * <!--关于拦截器的配置-->
 * <mvc:interceptors>
 *    <mvc:interceptor>
 *        <mvc:mapping path="/**"/>
 *        <bean id="loginInterceptor" class="com.bmft.filter.LoginIntercepter"/>
 *    </mvc:interceptor>
 * </mvc:interceptors>
 */
public class LoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("========拦截前========");
        HttpSession session = request.getSession();
        if (session != null) {
            return true;
        }else {
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("==============拦截后一般用来输出日志之类的============");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("=======一般用来清理的=========");
    }
}
