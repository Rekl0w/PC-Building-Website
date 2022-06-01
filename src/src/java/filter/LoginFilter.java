package filter;

import entity.Kullanici;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1;
        String url = request.getRequestURI();

        System.out.println(url);
        HttpSession session = request.getSession();
        Kullanici user = null;

        if (session != null) {
            user = (Kullanici) session.getAttribute("validUser");
        }
        if (user == null) {
            if (url.contains("logout")) {
                session.invalidate();
                response.sendRedirect(request.getContextPath() + "/panel/login.xhtml?faces-redirect=true");
                
            } else {
                fc.doFilter(sr, sr1);
            }

        } 

    }
}
