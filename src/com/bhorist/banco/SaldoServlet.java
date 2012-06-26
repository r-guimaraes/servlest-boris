package com.bhorist.banco;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaldoServlet")
public class SaldoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SaldoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = (String)request.getAttribute("usuario");
		if(usuario == null) {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
			return;
		} else {
			PrintWriter pw = response.getWriter();
			pw.println("<html><body><h4>Autenticação OK</h4>");
			pw.println("Usuário: " + usuario + "<br />");
			pw.println("Saldo: " + (int)(Math.random()*1000));
			pw.println("</body></html>");
		}		
	} //doPost

} //SaldoServlet
