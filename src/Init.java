import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Init")
public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String initial_message;
	Enumeration<String> init_params;
       
    public Init() {
        super();
    }
    // inserir dados de conexões, sgdb e demais inicializações aqui
    public void init(){
    	ServletConfig servlet_config = getServletConfig();
    	initial_message = servlet_config.getInitParameter("msg");
    	init_params = servlet_config.getInitParameterNames();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("ISO-8859-1");
		PrintWriter pw = response.getWriter();
		pw.println("<html><body><center><h5>" + initial_message + "</h5></center>");		
		for(; init_params.hasMoreElements();) {
			String nome = (String)init_params.nextElement();
			String valor = getServletConfig().getInitParameter(nome);
			pw.print("<strong>" + nome + ": </strong>" + valor + "<br />");
		}
		pw.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

} // Servlet Init
