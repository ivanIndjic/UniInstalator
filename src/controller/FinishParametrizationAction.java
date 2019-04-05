package controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Projekat;
import uist17.homeframe;

public class FinishParametrizationAction extends AbstractAction {
	
	/**
	 * 
	 */

	public FinishParametrizationAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME, homeframe.getInstance().getResourceBundle().getString("fin"));
		putValue(SHORT_DESCRIPTION, homeframe.getInstance().getResourceBundle().getString("cf"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		homeframe.getInstance().setVisible(false);
		Projekat odabrani = null;
		try {
			File f = chooseProject();
			if(f==null){
				homeframe.getInstance().setVisible(true);
			}else{
			odabrani = Serialization.openProject(f);
				
	//
			
				InstalacijaOdabranogProizvoda proizvod =new InstalacijaOdabranogProizvoda(odabrani);
			}
	//
			
			
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();

			JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("spi"),
					homeframe.getInstance().getResourceBundle().getString("dijW"), JOptionPane.WARNING_MESSAGE);
		}
		
		
	}
	public File chooseProject(){
		JFileChooser fc=new JFileChooser();
		fc.setDialogTitle(homeframe.getInstance().getResourceBundle().getString("spi"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PROJECT FILES", "proj", "proj");
		fc.setFileFilter(filter);
	    int a=fc.showOpenDialog(homeframe.getInstance());
		File f=fc.getSelectedFile();
		if(f == null){
			homeframe.getInstance().setVisible(true);
			return null;
		}
		else{
			//String s=f.getPath();
			return f;
		}
	}
}
