package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.Wizard;
import uist17.Stablo;
import uist17.homeframe;

public class IzmenaWizarda extends AbstractAction {
	
	/**
	 * 
	 */


	public IzmenaWizarda() {
		putValue(NAME, homeframe.getInstance().getResourceBundle().getString("wiz"));
		putValue(SHORT_DESCRIPTION, homeframe.getInstance().getResourceBundle().getString("CC"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		DefaultMutableTreeNode selected = (DefaultMutableTreeNode) homeframe.getInstance().getStablo().getLastSelectedPathComponent();
		if (selected != null){
		JLabel lNNW = new JLabel(homeframe.getInstance().getResourceBundle().getString("lNNW"));
		JFrame izmena = new JFrame();
		JPanel panel = new JPanel();
		Object o = selected.getUserObject();
		if (o instanceof Wizard == false){
			JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("CWi"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
		} else {
		Wizard zaIzmenu = (Wizard) o;
		JTextField poljeZaIzmenu = new JTextField(zaIzmenu.getIme());
		poljeZaIzmenu.setPreferredSize(new Dimension(100,20));
		JButton btnIzmeni = new JButton(homeframe.getInstance().getResourceBundle().getString("Change"));
		btnIzmeni.setPreferredSize(new Dimension(90,40));
		
		btnIzmeni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Stablo s = homeframe.getInstance().getStablo();
					
				Object o = selected.getUserObject();
				
					Wizard wiz = (Wizard) o;
					wiz.setIme(poljeZaIzmenu.getText());
					((DefaultTreeModel)s.getModel()).nodeChanged(selected);
					izmena.dispose();
				
			}
				 
		});
		panel.add(lNNW);
		panel.add(poljeZaIzmenu);
		panel.add(btnIzmeni);
		izmena.add(panel);
		izmena.setSize(350, 125);
		izmena.setVisible(true);
		izmena.setTitle(homeframe.getInstance().getResourceBundle().getString("nime"));
		izmena.setLocationRelativeTo(null);
		izmena.validate();
		}		
		}
	else{
		JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("CWi"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
	}
		
}
}