package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.Parametar;
import uist17.Stablo;
import uist17.homeframe;

public class IzmenaParametra extends AbstractAction{
	
	/**
	 * 
	 */


	public IzmenaParametra(){
		putValue(NAME, homeframe.getInstance().getResourceBundle().getString("par"));
		putValue(SHORT_DESCRIPTION, homeframe.getInstance().getResourceBundle().getString("dijCP"));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode selected=(DefaultMutableTreeNode)homeframe.getInstance().getStablo().getLastSelectedPathComponent();
		if (selected != null){
		JLabel lNN=new JLabel(homeframe.getInstance().getResourceBundle().getString("lNN"));
		JFrame izmena=new JFrame();
		JPanel panel1=new JPanel(new FlowLayout());
		Object o=selected.getUserObject();
		if(o instanceof Parametar==false){

			JOptionPane.showMessageDialog(null,homeframe.getInstance().getResourceBundle().getString("selP"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
		} else {
			Parametar p = (Parametar) o;

		if(p.getreadonly()==false){
		if(o instanceof Parametar){

		Parametar zaIzmenu=(Parametar) o;
		System.out.println(""+zaIzmenu.getBool());
		JTextField poljeZaIzmenu=new JTextField(zaIzmenu.getNaziv());
		poljeZaIzmenu.setPreferredSize(new Dimension(100,20));
		panel1.add(lNN);
		panel1.add(poljeZaIzmenu);
		//poromena vidljivosti
		ButtonGroup gvid = new ButtonGroup();
		JRadioButton vid = new JRadioButton(homeframe.getInstance().getResourceBundle().getString("vis"));
		JRadioButton nevid = new JRadioButton(homeframe.getInstance().getResourceBundle().getString("ivis"));
		
		ButtonGroup gpop = new ButtonGroup();
		JRadioButton pop = new JRadioButton("Mandatory");
		JRadioButton nepop = new JRadioButton("Non mandatory");
		gpop.add(pop);
		gpop.add(nepop);
		
		JPanel panelzapop = new JPanel(new FlowLayout());
		panelzapop.add(pop);
		panelzapop.add(nepop);
		
		if(zaIzmenu.getObavezno_popunjavanje()==true){
			pop.setSelected(true);
		}
		else{
			nepop.setSelected(true);
		}
		
		if(zaIzmenu.getVidljivost()==true){
		vid.setSelected(true);
		}else{
		nevid.setSelected(true);
		}
		gvid.add(vid);
		gvid.add(nevid);
		JPanel panel2=new JPanel(new FlowLayout());
		panel2.add(vid);
		panel2.add(nevid);
		//promena tipa
		ButtonGroup grupa = new ButtonGroup();
		
		JRadioButton tip1 = new JRadioButton(homeframe.getInstance().getResourceBundle().getString("tip1"));
		JRadioButton tip2 = new JRadioButton(homeframe.getInstance().getResourceBundle().getString("tip2"));
		JRadioButton tip3 = new JRadioButton(homeframe.getInstance().getResourceBundle().getString("tip3"));
		JRadioButton tip4 = new JRadioButton(homeframe.getInstance().getResourceBundle().getString("tip4"));
		JRadioButton tip5 = new JRadioButton(homeframe.getInstance().getResourceBundle().getString("tip5"));
		JRadioButton tip6 = new JRadioButton(homeframe.getInstance().getResourceBundle().getString("src"));
		JRadioButton tip7 = new JRadioButton(homeframe.getInstance().getResourceBundle().getString("dst"));
		
		grupa.add(tip1);
		grupa.add(tip2);
		grupa.add(tip3);
		grupa.add(tip4);
		grupa.add(tip5);
		grupa.add(tip6);
		grupa.add(tip7);
		
		
		JPanel panel3=new JPanel(new FlowLayout());
		panel3.add(tip1);
		panel3.add(tip2);
		panel3.add(tip3);
		panel3.add(tip4);
		panel3.add(tip5);
		panel3.add(tip6);
		panel3.add(tip7);
			if(zaIzmenu.getTip().equals("Boolean")){
				tip1.setSelected(true);
		}else if(zaIzmenu.getTip().equals("One line")){
				tip2.setSelected(true);
		}else if(zaIzmenu.getTip().equals("More lines")){
				tip3.setSelected(true);
		}else if(zaIzmenu.getTip().equals("File chooser")){
				tip4.setSelected(true);
		}else if(zaIzmenu.getTip().equals("Image")){
				tip5.setSelected(true);
		}else if(zaIzmenu.getTip().equals("Source")){
				tip6.setSelected(true);
		}else{
				tip7.setSelected(true);
		}
		JButton btnIzmeni = new JButton(homeframe.getInstance().getResourceBundle().getString("Change"));
		btnIzmeni.setPreferredSize(new Dimension(70,40));
		
		
		btnIzmeni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//SOURCE JE READ ONLY PA NE MORE OGRANICENJE
				 if(tip7.isSelected() &&(nevid.isSelected()) || nepop.isSelected()){
					JOptionPane.showMessageDialog(null,"Destination type has to be VISIBLE AND MANDATORY","Warning",JOptionPane.WARNING_MESSAGE);
					
				}else{
				Stablo s = homeframe.getInstance().getStablo();
				
						p.setNaziv(poljeZaIzmenu.getText());
						if(poljeZaIzmenu.getText().equals("")){
							JOptionPane.showMessageDialog(null,homeframe.getInstance().getResourceBundle().getString("pn"), homeframe.getInstance().getResourceBundle().getString("dijW"), JOptionPane.WARNING_MESSAGE);
						}else{
						boolean vids=vid.isSelected();
						//boolean nevids=nevid.isSelected();
						boolean popuni = pop.isSelected();
						//boolean nepopuni = nepop.isSelected();
						boolean prvi = tip1.isSelected();
						boolean drugi = tip2.isSelected();
						boolean treci = tip3.isSelected();
						boolean cetvrti = tip4.isSelected();
						boolean peti = tip5.isSelected();
						boolean sesti = tip6.isSelected();
						boolean sedmi = tip7.isSelected();
						if (vids==true){
							p.setVidljivost(true);
						}else{
							p.setVidljivost(false);
						}
						if(popuni == true){
							p.setObavezno_popunjavanje(true);
						}
						else{
							p.setObavezno_popunjavanje(false);
						}
						if(prvi==true){
						    p.setTip("Boolean");
						}else if(drugi==true){
							p.setTip("One line");
						}else if(treci==true){
							p.setTip("More lines");
						}else if(cetvrti==true){
							p.setTip("File chooser");
						}else if(peti==true){
							p.setTip("Image");
						}else if(sesti==true){
							p.setTip("Source");
						}else{
							p.setTip("Destination");
						}
						if(prvi == true){
							JFrame dodajProjekat=new JFrame();
							dodajProjekat.setVisible(false);
							
							JPanel Ptip=new JPanel(new FlowLayout());
							JLabel tip22 = new JLabel(homeframe.getInstance().getResourceBundle().getString("tip22"));
							ButtonGroup grupacheck = new ButtonGroup();
							JRadioButton cb1 = new JRadioButton(homeframe.getInstance().getResourceBundle().getString("true"));
							JRadioButton cb2 = new JRadioButton(homeframe.getInstance().getResourceBundle().getString("false"));
							

							grupacheck.add(cb1);
							grupacheck.add(cb2);
						    Ptip.add(tip22);
						    Ptip.add(cb1);
						    Ptip.add(cb2);
						    
							JPanel jp = new JPanel(new BorderLayout());
							JFrame biranjeTipa = new JFrame();
							jp.add(Ptip,BorderLayout.NORTH);
							
							JButton btnOK = new JButton(("OK"));
							jp.add(btnOK,BorderLayout.SOUTH);
							biranjeTipa.add(jp);
							biranjeTipa.setLocationRelativeTo(null);
							biranjeTipa.setSize(350,200);
							biranjeTipa.setVisible(true);
							
							if(zaIzmenu.getBool()){
								cb1.setSelected(true);
							}else{
								cb2.setSelected(true);
							}
							
							btnOK.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
			
									Stablo s = homeframe.getInstance().getStablo();
									
									boolean tacno=cb1.isSelected();
									//boolean netacno=cb2.isSelected();
							
										if(tacno==true){
											p.setBool(true);
										}else{
										p.setBool(false);	
										}
										s.refreshModel();
										dodajProjekat.dispose();
										biranjeTipa.setVisible(false);									
									
								}
							});
						}
						else if (drugi == true){
							JFrame dodajProjekat=new JFrame();
							dodajProjekat.setVisible(false);

							JLabel jednolinijski = new JLabel(homeframe.getInstance().getResourceBundle().getString("opis"));
							JTextField poljeOpis2=new JTextField(zaIzmenu.getJeVi());
							poljeOpis2.setPreferredSize(new Dimension(100,20));
							JPanel Popis2 = new JPanel(new FlowLayout());
							Popis2.add(jednolinijski);
							Popis2.add(poljeOpis2);
							
							JPanel jp2 = new JPanel(new BorderLayout());	   	
						    jp2.add(Popis2,BorderLayout.NORTH);
							
							JButton btnOK = new JButton(("OK"));
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
										p.setJevi(poljeOpis2.getText());
										s.refreshModel();
										dodajProjekat.dispose();
										biranjeTipa2.setVisible(false);						
								}
							});
						}
						else if(treci==true){
							JFrame dodajProjekat=new JFrame();
							dodajProjekat.setVisible(false);
							
							JLabel opis=new JLabel(homeframe.getInstance().getResourceBundle().getString("opis"));

							JTextArea PoljeOpis3=new JTextArea(zaIzmenu.getJeVi());
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
									
										p.setJevi(PoljeOpis3.getText());
										s.refreshModel();
										dodajProjekat.dispose();
										biranjeTipa3.setVisible(false);
									
								}
							});
							
						}
		
						else if(cetvrti==true){
							JFrame dodajProjekat=new JFrame();
							JPanel panel= new JPanel(new BorderLayout());
							JPanel panel2=new JPanel(new BorderLayout());
							JLabel cp=new JLabel(homeframe.getInstance().getResourceBundle().getString("cp"));
							JTextField tf=new JTextField(zaIzmenu.getJeVi());
							JButton dugme=new JButton("...");
							panel.add(cp,BorderLayout.NORTH);
							panel.add(tf,BorderLayout.SOUTH);
							panel2.add(dugme);
							dodajProjekat.setVisible(false);
					        JFrame biranjeTipa4=new JFrame();
					        biranjeTipa4.add(panel,BorderLayout.NORTH);
					        biranjeTipa4.add(panel2, BorderLayout.SOUTH);
					        biranjeTipa4.setTitle(homeframe.getInstance().getResourceBundle().getString("FileC"));
					        biranjeTipa4.setLocationRelativeTo(null);
					        biranjeTipa4.setPreferredSize(new Dimension(200,200));
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
										String s=f.getPath();
										//System.out.println(s);
									
										JTextField labela=new JTextField(s);
										p.setJevi(s);
									
										JButton ok = new JButton("OK");
										JPanel p=new JPanel(new BorderLayout());
										p.add(labela,BorderLayout.NORTH);
										p.add(ok,BorderLayout.SOUTH);
										JFrame fa= new JFrame();
										fa.setSize(600, 90);
										fa.setPreferredSize(new Dimension(420, 60));
										fa.setLocationRelativeTo(null);
										fa.add(p);
										biranjeTipa4.setVisible(false);
										fa.setVisible(true);
                                      ok.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											// TODO Auto-generated method stub
									        Stablo l = homeframe.getInstance().getStablo();						
	                                        
											l.refreshModel();
											dodajProjekat.dispose();
												fa.setVisible(false);					
								
										}
									});
									
                            
									}
									}
							});
					        
							
							
							
						}
						else if(peti==true){
							JFrame dodajProjekat=new JFrame();
							dodajProjekat.setVisible(false);
							JLabel ci=new JLabel(homeframe.getInstance().getResourceBundle().getString("ci"));
							JTextField tf=new JTextField(zaIzmenu.getJeVi());
							ImageIcon icon = new ImageIcon(zaIzmenu.getJeVi());
							Image scaleImage = icon.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
							JLabel slika=new JLabel();
							slika.setIcon(new ImageIcon(scaleImage));
							JPanel pslika=new JPanel(new FlowLayout());
							pslika.add(slika);
							JButton btn= new JButton(homeframe.getInstance().getResourceBundle().getString("bro"));
							btn.setSize(60, 30);
							JPanel p1=new JPanel(new BorderLayout());
							JPanel p2=new JPanel(new BorderLayout());
							p1.add(tf,BorderLayout.NORTH);
							p1.add(ci,BorderLayout.SOUTH);
							p1.add(pslika,BorderLayout.CENTER);
							p2.add(btn);
						
							JFrame f=new JFrame();
							f.setLocationRelativeTo(null);
							f.add(p1,BorderLayout.NORTH);
							f.add(p2, BorderLayout.SOUTH);
							f.setPreferredSize(new Dimension(200, 80));
							f.setSize(350,300);
							f.setVisible(true);
							
							btn.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									
									
									JFileChooser fc=new JFileChooser();
									int a=fc.showOpenDialog(homeframe.getInstance());
									if(a==JFileChooser.APPROVE_OPTION){
									File fi=fc.getSelectedFile();
									String si=fi.getPath();
									ImageIcon img= new ImageIcon(fi.getAbsolutePath());
									JButton ok = new JButton("Ok");
									JLabel labela12= new JLabel(si);
									labela12.setIcon(img);
									f.setVisible(false);
									
									ImageIcon icon = new ImageIcon(fi.getAbsolutePath());
									Image scaleImage = icon.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
									JLabel slika=new JLabel();
									slika.setIcon(new ImageIcon(scaleImage));
									JPanel pslika=new JPanel(new FlowLayout());
									pslika.add(slika);
									
									JTextField labela=new JTextField(fi.getAbsolutePath());
									p.setJevi(fi.getAbsolutePath());
									JPanel p=new JPanel(new BorderLayout());
									p.add(labela,BorderLayout.NORTH);
									p.add(pslika,BorderLayout.CENTER);
									p.add(ok,BorderLayout.SOUTH);
									JFrame fa= new JFrame();
									fa.setSize(350,300);
									fa.setLocationRelativeTo(null);
									fa.add(p);
									fa.setVisible(true);
				                    ok.addActionListener(new ActionListener() {
									
										@Override
										public void actionPerformed(ActionEvent e) {
											// TODO Auto-generated method stub
									
											  Stablo s = homeframe.getInstance().getStablo();

												s.refreshModel();
												
												dodajProjekat.dispose();
											   fa.setVisible(false);
											
										}
									});
									
									}
														
								}
							});
							
						}else if(sesti==true){
							JFrame dodajProjekat=new JFrame();
							JPanel panel= new JPanel(new BorderLayout());
							JPanel panel2=new JPanel(new BorderLayout());
							JLabel labela=new JLabel(homeframe.getInstance().getResourceBundle().getString("cs"));
							JTextField tf=new JTextField(zaIzmenu.getJeVi());
							JButton dugme=new JButton("...");
							panel.add(labela,BorderLayout.NORTH);
							panel.add(tf,BorderLayout.SOUTH);
							panel2.add(dugme);
							dodajProjekat.setVisible(false);
					        JFrame biranjeTipa6=new JFrame();
					        biranjeTipa6.add(panel,BorderLayout.NORTH);
					        biranjeTipa6.add(panel2, BorderLayout.SOUTH);
					        biranjeTipa6.setTitle(homeframe.getInstance().getResourceBundle().getString("src"));
					        biranjeTipa6.setLocationRelativeTo(null);
					        biranjeTipa6.setPreferredSize(new Dimension(200,200));
					        biranjeTipa6.setSize(400, 100);
					        biranjeTipa6.setVisible(true);
					        dugme.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent arg0) {
									// TODO Auto-generated method stub
									JFileChooser fc=new JFileChooser();
									int a=fc.showOpenDialog(homeframe.getInstance());
									if(a==JFileChooser.APPROVE_OPTION){
										File f=fc.getSelectedFile();
										String s=f.getPath();
										//System.out.println(s);
										JTextField labela=new JTextField(s);
										p.setJevi(s);
										JPanel p=new JPanel();
										p.add(labela);
										JFrame fa= new JFrame();
										fa.setSize(600, 90);
										JButton ok = new JButton("OK");
										JPanel panelcic=new JPanel(new BorderLayout());
										panelcic.add(labela,BorderLayout.NORTH);
										panelcic.add(ok,BorderLayout.SOUTH);
										fa.setPreferredSize(new Dimension(420, 60));
										fa.setLocationRelativeTo(null);
										fa.add(panelcic);
										fa.setVisible(true);

									}
                                    Stablo s = homeframe.getInstance().getStablo();						

										s.refreshModel();
										dodajProjekat.dispose();
										biranjeTipa6.setVisible(false);						
								}
							});
							
							
							
						}else if(sedmi==true){
							JFrame dodajProjekat=new JFrame();
							JPanel panel= new JPanel(new BorderLayout());
							JPanel panel2=new JPanel(new BorderLayout());
							JLabel labela=new JLabel(homeframe.getInstance().getResourceBundle().getString("cd"));
							JTextField tf=new JTextField(zaIzmenu.getJeVi());
							JButton dugme=new JButton("...");
							panel.add(labela,BorderLayout.NORTH);
							panel.add(tf,BorderLayout.SOUTH);
							panel2.add(dugme);
							dodajProjekat.setVisible(false);
					        JFrame biranjeTipa7=new JFrame();
					        biranjeTipa7.add(panel,BorderLayout.NORTH);
					        biranjeTipa7.add(panel2, BorderLayout.SOUTH);
					        biranjeTipa7.setTitle(homeframe.getInstance().getResourceBundle().getString("dst"));
					        biranjeTipa7.setLocationRelativeTo(null);
					        biranjeTipa7.setPreferredSize(new Dimension(200,200));
					        biranjeTipa7.setSize(400, 100);
					        biranjeTipa7.setVisible(true);
					        dugme.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent arg0) {
									// TODO Auto-generated method stub
									JFileChooser fc=new JFileChooser();
									int a=fc.showOpenDialog(homeframe.getInstance());
									if(a==JFileChooser.APPROVE_OPTION){
										File f=fc.getSelectedFile();
										String s=f.getPath();
										//System.out.println(s);
										JTextField labela=new JTextField(s);
										p.setJevi(s);
										JPanel p=new JPanel();
										p.add(labela);
										JFrame fa= new JFrame();
										fa.setSize(600, 90);
										fa.setPreferredSize(new Dimension(420, 60));
										fa.setLocationRelativeTo(null);
										fa.add(p);
										fa.setVisible(true);

									}
                                    Stablo s = homeframe.getInstance().getStablo();						

                                    
										s.refreshModel();
										dodajProjekat.dispose();
										biranjeTipa7.setVisible(false);						
								}
							});
							
							
							
						}

						((DefaultTreeModel)s.getModel()).nodeChanged(selected);
						izmena.dispose();
			
			}
			}}
		});
		
		JPanel panel=new JPanel(new BorderLayout());
		JPanel panel11=new JPanel(new BorderLayout());
		panel11.add(panel1, BorderLayout.NORTH);
		panel11.add(panel2,BorderLayout.CENTER);
		panel11.add(panelzapop,BorderLayout.SOUTH);
		panel.add(panel11, BorderLayout.NORTH);
		panel.add(panel3,BorderLayout.CENTER);
		panel.add(btnIzmeni,BorderLayout.SOUTH);
		izmena.add(panel);
		izmena.setSize(850, 220);
		izmena.setVisible(true);
		izmena.setTitle(homeframe.getInstance().getResourceBundle().getString("pName"));
		izmena.setLocationRelativeTo(null);
		izmena.validate();
			}
		}else{
			JOptionPane.showMessageDialog(null,homeframe.getInstance().getResourceBundle().getString("pread"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
		}
		}

	} else {
		JOptionPane.showMessageDialog(null,homeframe.getInstance().getResourceBundle().getString("selP"),homeframe.getInstance().getResourceBundle().getString("dijW"),JOptionPane.WARNING_MESSAGE);
		}
	}
}
