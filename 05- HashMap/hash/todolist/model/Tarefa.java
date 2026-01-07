package todolist.model;

public class Tarefa {
	
	private int id;
	private String descricao;
	private boolean estado = false;

	
public Tarefa (int id, String descricao) {
	this.id = id;
	this.descricao = descricao;
	this.estado = false;
}

public int getId() {
	return id;
}

public String getDescricao() {
	return descricao;
}

public boolean getEstado() {
	return estado;
}

public void setId(int id) {
	this.id = id;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public void setEstado(boolean estado) {
	this.estado = estado;
}
	
}
