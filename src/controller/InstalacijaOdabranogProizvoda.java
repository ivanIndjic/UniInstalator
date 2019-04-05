package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Parametar;
import model.Projekat;
import model.Wizard;
import uist17.homeframe;

public class InstalacijaOdabranogProizvoda{
	private JTextField Opis;
	private JTextArea Opis1;
	private JTextField Link; 
	private JTextField LinkSource; 
	private JTextField LinkDestination; 
	
	@SuppressWarnings("static-access")
	public InstalacijaOdabranogProizvoda(Projekat p) {
		int brVizardauProjektu = p.getVizardi().size();
		JFrame[] nizFrejmova = new JFrame[brVizardauProjektu];
		JPanel[] nizPanela = new JPanel[brVizardauProjektu];
		
		for(int i=0;i<brVizardauProjektu;i++){

			nizFrejmova[i] = new JFrame(p.getVizardi().get(i).getIme());
			
			nizPanela[i] = new JPanel(new BorderLayout());
			nizFrejmova[i].add(nizPanela[i]);
		}
		for(int i=0;i<brVizardauProjektu;i++){
				nizFrejmova[i].setSize(550, brVizardauProjektu*700);
				nizFrejmova[i].setLocationRelativeTo(null);
				Wizard w;
				Parametar zaIzmenu;
				w=p.findWizardByName(p.getVizardi().get(i).getIme());
				int brParametarauWizardu=w.getParametri().size();

		
				JPanel parIzlistati=new JPanel();
				BoxLayout box=new BoxLayout(parIzlistati, BoxLayout.Y_AXIS);


				for(int j=0;j<brParametarauWizardu;j++){
					zaIzmenu=w.findParametarByName(w.getParametri().get(j).getNaziv());
///////////////////////////////////
					if(zaIzmenu.getVidljivost()==true){
						if(zaIzmenu.getreadonly()==false){

					JLabel l=new JLabel("Parametar name: " + zaIzmenu.getNaziv());
					//JLabel tip=new JLabel(homeframe.getInstance().getResourceBundle().getString("par")+(j+1)+homeframe.getInstance().getResourceBundle().getString("tip")+zaIzmenu.getTip());
					
					JPanel panelI=new JPanel(new FlowLayout());
					JPanel panelT=new JPanel(new FlowLayout());
					//JLabel prazno=new JLabel(" "); //razmak u panelu 
					
					panelI.add(l);
					//panelT.add(tip);
					JPanel B=new JPanel(new BorderLayout());

					if(zaIzmenu.getTip().equals("Boolean")){
						ButtonGroup TF = new ButtonGroup();
						JRadioButton truee = new JRadioButton(homeframe.getInstance().getResourceBundle().getString("true"));
						JRadioButton falsee = new JRadioButton(homeframe.getInstance().getResourceBundle().getString("false"));
						TF.add(truee);
						TF.add(falsee);
							
						JPanel panelTV=new JPanel(new FlowLayout());
	
						panelTV.add(truee);
						panelTV.add(falsee);
							
						B.add(panelTV,BorderLayout.CENTER);
						
							if(	zaIzmenu.getBool()==true){
								truee.setSelected(true);
							}else {
								falsee.setSelected(true);
							}
					}else if(zaIzmenu.getTip().equals("One line")){
						Opis=new JTextField(zaIzmenu.getJeVi());
						Opis.setPreferredSize(new Dimension(100,20));
						JPanel opp=new JPanel(new FlowLayout());
						opp.add(Opis);
						B.add(opp,BorderLayout.CENTER);
					}else if(zaIzmenu.getTip().equals("More lines")){
						Opis1=new JTextArea(zaIzmenu.getJeVi());
						Opis1.setLineWrap(true);
						Opis1.setWrapStyleWord(true);
						Opis1.setPreferredSize(new Dimension(200,200));
					    Opis1.setSize(200,200);

					    JPanel opp=new JPanel(new FlowLayout());
						opp.add(Opis1);
						B.add(opp,BorderLayout.CENTER);
					}else if(zaIzmenu.getTip().equals("File chooser") || zaIzmenu.getTip().equals("Source") || zaIzmenu.getTip().equals("Destination") ){

						if(zaIzmenu.getTip().equals("File chooser")){
							Link=new JTextField(zaIzmenu.getJeVi());
						Link.setEnabled(false);
						Link.setPreferredSize(new Dimension(300, 20));
						}else if(zaIzmenu.getTip().equals("Source")){
							LinkSource=new JTextField(zaIzmenu.getJeVi());
							LinkSource.setEnabled(false);
							LinkSource.setPreferredSize(new Dimension(300, 20));
						}else{
							LinkDestination=new JTextField(zaIzmenu.getJeVi());
							LinkDestination.setEnabled(false);
							LinkDestination.setPreferredSize(new Dimension(300, 20));
						}
					    JPanel opp=new JPanel(new FlowLayout());
					    if(zaIzmenu.getTip().equals("File chooser")){
					    	 opp.add(Link);
						}else if(zaIzmenu.getTip().equals("Source")){
							 opp.add(LinkSource);
						}else{
							 opp.add(LinkDestination);
							
						}
					   
						
						JButton izmeni=new JButton(homeframe.getInstance().getResourceBundle().getString("Change"));
						if(!zaIzmenu.getTip().equals("Source"))
							opp.add(izmeni);
						B.add(opp,BorderLayout.CENTER);
						Parametar temp = zaIzmenu;
						izmeni.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
											JFileChooser fc=new JFileChooser();
											if( temp.getTip().equals("Source") || temp.getTip().equals("Destination")){
												fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
											    fc.setAcceptAllFileFilterUsed(false);
											}else{
												
												fc.setAcceptAllFileFilterUsed(true);
											}
											int a=fc.showOpenDialog(homeframe.getInstance());
											if(a==fc.APPROVE_OPTION){
												File f=fc.getSelectedFile();
												String s=f.getPath();
												 if(temp.getTip().equals("File chooser")){

														Link.setText(s);
												}else if(temp.getTip().equals("Source")){

													LinkSource.setText(s);
												}else{
													 
														LinkDestination.setText(s);
													
												}
												temp.setJevi(s);
												
											}
							}
						});
						zaIzmenu = temp;
					}else{
					    JPanel opp=new JPanel(new FlowLayout());
					
						ImageIcon icon = new ImageIcon(zaIzmenu.getJeVi());
						Image scaleImage = icon.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
						JLabel slika=new JLabel();
						Parametar temp = zaIzmenu;
						slika.setIcon(new ImageIcon(scaleImage));
						opp.add(slika);
						JButton izmeni=new JButton(homeframe.getInstance().getResourceBundle().getString("Change"));
						opp.add(izmeni);
						B.add(opp,BorderLayout.CENTER);
						izmeni.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
				
											JFileChooser fc=new JFileChooser();
											FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
												    "Image files", ImageIO.getReaderFileSuffixes());
											fc.addChoosableFileFilter(imageFilter);
											fc.setAcceptAllFileFilterUsed(false);
											int a=fc.showOpenDialog(homeframe.getInstance());
											if(a==fc.APPROVE_OPTION){
												File f=fc.getSelectedFile();
												String s=f.getPath();
												temp.setJevi(s);
												ImageIcon icon = new ImageIcon(s);
												Image scaleImage = icon.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
												
												slika.setIcon(new ImageIcon(scaleImage));
											}
							}
						});
						zaIzmenu = temp;
					}
					JPanel n=new JPanel(new BorderLayout());
					n.add(panelI,BorderLayout.NORTH);
					n.add(panelT,BorderLayout.SOUTH);

					B.add(n,BorderLayout.NORTH);
			        parIzlistati.add(Box.createVerticalStrut(25));  
					parIzlistati.setLayout(box);
					parIzlistati.add(B);
						}else{
						//AKO JE PARAMETAR READ ONLY
						JPanel im=new JPanel(new FlowLayout());
						JPanel t=new JPanel(new FlowLayout());
						JLabel ime= new JLabel(homeframe.getInstance().getResourceBundle().getString("par")+(j+1)+" name: "+ zaIzmenu.getNaziv());
						JLabel tip=new JLabel(homeframe.getInstance().getResourceBundle().getString("par")+(j+1)+" type: "+zaIzmenu.getTip());
						JLabel vrednost=new JLabel();
						JPanel vr=new JPanel(new FlowLayout());
						vr.add(vrednost);


						if (zaIzmenu.getTip().equals("Boolean")){
							vrednost.setText("Parameter"+(j+1)+"value: "+zaIzmenu.getBool());
						}else if(zaIzmenu.getTip().equals("One line") || zaIzmenu.getTip().equals("More lines") || zaIzmenu.getTip().equals("File chooser")||zaIzmenu.getTip().equals("Source")||zaIzmenu.getTip().equals("Destination")){
							vrednost.setText("Parameter"+(j+1)+"value: "+zaIzmenu.getJeVi());
						}else{
							ImageIcon icon = new ImageIcon(zaIzmenu.getJeVi());
							Image scaleImage = icon.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
							JLabel slika=new JLabel();
							slika.setIcon(new ImageIcon(scaleImage));
							vrednost.setText("Parameter"+(j+1)+"value: ");
							vr.add(slika);
						}
						im.add(ime);
						t.add(tip);
						JPanel it=new JPanel(new BorderLayout());
						it.add(im,BorderLayout.NORTH);
						it.add(t,BorderLayout.SOUTH);
						//ime.setSize(300,100);;
						JPanel pi=new JPanel(new BorderLayout());
						JLabel prazno=new JLabel(" "); //razmak u panelu 
			
						pi.add(it,BorderLayout.NORTH);
						pi.add(vr,BorderLayout.CENTER);
						pi.add(prazno,BorderLayout.SOUTH);
						parIzlistati.setLayout(box);
						parIzlistati.add(pi);
					}
					}
/////////////////////////////////////
					nizPanela[i].add(parIzlistati,BorderLayout.NORTH);
				}

				
				JButton btnBack = new JButton(homeframe.getInstance().getResourceBundle().getString("back"));
				btnBack.setPreferredSize(new Dimension(70, 40));
				
				JButton btnNext = new JButton(homeframe.getInstance().getResourceBundle().getString("next"));
				btnNext.setPreferredSize(new Dimension(70, 40));
				
				
				JButton btnFinish = new JButton(homeframe.getInstance().getResourceBundle().getString("fin"));
				btnFinish.setPreferredSize(new Dimension(70, 40));
				JPanel dugme=new JPanel(new FlowLayout());

				if(i!=0){
					dugme.add(btnBack);
					nizPanela[i].add(dugme,BorderLayout.SOUTH);
				}
				
				if(i!=brVizardauProjektu-1){
					dugme.add(btnNext);
					nizPanela[i].add(dugme,BorderLayout.SOUTH);
				}
				
				if(i==brVizardauProjektu-1){
					dugme.add(btnFinish);
					nizPanela[i].add(dugme,BorderLayout.SOUTH);
				}
				nizFrejmova[0].setVisible(true);
				int trenutni = i;
	
				btnNext.addActionListener(new ActionListener() {
					@Override
					
					public void actionPerformed(ActionEvent e) {
						boolean greska = false;
						for(int j=0;j<p.getVizardi().get(trenutni).getParametri().size();j++){
							
							if(p.getVizardi().get(trenutni).getParametri().get(j).getObavezno_popunjavanje() && p.getVizardi().get(trenutni).getParametri().get(j).getreadonly() == false){
							
								
								if(p.getVizardi().get(trenutni).getParametri().get(j).getTip().equals("One line")){
									p.getVizardi().get(trenutni).getParametri().get(j).setJevi(Opis.getText());
									if(p.getVizardi().get(trenutni).getParametri().get(j).getJeVi().equals("")){
										
										JOptionPane.showMessageDialog(null, "Niste uneli vrednost obaveznog parametra: " + p.getVizardi().get(trenutni).getParametri().get(j).getNaziv(),"Upozorenje", JOptionPane.WARNING_MESSAGE);
										greska = true;
									}
								}else if(p.getVizardi().get(trenutni).getParametri().get(j).getTip().equals("More lines")){
									p.getVizardi().get(trenutni).getParametri().get(j).setJevi(Opis1.getText());
									if(p.getVizardi().get(trenutni).getParametri().get(j).getJeVi().equals("")){
										
										JOptionPane.showMessageDialog(null, "Niste uneli vrednost obaveznog parametra: " + p.getVizardi().get(trenutni).getParametri().get(j).getNaziv(),"Upozorenje", JOptionPane.WARNING_MESSAGE);
										greska = true;
									}
								}	
							}
						}
						if(greska==false && trenutni <= brVizardauProjektu - 1){
							nizFrejmova[trenutni].setVisible(false);
							if(trenutni < brVizardauProjektu){
								nizFrejmova[trenutni+1].setVisible(true);
							}
						}
						
					}
				});
				
				btnBack.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						nizFrejmova[trenutni].setVisible(false);
						nizFrejmova[trenutni-1].setVisible(true);
					}
				});
				
				btnFinish.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						boolean greska = false;
						for(int j=0;j<p.getVizardi().get(trenutni).getParametri().size();j++){
							
							if(p.getVizardi().get(trenutni).getParametri().get(j).getObavezno_popunjavanje() && p.getVizardi().get(trenutni).getParametri().get(j).getreadonly() == false){
								
								
								if(p.getVizardi().get(trenutni).getParametri().get(j).getTip().equals("One line")){
									p.getVizardi().get(trenutni).getParametri().get(j).setJevi(Opis.getText());
									if(p.getVizardi().get(trenutni).getParametri().get(j).getJeVi().equals("")){
										
										JOptionPane.showMessageDialog(null, "Niste uneli vrednost obaveznog parametra: " + p.getVizardi().get(trenutni).getParametri().get(j).getNaziv(),"Upozorenje", JOptionPane.WARNING_MESSAGE);
										greska = true;
									}
								}else if(p.getVizardi().get(trenutni).getParametri().get(j).getTip().equals("More lines")){
									p.getVizardi().get(trenutni).getParametri().get(j).setJevi(Opis1.getText());
									if(p.getVizardi().get(trenutni).getParametri().get(j).getJeVi().equals("")){
										
										JOptionPane.showMessageDialog(null, "Niste uneli vrednost obaveznog parametra: " + p.getVizardi().get(trenutni).getParametri().get(j).getNaziv(),"Upozorenje", JOptionPane.WARNING_MESSAGE);
										greska = true;
									}
								}	
							}
						}
						if(greska==false){
						nizFrejmova[trenutni].setVisible(false);
						int brVizarda = p.getVizardi().size();
						String str = "";
						
						for(int i=0;i<brVizarda;i++){
							int brParametara = p.getVizardi().get(i).getParametri().size();
							for(int j=0;j<brParametara;j++){
								if(p.getVizardi().get(i).getParametri().get(j).getTip().equals("Destination")){
									str = p.getVizardi().get(i).getParametri().get(j).getJeVi();
								}
							}
						}
						try {
							Serialization.saveProject(p, new File(str+"\\"+  p.getIme() + ".proj"));
							JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("usp")+" snimljen na destinaciju " + str+"\\"+  p.getIme() + ".proj",
									homeframe.getInstance().getResourceBundle().getString("info"), JOptionPane.INFORMATION_MESSAGE);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					}
				});
	
		}
		
				
				

			
			}
		
	

}
