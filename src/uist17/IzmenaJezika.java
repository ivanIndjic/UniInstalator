package uist17;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class IzmenaJezika extends JFrame{
public IzmenaJezika() {
	// TODO Auto-generated constructor stub

	JRadioButton srpski=new JRadioButton("Serbian");
	JRadioButton engleski=new JRadioButton("English");
	ButtonGroup b1 =new ButtonGroup();
	b1.add(engleski);
	b1.add(srpski);
	JButton ok= new JButton("Ok");
	JFrame jez= new JFrame();
	JPanel izbJez= new JPanel();
	jez.setTitle("Izaberi jezik/Choose language");
	izbJez.setName("Izaberi jezik/Choose language");
	izbJez.setVisible(true);
	izbJez.add(srpski);
	izbJez.add(engleski);
	izbJez.add(ok);
	jez.add(izbJez);
	jez.setVisible(true);
	jez.setSize(400, 100);
    jez.setLocationRelativeTo(null);
    
	
    
	srpski.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Locale.setDefault(new Locale("sr", "RS"));
		
			
		}
	});
	
	
	engleski.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Locale.setDefault(new Locale("en", "US"));	
		}
	});
	ok.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			if(srpski.isSelected() || engleski.isSelected()){
			jez.setVisible(false);	
			homeframe h = homeframe.getInstance();
			h.setVisible(true);
			}
		}
	});
	}
}
