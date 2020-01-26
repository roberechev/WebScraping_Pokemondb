<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		ArrayList<String> pokemones = (ArrayList<String>) request.getAttribute("pokemonCaracteristicas");
		ArrayList<String> images = (ArrayList<String>) request.getAttribute("rutaImagenEntera");
		String table = "<!Doctype Html><html><head><meta charset=\'UTF-8\'></head><body><table border=1>";
		int t = 1;
		for (int i = 0; i < images.size(); i++) {

			table += "<tr>";

			if (i == 0) {
				table += "<td>" + "<img width=\"32px\" src=\"" + "camera.png" + "\"/>" + "</td>";
			} else {
				table += "<td>" + "<img src=\"" + images.get(i) + "\"/>" + "</td>";
			}
			table += "<td>" + pokemones.get(i) + "</td>";
			table += "</tr>";
			t++;
		}
		table += "</table></body>";
		out.print(table);
	%>
</body>
</html>