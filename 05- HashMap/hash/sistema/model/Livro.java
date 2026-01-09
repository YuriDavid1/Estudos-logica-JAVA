package sistema.model;

public class Livro {

	private int id;
	private String titulo;
	private String autor;
	private boolean emprestado = false;
	
	public Livro(int id, String titulo, String autor) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.emprestado = false;
	}
	
	//GETTERS
	public int getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public boolean getEmprestado() {
		return emprestado;
	}
	
	//SETTERS 
	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
}
