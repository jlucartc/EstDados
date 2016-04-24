package ATV13042016_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ATV13042016.Agenda;
import ATV13042016.Aluno;

public class TelaContato extends JPanel implements Serializable{

	JButton b1 = new JButton("Editar");
	JButton b2 = new JButton("Remover");

	JPanel t1 = new JPanel();
	JPanel t2 = new JPanel();

	Handler button_handler = new Handler();
	
	Aluno a;
	Sub_JD_View container;
	ArrayList<Aluno> resultados;
	Agenda agenda;
	
	TelaContato(Aluno a, Sub_JD_View container, ArrayList<Aluno> resultados, Agenda agenda){

		this.agenda = agenda;
		this.resultados = resultados;
		
		this.a = a;
		this.container = container;

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		this.setPreferredSize(new Dimension(250,90));
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

		t1.setLayout(new BoxLayout(t1, BoxLayout.PAGE_AXIS));
		t2.setLayout(new GridLayout(2,1));

		t1.setPreferredSize(new Dimension(150,35));
		t2.setPreferredSize(new Dimension(100,35));

		t1.add(new JLabel("Nome: "+a.getNome()));
		t1.add(new JLabel("Matricula: "+a.getMatricula()));
		t1.add(new JLabel("Estado: "+a.getEstado()));

		b1.addActionListener(button_handler);
		b2.addActionListener(button_handler);
		
		t2.add(b1);
		t2.add(b2);

		t1.setVisible(true);
		t2.setVisible(true);

		this.add(t1);
		this.add(t2);

		this.setVisible(true);	
	}

	public class Handler implements ActionListener,Serializable{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == b2){
				container.remover(a, resultados, agenda);
			}
			else if(event.getSource() == b1){
					try{
					int escolha = Integer.parseInt(JOptionPane.showInputDialog("\n\n 1 - Alterar nome do aluno \n 2 - Alterar matricula do aluno \n 3 - Alterar estado do aluno \n 4 - Alterar tudo \n\n"));
					agenda.update(a, escolha);
					container.refresh(resultados,agenda);			
					} catch(NumberFormatException ex){
					}
			}
			
		}
		
	}
}
