package Poo2;

public class Pessoa {

	
	private String nome;
	private int idade;
	
	public Pessoa(String nome, int idade){
	this.nome = nome;
	this.idade = idade;
	}
	
	public String nomeGet() {
		return nome;
	}
	
	public void nomeSet(String nome) {
		this.nome = nome;
	}
	
	public int idadeGet() {
		return idade;
	}
	
	public void idadeSet(int idade) {
		this.idade = idade;
	}
	
	public void listar() {
		System.out.println(nome + " | " + idade);
		}
		
	public void fazerAniversario() {
		idade++;
		}
	}
	