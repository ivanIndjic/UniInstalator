package controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Workspace;
import uist17.homeframe;

public class OtvaranjeWorkspaceAction extends AbstractAction {

	/**
	 * 
	 */

	public OtvaranjeWorkspaceAction() {
		// TODO Auto-generated constructor stub
		//putValue(NAME, "Open existing workspace");
		putValue(SHORT_DESCRIPTION, homeframe.getInstance().getResourceBundle().getString("wsp"));
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser fc=new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("SERIALIZED FILES", "ser", "ser");
		fc.setFileFilter(filter);
	    int a=fc.showOpenDialog(homeframe.getInstance());
		File f=fc.getSelectedFile();
		if(f == null){
			JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("wwsp"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
		}
		else{
			//String s=f.getPath();
		
			try {
				Workspace izabrani = Serialization.openModel(f);
				homeframe.getInstance().setW(izabrani);
				homeframe.getInstance().getStablo().popuniStablo(izabrani);
				homeframe.getInstance().getStablo().refreshModel();
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		}
	}

}
