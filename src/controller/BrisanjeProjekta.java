package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Projekat;
import uist17.homeframe;

public class BrisanjeProjekta extends AbstractAction {

	/**
	 * 
	 */
	public BrisanjeProjekta() {
		// TODO Auto-generated constructor stub
			putValue(NAME, homeframe.getInstance().getResourceBundle().getString("proj"));
			putValue(SHORT_DESCRIPTION, homeframe.getInstance().getResourceBundle().getString("dijSPP"));
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode selected = (DefaultMutableTreeNode) homeframe.getInstance().getStablo().getLastSelectedPathComponent();
	
		if (selected != null){
		Object o = selected.getUserObject();
		if(o instanceof Projekat == false){
		JOptionPane.showMessageDialog(null,homeframe.getInstance().getResourceBundle().getString("dijSPP"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);		
		}else{
			homeframe.getInstance().getStablo().obrisiProjekatIzWorkspace(selected);
			homeframe.getInstance().getStablo().refreshModel();
		}
		
	}
	 else {
		JOptionPane.showMessageDialog(null,homeframe.getInstance().getResourceBundle().getString("dijSPP"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);		
		}

	}
}