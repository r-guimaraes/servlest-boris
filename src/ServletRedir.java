import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/ServletRedir", "/Redir.boris" })
public class ServletRedir extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletRedir() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getParameter("url");
		response.sendRedirect(url);		
	}

} // ServletRedir
