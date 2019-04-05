package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Wizard;
import uist17.homeframe;

public class BrisanjeWizarda extends AbstractAction {

	/**
	 * 
	 */

	public BrisanjeWizarda(){
		putValue(NAME,homeframe.getInstance().getResourceBundle().getString("wiz"));
		putValue(SHORT_DESCRIPTION, homeframe.getInstance().getResourceBundle().getString("dijWi"));
		//putValue(MNEMONIC_KEY, KeyEvent.VK_B);
		//putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl D"));
		//putValue(SMALL_ICON, new ImageIcon("images/delete-16x16.png"));
		//putValue(LARGE_ICON_KEY, new ImageIcon("images/delete-32x32.png"));
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode selected = (DefaultMutableTreeNode) homeframe.getInstance().getStablo().getLastSelectedPathComponent();
		if (selected!=null){
		Object o = selected.getUserObject();
		if(o instanceof Wizard == false){
		JOptionPane.showMessageDialog(null,homeframe.getInstance().getResourceBundle().getString("dijWi"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);		
	}else{
		homeframe.getInstance().getStablo().obrisiWizard(selected);
		homeframe.getInstance().getStablo().refreshModel();
		
	}
		}  else {
			JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("dijWi"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
		}
		
	}
}
