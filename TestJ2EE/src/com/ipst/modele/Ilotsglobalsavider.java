package com.ipst.modele;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.ipst.daos.DAOCamion;
import com.ipst.daos.DAOConteneur;
import com.ipst.daos.DAOFactory;
import com.ipst.daos.DAOHistorique;
import com.ipst.daos.DAOIlot;
import com.ipst.daos.DAOTypedechets;

public class Ilotsglobalsavider {
	private List<Ilotsavider> ilotsavider;
	
	public Ilotsglobalsavider(int taux,Date datelimite) throws Exception {
		ilotsavider = new LinkedList<Ilotsavider>();
		DAOIlot daoilot = DAOFactory.creerDAOIlot();
		// recuperation de tous les ilots
		List<Ilot> touslesilots = daoilot.select();
		// recuperation de tous les types de dechets
		DAOTypedechets daotypedechets = DAOFactory.creerDAOTypedechets();
		List<Typedechets> touslesdechets = daotypedechets.select();
		System.out.println ("Nombre de types de dechets : " + touslesdechets.size());
		DAOCamion daocamion = DAOFactory.creerDAOCamion();
		List<Camion> camionsdisponibles = daocamion.selectdisponible();
		System.out.println ("Nombre de camions disponibles : " + camionsdisponibles.size());
		// Pour tous les types de dechets
		for ( int i = 0 ; i < touslesdechets.size(); i++ ) {
			Ilotsavider il = new Ilotsavider(touslesdechets.get(i).get_id());
			// pour tous les camions disponibles
			for ( int j = 0 ; j < camionsdisponibles.size(); j++ ) {
				if(camionsdisponibles.get(j).get_Typedechets_id() == touslesdechets.get(i).get_id()) {
					il.ajoutercamion(camionsdisponibles.get(j));
				}
			}
			// Pour tous les ilots
			for (int k = 0 ; k < touslesilots.size() ; k++ ) {
				List<Conteneur> cont = touslesilots.get(k).get_conteneurs();
				int volumemax = 0;
				int volumeencours = 0;
				int poids = 0;
				boolean passageoblige = false;
				// Pour tous les conteneurs de l'ilots
				for (int l = 0 ; l < cont.size(); l++) {
					// Si le conteneur est du type que l'on recherche
					if(cont.get(l).get_TypeDechets_id() == touslesdechets.get(i).get_id()) {
						// Si le conteneur est de type tout venant et qu'il n'est pas vide
						if(touslesdechets.get(i).get_id() == 1 && cont.get(l).get_lastvolume()>0 && cont.get(l).get_lastpoids()>0) {
							// on verifie qu'il a �t� vid� durant le temps indiqu�
							DAOHistorique daohistorique = DAOFactory.creerDAOHistorique();
							if(daohistorique.selectderniervidage(cont.get(l).get_id()).before(datelimite) ) {
								System.out.println(daohistorique.selectderniervidage(cont.get(l).get_id()));
								passageoblige=true;
							}
						}
						// Ajouter ses donn�es a l'ilots
						volumemax = volumemax + cont.get(l).get_volumemax();
						volumeencours = volumeencours + cont.get(l).get_lastvolume();
						poids = poids + cont.get(l).get_lastpoids();
					}
				}
				// Si le volume en cours de l'ilot est superieur � 0
				if(volumeencours > 0 ) {
					// Si le taux en cours et sup�rieur au taux limite
					if(volumeencours  * 100 / volumemax >= taux || passageoblige) {
						// ajouter l'ilot a la liste des ilot
						il.ajouterilot(touslesilots.get(k));
					}
				}
			}
			this.ajouterilotsavider(il);
		}
	}
	
	public void ajouterilotsavider(Ilotsavider i) {
		this.ilotsavider.add(i);
	}
	public List<Ilotsavider> get_ilotsavider() {
		return this.ilotsavider;
	}
}
