package ATV13042016_GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import ATV13042016.Agenda;
import ATV13042016.Aluno;

public class Janela_Dir extends JPanel implements Serializable{

	Agenda agenda;

	JPanel t1 = new JPanel();

	JScrollPane scroll = new JScrollPane();
	JTextField tf1 = new JTextField(" ");
	JButton b1 = new JButton("Ir");
	ArrayList<Aluno> resultados;
	Sub_JD_View t2 = new Sub_JD_View(scroll);

	Handler button_handler = new Handler();

	Janela_Dir(Agenda a){

		this.resultados = new ArrayList<Aluno>();

		this.agenda = a;

		this.setPreferredSize(new Dimension(350,275));
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

		t1.setLayout(new BoxLayout(t1,BoxLayout.LINE_AXIS));

		t2.setLayout(new BoxLayout(t2,BoxLayout.PAGE_AXIS));

		t1.add(tf1);
		t1.add(b1);

		b1.addActionListener(button_handler);

		t1.setPreferredSize(new Dimension(350,40));

		scroll.add(t2);

		scroll.setPreferredSize(new Dimension(350,200));

		scroll.setViewportView(t2);

		t1.setVisible(true);
		t2.setVisible(true);

		this.add(t1);
		this.add(scroll);

		this.setVisible(true);
	}

	public void listar(){
		t2.removeAll();
		for(Aluno a : this.agenda){
			t2.add(new TelaContato(a,t2,resultados,this.agenda));
		}
		t2.setVisible(false);
		t2.setVisible(true);
		scroll.add(t2);
		scroll.setViewportView(t2);
	}

	public void refresh(){
		t2.removeAll();
		for(Aluno b : resultados){
			t2.add(new TelaContato(b,t2,resultados,agenda));
		}
		t2.setVisible(false);
		t2.setVisible(true);
		scroll.add(t2);
		scroll.setViewportView(t2);
	} 

	public void remover(Aluno a){
		resultados.remove(a);
		refresh();
	}

	public class Handler implements ActionListener,Serializable{

		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == b1){
				resultados = new ArrayList<Aluno>();
				String teste;
				if(tf1.getText().length() >= 2){
					if(tf1.getText().charAt(0) == ' '){
						teste = tf1.getText().substring(1);
					}
					else{
					teste = tf1.getText();
					}
				}
				else{
					teste = tf1.getText();
				}
				for(Aluno a : agenda){
					if(a.getNome().matches(".*"+teste+".*") || a.getMatricula().matches(".*"+teste+".*")){
						resultados.add(a);
					}
					else{
						continue;
					}
				}
				refresh();
			}
		}

	}

}
