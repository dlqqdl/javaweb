package controller.administrator.driverServlet;

import service.administratorService.driverService;
import vo.administratorVo.Driver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class doWithDriver extends HttpServlet {
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
        if(method.equals("showAllDriver")){
            showAllDriver(request,response);
            return;
        }
        else if(method.equals("addNewDriver")){
            addNewDriver(request,response);
            return;
        }
        else if(method.equals("deleteDriver")){
            deleteDriver(request,response);
            return;
        }
        else if(method.equals("showDriver")){
            showDriver(request,response);
        }
    }

    private void showDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        driverService service=new driverService();
        String id_temp=request.getParameter("driverId");
        int id=Integer.parseInt(id_temp);
        List<Driver> driverList=service.showDriver(id);
        response.setContentType("text/xml;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("driverList",driverList);
        request.getRequestDispatcher("/jsp/administratorJsp/showDrivers.jsp").forward(request,response);
    }

    private void showAllDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        driverService service=new driverService();
        List<Driver> driverList=service.showAllDriver();
        response.setContentType("text/xml;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("driverList",driverList);
        request.getRequestDispatcher("/jsp/administratorJsp/showDrivers.jsp").forward(request,response);
    }
    private void deleteDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        driverService service=new driverService();
        String temp_id=request.getParameter("hotel_id");
        int id=Integer.parseInt(temp_id);
        boolean result=service.deleteDriver(id);
        if(result) request.setAttribute("deleteDriverResult",true);
        else request.setAttribute("deleteDriverResult",false);
        request.getRequestDispatcher("/jsp/administratorJsp/deleteDriver.jsp").forward(request,response);
    }
    private void addNewDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        driverService service=new driverService();
        response.setContentType("text/xml;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        int driver_id=Integer.parseInt(request.getParameter("driver_id"));//id
        String name=request.getParameter("name");//司机名字
        int telephone=Integer.parseInt(request.getParameter("telephone"));//联系电话
        String password=request.getParameter("password");//登录密码
        Driver driver=new Driver(driver_id,telephone,name,password);
        boolean addDriverResult=service.addOneDriver(driver);
        if(addDriverResult)
            request.setAttribute("addDriverResult",true);
        else
            request.setAttribute("addDriverResult",false);
        request.getRequestDispatcher("/jsp/administratorJsp/addNewDriver.jsp").forward(request,response);
    }

}
