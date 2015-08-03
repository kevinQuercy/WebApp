package com.ipst.actions;

import java.util.List;

import com.ipst.daos.DAOCamion;
import com.ipst.daos.DAOFactory;
import com.ipst.modele.Camion;

public class ActionListeCamions {

	public List<Camion> executer() throws Exception {
		DAOCamion dao = DAOFactory.creerDAOCamion();
	    List<Camion> liste = dao.select();
	    
	    //traiter éventuellement la liste
	    
	    return liste;
	}
}
