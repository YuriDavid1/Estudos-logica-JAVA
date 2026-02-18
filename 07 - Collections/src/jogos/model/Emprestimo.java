package jogos.model;

public class Emprestimo {

	 private int id;
	    private Usuario usuario;
	    private Jogo jogo;
	    private boolean ativo;

	    public Emprestimo(int id, Usuario usuario, Jogo jogo) {
	    this.id = id;
	    this.usuario = usuario;
	    this.jogo = jogo;
	    this.ativo = true;
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
