package com.ipst.modele;

public class Ilotdepassage {
	private Ilot ilot;
	private int Itineraire_id;
	private int ordre;
	
	public Ilotdepassage() {
	}
	public Ilotdepassage(Ilot a,int b) {
		this.ilot=a;
		this.ordre=b;
	}
	public Ilot get_Ilot() {
		return this.ilot;
	}
	public int get_Itineraire_id() {
		return this.Itineraire_id;
	}
	public int get_ordre() {
		return this.ordre;
	}
	public void set_ilot(Ilot i) {
		this.ilot = i;
	}
	public void set_Itineraire_id(int i) {
		this.Itineraire_id = i;
	}
	public void set_ordre(int i) {
		this.ordre = i;
	}
}