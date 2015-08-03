package com.ipst.modele;

public class User {
	
	private String login;
	private String mdp;
	
	public User(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getMdp() {
		return mdp;
	}
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	

}
