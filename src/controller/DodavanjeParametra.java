package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
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
import javax.swing.tree.DefaultMutableTreeNode;

import model.Wizard;
import uist17.Stablo;
import uist17.homeframe;

public class DodavanjeParametra extends AbstractAction{
	
    public String s;
	/**
	 * 
	 */
	public boolean vidljivost;
	public boolean citanje;
	public String tipp;
	public boolean ist; //ako je bool da li je true ili false
	public String opisl;//ako je jednolin,viselin,file chooser ili image
	public boolean popunjavanje;
	public DodavanjeParametra() {
		putValue(NAME, "Add parameter");
		putValue(SHORT_DESCRIPTION, homeframe.getInstance().getResourceBundle().getString("dijAPW"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode selected = (DefaultMutableTreeNode) homeframe.getInstance().getStablo().getLastSelectedPathComponent();

		if(selected != null){
		Object node = selected.getUserObject();
		
		//provera sta je oznaceno u stablu
		//oznacen je workspace
		if(node instanceof Wizard == false){
			JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("dijSW"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
		}
		else{
			
		for(int i = 0 ; i < selected.getParent().getChildCount() ; i++ ){
			if (selected.getParent().getChildAt(i).equals(selected)){
				JFrame dodajProjekat = new JFrame();
				JPanel container = new JPanel(new BorderLayout());
				JLabel tip = new JLabel(homeframe.getInstance().getResourceBundle().getString("tip"));
				JTextField tiptxt = new JTextField();
				tiptxt.setPreferredSize(new Dimension(150,25));
				ButtonGroup grupa = new ButtonGroup();
				
				JRadioButton tip1 = new JRadioButton("Boolean");
				JRadioButton tip2 = new JRadioButton("One line");
				JRadioButton tip3 = new JRadioButton("More lines");
				JRadioButton tip4 = new JRadioButton("File chooser");
				JRadioButton tip5 = new JRadioButton("Image");
				JRadioButton tip6 = new JRadioButton("Source");
				JRadioButton tip7 = new JRadioButton("Destination");

				grupa.add(tip1);
				grupa.add(tip2);
				grupa.add(tip3);
				grupa.add(tip4);
				grupa.add(tip5);
				grupa.add(tip6);
				grupa.add(tip7);
				
				JPanel Ptip=new JPanel(new FlowLayout());
				Ptip.add(tip);
				Ptip.add(tip1);
				Ptip.add(tip2);
				Ptip.add(tip3);
				Ptip.add(tip4);
				Ptip.add(tip5);
				Ptip.add(tip6);
				Ptip.add(tip7);
				
				JLabel naz=new JLabel(homeframe.getInstance().getResourceBundle().getString("naz"));
				JTextField nazf=new JTextField();
				nazf.setPreferredSize(new Dimension(150,25));
				JPanel Pnaz=new JPanel(new FlowLayout());
				Pnaz.add(naz);
				Pnaz.add(nazf);
				//ButtonGroup za vidljivost
				ButtonGroup gvid = new ButtonGroup();
				JRadioButton vid = new JRadioButton("Visible");
				JRadioButton nevid = new JRadioButton("Invisible");
				gvid.add(vid);
				gvid.add(nevid);
				JPanel Pvid=new JPanel(new FlowLayout());
				Pvid.add(vid);
				Pvid.add(nevid);
				
				nevid.setSelected(true);
				//ButtonGroup za citljivost
				ButtonGroup gcit = new ButtonGroup();
				JRadioButton cit = new JRadioButton("Read only");
				JRadioButton necit = new JRadioButton("Not read only");
				gcit.add(cit);
				gcit.add(necit);
				JPanel Pcit=new JPanel(new FlowLayout());
				Pcit.add(cit);
				Pcit.add(necit);
				
				necit.setSelected(true);
				
				ButtonGroup gpopunjavanje = new ButtonGroup();
				JRadioButton pop = new JRadioButton("Mandatory");
				JRadioButton nepop = new JRadioButton("Non mandatory");
				gpopunjavanje.add(pop);
				gpopunjavanje.add(nepop);
				
				JPanel Ppop=new JPanel(new FlowLayout());
				Ppop.add(pop);
				Ppop.add(nepop);
				
				nepop.setSelected(true);
				
				JButton btnNext = new JButton("Next");
				
				btnNext.addActionListener(new ActionListener(){
					
					public void actionPerformed(ActionEvent arg0) {
						if(tip6.isSelected() && (nevid.isSelected() || necit.isSelected() || nepop.isSelected())){
							JOptionPane.showMessageDialog(null,"Source type has to be READ-ONLY,VISIBLE AND MANDATORY","Warning",JOptionPane.WARNING_MESSAGE);
							
						}else if(tip7.isSelected() && (nevid.isSelected() || nepop.isSelected())){
							JOptionPane.showMessageDialog(null,"Destination type has to be VISIBLE AND MANDATORY","Warning",JOptionPane.WARNING_MESSAGE);
							
						}else{
						boolean vids=vid.isSelected();
						//boolean nevids=nevid.isSelected();
						boolean cits=cit.isSelected();
						//boolean necits=necit.isSelected();

						boolean popuni = pop.isSelected();
						//boolean nepopuni = nepop.isSelected();

						//prosledjuje vidljivost parametra (npr. da bi moglo u izmeni da ima tu vrednost)

						if(vids==true){
							vidljivost=true;
						}else{
							vidljivost=false;
						}
						//prosledjuje da li je parametar read-only (npr. da bi moglo u izmeni da ima tu vrednost)
						if(cits==true){
							citanje=true;
						}else{
							citanje=false;
						}	
						if(popuni == true){
							popunjavanje = true;
						}
						else{
							popunjavanje = false;
						}
						boolean prvi = tip1.isSelected();
						boolean drugi = tip2.isSelected();
						boolean treci = tip3.isSelected();
						boolean cetvrti = tip4.isSelected();
						boolean peti = tip5.isSelected();
						boolean sesti = tip6.isSelected();
						boolean sedmi = tip7.isSelected();
						//prosledjuje tip parametra
						if(prvi==true){
							tipp=tip1.getText();
						}else if(drugi==true){
							tipp=tip2.getText();
						}else if(treci==true){
							tipp=tip3.getText();
						}else if(cetvrti==true){
							tipp=tip4.getText();
						}else if(peti==true){
							tipp=tip5.getText();
						}else if(sesti==true){
								tipp=tip6.getText();
						}else{
							tipp=tip7.getText();
						}
						System.out.println(tipp);
						if(nazf.getText().equals("")){
							//mora se uneti ime parametra
							JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("pn"), homeframe.getInstance().getResourceBundle().getString("dijW"), JOptionPane.WARNING_MESSAGE);
						}else if(prvi==false && drugi==false && treci==false && cetvrti==false && peti==false && sesti==false && sedmi==false){
							//moras uneti tip parametra
							JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("pt"), homeframe.getInstance().getResourceBundle().getString("dijW"), JOptionPane.WARNING_MESSAGE);
						}else{
							//ako je boolean
							//true ili false
							if(prvi == true){
								dodajProjekat.setVisible(false);
								
								JPanel Ptip=new JPanel(new FlowLayout());
								JLabel tip22 = new JLabel(homeframe.getInstance().getResourceBundle().getString("tip22"));
								ButtonGroup grupacheck = new ButtonGroup();
								JRadioButton cb1 = new JRadioButton("True");
								JRadioButton cb2 = new JRadioButton("False");

								
								grupacheck.add(cb1);
								grupacheck.add(cb2);
							    Ptip.add(tip22);
							    Ptip.add(cb1);
							    Ptip.add(cb2);
							    //defaultna vrednost je false
							    cb2.setSelected(true);
							    
								JPanel jp = new JPanel(new BorderLayout());
								JFrame biranjeTipa = new JFrame();
								jp.add(Ptip,BorderLayout.NORTH);
								
								JButton btnOK = new JButton("OK");
								jp.add(btnOK,BorderLayout.SOUTH);
								biranjeTipa.add(jp);
								biranjeTipa.setLocationRelativeTo(null);
								biranjeTipa.setSize(350,200);
								biranjeTipa.setVisible(true);
								btnOK.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										Stablo s = homeframe.getInstance().getStablo();
										
										boolean tacno=cb1.isSelected();
										boolean netacno=cb2.isSelected();
										//ukoliko dodje do promene defaultne vrednosti prosledjuje novu vrednost true ili false
										if(tacno==true){
											ist=true;
										}else{
											ist=false;
										}
										if(tacno==false && netacno==false){
											JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("tip22"), homeframe.getInstance().getResourceBundle().getString("dijW"), JOptionPane.WARNING_MESSAGE);
										}else if(!nazf.getText().equals("")){
											//dodavanje parametra sa prosledjivanjem njegovog roditelja,naziva,vidljivosti,da li je read-only,tipa,vrednosti true ili false i obaveznosti popunjavanja
											s.dodajParametarUWizard1(selected,nazf.getText(),vidljivost,citanje,tipp,ist,popunjavanje);
											s.refreshModel();
											dodajProjekat.dispose();
											biranjeTipa.setVisible(false);
										
										}
									}
								});
							}
							//ako je jednolinijski
							else if (drugi == true){
								dodajProjekat.setVisible(false);

								JLabel jednolinijski = new JLabel(homeframe.getInstance().getResourceBundle().getString("opis"));
								JTextField poljeOpis2=new JTextField("Ovde unesite opis parametra");
								poljeOpis2.setPreferredSize(new Dimension(200,20));
								JPanel Popis2 = new JPanel(new FlowLayout());
								Popis2.add(jednolinijski);
								Popis2.add(poljeOpis2);
								
								JPanel jp2 = new JPanel(new BorderLayout());	   	
							    jp2.add(Popis2,BorderLayout.NORTH);
								
								JButton btnOK = new JButton("OK");
								jp2.add(btnOK,BorderLayout.SOUTH);
								
								JFrame biranjeTipa2 = new JFrame();
								biranjeTipa2.add(jp2);
								biranjeTipa2.setLocationRelativeTo(null);
								biranjeTipa2.setSize(350,200);
								biranjeTipa2.setVisible(true);
								btnOK.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										Stablo s = homeframe.getInstance().getStablo();
										opisl=poljeOpis2.getText();
										if(!nazf.getText().equals("")){

											s.dodajParametarUWizard2(selected,nazf.getText(),vidljivost,citanje,tipp,opisl,popunjavanje);

									
											//dodavanje parametra sa prosledjivanjem njegovog roditelja,naziva,vidljivosti,da li je read-only,tipa,opis jednolinijskog parametra i obaveznosti popunjavanja
											

											s.refreshModel();
											dodajProjekat.dispose();
											biranjeTipa2.setVisible(false);
										
										}
									}
								});
							}
							//ako je viselinijski tip
							else if(treci==true){
								dodajProjekat.setVisible(false);
								
								JLabel opis=new JLabel(homeframe.getInstance().getResourceBundle().getString("opis"));
								JTextArea PoljeOpis3=new JTextArea("Ovde unesite opis parametra");
								PoljeOpis3.setLineWrap(true);
								PoljeOpis3.setWrapStyleWord(true);
								PoljeOpis3.setPreferredSize(new Dimension(200,200));
							    PoljeOpis3.setSize(200,200);
								JPanel Popis3=new JPanel(new FlowLayout());
								Popis3.add(opis);
								Popis3.add(PoljeOpis3);
								
								JButton ok=new JButton("OK");
								JPanel jp3=new JPanel(new BorderLayout());
								jp3.add(Popis3,BorderLayout.NORTH);
								jp3.add(ok,BorderLayout.SOUTH);
								
								
								JFrame biranjeTipa3=new JFrame();
								biranjeTipa3.add(jp3);
								biranjeTipa3.setLocationRelativeTo(null);
								biranjeTipa3.setSize(500,300);
								biranjeTipa3.setVisible(true);
								
								ok.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										Stablo s = homeframe.getInstance().getStablo();
										opisl=PoljeOpis3.getText();
										if(!nazf.getText().equals("")){

											s.dodajParametarUWizard2(selected,nazf.getText(),vidljivost,citanje,tipp,opisl,popunjavanje);

											//dodavanje parametra sa prosledjivanjem njegovog roditelja,naziva,vidljivosti,da li je read-only,tipa,opis viselinijskog parametra i obaveznosti popunjavanja

											s.refreshModel();
											dodajProjekat.dispose();
											biranjeTipa3.setVisible(false);
										
										}	
									}
								});							
							}
							//ako je file chooser
							else if(cetvrti==true){
								JPanel panel= new JPanel(new BorderLayout());
								JPanel panel2=new JPanel(new BorderLayout());
								JLabel cp=new JLabel(homeframe.getInstance().getResourceBundle().getString("cp"));
								JButton dugme=new JButton("...");
								panel.add(cp);
								panel2.add(dugme);
								dodajProjekat.setVisible(false);
						        JFrame biranjeTipa4=new JFrame();
						        biranjeTipa4.add(panel,BorderLayout.NORTH);
						        biranjeTipa4.add(panel2, BorderLayout.SOUTH);
						        biranjeTipa4.setTitle(homeframe.getInstance().getResourceBundle().getString("FileC"));
						        biranjeTipa4.setLocationRelativeTo(null);
						        biranjeTipa4.setPreferredSize(new  Dimension(200,200));
						        biranjeTipa4.setSize(400, 100);
						        biranjeTipa4.setVisible(true);
						        dugme.addActionListener(new ActionListener() {
						        	
									
									@Override
									public void actionPerformed(ActionEvent arg0) {
										// TODO Auto-generated method stub
										JFileChooser fc=new JFileChooser();
										int a=fc.showOpenDialog(homeframe.getInstance());
										if(a==JFileChooser.APPROVE_OPTION){
											File f=fc.getSelectedFile();
											 s=f.getPath();
										biranjeTipa4.setVisible(false);
										}
										
										JTextField labela=new JTextField(s);
										opisl=s;
										JPanel p=new JPanel(new BorderLayout());
										JPanel p2=new JPanel(new BorderLayout());
										JButton btn= new JButton("Ok");
										p.add(labela);
										p2.add(btn);
										JFrame fa= new JFrame();
										fa.setSize(450, 90);
										fa.setPreferredSize(new Dimension(460, 60));
										fa.setLocationRelativeTo(null);
										fa.add(p,BorderLayout.WEST);
										fa.add(p2,BorderLayout.SOUTH);
										fa.setVisible(true);
										btn.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												
												
			                                    Stablo s = homeframe.getInstance().getStablo();
												
												if(!nazf.getText().equals("")){
													//dodavanje parametra sa prosledjivanjem njegovog roditelja,naziva,vidljivosti,da li je read-only,tipa,putanja fajla i obaveznosti popunjavanja
													s.dodajParametarUWizard2(selected,nazf.getText(),vidljivost,citanje,tipp,opisl,popunjavanje);

													s.refreshModel();
													dodajProjekat.dispose();
													fa.setVisible(false);
												}			
											}
										});
									}
								});
							}
							//ako je image
							else if(peti==true){
								dodajProjekat.setVisible(false);
								JLabel ci=new JLabel(homeframe.getInstance().getResourceBundle().getString("ci"));
								JButton bro= new JButton(homeframe.getInstance().getResourceBundle().getString("bro"));
								bro.setSize(60, 30);
								JPanel p1=new JPanel(new BorderLayout());
								JPanel p2=new JPanel(new BorderLayout());
								p1.add(ci);
								p2.add(bro);
								JFrame f=new JFrame();
								f.setLocationRelativeTo(null);
								f.add(p1,BorderLayout.NORTH);
								f.add(p2, BorderLayout.SOUTH);
								f.setPreferredSize(new Dimension(200, 80));
								f.setSize(200, 130);
								f.setVisible(true);
								
								bro.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										f.setVisible(false);
										
										JFileChooser fc=new JFileChooser();
										FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
											    "Image files", ImageIO.getReaderFileSuffixes());
										fc.addChoosableFileFilter(imageFilter);
									    fc.setAcceptAllFileFilterUsed(false);
										
										
										int a=fc.showOpenDialog(homeframe.getInstance());
										if(a==JFileChooser.APPROVE_OPTION){
										File fi=fc.getSelectedFile();
										 s=fi.getPath();
		
										ImageIcon icon = new ImageIcon(fi.getAbsolutePath());
										Image scaleImage = icon.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
										JLabel slika=new JLabel();
										slika.setIcon(new ImageIcon(scaleImage));
										JPanel pslika=new JPanel(new FlowLayout());
										pslika.add(slika);
										
										JButton btn = new JButton(("OK"));
										JTextField labela=new JTextField(fi.getAbsolutePath());
										opisl=fi.getAbsolutePath();
										JPanel p3= new JPanel(new BorderLayout());
										JPanel p=new JPanel(new BorderLayout());
										p.add(labela);
										p3.add(btn);
										JFrame fa= new JFrame();
										fa.setSize(400, 90);
										fa.setSize(350, 300);
										fa.setLocationRelativeTo(null);
										fa.add(p,BorderLayout.NORTH);
										fa.add(pslika,BorderLayout.CENTER);
										fa.add(p3,BorderLayout.SOUTH);
										fa.setVisible(true);
										
								        btn.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												
												  Stablo s = homeframe.getInstance().getStablo();
													
													if(!nazf.getText().equals("")){
														//dodavanje parametra sa prosledjivanjem njegovog roditelja,naziva,vidljivosti,da li je read-only,putanja slike i obaveznosti popunjavanja
														s.dodajParametarUWizard2(selected,nazf.getText(),vidljivost,citanje,tipp,opisl,popunjavanje);

														s.refreshModel();
														dodajProjekat.dispose();
													   fa.setVisible(false);		
													}
											}
										});
										}
									}
								});
								//ukoliko je source
							}else if(sesti==true){
								JPanel panel= new JPanel(new BorderLayout());
								JPanel panel2=new JPanel(new BorderLayout());
								JLabel cp=new JLabel(homeframe.getInstance().getResourceBundle().getString("cp"));
								JButton dugme=new JButton("...");
								panel.add(cp);
								panel2.add(dugme);
								dodajProjekat.setVisible(false);
						        JFrame biranjeTipa6=new JFrame();
						        biranjeTipa6.add(panel,BorderLayout.NORTH);
						        biranjeTipa6.add(panel2, BorderLayout.SOUTH);
						        biranjeTipa6.setTitle(homeframe.getInstance().getResourceBundle().getString("FileC"));
						        biranjeTipa6.setLocationRelativeTo(null);
						        biranjeTipa6.setPreferredSize(new Dimension(200,200));
						        biranjeTipa6.setSize(400, 100);
						        biranjeTipa6.setVisible(true);
						        dugme.addActionListener(new ActionListener() {
						        	
									
									@Override
									public void actionPerformed(ActionEvent arg0) {
										// TODO Auto-generated method stub
										JFileChooser fc=new JFileChooser();
										fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
									    fc.setAcceptAllFileFilterUsed(false);
										int a=fc.showOpenDialog(homeframe.getInstance());
									
										if(a==JFileChooser.APPROVE_OPTION){
											File f=fc.getSelectedFile();
											 s=f.getPath();
										biranjeTipa6.setVisible(false);
										}
										
										System.out.println(s);
										JTextField labela=new JTextField(s);
										JPanel p=new JPanel(new BorderLayout());
										JPanel p2=new JPanel(new BorderLayout());
										JButton btn= new JButton("Ok");
										p.add(labela);
										p2.add(btn);
										JFrame fa= new JFrame();
										fa.setSize(450, 90);
										fa.setPreferredSize(new Dimension(460, 60));
										fa.setLocationRelativeTo(null);
										fa.add(p,BorderLayout.WEST);
										fa.add(p2,BorderLayout.SOUTH);
										fa.setVisible(true);
										opisl = s;
										btn.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												
			                                    Stablo s = homeframe.getInstance().getStablo();
												
												if(!nazf.getText().equals("")){
													//dodavanje parametra sa prosledjivanjem njegovog roditelja,naziva,vidljivosti,da li je read-only,tipa,putanja fajla i obaveznosti popunjavanja
													s.dodajParametarUWizard2(selected,nazf.getText(),vidljivost,citanje,tipp,opisl,popunjavanje);

										

													s.refreshModel();
													dodajProjekat.dispose();
													fa.setVisible(false);
												
												}
												
											}
										});
									}
								});
						        //ukoliko je destination
							}else if(sedmi==true){
								JPanel panel= new JPanel(new BorderLayout());
								JPanel panel2=new JPanel(new BorderLayout());
								JLabel cp=new JLabel(homeframe.getInstance().getResourceBundle().getString("cp"));
								JButton dugme=new JButton("...");
								panel.add(cp);
								panel2.add(dugme);
								dodajProjekat.setVisible(false);
						        JFrame biranjeTipa7=new JFrame();
						        biranjeTipa7.add(panel,BorderLayout.NORTH);
						        biranjeTipa7.add(panel2, BorderLayout.SOUTH);
						        biranjeTipa7.setTitle(homeframe.getInstance().getResourceBundle().getString("FileC"));
						        biranjeTipa7.setLocationRelativeTo(null);
						        biranjeTipa7.setPreferredSize(new Dimension(200,200));
						        biranjeTipa7.setSize(400, 100);
						        biranjeTipa7.setVisible(true);
						        dugme.addActionListener(new ActionListener() {
						        	
									@Override
									public void actionPerformed(ActionEvent arg0) {
										// TODO Auto-generated method stub
										JFileChooser fc=new JFileChooser();
										fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
									    fc.setAcceptAllFileFilterUsed(false);
										int a=fc.showOpenDialog(homeframe.getInstance());
										
										if(a==JFileChooser.APPROVE_OPTION){
											File f=fc.getSelectedFile();
											 s=f.getPath();
										biranjeTipa7.setVisible(false);
										}
										JTextField labela=new JTextField(s);
										JPanel p=new JPanel(new BorderLayout());
										JPanel p2=new JPanel(new BorderLayout());
										JButton btn= new JButton("Ok");
										p.add(labela);
										p2.add(btn);
										JFrame fa= new JFrame();
										fa.setSize(450, 90);
										fa.setPreferredSize(new Dimension(460, 60));
										fa.setLocationRelativeTo(null);
										fa.add(p,BorderLayout.WEST);
										fa.add(p2,BorderLayout.SOUTH);
										fa.setVisible(true);
										opisl=s;
										btn.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												
												
			                                    Stablo s = homeframe.getInstance().getStablo();
												
												if(!nazf.getText().equals("")){

													s.dodajParametarUWizard2(selected,nazf.getText(),vidljivost,citanje,tipp,opisl,popunjavanje);

													//dodavanje parametra sa prosledjivanjem njegovog roditelja,naziva,vidljivosti,da li je read-only,tipa,putanja fajla i obaveznosti popunjavanja
													

													s.refreshModel();
													dodajProjekat.dispose();
													fa.setVisible(false);
												
												}
												
											}
										});	
									}
								});
							}}
					}
					}
				});
				JPanel gornji=new JPanel(new BorderLayout());
				gornji.add(Ptip,BorderLayout.NORTH);
				gornji.add(Pnaz,BorderLayout.SOUTH);
				
				JPanel srednji=new JPanel(new BorderLayout());
				srednji.add(Pvid,BorderLayout.NORTH);
				srednji.add(Pcit,BorderLayout.CENTER);
				srednji.add(Ppop,BorderLayout.SOUTH);
				
				container.add(gornji,BorderLayout.NORTH);
				container.add(srednji,BorderLayout.CENTER);
				container.add(btnNext,BorderLayout.SOUTH);
				
				dodajProjekat.add(container);
				dodajProjekat.setSize(850,250);
				dodajProjekat.setVisible(true);
				dodajProjekat.setTitle(homeframe.getInstance().getResourceBundle().getString("dijAPW"));
				dodajProjekat.setLocationRelativeTo(null);
				dodajProjekat.validate();
			
			}
		}
		}
		}else{
			//mora se selektovati wizard
			JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("dijSW"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
		}
	}
}
