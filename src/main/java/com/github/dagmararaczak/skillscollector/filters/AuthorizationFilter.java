package com.github.dagmararaczak.skillscollector.filters;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebFilter(urlPatterns = "/*")
public class AuthorizationFilter extends HttpFilter {

    Set<String> authorizedPath = new HashSet<>();
    Set<String> unauthorizedPath = new HashSet<>();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String servletPath = req.getServletPath();
        HttpSession session =  req.getSession();

        if(unauthorizedPath.contains(servletPath)){
            chain.doFilter(req,res);
        }else if (authorizedPath.contains(servletPath)){
                if(session.getAttribute("user") != null){
                    chain.doFilter(req,res);
                }else {
                    req.getRequestDispatcher("/login").forward(req,res);
                }

        }else  {
            res.sendError(500,"strona " + servletPath + " nie istnieje");
        }


    }

    @Override
    public void init() throws ServletException {
        authorizedPath.add("/user/skills");
        authorizedPath.add("/user/sources");
        authorizedPath.add("/user/unknown-sources");
        authorizedPath.add("/logout");
        authorizedPath.add("user/add-source");


        unauthorizedPath.add("/register");
        unauthorizedPath.add("/login");
        unauthorizedPath.add("/index.jsp");

    }
}
