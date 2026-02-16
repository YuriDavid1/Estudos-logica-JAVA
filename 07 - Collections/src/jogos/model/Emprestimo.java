package jogos.model;

public class Emprestimo {

	int id;
	Usuario usuario;
	Jogo jogo;
	
	boolean ativo;
	
	public Emprestimo(int id, Usuario usuario, Jogo jogo) {
		this.id = id;
		this.usuario = usuario;
		this.jogo = jogo;
		ativo = true;
	}
	
	//GETTERS E SETTERS
	
	public int getId() {
		return id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Jogo getJogo() {
		return jogo;
	}
	
	public boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
