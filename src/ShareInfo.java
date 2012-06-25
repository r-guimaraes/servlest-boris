import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShareInfo")
public class ShareInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShareInfo() {
        super();
    }
    
	public void init(){
		getServletContext().setAttribute("attr", getServletName());
		getServletContext().setAttribute("attr2", getServletInfo());
		getServletContext().setAttribute("attr3", getClass());
	}	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		ServletContext sc = getServletContext();		
		pw.println("<html><body><h4>Compartilhando Info por GET - Atributo</h4>");
		pw.println("Servlet Name: " + sc.getAttribute("attr") + " | Servlet Info: " + sc.getAttribute("attr2") + " | Classe: " + sc.getAttribute("attr3"));
		pw.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String link = request.getParameter("site");
		String destino;
		pw.println("<html><body><h4>Compartilhando Info</h4></body></html>");
		if (link.equals("INF")) {
			destino = "inf.ufg";
		} else if (link.equals("Opa")) {
			destino = "opacomunicacao";
		} else {
			destino = link;
		}
		response.sendRedirect("http://www."+destino+".com.br/");
	}

}
