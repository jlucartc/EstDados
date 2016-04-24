package ATV13042016_GUI;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ATV13042016.Agenda;
import ATV13042016.Aluno;

public class Sub_JD_View extends JPanel implements Serializable{
	JScrollPane scroll = new JScrollPane();
	
	Sub_JD_View(JScrollPane scroll){
		this.scroll = scroll;
		this.setVisible(true);
	}
	
	public void remover(Aluno a, ArrayList<Aluno> b, Agenda agenda){
		agenda.remove(a);
		b.remove(a);
		this.refresh(b,agenda);
	}
	
	public void refresh(ArrayList<Aluno> b, Agenda agenda){
		this.removeAll();
		for(Aluno c : agenda){
			this.add(new TelaContato(c,this,b,agenda));
		}
		this.setVisible(false);
		this.setVisible(true);
		scroll.add(this);
		scroll.setViewportView(this);
	}
}
