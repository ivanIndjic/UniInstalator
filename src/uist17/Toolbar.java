package uist17;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.BrisanjeParametra;
import controller.BrisanjeProjekta;
import controller.BrisanjeWizarda;
import controller.DodavanjeParametra;
import controller.DodavanjeProjekta_nastavak;
import controller.DodavanjeWizarda;
import controller.HelpAction;
import controller.IzmenaParametra;
import controller.IzmenaProjekta;
import controller.IzmenaWizarda;
import controller.Dodavanje_projekta;

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

import controller.OtvaranjeWorkspaceAction;
import controller.SaveAction;


public class Toolbar extends JToolBar{
	private JFrame parent=null;
	
	public Toolbar(){
		super(SwingConstants.HORIZONTAL);
		this.parent=parent;

		JButton btnNewp= new JButton();
		btnNewp.setToolTipText(homeframe.getInstance().getResourceBundle().getString("newP"));
		btnNewp.setIcon(new ImageIcon("imagestoolbar/window_new.png"));
		btnNewp.addActionListener(new DodavanjeProjekta_nastavak());
		add(btnNewp);


		JButton btnNeww= new JButton();
		btnNeww.setToolTipText(homeframe.getInstance().getResourceBundle().getString("newW"));
		btnNeww.setIcon(new ImageIcon("imagestoolbar/wizard.jpg"));
		btnNeww.addActionListener(new DodavanjeWizarda());
		add(btnNeww);


		JButton btnNewpar= new JButton();
		btnNewpar.setToolTipText(homeframe.getInstance().getResourceBundle().getString("newPP"));
		btnNewpar.setIcon(new ImageIcon("imagestoolbar/stock_chart_edit_type.jpg"));
		btnNewpar.addActionListener(new DodavanjeParametra());
		add(btnNewpar);

		addSeparator();
		
		JButton btnRemovep= new JButton();
		btnRemovep.setToolTipText(homeframe.getInstance().getResourceBundle().getString("remP"));
		btnRemovep.setIcon(new ImageIcon("imagestoolbar/folder_delete.jpg"));
		btnRemovep.addActionListener(new BrisanjeProjekta());
		add(btnRemovep);
	
		JButton btnRemovew= new JButton();
		btnRemovew.setToolTipText(homeframe.getInstance().getResourceBundle().getString("remW"));
		btnRemovew.setIcon(new ImageIcon("imagestoolbar/star_delete2.jpg"));
		btnRemovew.addActionListener(new BrisanjeWizarda());
		add(btnRemovew);
		//addSeparator();
		
		JButton btnRemovepar= new JButton();
		btnRemovepar.setToolTipText(homeframe.getInstance().getResourceBundle().getString("remPP"));
		btnRemovepar.setIcon(new ImageIcon("imagestoolbar/rss_file_remove.jpg"));
		btnRemovepar.addActionListener(new BrisanjeParametra());
		add(btnRemovepar);
		
		addSeparator();
		
		JButton btnChangep= new JButton();
		btnChangep.setToolTipText(homeframe.getInstance().getResourceBundle().getString("chaP"));
		btnChangep.setIcon(new ImageIcon("imagestoolbar/projectch.jpg"));
		btnChangep.addActionListener(new IzmenaProjekta());
		add(btnChangep);
	
		JButton btnChangew= new JButton();
		btnChangew.setToolTipText(homeframe.getInstance().getResourceBundle().getString("chaW"));
		btnChangew.setIcon(new ImageIcon("imagestoolbar/wizardch.jpg"));
		btnChangew.addActionListener(new IzmenaWizarda());
		add(btnChangew);
		//addSeparator();
		
		JButton btnChangepar= new JButton();
		btnChangepar.setToolTipText(homeframe.getInstance().getResourceBundle().getString("chaPP"));
		btnChangepar.setIcon(new ImageIcon("imagestoolbar/paramch.jpg"));
		btnChangepar.addActionListener(new IzmenaParametra());
		add(btnChangepar);
		
		addSeparator();
		

		JButton btnOpen=new JButton(new OtvaranjeWorkspaceAction());
		btnOpen.setToolTipText(homeframe.getInstance().getResourceBundle().getString("open"));
		btnOpen.setIcon(new ImageIcon("imagestoolbar/open_22x22.jpg"));
		add(btnOpen);
		
		JButton btnSave=new JButton(new SaveAction());
		btnSave.setToolTipText(homeframe.getInstance().getResourceBundle().getString("save"));
		btnSave.setIcon(new ImageIcon("imagestoolbar/gnome_dev_floppy.jpg"));
		add(btnSave);

		addSeparator();
		
		JButton btnHelp=new JButton(new HelpAction());
		btnHelp.setToolTipText(homeframe.getInstance().getResourceBundle().getString("help"));
		btnHelp.setIcon(new ImageIcon("imagestoolbar/help_browser.jpg"));
		add(btnHelp);
		setFloatable(true);

		
	//	setFloatable(true);
		
	}
	
	
}
