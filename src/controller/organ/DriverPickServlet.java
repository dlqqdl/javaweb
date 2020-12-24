package controller.organ;

import com.google.gson.Gson;

import service.organService.DriverPickService;
import service.organService.DriverPickServiceImpl;
import service.organService.DriverService;
import service.organService.DriverServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/organ/driverPickServlet")
public class DriverPickServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equals("disputeConferee")&&method!=null){
            this.disputeConferee(request,response);
        }else if(method.equals("existOrganid")&&method!=null){
//            this. existOrganid(request, response);
        }
    }


    protected void disputeConferee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int driverid = Integer.parseInt(request.getParameter("a"));
        DriverService ps=new DriverServiceImpl();
        int i3 = ps.changeDriverstate(driverid);
        System.out.println("driverPickServlet"+driverid);
        String[] arr=request.getParameterValues("arr");
        System.out.println("driverPickServlet2"+arr.length);
        int i1=0;
        List i2=new ArrayList();
        Map<String, Integer> result = new HashMap<String, Integer>();
        DriverPickService dps=new DriverPickServiceImpl();
        for(int i=0;i<arr.length;i++){
            i1 = dps.insertDriver(driverid,Integer.parseInt(arr[i]));
            System.out.println(i+"...."+i1);
            i2.add(i, i1) ;
        }
        if (i3==i1&&i1==1){
            result.put("result1", 1);
        }else {
            result.put("result1", 0);
        }
        Gson gson = new Gson();
        String json = gson.toJson(result);
        response.getWriter().write(json);

//        request.setAttribute("method","undispatchingConferee");
//        request.setAttribute("cflag",0);
//        response.sendRedirect("/organ/confereeServlet");
    }
}
