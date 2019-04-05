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

import model.Projekat;
import uist17.Stablo;
import uist17.homeframe;
public class DodavanjeWizarda extends AbstractAction{

	

	
	public DodavanjeWizarda() {
		putValue(NAME, homeframe.getInstance().getResourceBundle().getString("dw"));
		putValue(SHORT_DESCRIPTION, homeframe.getInstance().getResourceBundle().getString("labelaAW"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		DefaultMutableTreeNode selected = (DefaultMutableTreeNode) homeframe.getInstance().getStablo().getLastSelectedPathComponent();
		if (selected != null){
		Object node = selected.getUserObject();
		
		if(node instanceof Projekat == false){
			JOptionPane.showMessageDialog(null,homeframe.getInstance().getResourceBundle().getString("qq"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
		}
		
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) homeframe.getInstance().getStablo().getModel().getRoot();
		for(int i = 0 ; i < root.getChildCount() ; i++ ){
			if (root.getChildAt(i).equals(selected)){
				JLabel labelaAW = new JLabel(homeframe.getInstance().getResourceBundle().getString("labelaAW"));
				JFrame dodajProjekat = new JFrame();
				JPanel container = new JPanel();
				JTextField jtf = new JTextField();
				
				jtf.setPreferredSize(new Dimension(100,20));
				JButton btnADD = new JButton(homeframe.getInstance().getResourceBundle().getString("btnADD"));
				btnADD.setPreferredSize(new Dimension(70,40));


				container.add(labelaAW);
				container.add(jtf);
				container.add(btnADD);
				dodajProjekat.add(container);
				dodajProjekat.setSize(350, 125);
				dodajProjekat.setVisible(true);
				dodajProjekat.setTitle((homeframe.getInstance().getResourceBundle().getString("dw")));
				dodajProjekat.setLocationRelativeTo(null);
				dodajProjekat.validate();

				btnADD.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						Stablo s = homeframe.getInstance().getStablo();
						//DefaultMutableTreeNode root = (DefaultMutableTreeNode)s.getModel().getRoot();
						
						s.dodajWizardUProjekat(selected,jtf.getText());
						s.refreshModel();
						dodajProjekat.dispose();

					}
					
				});

			}
			
			}
		}else{
			JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("qq"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
		}
	}
}
