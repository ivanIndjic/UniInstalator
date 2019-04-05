package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.ImageIcon;

public class Projekat implements Serializable {
	/**
	 * 
	 */

	private UUID id;
	private String ime;
	private ArrayList<Wizard> vizardi;
	private ImageIcon ikonica;
	
	public Projekat(){}
	
	public Projekat(String ime){
		this.id = UUID.randomUUID();
		this.ime = ime;
		this.vizardi = new ArrayList<Wizard>();
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public ArrayList<Wizard> getVizardi() {
		return vizardi;
	}

	public void setVizardi(ArrayList<Wizard> vizardi) {
		this.vizardi = vizardi;
	}
	public Wizard findWizardByName(String name){
		for(int i = 0;i<vizardi.size();i++){
			if(vizardi.get(i).getIme().equals(name)){
				return vizardi.get(i);
			}
		}
		return null;
	}
	public ImageIcon getIkonica() {
		return ikonica;
	}

	public void setIkonica(ImageIcon ikonica) {
		this.ikonica = ikonica;
	}
	
}
