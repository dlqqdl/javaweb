package controller.organ;

import service.organService.LoginService;
import vo.organVo.Organ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/organ/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usename=request.getParameter("username");
        String pwd=request.getParameter("pwd");
        Organ organ=new Organ(usename,pwd);
        //???
        HttpSession session=request.getSession();
        LoginService loginService=new LoginService();
        int i = loginService.confirm(organ);
        if(i==1){
            Organ organ1=loginService.getDetail(usename);
            session.setAttribute("organ1",organ1);
            request.getRequestDispatcher("/jsp/organJsp/public.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/jsp/organJsp/index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
