package uist17;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import controller.Serialization;
import model.Parametar;
import model.Projekat;
import model.Wizard;
import model.Workspace;
import view.TreeCellRenderer;

public class Stablo extends JTree {
	
	
	
	public Stablo(Workspace w){
		super(new DefaultMutableTreeNode(w));
		popuniStablo(w);
		this.setCellRenderer(new TreeCellRenderer());
		this.setPreferredSize(new Dimension(200,150));
		this.setVisible(true);
	}
	public void popuniStablo(Workspace w){
		System.out.println(w.getProjekti().size());
		DefaultMutableTreeNode koren = (DefaultMutableTreeNode) this.getModel().getRoot();
		koren.removeAllChildren();
		for(int i = 0 ; i < w.getProjekti().size(); i++){
			DefaultMutableTreeNode roditelj = new DefaultMutableTreeNode(w.getProjekti().get(i));
			for(int j = 0 ; j < w.getProjekti().get(i).getVizardi().size(); j++){
				DefaultMutableTreeNode roditeljWizard = new DefaultMutableTreeNode(w.getProjekti().get(i).getVizardi().get(j));
				for(int k = 0; k < w.getProjekti().get(i).getVizardi().get(j).getParametri().size(); k++){
					roditeljWizard.add(new DefaultMutableTreeNode(w.getProjekti().get(i).getVizardi().get(j).getParametri().get(k)));
					
				}
				roditelj.add(roditeljWizard);
				//break;
				
			}
			koren.add(roditelj);
		}
	}
	public void dodajProjekatUWorkspace(String ime){
		Projekat p = new Projekat(ime);
		homeframe.getInstance().getW().getProjekti().add(p);
		DefaultMutableTreeNode koren = (DefaultMutableTreeNode) this.getModel().getRoot();
		koren.add(new DefaultMutableTreeNode(p));
		
	}
	public void obrisiProjekatIzWorkspace(DefaultMutableTreeNode selected){
		Workspace w = homeframe.getInstance().getW();
		Object o = selected.getUserObject();
		Projekat zaBrisanje = (Projekat) o;
		
		w.getProjekti().remove(zaBrisanje);
		DefaultMutableTreeNode koren = (DefaultMutableTreeNode) this.getModel().getRoot();
		koren.remove(selected);
		
	}
	public void dodajWizardUProjekat(DefaultMutableTreeNode parent, String ime){
		Wizard wizard = new Wizard(ime);
		Object o = parent.getUserObject();
		Projekat roditelj = (Projekat) o;
		roditelj.getVizardi().add(wizard);
		parent.add(new DefaultMutableTreeNode(wizard));

	}
	public void izmeniWizard(DefaultMutableTreeNode parent,String ime){
		DefaultMutableTreeNode selected=(DefaultMutableTreeNode) homeframe.getInstance().getStablo().getLastSelectedPathComponent();
	}

	public void obrisiWizard(DefaultMutableTreeNode selected){
		
		Object o = selected.getUserObject();
		Wizard zaBrisanje = (Wizard) o;
		DefaultMutableTreeNode roditeljUStablu = (DefaultMutableTreeNode) selected.getParent();
		Projekat roditelj = (Projekat) roditeljUStablu.getUserObject();
		DefaultMutableTreeNode parent=(DefaultMutableTreeNode) selected.getParent();
		roditelj.getVizardi().remove(zaBrisanje);
		parent.remove(selected);
	  
	  }
	public void dodajParametarUWizard1(DefaultMutableTreeNode parent, String ime,boolean vidlj,boolean cit,String tip,boolean ist,boolean popunjavanje){
		Parametar p = new Parametar(ime,vidlj,cit,tip,ist,popunjavanje);
		Object o = parent.getUserObject();
		Wizard roditelj = (Wizard) o;
		roditelj.getParametri().add(p);
		parent.add(new DefaultMutableTreeNode(p));
	}
	public void dodajParametarUWizard2(DefaultMutableTreeNode parent, String ime,boolean vidlj,boolean cit,String tip,String op,boolean popunjavanje){
		Parametar p = new Parametar(ime,vidlj,cit,tip,op,popunjavanje);
		Object o = parent.getUserObject();
		Wizard roditelj = (Wizard) o;
		roditelj.getParametri().add(p);
		parent.add(new DefaultMutableTreeNode(p));
	}
	
	public void izmeniParametra(String ime,String novoIme){
		Projekat p = homeframe.getInstance().getW().findbyname(ime);
		p.setIme(novoIme);
	}
	
	public void refreshModel(){
		((DefaultTreeModel)this.getModel()).reload();
	}

	public void obrisiParametar(DefaultMutableTreeNode selected) {
		// TODO Auto-generated method stub
		Object o = selected.getUserObject();
		Parametar zaBrisanje = (Parametar) o;
		DefaultMutableTreeNode roditeljUStablu = (DefaultMutableTreeNode) selected.getParent();
		Wizard roditelj = (Wizard) roditeljUStablu.getUserObject();
		DefaultMutableTreeNode parent=(DefaultMutableTreeNode) selected.getParent();
		roditelj.getParametri().remove(zaBrisanje);
		parent.remove(selected);
	
		
	}

	
	
	
	
	
	
}
