package ATV13042016;

import javax.swing.JOptionPane;

public class Principal {
public static Agenda agenda = new Agenda();
	public static void main(String[] args) {
		
		
		int escolha = Integer.parseInt(JOptionPane.showInputDialog("\n\nAgenda\n\n"+"1 - Cadastrar aluno\n"+"2 - Imprimir alunos\n"+"3 - Atualizar contato\n"+"4 - Remover aluno\n"+"5 - Sair do programa\n\n"));

		switch(escolha){
		case 1:
			Aluno obj = new Aluno();
			agenda.setNome(obj);
			agenda.setEstado(obj);
			agenda.inserir(obj);
			main(null);
			break;
		case 2:
			agenda.contatos();
			main(null);
			break;
		case 3:
			String string1 = JOptionPane.showInputDialog("Digite a matrícula do aluno: \n");
			Aluno aluno1 = agenda.procurar(string1);
			if(aluno1 != null){
				int escolha2 = Integer.parseInt(JOptionPane.showInputDialog("\n\n 1 - Alterar nome do aluno \n 2 - Alterar matricula do aluno \n 3 - Alterar estado do aluno \n 4 - Alterar tudo \n\n"));
				agenda.update(aluno1, escolha2);
			}
			main(null);
			break;
		case 4:
			String string2 = JOptionPane.showInputDialog("Digite a matrícula do aluno: \n");
			Aluno aluno2 = agenda.procurar(string2);
			agenda.remove(aluno2);
			main(null);
			break;
		case 5:
			break;
		}
	}

}
