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

import uist17.Stablo;
import uist17.homeframe;

public class DodavanjeProjekta_nastavak extends AbstractAction{

	/**
	 * 
	 */
	public DodavanjeProjekta_nastavak() {
		putValue(NAME, homeframe.getInstance().getResourceBundle().getString("dp"));
		putValue(SHORT_DESCRIPTION, homeframe.getInstance().getResourceBundle().getString("AP"));
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode selected = (DefaultMutableTreeNode) homeframe.getInstance().getStablo().getLastSelectedPathComponent();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) homeframe.getInstance().getStablo().getModel().getRoot();
		
				JLabel labelaPN = new JLabel(homeframe.getInstance().getResourceBundle().getString("labelaPN"));
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
						
						//Workspace w=new Workspace();
						if(homeframe.getInstance().getW().findbyname(jtf.getText())!=null){
							JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("PO"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
						}
						else if(jtf.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("labelaPN"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
				
						}
						else {
						s.dodajProjekatUWorkspace(jtf.getText());
						s.refreshModel();
						dodajProjekat.dispose();
						}
					}
				});

				container.add(labelaPN);
				container.add(jtf);
				container.add(btnADD);
				dodajProjekat.add(container);
				dodajProjekat.setSize(350, 125);
				dodajProjekat.setVisible(true);
				dodajProjekat.setTitle(homeframe.getInstance().getResourceBundle().getString("AP"));
				dodajProjekat.setLocationRelativeTo(null);
				dodajProjekat.validate();
	}

}
