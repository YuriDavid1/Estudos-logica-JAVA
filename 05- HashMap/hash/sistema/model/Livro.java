package sistema.model;

public class Livro {

	private int id;
	private String titulo;
	private String autor;
	private EstadoLivro estado;
	
	public Livro(int id, String titulo, String autor) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.estado = EstadoLivro.DISPONIVEL;
	}
	
	//GETTERS
	
	public EstadoLivro getEstado () {
		return estado;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	//SETTERS 
	public void SetEstado(EstadoLivro estado) {
		this.estado = estado;
	}
}
