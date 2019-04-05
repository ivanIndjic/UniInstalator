package controller;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import uist17.homeframe;
import uist17.Stablo;

public class Dodavanje_projekta implements ActionListener{
//ova klasa je ista kao i klasa dodavanjeprojektanastavak!	
	public void NewActionListener(){}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JLabel lNNP = new JLabel(homeframe.getInstance().getResourceBundle().getString("lNNP"));
		JFrame dodajProjekat = new JFrame();
		JPanel container = new JPanel();
		JTextField jtf = new JTextField();
		jtf.setPreferredSize(new Dimension(100,20));
		JButton btnADD = new JButton(homeframe.getInstance().getResourceBundle().getString("btnADD"));
		btnADD.setPreferredSize(new Dimension(70,40));

		btnADD.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Stablo s = homeframe.getInstance().getStablo();
				//DefaultMutableTreeNode root = (DefaultMutableTreeNode)s.getModel().getRoot();
				if(homeframe.getInstance().getW().findbyname(jtf.getText())!=null){
					JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("PO"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
				}
				else if(jtf.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,homeframe.getInstance().getResourceBundle().getString("lNNP"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
					
				}
				else {
				s.dodajProjekatUWorkspace(jtf.getText());
				s.refreshModel();
				dodajProjekat.dispose();
				}
			}
			
		});

		container.add(lNNP);
		container.add(jtf);
		container.add(btnADD);
		dodajProjekat.add(container);
		dodajProjekat.setSize(350, 125);
		dodajProjekat.setVisible(true);
		dodajProjekat.setTitle(homeframe.getInstance().getResourceBundle().getString("DP"));
		dodajProjekat.setLocationRelativeTo(null);
		dodajProjekat.validate();
	}
	
}
