package filter;

import util.Constants;
import vo.hotelVo.Hotel;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Timgreat
 * @date 2020/12/5 - 13:41
 */
public class SysFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        Hotel hotel=(Hotel)request.getSession().getAttribute(Constants.HOTEL_SESSION);
        if(hotel==null){
            response.sendRedirect("/jsp/hotelJsp/error.jsp");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
