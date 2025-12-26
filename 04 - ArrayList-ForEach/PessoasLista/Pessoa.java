package Poo2;

public class Pessoa {

	
	public String nome;
	public int idade;
	
	public Pessoa(String nome, int idade){
	this.nome = nome;
	this.idade = idade;
	}
	
	public void apresentar() {
		System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos");
	}
	
	public void FazerAniversario() {
		idade ++;
	}
	}
	

