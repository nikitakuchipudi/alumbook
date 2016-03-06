import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    private WebsiteModel wm;
    
    
    public void init() throws ServletException {
    	wm = new WebsiteModel();
    }
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
    	if(request.getParameter("Submit") != null){
	        // get request parameters for userID and password
	        String user = request.getParameter("user");
	        String pwd = request.getParameter("pwd");
	   
	        //Will put a for loop to go through all the use
	        int userID = wm.userExist(user, pwd);
	        
	        if(userID != -1){
	            Cookie FirstName = new Cookie("firstName",wm.getFirst(userID));
	            Cookie LastName = new Cookie("lastName",wm.getLast(userID));
	            //setting cookie to expiry in 30 mins
	            FirstName.setMaxAge(30*60);
	            LastName.setMaxAge(30*6);
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
    	else{
        
	     // get request parameters for userID and password
	        String userr = request.getParameter("userr");
	        String pwdr = request.getParameter("pwdr");
	        System.out.println("Password Entereted: "+pwdr);

	        //Will put a for loop to go through all the use
	        int userIDr = wm.userExist(userr, pwdr);
	        System.out.println("ID: "+userIDr);

	        
	        if(userIDr != -1){
	        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
	            PrintWriter out= response.getWriter();
	        	out.println("<font color=red>Username is already in use.</font>");
	            rd.include(request, response);
	        }else{
		        String firstname = request.getParameter("firstname");
		        String lastname = request.getParameter("lastname");
		        String school = request.getParameter("school");
		        int gradYear = Integer.parseInt(request.getParameter("gradYear"));
		        wm.addUser(userr,pwdr,firstname,lastname,school,gradYear,false);
		        //Make a checkbox for alumni
		        userIDr = wm.userExist(userr, pwdr);
		        Cookie FirstName = new Cookie("firstName",wm.getFirst(userIDr));
		        Cookie LastName = new Cookie("lastName",wm.getLast(userIDr));
		        //setting cookie to expiry in 30 mins
		        FirstName.setMaxAge(30*60);
		        LastName.setMaxAge(30*6);
		        response.addCookie(FirstName);
		        response.addCookie(LastName);
		        if(wm.getAlumni(userIDr))
		        	response.sendRedirect("AlumLogin.jsp");
		        else
		        	response.sendRedirect("StudentLogin.jsp");
	        }
    	}
        	
    }
 
}