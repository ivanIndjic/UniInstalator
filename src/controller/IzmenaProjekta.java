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

import model.Projekat;
import uist17.homeframe;
import uist17.Stablo;

public class IzmenaProjekta extends AbstractAction{

	/**
	 * 
	 */


	public IzmenaProjekta() {
		putValue(NAME, homeframe.getInstance().getResourceBundle().getString("proj"));
		putValue(SHORT_DESCRIPTION, homeframe.getInstance().getResourceBundle().getString("CC"));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode selected = (DefaultMutableTreeNode) homeframe.getInstance().getStablo().getLastSelectedPathComponent();
		if (selected != null){
		JLabel lNN = new JLabel(homeframe.getInstance().getResourceBundle().getString("lNN"));
		JFrame izmena = new JFrame();
		JPanel panel = new JPanel();
		Object o = selected.getUserObject();
		if(o instanceof Projekat == false){
			JOptionPane.showMessageDialog(null,homeframe.getInstance().getResourceBundle().getString("CPr"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
		} else {
		Projekat zaIzmenu = (Projekat) o;
		JTextField poljeZaIzmenu = new JTextField(zaIzmenu.getIme());
		poljeZaIzmenu.setPreferredSize(new Dimension(100,20));
		JButton btnIzmeni = new JButton(homeframe.getInstance().getResourceBundle().getString("Change"));
		btnIzmeni.setPreferredSize(new Dimension(90,40));
		
		btnIzmeni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Stablo s = homeframe.getInstance().getStablo();
				
				
					//Workspace w = homeframe.getInstance().getW();
					Object o = selected.getUserObject();
					
						Projekat p = (Projekat) o;
						p.setIme(poljeZaIzmenu.getText());
						((DefaultTreeModel)s.getModel()).nodeChanged(selected);
						izmena.dispose();
				
			}
		});
		panel.add(lNN);
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
	 else
		{
		JOptionPane.showMessageDialog(null,homeframe.getInstance().getResourceBundle().getString("CPr"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
		}

	}
}
