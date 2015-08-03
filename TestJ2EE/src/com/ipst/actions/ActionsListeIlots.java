package com.ipst.actions;

import java.util.List;

import com.ipst.daos.DAOFactory;
import com.ipst.daos.DAOIlot;
import com.ipst.modele.Ilot;

public class ActionsListeIlots {
	
	public List<Ilot> executer() throws Exception{
		DAOIlot dao = DAOFactory.creerDAOIlot();
	    List<Ilot> liste = dao.select();
	    
	    //traiter éventuellement la liste
	    
	    return liste;
	}
}
