package view;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Parametar;
import model.Projekat;
import model.Wizard;
import model.Workspace;


public class TreeCellRenderer extends DefaultTreeCellRenderer {

	private ImageIcon projekatIcon = new ImageIcon("imagestree/project.jpg");
	private ImageIcon wizardIcon = new ImageIcon("imagestree/wizard.jpg");
	private ImageIcon parametarIcon = new ImageIcon("imagestree/os_type_16px.jpg");
	
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		// Čvor koga treba iscrtati.
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
		Object o = node.getUserObject();

		// Podešavanje tekst čvora koji se iscrtava na osnovu naziva članka ili
		// kategorije iz modela.
		
		if (o instanceof Projekat) {
			Projekat proj = (Projekat) o;
			setText(proj.getIme());
			setIcon(projekatIcon);
		}else if(o instanceof Wizard){
			Wizard w = (Wizard) o;
			setText(w.getIme());
			setIcon(wizardIcon);
		}else if(o instanceof Parametar){
			Parametar par = (Parametar) o;
			setText(par.getNaziv());
			if(par.getTip().equals("Image")){
				ImageIcon ikonica = new ImageIcon(par.getJeVi());
				Image img = ikonica.getImage();
				Image img2 = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
				ikonica = new ImageIcon(img2);
				setIcon(ikonica);
			}
			else{
				setIcon(parametarIcon);
			}
		}else if(o instanceof Workspace){
			Workspace w = (Workspace) o;
			setText(w.getIme());
		}
		return this;
	}
}
