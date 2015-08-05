<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.ipst.modele.Ilot" %>
<%@ page import="com.ipst.modele.Conteneur" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Carte des ilots</title>
	<style type="text/css">
	      html, body, #map-canvas { height: 100%; margin: 0; padding: 0;}
	    </style>
	    <script type="text/javascript"
	      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBHRZ6O1cuGU--6O0V_3QROeA-VJA4mB1k">
	    </script>
	    
</head>
<body>
	<% 
            List<Ilot> liste= (List<Ilot>) request.getAttribute("liste");    	       
    %>
	<script type="text/javascript">
			//Création de la map
		      function initialize() {
		        var mapOptions = {
		          center: { lat: 43.604429, lng: 1.443484},
		          zoom: 14
		        };
		        var map = new google.maps.Map(document.getElementById('map-canvas'),
		            mapOptions);
		        
				// tableaux destinés à sauvegarder les marqueurs et les infobulles
		        marqueurs = Array();
		        infoBulles = Array();
		        
		        //variable qui permet d indexer les infobulles
		        var i = 0;
		        
		        <%  
		        	
			        for(Ilot il : liste){
			        	double longit = il.get_longitude();
			        	double lat = il.get_latitude();
		        %>
		        
		    	//création du marqueur
		    	var marqueur = new google.maps.Marker({
		    		position: new google.maps.LatLng(<%= lat%>, <%= longit%>),
		    		map: map,
		    		infoWindowIndex : i
		    	});
		    	
		    	var adr = " <%= il.get_adresse() %> ";
		    	var vil = " <%= il.get_ville() %> ";
		    	
				var contenuInfoBulle = '<h1>Infos Ilot</h1>'+ 
										'<p> Ilot n°:' + <%= il.get_id() %> + '</p>' +
										'<p> Adresse:' + adr + '</p>' +
										'<p> Code postal:' + <%= il.get_codepostal() %> + '</p>' +
										'<p> Ville:' + vil + '</p>' + 
										'<p> latitude:' + <%= il.get_latitude() %> + '</p>' +
										'<p> Longitude:' + <%= il.get_longitude() %> + '</p>' +
										'<p> Contact:' + <%= il.get_Contact_id() %> + '</p>' + 
				
				<%
					List<Conteneur> listeC = il.get_conteneurs();
					for(Conteneur co : listeC) {
				%>
						'<h2>Infos Conteneurs</h2>' + 
						'<p> Conteneur n°:' + <%= co.get_id() %> + '</p>' + 
						'<p> Volume max:' + <%= co.get_volumemax() %> + '</p>' +
						'<p> Dernier volume:' + <%= co.get_lastvolume() %> + '</p>' +
						'<p> Dernier poids:' + <%= co.get_lastpoids() %> + '</p>';

				<%
					}
				%>
				
				//Création de l'infobulle
				var infoBulle = new google.maps.InfoWindow({
					content: contenuInfoBulle
				})
				
				
				
				google.maps.event.addListener(marqueur, 'click', 
						function(event) {
					 		map.panTo(event.latLng);
					 		infoBulles[this.infoWindowIndex].open(map, this);
						}
				);
				
				// Sauvegarde(ajout) des marqueurs et des infobulles dans un tableau
				infoBulles.push(infoBulle);
		        marqueurs.push(marqueur);
		        i++;
		    	<%
		    		}
		        %>
		        
	
		      }
		      google.maps.event.addDomListener(window, 'load', initialize);
		    </script>
	<div id="map-canvas"></div>
</body>