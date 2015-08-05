package com.ipst.testServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipst.actions.ActionsListeIlots;
import com.ipst.modele.Conteneur;
import com.ipst.modele.Ilot;

/**
 * Servlet implementation class MaServlet
 */
@WebServlet(name = "MaServlet", urlPatterns = {"/connexion"})
public class MaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Dans la servlet");
		/*response.setContentType("text/html");
		PrintWriter	writer = response.getWriter();
		writer.println("<HTML>");
		writer.println("<HEAD><TITLE>Liste des formations du catalogue</TITLE></HEAD>");
		writer.println("<BODY>");
		writer.println("<CENTER> Liste des formations : JAVA, WEBSERVICES </CENTER>");
		writer.println("</BODY>");
		writer.println("</HTML>");*/
		//traitement(request, response);
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
	}
	
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int action = Integer.parseInt(request.getParameter("action"));
		
		HttpSession session = request.getSession();
		
		try {
			switch(action) {
	         
		         case 1 : //liste des ilots
		         {
		        	/* String login = request.getParameter("login");
		     		 String mdp = request.getParameter("mdp");
		     		
		        	 if("dje".equalsIgnoreCase(login) && "yop".equalsIgnoreCase(mdp)) {
		     			dispatcher = request.getRequestDispatcher("accueil.jsp");
		     		 } else {
		     			dispatcher = request.getRequestDispatcher("index.html");
		     		   }
		     		
		     		 dispatcher.forward(request, response);*/
		        	 ActionsListeIlots ac = new ActionsListeIlots();
		        	 List<Conteneur> listeC = null;
		        	 List<Ilot> liste = ac.executer();
			         for(Ilot i : liste){
			        	 System.out.println("ID Ilot: " + i.get_id());
			        	 System.out.println("Adresse: " + i.get_adresse());
			        	 System.out.println("Code Postal: " + i.get_codepostal());
			        	 System.out.println("Ville: " + i.get_ville());
			        	 System.out.println("Longitude: " + i.get_longitude());
			        	 System.out.println("Latitude: " + i.get_latitude());
			        	 System.out.println("Contact: " + i.get_Contact_id());
			        	 listeC = i.get_conteneurs();
			        	 for(Conteneur co : listeC){
			        		 System.out.println("ID conteneur: " + co.get_id());
			        		 System.out.println("Volume max: " + co.get_volumemax());
			        		 System.out.println("Dernier Volume: " + co.get_lastvolume());
			        		 System.out.println("Dernier poids: " + co.get_lastpoids());
			        		 System.out.println("Dernière MAJ: " + co.get_lastupdate());
			        		 System.out.println("Iloy id: " + co.get_Ilot_id());
			        		 System.out.println("Type déchet id: " + co.get_TypeDechets_id());
			        	 }
			        	 
			         }
			         
			         request.setAttribute("liste", liste);
			         //dispatcher = getServletContext().getRequestDispatcher("/ListeIlots.jsp");
			         this.getServletContext().getRequestDispatcher("/ilotMap.jsp").forward(request, response);
			         //dispatcher.forward(request, response);
		         }
		             break;
		             
		         case 2 :
		         {
		        	 
		         }
		             break;
		             
		         case 3 : 
		         {
		            
		         }
		             break;
		             
		         case 4 :
		         {
		            
		         }
		             break;
		             
		         case 5 :
		         {
		           
		         }
		             break;
		             
		         case 6 :
		         {
		             
		         }
	         }
		} catch (Exception e) {
			
		}
	}

}
