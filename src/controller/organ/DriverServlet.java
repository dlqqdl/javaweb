package controller.organ;


import service.organService.DriverService;
import service.organService.DriverServiceImpl;
import vo.organVo.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/organ/driverServlet")
public class DriverServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");

        System.out.println(method);
        if(method.equals("undispatchingDriver")&&method!=null){
            this.undispatchingDriver(request,response);
        }else if(method.equals("dispatchingDriver")&&method!=null){
//            this. changeDriverstate(request, response);
        }
    }

    protected void undispatchingDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DriverService ds=new DriverServiceImpl();
        int dflag = Integer.parseInt(request.getParameter("dflag"));
        List<Driver> list = ds.unDriver(dflag);
        HttpSession session=request.getSession();
        if(dflag==0){
            session.setAttribute("list2",list);
        }else if(dflag==1){
            session.setAttribute("list3",list);
        }

        if(dflag==0){
            request.getRequestDispatcher("/jsp/organJsp/undriver.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/jsp/organJsp/driver.jsp").forward(request,response);
        }
    }

//    protected void dispatchingDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        DriverService ds=new DriverServiceImpl();
//        int dflag = Integer.parseInt(request.getParameter("dflag"));
//        List<Driver> list = ds.unDriver(dflag);
//        HttpSession session=request.getSession();
//        session.setAttribute("list3",list);
//        if(dflag==0){
//            request.getRequestDispatcher("/jsp/organJsp/undriver.jsp").forward(request,response);
//        }else {
//            request.getRequestDispatcher("/jsp/organJsp/driver.jsp").forward(request,response);
//        }
//    }


}
