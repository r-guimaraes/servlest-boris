package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/BeerSelect", "/SelectBeer.do" })
public class BeerSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BeerSelect() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter escreve = response.getWriter();
		String nome = request.getParameter("nome");
		String raiz = request.getContextPath();
		escreve.println("Qualé, " + nome + ". Raiz desse servlet ~> " + raiz);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Beer Selection Advice <br />");
		String beerColor = request.getParameter("color");
		String ip = request.getRemoteHost();		
		out.println("<br /> Got beer color " + beerColor + ". Seu IP: " + ip + "<br />");
		
		for(Enumeration<String> enm = request.getHeaderNames(); enm.hasMoreElements();) {
			String headerKey = (String)enm.nextElement();
			String headerValue = request.getHeader(headerKey);
			out.println("<strong>"+headerKey +"</strong>: " + headerValue + "<br />");		
		}
		
	} // doPost()

}
