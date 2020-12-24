package controller.administrator.meetingServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class doWithMeeting extends HttpServlet {
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
        if(method.equals("showAllMeeting")){
            showAllMeeting(request,response);
            return;
        }
        else if(method.equals("showMeeting")){
            showMeeting(request,response);
        }
        else if(method.equals("deleteMeeting")){
            deleteMeeting(request,response);
        }
    }

    private void deleteMeeting(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void showMeeting(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void showAllMeeting(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
