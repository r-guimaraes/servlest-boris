<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.http.*, java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jsp's agora</title>
</head>
<body>
<h3>Início do estudo de JSP</h3>
 <%! 
 int contador = 0;  
 String contadorArquivo;
 
 public void sendInt(int v) throws Exception {
	 FileOutputStream fos = new FileOutputStream(contadorArquivo);
	 DataOutputStream dos = new DataOutputStream(fos);
	 dos.writeInt(v);
	 dos.close();
 }
 public int getInt() throws Exception {
	 FileInputStream fis = new FileInputStream(contadorArquivo);
	 DataInputStream dis = new DataInputStream(fis);
	 contador = dis.readInt();
	 dis.close();
	 return contador;
 }
 public void jspInit(){
	 try {
		 ServletContext sc = getServletContext();
		 contadorArquivo = sc.getRealPath("/WEB-INF/contador.txt");
		 if (!new File(contadorArquivo).exists()) {
			 sendInt(0);
		 }
		 contador = getInt();
	 } catch (Exception error) {
		 log("ups");		 
	 }
 } //jpsInit
 public void jspDestroy(){
	 try {
		 sendInt(contador);
	 } catch(Exception error) {
		 log("Erro ao salvar arquivo de contador", error);
	 }
 } //jspDestroy
 %>
 <% contador++; %>
 Acesso à página de número <%= contador %>.
</body>
</html>