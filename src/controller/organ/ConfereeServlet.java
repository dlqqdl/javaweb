package controller.organ;

import service.organService.ConfereeService;
import service.organService.ConfereeServiceImpl;
import vo.organVo.DriverPick;
import vo.organVo.Organ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/organ/confereeServlet")
public class ConfereeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method=(request.getParameter("method")==null)? String.valueOf(request.getAttribute("method")) :(request.getParameter("method"));
        System.out.println(method);
        if(method.equals("undispatchingConferee")&&method!=null){
            this.undispatchingConferee(request,response);
        }else if(method.equals("existOrganid")&&method!=null){
//            this. existOrganid(request, response);
        }
    }

    protected void undispatchingConferee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         ConfereeService cs= new ConfereeServiceImpl();
         int cflag;
        if(request.getParameter("cflag")==null){
            cflag= (int) request.getAttribute("cflag");
        }else {
            cflag = Integer.parseInt(request.getParameter("cflag"));
        }
        HttpSession session = request.getSession();
        Organ organ1 = (Organ) session.getAttribute("organ1");
        List<DriverPick> list = cs.driverPick(cflag,organ1.getOrgan_id());
        request.setAttribute("list",list);
        if(cflag==0){
            request.getRequestDispatcher("/jsp/organJsp/unconferee.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/jsp/organJsp/conferee.jsp").forward(request,response);
        }
    }
}
