package controller.organ;


import service.organService.RegisterService;
import vo.organVo.Organ;

@javax.servlet.annotation.WebServlet("/organ/registerServlet")
public class RegistServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        int userid = Integer.parseInt(request.getParameter("userid"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int tel = Integer.parseInt(request.getParameter("tel"));
        Organ organ=new Organ(userid,username,tel,password);
        RegisterService service=new RegisterService();
        int i = service.regist(organ);
        System.out.println(i);
        if(i==1){
            request.getRequestDispatcher("/jsp/organJsp/index.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/jsp/organJsp/registfailed.jsp").forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doPost(request, response);
    }
}
