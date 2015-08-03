package com.ipst.modele;

import java.io.Serializable;

public class Camion implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private int poidsmax;
	private int volumemax;
	private int Typedechets_id;
	private boolean disponible;

	public Camion(){
	}
	public Camion(int id,int p,int v,int t,boolean d){
		this.id=id;
		this.poidsmax=p;
		this.volumemax=v;
		this.Typedechets_id=t;
		this.disponible=d;
	}
	public int get_id(){
		return this.id;
	}
	public int get_poidsmax(){
		return this.poidsmax;
	}
	public int get_volumemax(){
		return this.volumemax;
	}
	public int get_Typedechets_id(){
		return this.Typedechets_id;
	}
	public boolean get_disponible(){
		return this.disponible;
	}
	public void set_id(int a){
		this.id=a;
	}
	public void set_poidsmax(int a){
		this.poidsmax=a;
	}
	public void set_volumemax(int a){
		this.volumemax=a;
	}
	public void set_Typedechets_id(int a){
		this.Typedechets_id=a;
	}
	public void set_disponible(boolean a){
		this.disponible=a;
	}
}
