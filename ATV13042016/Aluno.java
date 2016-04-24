package ATV13042016;

import java.io.Serializable;

public class Aluno implements Serializable{
	String nome;
	String matricula;
	String cursando;
	
	public Aluno(){
		this.nome = null;
		this.matricula = null;
		this.cursando = null;
	}
	
	public Aluno(String nome, String matricula , String cursando){
		this.nome = nome;
		this.matricula = matricula;
		this.cursando = cursando;
	}
	public String toString(){
		if(this.cursando != null){
		if(this.cursando.length() == 1){
			if(Character.valueOf(this.cursando.charAt(0)) == 0){
				String s = "\n\n"+"Nome: "+this.nome+"\n"+"Matricula: "+this.matricula+"\n"+"Estado: cursando "+"\n\n";
				return s;
			}
			else if(Character.valueOf(this.cursando.charAt(0)) == 1){
				String s = "\n\n"+"Nome: "+this.nome+"\n"+"Matricula: "+this.matricula+"\n"+"Estado: não está cursando "+"\n\n";
				return s;
			}
			else{
				String s = "\n\n"+"Nome: "+this.nome+"\n"+"Matricula: "+this.matricula+"\n"+"Estado: indefinido "+"\n\n";
				return s;
			}
		}
		else{
			String s = "\n\n"+"Nome: "+this.nome+"\n"+"Matricula: "+this.matricula+"\n"+"Estado: indefinido "+"\n\n";
			return s;
		}
		}
		else{
			String s = "\n\n"+"Nome: "+this.nome+"\n"+"Matricula: "+this.matricula+"\n"+"Estado: indefinido "+"\n\n";
			return s;
		}
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getMatricula(){
		return this.matricula;
	}
	
	public String getEstado(){
		if(this.cursando != null){
		if(this.cursando.length() == 1){
			if(this.cursando.equals("1")){
				return "cursando";
			}
			else if(this.cursando.equals("0")){
				return "não está cursando";
			}
			else{
				return "indefinido";
			}
		}
		else{
			return "indefinido";
		}
	}
		else{
			return null;
		}
	}
}
