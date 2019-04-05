package controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Parametar;
import model.Projekat;
import model.Wizard;
import model.Workspace;
import uist17.homeframe;

public class SaveAction extends AbstractAction {
	
	/**
	 * 
	 */

	public SaveAction(){

		putValue(SHORT_DESCRIPTION, homeframe.getInstance().getResourceBundle().getString("Spw"));
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Workspace w = homeframe.getInstance().getW();
		DefaultMutableTreeNode selected = (DefaultMutableTreeNode) homeframe.getInstance().getStablo().getLastSelectedPathComponent();
		if (selected != null){
			Object o = selected.getUserObject();
			
			
			if(o instanceof Workspace){
				try {
					JFileChooser fc=new JFileChooser();
					fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				    fc.setAcceptAllFileFilterUsed(false);
					
					int a=fc.showOpenDialog(homeframe.getInstance());
					File f=fc.getSelectedFile();
					File file;
					if(f!=null){
						file = new File(f.toString() + ".ser");
						Serialization.saveModel(w, file);
						JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("usp"),
							homeframe.getInstance().getResourceBundle().getString("info"), JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("fnf"),
							homeframe.getInstance().getResourceBundle().getString("dijW"), JOptionPane.WARNING_MESSAGE);
				} catch (IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("er"),
							homeframe.getInstance().getResourceBundle().getString("dijW"), JOptionPane.WARNING_MESSAGE);
				}
			}else if(o instanceof Projekat){
				Projekat zaCuvanje = (Projekat) o;
				int brVizarda = zaCuvanje.getVizardi().size();
				
				try {
					String str=null;
					for(int i=0;i<brVizarda;i++){
						int brParametara = zaCuvanje.getVizardi().get(i).getParametri().size();
						for(int j=0;j<brParametara;j++){
							if(zaCuvanje.getVizardi().get(i).getParametri().get(j).getTip().equals("Source")){
								str = zaCuvanje.getVizardi().get(i).getParametri().get(j).getJeVi();
							}
						}
					}
					
					int izvor=0;
					int destinacija=0;
					for (int i=0; i<brVizarda; i++){
						Wizard wiz;
						Parametar uvizardu;
						wiz=zaCuvanje.findWizardByName(zaCuvanje.getVizardi().get(i).getIme());
						int brParam=wiz.getParametri().size();
						for (int j=0; j<brParam; j++){
							uvizardu=wiz.findParametarByName(wiz.getParametri().get(j).getNaziv());
							if(uvizardu.getTip().equals("Source")){
								izvor++;
							} else
								if(uvizardu.getTip().equals("Destination")){
								destinacija++;
							}
						}
						
					}
					
					if (izvor==1 && destinacija==1){
						
						
						Serialization.saveProject(zaCuvanje, new File(str+"\\"+  zaCuvanje.getIme() + ".proj"));
						JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("usp"),
								homeframe.getInstance().getResourceBundle().getString("info"), JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("pq"),
								homeframe.getInstance().getResourceBundle().getString("dijW"), JOptionPane.WARNING_MESSAGE);
					}
					
					//System.out.println("Sacuvao");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				JOptionPane.showMessageDialog(null,homeframe.getInstance().getResourceBundle().getString("pc"),homeframe.getInstance().getResourceBundle().getString("dijW"), JOptionPane.WARNING_MESSAGE);
			}
		}
		else{
			JOptionPane.showMessageDialog(null,homeframe.getInstance().getResourceBundle().getString("pc"),homeframe.getInstance().getResourceBundle().getString("dijW"), JOptionPane.WARNING_MESSAGE);
		}
	}

	

}
