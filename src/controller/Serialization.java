package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import model.Projekat;
import model.Workspace;
import uist17.homeframe;

public class Serialization {
	
	public static final File DEFAULT_FILE = new File("workspace.ser");

	public static void saveModel(Workspace w, File path) throws FileNotFoundException, IOException {
		ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
		try {
			os.writeObject(w);
		} finally {
			os.close();
		}
	}

	public static Workspace openModel(File path)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
		try {
			Workspace w = (Workspace) ois.readObject();
			return w;
		} finally {
			ois.close();
		}
	}
	
	public static void saveProject(Projekat p, File path) throws FileNotFoundException, IOException {
		ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
		try {
			os.writeObject(p);
		} finally {
			os.close();
		}
	}
	public static Projekat openProject(File path)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
		Projekat p = new Projekat();
		try {
			p = (Projekat) ois.readObject();
			return p;
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, homeframe.getInstance().getResourceBundle().getString("PI"),
					homeframe.getInstance().getResourceBundle().getString("dijW"), JOptionPane.WARNING_MESSAGE);
			
		}
		finally {
			ois.close();
		}
		return p;
	}
	
}

