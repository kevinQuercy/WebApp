<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.ipst.modele.Camion"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Liste des Camions</title>
</head>
<body>
	 <div>
         <% 
            List<Camion> liste= (List<Camion>) request.getAttribute("liste");
            for(Camion c : liste){
         %>
         		<p><%= c.get_id() %></p>
         		<p><%= c.get_poidsmax() %></p>
         		<p><%= c.get_volumemax() %></p>
         		<p><%= c.get_Typedechets_id() %></p>
         		<p><%= c.get_disponible() %></p>
         <%} 
         %>
     </div>
</body>
</html>