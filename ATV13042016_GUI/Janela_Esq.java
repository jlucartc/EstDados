package ATV13042016_GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ATV13042016.Agenda;
import ATV13042016.Aluno;

public class Janela_Esq extends JPanel implements Serializable{
	JButton b1 = new JButton("Criar");
	JButton b3 = new JButton("Listar");

	Janela_Dir Direita;

	Handler button_handler = new Handler();

	Agenda agenda;
	
	Janela_Esq(Agenda a, Janela_Dir b){

		this.agenda = a;

		this.Direita = b;

		this.setPreferredSize(new Dimension(175,275));
		this.setLayout(new GridLayout(4,1));

		b1.setFont(new Font("Arial",Font.PLAIN,20));
		b3.setFont(new Font("Arial",Font.PLAIN,20));

		this.add(b1);
		this.add(b3);

		b1.addActionListener(button_handler);
		b3.addActionListener(button_handler);

		this.setVisible(true);
	}

	//Action Listener class

	public class Handler implements ActionListener,Serializable{

		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == b1){
				Aluno a = new Aluno();
				agenda.setNome(a);
				if(a.getNome() != null){
				agenda.setEstado(a);
				if(a.getEstado() != null){
					agenda.inserir(a);
				}
				}
			}
			if(event.getSource() == b3){
					Direita.listar();
			}
		}

	}

}
