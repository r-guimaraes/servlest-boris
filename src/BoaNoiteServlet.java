import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoaNoiteServlet")
public class BoaNoiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoaNoiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body><h1>"+"Boa noite Boris!" + "</h1></body>");
		out.println("</html>");

	}

}
