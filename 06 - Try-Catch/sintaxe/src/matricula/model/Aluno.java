package matricula.model;

public class Aluno {

	final private int id;
	final private String nome;
	private int idade;
	
	public Aluno(int id, String nome, int idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}
	
	//GETTERS
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}
}