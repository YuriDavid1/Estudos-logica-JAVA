package todolist.model;

public class Tarefa {
	
	private int id;
	private String descricao;
	private boolean estado;

	public Tarefa(int id, String descricao, boolean estado) {
		this.id = id;
		this.descricao = descricao;
		this.estado = false;
	}
	
	//GETTERS
	public int getID() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public boolean estado() {
		return estado;
	}
	
	
	
	//SETTERS
	public void setID(int id) {
		this.id = id;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
