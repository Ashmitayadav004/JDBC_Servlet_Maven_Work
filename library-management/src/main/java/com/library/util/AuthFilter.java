package com.library.util;

import com.library.model.User;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// map this in web.xml to protect /jsp/* or paths you want protected
public class AuthFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        String path = request.getRequestURI();
        boolean isLogin = path.endsWith("login.jsp") || path.endsWith("LoginServlet") || path.endsWith("index.jsp");

        if (session == null || session.getAttribute("user") == null) {
            if (isLogin) {
                chain.doFilter(req, res);
            } else {
                response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
            }
            return;
        }

        // user exists
        chain.doFilter(req, res);
    }
}
