package ATV13042016_GUI;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import ATV13042016.Agenda;

public class Janela1 extends JFrame implements Serializable{
	
	Listener wl = new Listener();
	Agenda agenda;
	Janela_Esq t1;
	Janela_Dir t2;

	Janela1(Agenda a, Janela_Esq b, Janela_Dir c){
		
		super("Agenda");
		
		this.agenda = a;
		this.t1 = b;
		this.t2 = c;
		
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.LINE_AXIS));

		this.add(t1);
		this.add(t2);

		this.setSize(525,275);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.addWindowListener(wl);;

	}
	
	Janela1() throws ClassNotFoundException, IOException{
		super("Agenda");
		agenda = new Agenda();

		if(wl.checkCarregar()){
			wl.carregar();
		}
		else{
		t2 = new Janela_Dir(agenda);
		t1 = new Janela_Esq(agenda,t2);
		}
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.LINE_AXIS));

		this.add(t1);
		this.add(t2);

		this.setSize(525,275);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.addWindowListener(wl);;
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException{
		Janela1 j1 = new Janela1();
	}
	
	public class Listener implements WindowListener,Serializable{

		@Override
		public void windowActivated(WindowEvent arg0) {
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			try {
				salvar();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		}

		public void salvar() throws IOException{
		File arquivo1 = new File("C:/Users/Public/agndestd1.bin");
		arquivo1.createNewFile();
		FileOutputStream fos1 = new FileOutputStream(arquivo1,false);
		ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
		oos1.writeObject(agenda);
		
		oos1.close();
		fos1.close();
	}
	
		public void carregar() throws IOException, ClassNotFoundException{
			File arquivo1 = new File("C:/Users/Public/agndestd1.bin");
			if(arquivo1.exists()){
				FileInputStream fis1 = new FileInputStream(arquivo1);
				ObjectInputStream ois1 = new ObjectInputStream(fis1);
				
				agenda = (Agenda) ois1.readObject();
				Iterator a = agenda.iterator();
				if(a.hasNext()){
				}
				else
					agenda = new Agenda();
				
				t2 = new Janela_Dir(agenda);
				t1 = new Janela_Esq(agenda,t2);
				
				ois1.close();
			}
		}
		
		public boolean checkCarregar(){
			File arquivo1 = new File("C:/Users/Public/agndestd1.bin");
			if(arquivo1.exists()){
				return true;
			}
			return false;
		}
	}


}
