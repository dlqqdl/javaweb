package controller.administrator.userServlet;

import service.administratorService.confereeService;
import vo.administratorVo.Conferee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class doWithUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getFunction(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getFunction(request,response);
    }
    public void getFunction(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");
        if(method.equals("showAllUser")){
            showAllUser(request,response);
            return;
        }
        else if(method.equals("deleteUser")){
            deleteUser(request,response);
            return;
        }
        else if(method.equals("showUser")){
            showUser(request,response);
        }
    }

    private void showAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        confereeService service=new confereeService();
        List<Conferee> confereeList=service.showAllUsers();
        response.setContentType("text/xml;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("confereeList",confereeList);
        request.getRequestDispatcher("/jsp/administratorJsp/showConferee.jsp").forward(request,response);
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        confereeService service=new confereeService();
        String temp_id=request.getParameter("conf_id");
        int id=Integer.parseInt(temp_id);
        boolean result=service.deleteUser(id);
        if(result) request.setAttribute("deleteConfereeResult",true);
        else request.setAttribute("deleteConfereeResult",false);
        request.getRequestDispatcher("/jsp/administratorJsp/deleteConferee.jsp").forward(request,response);
    }
    private void showUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        confereeService service=new confereeService();
        String temp=request.getParameter("confereeId");
        if(temp!=null){
            int id=Integer.parseInt(temp);
            List<Conferee> confereeList=service.showUser(id);
            response.setContentType("text/xml;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            request.setAttribute("confereeList",confereeList);
        }
        else
            request.setAttribute("confereeList",null);
        request.getRequestDispatcher("/jsp/administratorJsp/showConferee.jsp").forward(request,response);
    }

}
