package com.bhorist.banco;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/LoginServlet", "/login.bo" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Map<String, String> senhas = new HashMap<String, String>();

	private boolean Verificar(String usuario, String senha) {
		boolean ok = true;
		ok = ok && (senhas.get(usuario) != null);
		ok = ok && (senhas.get(usuario).equals(senha));
		return ok;
	}

	public LoginServlet() {
		super();
	}

	public void init() throws ServletException {
		senhas.put("user", "password");
		senhas.put("usuario", "senha");
		senhas.put("demo", "123");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("user");
		String senha = request.getParameter("password");
		RequestDispatcher dispatch;

		if (Verificar(usuario, senha)) {
			request.setAttribute("usuario", usuario);
			ServletContext context = getServletContext();
			dispatch = context.getRequestDispatcher("/saldo");
		} else {
			PrintWriter pw = response.getWriter();
			pw.println("<h2>preencha direito!</h2>");
			dispatch = request.getRequestDispatcher("/index.html");
		}
		dispatch.forward(request, response);
	} // doPost

}
