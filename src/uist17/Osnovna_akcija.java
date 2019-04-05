package uist17;

import java.awt.Frame;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Osnovna_akcija extends JDialog{
	public Osnovna_akcija(Frame parent, String title, boolean modal){
		super(parent, title, modal);
		
		setSize(350,300);
		setLocationRelativeTo(parent);
		JLabel lblTxtField1=new JLabel("Pomoc:");
		//JLabel lbl2=new	JLabel("ne znam kako da ti  pomognem, posto ocigledno ne znam ni sebi!");
        Box boxActionListenerTxtField1=Box.createVerticalBox();
        boxActionListenerTxtField1.add(lblTxtField1);
        add(boxActionListenerTxtField1);
       
		//JPanel p=new JPanel();
		//JTextPane l=new JTextPane();
		//l.setText("skdfjsdfskdfsdjfksdjfskdfjskdjj sjdffkladjmc dlaksjsdlkvjsxicljkvmsj slkdfmjdskx");
		//l.setEditable(false);
		//1.
		//JScrollPane scrollPane = new JScrollPane(l, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //add(scrollPane);
		//p.add(l);
		//add(p);
}

}