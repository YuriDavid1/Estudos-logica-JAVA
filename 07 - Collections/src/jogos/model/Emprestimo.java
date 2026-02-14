package jogos.model;

public class Emprestimo {

	int id;
	Usuario usuario;
	Jogo jogo;
	
	boolean ativo;
	
	public Emprestimo(Usuario usuario, Jogo jogo) {
		this.usuario = usuario;
		this.jogo = jogo;
		ativo = true;
	}
	
	//GETTERS E SETTERS
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Jogo getJogo() {
		return jogo;
	}
	
	public boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
}
