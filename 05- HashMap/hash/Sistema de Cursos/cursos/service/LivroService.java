package sistema.service;
import sistema.model.EstadoLivro;
import sistema.model.Livro;
import java.util.HashMap;

import sistema.repository.LivroRepository;

public class LivroService {
	private final LivroRepository repositorio;
	
	public LivroService(LivroRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	public boolean cadastrarLivro(Livro livro) {
		if(livro.getId() <= 0) {
			System.out.println("Insira um ID válido.");
			return false;
		}
		
		if(repositorio.buscarLivro(livro.getId()) != null){
			System.out.println("ID de livro já cadastrado.");
			return false;
		}
		
		if(livro.getAutor() == null || livro.getAutor().isEmpty()) {
			System.out.println("É obrigatório ter um autor.");
		return false;
		}
		
		if(livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
			System.out.println("É obrigatório ter um titulo.");
		return false;
		}
		System.out.println("Livro cadastrado.");
		repositorio.salvarLivro(livro);
		return true;
	}
	
	public boolean removerLivro(int id) {
		if(repositorio.buscarLivro(id) == null) {
			System.out.println("Livro não encontrado para este ID.");
			return false;
		}
		
		System.out.println("Livro removido com êxito.");
		repositorio.removerLivro(id);
		return true;
	}
	
	public Livro buscarLivro(int id) {
		return repositorio.buscarLivro(id);
	}

	
	public boolean emprestarLivro(int id) {
		Livro livro = repositorio.buscarLivro(id);
		if(livro == null) {
			System.out.println("Livro não encontrado para este ID.");
		return false;
		}
		if(livro.getEstado() == EstadoLivro.EMPRESTADO) {
			System.out.println("Livro já emprestado.");
			return false;
		}
		System.out.println("Livro emprestado.");
		livro.SetEstado(EstadoLivro.EMPRESTADO);
		return true;
	}
	
	public boolean devolverLivro(int id) {
		Livro livro = repositorio.buscarLivro(id);
		if(livro == null) {
			System.out.println("Livro não encontrado para este ID.");
			return false;
		}
		if(livro.getEstado() == EstadoLivro.DISPONIVEL) {
			System.out.println("Este livro não esta emprestado.");
			return false;
		}
		System.out.println("Livro devolvido.");
		livro.SetEstado(EstadoLivro.DISPONIVEL);
		return true;
	}
	

	
	public HashMap<Integer,Livro> listarLivro() {
		return repositorio.listarLivros();
		
	}
	
}
