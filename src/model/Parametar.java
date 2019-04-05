package model;

import java.io.Serializable;
import java.util.UUID;

import javax.swing.ImageIcon;

public class Parametar implements Serializable {
	/**
	 * 
	 */

	private UUID id;
	private String naziv;
	private String tip;
	private boolean vidljivost;
	private boolean readonly;
	private boolean obavezno_popunjavanje;
	private ImageIcon ikonica; 
	
	private boolean istBool;
	private String opis;
	
	
	public ImageIcon getIkonica() {
		return ikonica;
	}

	public void setIkonica(ImageIcon ikonica) {
		this.ikonica = ikonica;
	}
	
	public Parametar(String ime,boolean vidlj,boolean cit,String tip){
		this.naziv = ime;
		this.vidljivost=vidlj;
		this.readonly=cit;
		this.tip=tip;
		
	}
	public Parametar(String ime,boolean vidlj,boolean cit,String tip,boolean ist,boolean popunjavanje){
		this.naziv = ime;
		this.vidljivost=vidlj;
		this.readonly=cit;
		this.tip=tip;
		this.istBool=ist;
		this.obavezno_popunjavanje = popunjavanje;
	}
	public Parametar(String ime,boolean vidlj,boolean cit,String tip,String opisl,boolean popunjavanje){
		this.naziv = ime;
		this.vidljivost=vidlj;
		this.readonly=cit;
		this.tip=tip;
		this.opis=opisl;
		this.obavezno_popunjavanje = popunjavanje;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public boolean getVidljivost(){
		return vidljivost;
	}
	public void setVidljivost(boolean vidljivost){
		this.vidljivost=vidljivost;
	}
	public boolean getreadonly(){
		return readonly;
	}
	public void setreadonly(boolean readonly){
		this.readonly=readonly;
	}/////////////////
	
	public boolean getBool(){
		return istBool;
	}
	public void setBool(boolean istina){
		this.istBool=istina;
	}
	public String getJeVi(){
		return opis;
	}
	public void setJevi(String op){
		this.opis=op;
	}

	public boolean getObavezno_popunjavanje() {
		return obavezno_popunjavanje;
	}

	public void setObavezno_popunjavanje(boolean obavezno_popunjavanje) {
		this.obavezno_popunjavanje = obavezno_popunjavanje;
	}


}
