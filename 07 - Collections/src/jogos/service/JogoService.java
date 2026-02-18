package jogos.service;
import java.util.List;

import jogos.model.Jogo;
import jogos.repository.JogoRepository;

public class JogoService {
	
	JogoRepository repositorio;
	
	public JogoService(JogoRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	public void registrarJogo(Jogo jogo) {
		if(jogo.getId() <= 0) {
			throw new IllegalArgumentException("Insira um número válido");
		}
		
		if(repositorio.buscarPorId(jogo.getId()) != null) {
			throw new IllegalArgumentException("Número de jogo já cadastrado.");
		}
		
		if(jogo.getNome() == null || jogo.getNome().isEmpty()) {
			throw new IllegalArgumentException("Erro: o nome do jogo não pode se vázio");
		}
		if(repositorio.buscarPorNome(jogo.getNome()) != null) {
			throw new IllegalArgumentException("Este jogo já esta registrado");
		}
		repositorio.registrarJogo(jogo);
		}
		
		public void removerJogo(String nome) {
			Jogo jogo = repositorio.buscarPorNome(nome);
			if(jogo == null) {
				throw new IllegalArgumentException("Jogo não encontrado para remoção.");
			}
			
			repositorio.removerJogo(jogo.getId());
		}
		
		public Jogo buscarPorId(int id) {
		Jogo jogo = repositorio.buscarPorId(id);
		if(jogo == null) {
			throw new IllegalArgumentException("Id inserido não registrado.");
		}
		return jogo;
		}
		
		public Jogo buscarUsuNome(String nome) {
		Jogo jogo = repositorio.buscarPorNome(nome);
			if(jogo == null) {
				throw new IllegalArgumentException("Jogo não encontrado");
			}
			return jogo;
		}
		
		public List<Jogo> listarJogos() {
		List<Jogo> jogos = repositorio.listarJogos();
		if(jogos == null) {
			throw new IllegalArgumentException("Nenhum jogo registrado.");
		}
		return jogos;
	}
		
}
