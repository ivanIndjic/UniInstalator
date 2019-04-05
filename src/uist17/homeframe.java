package uist17;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.FinishParametrizationAction;
import controller.Serialization;
import model.Parametar;
import model.Workspace;


public class homeframe extends JFrame {
	
	private static homeframe instance;
	private Workspace w;
	private Stablo s;
	private DefaultMutableTreeNode sm;
	private ResourceBundle resourceBundle;
	
	public static homeframe getInstance(){
		if(instance==null){
			instance=new homeframe();
		  instance.init();
		}return instance;
	}
	
	
	
	 private homeframe(){}
	 
	 private void init(){
		 
	
		/*try {
			JFileChooser fc=new JFileChooser();
			int a=fc.showOpenDialog(homeframe.getInstance());
			File f=fc.getSelectedFile();
			
			String s=f.getPath();
		
			w = Serialization.openModel(f);
		} catch (ClassNotFoundException | IOException e) {
			//e.printStackTrace();
			w=new Workspace("Workspace");
		}*/
		resourceBundle =ResourceBundle.getBundle( "jezici.MessageResources", Locale.getDefault());
		w=new Workspace("Workspace");
		s = new Stablo(w);
		sm = new DefaultMutableTreeNode();
		Glavni_prozor nina=new Glavni_prozor();
		Toolbar tica=new Toolbar();
		setTitle("UIST17");
		setSize(800,400);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        
		
	    JPanel gornji=new JPanel();
		gornji.setLayout(new BorderLayout());
		gornji.add(nina,BorderLayout.NORTH);
		gornji.add(tica,BorderLayout.SOUTH);
		
		JPanel srednji=new JPanel();
		srednji.setLayout(new BorderLayout());
		JPanel p1=new JPanel(new BorderLayout());
		
	
		JPanel levi = new JPanel();
		JPanel desni = new JPanel();
		desni.setLayout(new BorderLayout());
		JButton finishButton = new JButton(new FinishParametrizationAction());
		desni.add(finishButton, BorderLayout.SOUTH);
		
		srednji.add(levi);
		levi.add(s);

		srednji.add(desni);

		JScrollPane skrol = new JScrollPane(levi,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(skrol);
		
		JSplitPane razdvajanje = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,skrol,desni);
		razdvajanje.setDividerLocation(270);
		srednji.add(razdvajanje);
		
		add(gornji,BorderLayout.NORTH);
		add(srednji,BorderLayout.CENTER);
		
		addWindowListener(new Zatvaranje_prozora());
	}
	


	
	public void changeLanguage(){
		
		resourceBundle =
            ResourceBundle.getBundle( "jezici.MessageResources", Locale.getDefault() );

		
		UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yesOption"));
		UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("noOption"));
		UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("okOption"));
		UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancelOption"));
		
	}
	public Stablo getStablo(){
		return s;
	}

	public Workspace getW() {
		return w;
	}

	public void setW(Workspace w) {
		this.w = w;
	}
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	public DefaultMutableTreeNode getStabloModel(){
		return sm;
	}

}
