<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.ipst.modele.Ilot" %>
<%@page import="java.util.List" %>


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
<script type="text/javascript">
	      function initialize() {
	        var mapOptions = {
	          center: { lat: 43.604429, lng: 1.443484},
	          zoom: 14
	        };
	        var map = new google.maps.Map(document.getElementById('map-canvas'),
	            mapOptions);
	    	//création du marqueur
	    	var marqueur = new google.maps.Marker({
	    		position: new google.maps.LatLng(43.598148, 1.451931),
	    		map: map
	    	});
	    	
	    	var infowindow = new google.maps.InfoWindow({
	    		  content:"Salut JEWKSU!"
	    		  });

	    		infowindow.open(map,marqueur);

	      }
	      google.maps.event.addDomListener(window, 'load', initialize);
	    </script>
	<div id="map-canvas"></div>
</body>