import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class Browse
 * Allows the user to search and browse for alumni's
 */
@WebServlet("/Browse")
public class Browse extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    private WebsiteModel wm;
    
    
    public void init() throws ServletException {
    	wm = new WebsiteModel();
    }
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        // get request parameters for userID and password
        String name = request.getParameter("searchName");
   
        System.out.println("Searching for: "+name);
        
        //Will put a for loop to go through all the use
        ArrayList<Integer> userID = wm.nameExist(name);
        
        if(userID.size() < 1){
            Cookie search = new Cookie("search",name+" cannot be found.");
            search.setMaxAge(30*60);
            response.addCookie(search);
        	response.sendRedirect("StudentLogin.jsp");

        }
        else{
        	request.setAttribute("namesList", userID);
        	RequestDispatcher view=request.getRequestDispatcher("Search.jsp"); 
        		        view.forward(request, response);
        }
        
        
    }
 
}