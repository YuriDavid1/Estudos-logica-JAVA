package jogos.model;

public class Jogo {

	int id;
	String nome;
	String genero;
	boolean disponivel;
	
	public Jogo(int id, String nome, String genero) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		disponivel = true;
	}
	
	//Getters
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}
	
	//Setters
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	
	}
