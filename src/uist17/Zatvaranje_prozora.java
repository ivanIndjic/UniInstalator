package uist17;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

	public class Zatvaranje_prozora implements WindowListener{
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			JFrame frame= (JFrame) arg0.getComponent();
			int code=JOptionPane.showConfirmDialog(frame, homeframe.getInstance().getResourceBundle().getString("x"),homeframe.getInstance().getResourceBundle().getString("exit"),JOptionPane.YES_NO_OPTION);
			if (code!=JOptionPane.YES_OPTION){
			
				frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			}
			else{
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			}
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}



	}
