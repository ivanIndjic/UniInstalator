package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Parametar;
import uist17.homeframe;

public class BrisanjeParametra extends AbstractAction {

	/**
	 * 
	 */
	public BrisanjeParametra() {
		// TODO Auto-generated constructor stub
		putValue(NAME, homeframe.getInstance().getResourceBundle().getString("par"));
		putValue(SHORT_DESCRIPTION, homeframe.getInstance().getResourceBundle().getString("dijSP"));
	
	}
	public void actionPerformed(ActionEvent arg0) {
		
		DefaultMutableTreeNode selected = (DefaultMutableTreeNode) homeframe.getInstance().getStablo().getLastSelectedPathComponent();
		if (selected!=null){
		Object o = selected.getUserObject();
		if(o instanceof Parametar == false){
		JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("dijSP"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);		
		}else{
			homeframe.getInstance().getStablo().obrisiParametar(selected);
			homeframe.getInstance().getStablo().refreshModel();
			
		}
		}	
		else{
			JOptionPane.showMessageDialog(null,homeframe.getInstance().getResourceBundle().getString("dijSP"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);		
		}
	}
	
}
