package uist17;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.BrisanjeParametra;
import controller.BrisanjeProjekta;
import controller.BrisanjeWizarda;
import controller.DodavanjeParametra;
import controller.DodavanjeProjekta_nastavak;
import controller.DodavanjeWizarda;
import controller.IzmenaParametra;
import controller.IzmenaProjekta;
import controller.IzmenaWizarda;
import controller.Dodavanje_projekta;

public class Glavni_prozor extends JMenuBar {
	private JFrame parent=null;
	
	public Glavni_prozor() {
	this.parent=parent;
	JMenu file=new JMenu(homeframe.getInstance().getResourceBundle().getString("file"));
	JMenu novo=new JMenu(homeframe.getInstance().getResourceBundle().getString("new"));
	
	JMenuItem jprojekat=new JMenuItem(new DodavanjeProjekta_nastavak());
	JMenuItem jwizard=new JMenuItem(new DodavanjeWizarda());
	JMenuItem jparametar = new JMenuItem(new DodavanjeParametra());
	novo.add(jprojekat);
	novo.add(jwizard);
	novo.add(jparametar);
	//novo.add(project);
	JMenu remove = new JMenu(homeframe.getInstance().getResourceBundle().getString("remove"));
	JMenuItem removeProject = new JMenuItem(new BrisanjeProjekta());
	remove.add(removeProject);
	JMenuItem removeWizard=new JMenuItem(new BrisanjeWizarda());
	remove.add(removeWizard);
	JMenuItem removeParametar=new JMenuItem(new BrisanjeParametra());
	remove.add(removeParametar);
	
	JMenu change = new JMenu(homeframe.getInstance().getResourceBundle().getString("Change"));
	JMenuItem changeProject = new JMenuItem(new IzmenaProjekta());
	JMenuItem changeWizard = new JMenuItem(new IzmenaWizarda());
	JMenuItem changeParametar=new JMenuItem(new IzmenaParametra());
	change.add(changeProject);
	change.add(changeWizard);
	change.add(changeParametar);
	file.add(change);
	
	file.addSeparator();
	file.add(novo);
	file.addSeparator();
	file.add(remove);
	
	add(file);
	}
}
