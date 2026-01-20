package matricula.model;
import  matricula.model.EstadoCurso;

public class Curso {

	private int id;
	private String nome;
	private int cargaHoraria;
	private EstadoCurso estado;
	
	public Curso(int id, String nome, int cargaHoraria) {
		this.id = id;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		estado = EstadoCurso.ATIVO;	
	}
	
	//GETTERS
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	
	public EstadoCurso getEstado() {
		return estado;
	}
	
	//SETTERS
	public void setEstado(EstadoCurso estado) {
	this.estado = estado;
	
	}
	
}
