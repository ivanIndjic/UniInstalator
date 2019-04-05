package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Wizard implements Serializable {
	/**
	 * 
	 */
	private String ime;
	public ArrayList<Parametar> parametri;
	private ImageIcon ikonica;
	
	public Wizard(){}
	public Wizard(String ime){
		this.ime = ime;
		this.parametri = new ArrayList<Parametar>();
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public ArrayList<Parametar> getParametri(){
		return this.parametri;
	}
	public ImageIcon getIkonica() {
		return ikonica;
	}

	public void setIkonica(ImageIcon ikonica) {
		this.ikonica = ikonica;
	}
	public Parametar findParametarByName(String name){
		for(int i = 0;i<parametri.size();i++){
			if(parametri.get(i).getNaziv().equals(name)){
				return parametri.get(i);
			}
		}
		return null;
	}
}
