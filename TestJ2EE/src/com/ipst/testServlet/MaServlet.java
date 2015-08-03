package com.ipst.testServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipst.actions.ActionListeCamions;
import com.ipst.modele.Camion;

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
		        	 ActionListeCamions ac = new ActionListeCamions();
		        	 List<Camion> liste = ac.executer();
			         for(Camion c : liste){
			        	 System.out.println("ID Camion: " + c.get_id());
			        	 System.out.println("Poids max: " + c.get_poidsmax());
			        	 System.out.println("Volume max: " + c.get_volumemax());
			        	 System.out.println("Type déchet: " + c.get_Typedechets_id());
			        	 System.out.println("disponible: " + c.get_disponible());
			        	 
			         }
			         
			         request.setAttribute("liste", liste);
			         //dispatcher = getServletContext().getRequestDispatcher("/ListeIlots.jsp");
			         this.getServletContext().getRequestDispatcher("/ListeIlots.jsp").forward(request, response);
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
