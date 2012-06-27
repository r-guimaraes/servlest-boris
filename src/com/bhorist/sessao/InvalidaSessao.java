package com.bhorist.sessao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/InvalidaSessao" }, 
		initParams = { 
				@WebInitParam(name = "nome", value = "rodrigo", description = "nao sei ainda a utilidade")
		})
public class InvalidaSessao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InvalidaSessao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("ServletSessao");
	}
}
