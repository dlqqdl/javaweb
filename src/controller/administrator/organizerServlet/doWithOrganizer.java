package controller.administrator.organizerServlet;

import service.administratorService.organizerService;
import vo.administratorVo.Organizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class doWithOrganizer extends HttpServlet {
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
        if(method.equals("showAllOrganizer")){
            showAllOrganizer(request,response);
            return;
        }
        else if(method.equals("showOrganizer")){
            showOrganizer(request,response);
        }
        else if(method.equals("deleteOrganizer")){
            deleteOrganizer(request,response);
        }
    }

    private void deleteOrganizer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        organizerService service=new organizerService();
        String temp=request.getParameter("organ_id");
        int id=Integer.parseInt(temp);
        boolean deleteOrganizerResult=service.deleteOneOrganizer(id);
        response.setContentType("text/xml;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("deleteOrganizerResult",deleteOrganizerResult);
        request.getRequestDispatcher("/jsp/administratorJsp/deleteOrganizer.jsp").forward(request,response);
    }

    private void showOrganizer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        organizerService service=new organizerService();
        String temp=request.getParameter("organizerId");
        int id=Integer.parseInt(temp);
        List<Organizer> organizerList=service.showOrganizer(id);
        response.setContentType("text/xml;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("organizerList",organizerList);
        request.getRequestDispatcher("/jsp/administratorJsp/showOrganizer.jsp").forward(request,response);
    }

    private void showAllOrganizer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        organizerService service=new organizerService();
        List<Organizer> organizerList=service.showAllOrganizer();
        response.setContentType("text/xml;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("organizerList",organizerList);
        request.getRequestDispatcher("/jsp/administratorJsp/showOrganizer.jsp").forward(request,response);
    }
}
