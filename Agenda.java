package ATV13042016;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Agenda implements Iterable<Aluno>, Serializable{
	int cod;
	public ArrayList<Aluno> agenda;

	public void inserir(Aluno a){
		a.matricula = Integer.toString(cod);
		cod++;
		this.agenda.add(a);
	}

	public void contatos(){
		for(Iterator i = agenda.iterator();i.hasNext();){
			System.out.println(i.next());
		}
	}

	public Agenda(){
		cod = 0;
		agenda = new ArrayList<Aluno>();
	}

	public void update(Aluno a, int escolha){
		if(escolha == 1){
			String temp = a.getNome();
			this.setNome(a);
			if(a.getNome() == null){
				a.nome = temp;
			}

		}
		else if(escolha == 2){
			String temp = a.getMatricula();
			this.setMatricula(a);
			if(a.getMatricula() == null){
				a.matricula = temp;
			}
		}
		else if(escolha == 3){
			String temp = a.getEstado();
			this.setEstado(a);
			if(a.getEstado() == null){
				a.cursando = temp;
			}
		}
		else if(escolha == 4){
			String temp1 = a.getNome();
			String temp2 = a.getMatricula();
			String temp3 = a.getEstado();
			this.setNome(a);
			if(a.getNome() != null){
				this.setMatricula(a);
					if(a.getMatricula() != null){
						this.setEstado(a);
						if(a.getEstado() == null){
							a.cursando = temp3;
							a.matricula = temp2;
							a.nome = temp1;
						}
					}
					else{
						a.matricula = temp2;
						a.nome = temp1;
					}
			}
			else{
				a.nome = temp1;
			}
		}
		else{
			JOptionPane.showMessageDialog(null,"Procedimento inválido.");
		}
	}
	public void setNome(Aluno a){
		a.nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
		int space = 0;
		if(a.nome != null){
			for(int i = 0; i< a.nome.length();i++){
				if(Character.isAlphabetic(a.nome.charAt(i))){
					continue;
				}
				else if(a.nome.charAt(i) ==' '){
					space++;
				}
				else{
					a.nome = null;
					JOptionPane.showMessageDialog(null,"1 - Cadastro Inválido.");
					return;
				}
			}
			if(a.nome.length() == space){
				a.nome = null;
				JOptionPane.showMessageDialog(null,"2 - Cadastro Inválido.");
			}
		}
		System.out.println("\n\n");
	}
	public void setMatricula(Aluno a){
		try{
			a.matricula = JOptionPane.showInputDialog("Digite a matrícula do aluno: ");
		} catch(NullPointerException ex){
		}
		boolean isdigit = false;
		for(int i = 0; i < a.matricula.length(); i++){
			char caractere = a.matricula.charAt(i);
			if(Character.isDigit(caractere)){
				isdigit = true;
				break;
			}
		}
		if(isdigit){
		}
		else{
			JOptionPane.showMessageDialog(null,"Procedimento inválido.");
			a.matricula = null;
		}

		System.out.println("\n\n");
	}
	public void setEstado(Aluno a){
		try{
			//int i = Integer.parseInt(JOptionPane.showInputDialog("Digite o estado do aluno: "+"\n"+"0 - não está cursando"+"\n"+"1 - está cursando"+"\n\n"));
			String i = JOptionPane.showInputDialog("Digite o estado do aluno: "+"\n"+"0 - não está cursando"+"\n"+"1 - está cursando"+"\n\n");
			System.out.println("\n\n");
			if(i.length() == 1){
				if(i.equals("0")){
					a.cursando = "0";
				}
				else if(i.equals("1")){
					a.cursando = "1";
				}
				else{
					a.cursando = null;
					JOptionPane.showMessageDialog(null,"Cadastro inválido.");
				}
			}
			else{
				a.cursando = null;
				JOptionPane.showMessageDialog(null,"Cadastro inválido.");
			}
		}catch(NumberFormatException ex){
		}catch(NullPointerException ex){
			a.cursando = null;
			JOptionPane.showMessageDialog(null,"Cadastro inválido.");
		}

	}

	public void remove(Aluno a){
		this.agenda.remove(a);
	}

	public Aluno procurar(String a){
		Aluno j = null;
		for(Aluno i : agenda){
			if(i.matricula.equals(a)){
				return i;
			}
		}
		return j;		
	}

	@Override
	public Iterator<Aluno> iterator() {
		Iterator<Aluno> iter = agenda.iterator();
		return iter;
	}

}
