package uist17;

import javax.swing.JFrame;



public class Poziv_glavnog_prozora extends JFrame{
	
	public Poziv_glavnog_prozora(){
		
		setSize(500,500);
		setLocationRelativeTo(null);
		
		Glavni_prozor nina=new Glavni_prozor();
		this.setJMenuBar(nina);
		
		
	}

}
