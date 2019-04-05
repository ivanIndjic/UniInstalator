package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uist17.homeframe;

public class HelpAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelpAction() {
		putValue(SHORT_DESCRIPTION, "Help");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JLabel labelaH = new JLabel("<html>"+homeframe.getInstance().getResourceBundle().getString("pom")+"<br/>"
		+homeframe.getInstance().getResourceBundle().getString("pom1")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom2")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom3")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom4")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom5")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom6")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom7")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom8")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom9")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom10")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom11")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom12")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom13")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom14")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom15")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom16")+"<br/>"+
		homeframe.getInstance().getResourceBundle().getString("pom17")+
				"</html>");
	
		JFrame Help = new JFrame();
		JPanel container = new JPanel(new BorderLayout());
		
		JButton btnCancel = new JButton(homeframe.getInstance().getResourceBundle().getString("cancelOption"));
		
		
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {

			Help.dispose();
			}	
		});
		container.add(labelaH, BorderLayout.NORTH);
	
		container.add(btnCancel, BorderLayout.SOUTH);
		btnCancel.setPreferredSize(new Dimension(70, 30));
		Help.add(container);
		Help.setSize(500, 450);
		Help.setVisible(true);
		Help.setTitle(homeframe.getInstance().getResourceBundle().getString("help"));
		Help.setLocationRelativeTo(null);
		//Help.validate();
	}
}
