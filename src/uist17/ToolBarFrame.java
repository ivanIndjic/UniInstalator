package uist17;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ToolBarFrame extends JFrame {

	public ToolBarFrame() {
		// TODO Auto-generated constructor stub
		
		Toolbar toolbar=new Toolbar();
		
		add(toolbar, BorderLayout.NORTH);
		
	}

}
