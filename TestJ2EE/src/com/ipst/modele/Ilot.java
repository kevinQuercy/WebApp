package com.ipst.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ilot implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String adresse;
	private int codepostal;
	private String ville;
	private Double longitude;
	private Double latitude;
	private int Contact_id;
	private List<Conteneur> conteneurs;
	
	public Ilot(){
		conteneurs= new ArrayList<Conteneur>();
	}
	public int get_id() {
		return this.id;
	}
	public String get_adresse() {
		return this.adresse;
	}
	public int get_codepostal() {
		return this.codepostal;
	}
	public String get_ville() {
		return this.ville;
	}
	public Double get_longitude() {
		return this.longitude;
	}
	public Double get_latitude() {
		return this.latitude;
	}
	public int get_Contact_id() {
		return this.Contact_id;
	}
	public List<Conteneur> get_conteneurs() {
		return this.conteneurs;
	}
	public void set_id(int a) {
		this.id=a;
	}
	public void set_adresse(String a) {
		this.adresse=a;
	}
	public void set_codepostal(int a) {
		this.codepostal = a; 
	}
	public void set_ville(String a) {
		this.ville=a;
	}
	public void set_longitude(Double a) {
		this.longitude=a;
	}
	public void set_latitude(Double a) {
		this.latitude=a;
	}
	public void set_Contact_id(int a) {
		this.Contact_id=a;
	}
	public void set_conteneurs(List<Conteneur> lc) {
		this.conteneurs=lc;
	}
	public void addconteneur(Conteneur c) {
		this.conteneurs.add(c);
	}
}
