package model;

import java.io.Serializable;
import java.util.ArrayList;



public class Workspace implements Serializable {
	/**
	 * 
	 */

	private String ime;
	private ArrayList<Projekat> projekti;
	
	public Workspace(){
		
	}
	
	public Workspace(String ime){
		this.setIme(ime);
		this.setProjekti(new ArrayList<Projekat>());
	}
	public ArrayList<Projekat> getProjekti() {
		return projekti;
	}
	public void setProjekti(ArrayList<Projekat> projekti) {
		this.projekti = projekti;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public Projekat findbyname(String ime1){
		for(int i=0;i<projekti.size();i++){
			if(projekti.get(i).getIme().equals(ime1)){
				return projekti.get(i);
			}
		}
		return null;
	}
}
