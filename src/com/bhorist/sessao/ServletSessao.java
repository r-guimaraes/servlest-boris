package com.bhorist.sessao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletSessao")
public class ServletSessao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletSessao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		List<Integer> listaSessoes = (List<Integer>) sessao.getAttribute("valores");
		
		if(listaSessoes == null) {
			listaSessoes = new ArrayList<Integer>();
		}
		int numero_sessao = (int)(Math.random() * 1000);
		listaSessoes.add(numero_sessao);
		sessao.setAttribute("valores",listaSessoes);
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><body><h4>Número acrescentado nesta sessão:"+ numero_sessao +"</h4>");
		pw.println("Clique <a href=\"/exemplo/InvalidaSessao\"> aqui </a>");
		pw.println("para invalidar a sessão. <br /><strong>Resultado</strong>");
		for(int i : listaSessoes){
			pw.println(i + "<br />");
		}
		Iterator al = listaSessoes.iterator();
		
		while(al.hasNext()){
			pw.println("</h5>"+ al.next() +"</h5>");			
		}
		
		pw.println("</body></html>");
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
