import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
   
        //Will put a for loop to go through all the use
        int userID = wm.userExist(user, pwd);
        
        while(userID != -1){
            PrintWriter out= response.getWriter();
        	out.println("<font color=red>Username is already in use.</font>");
        	user = request.getParameter("user");
            pwd = request.getParameter("pwd");
        	userID = wm.userExist(user,pwd);
        }
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String school = request.getParameter("school");
        int gradYear = Integer.parseInt(request.getParameter("gradYear"));
        wm.addUser(user,pwd,firstname,lastname,school,gradYear,false);
        //Make a checkbox for alumni
        if(userID != -1){
            Cookie FirstName = new Cookie("firstName",wm.getFirst(userID));
            Cookie LastName = new Cookie("lastName",wm.getLast(userID));
            //setting cookie to expiry in 30 mins
            FirstName.setMaxAge(30*60);
            LastName.setMaxAge(30*6);;
            response.addCookie(FirstName);
            response.addCookie(LastName);
            if(wm.getAlumni(userID))
            	response.sendRedirect("AlumLogin.jsp");
            else
            	response.sendRedirect("StudentLogin.jsp");
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
 
    }
 
}