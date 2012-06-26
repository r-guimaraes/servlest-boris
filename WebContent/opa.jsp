<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.*, java.io.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Opa!</title>
</head>
<body>
	<form action="opa.jsp" method="GET">
		<input type="text" name="nome" /> <input
			type="submit" />
	</form>

	<%
	String nome = request.getParameter("nome");
	if((nome != null) && !(nome.equals(""))) { %>
	<h2>
		Boa noite, <%= nome %>. <br /> Novos conhecimentos JSP
	</h2>
	<% } else { 
	PrintWriter pw = response.getWriter();	
	pw.println("<h2>Digite um nome!</h2>");
	}
%>

<form action="opa.jsp" method="POST">
		<fieldset style="width: 350px">
			Selecione suas linguagens preferidas
			<select name="lang" size="4" multiple="mutiple">
				<option value="java">Java</option>
				<option value="ruby">Ruby</option>
				<option value="php">PHP</option>
				<option value="asp">ASP</option>
				<option value="python">Python</option>
			</select> <input type="submit" value="Enviar" />
		</fieldset>
	</form>
	<%
		String[] langs = request.getParameterValues("lang");
	  if (langs != null) {
			out.println("Então você gosta de ..");
		  for (int i=0; i < langs.length; i++) {
			out.println("<strong>" + langs[i] + "</strong> <br />");
			if(langs[i].equals("asp")) {
				out.println("Pouts .. ASP meu?! :/");
			}else if(langs[i].equals("java")){
				out.println("Daê pow! Java é a melhor mesmo! >D");
			}
		  }
	  }
	%>
</body>
</html>