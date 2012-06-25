import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletContext;
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
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body><h1> Boa noite Boris! Setando Especializa<span style=\"color:red\">çã</span>o </h1></body>");
		out.println("Encoding: " + response.getCharacterEncoding() + "<br />");
		out.println("Local: " + response.getLocale());
		out.println("</html>");
	} // doGet*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("image/jpeg");
		//PrintWriter pw = response.getWriter();
	   	ServletContext context = getServletContext();
	   	//String c = context.getContextPath();
	   	//pw.println(c);
	   	URL url = context.getResource("/rodrigo.jpg");
	   	OutputStream os = response.getOutputStream();
	   	InputStream is = url.openStream();
	   	byte[] byteArray = new byte[1024];
	   	int bytesLidos = 0;
	   	while((bytesLidos = is.read(byteArray)) != -1) {
	   		os.write(byteArray, 0, bytesLidos);
	   	}
	   	is.close();
	   	os.flush();	   	
	} 
	

} // BoaNoiteServlet
