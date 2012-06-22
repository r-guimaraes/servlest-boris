import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExemploServlet")
public class ExemploServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExemploServlet() {
        // TODO Auto-generated constructor stub
    }
    public WebServlet borao;    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
    	java.util.Date today = new java.util.Date();
    	out.println("<html><body><h2>Servlet#1</h2></body></html>");
    	out.println(today);
    	out.println("<br /> E aih, bhorist \t :]");
	}

}
