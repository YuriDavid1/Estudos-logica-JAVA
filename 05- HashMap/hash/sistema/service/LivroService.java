package sistema.service;
import sistema.model.Livro;
import sistema.repository.LivroRepository;

public class LivroService {

	private Livro livro;
	private LivroRepository livroRepository;
	
	public boolean cadastrarLivro(Livro livro) {
		if(livro.getId() <= 0) {
			System.out.println("Insira um ID válido.");
			return false;
		}
		
		
		
		
		
		return true;
	}
	
	public void removerLivroV() {
		
	}
	
	public void buscarLivroV() {
		
	}
	
	public void devolverLivro() {
		
	}
	
	public void emprestarLivro() {
		
	}
	
	public void listarLivroV() {
		
	}
	
}
