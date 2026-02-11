package jogos.service;
import jogos.model.Jogo;
import jogos.repository.JogoRepository;

public class JogoService {
/*Regras obrigatórias:
Não permitir ID duplicado
Não permitir nome vazio
Não permitir cadastrar jogo com mesmo nome
*/
	
	JogoRepository repositorio;
	
	public JogoService(JogoRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	public boolean registrarJogo(Jogo jogo) {
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
		return true;
		}
		
		public boolean removerJogo(String nome) {
			Jogo jogo = repositorio.buscarPorNome(nome);
			if(jogo == null) {
				throw new IllegalArgumentException("Jogo não encontrado para remoção.");
			}
			
			repositorio.removerJogo(jogo.getId());
			return true;
		}
	
		
		
		public boolean buscarPorId(int id) {
		Jogo jogo = repositorio.buscarPorId(id);
		if(jogo == null) {
			throw new IllegalArgumentException("Id inserido não registrado.");
		}
		repositorio.buscarPorId(id);
		return true;
		}
		
		public boolean buscarUsuNome(String nome) {
		Jogo jogo = repositorio.buscarPorNome(nome);
			if(jogo == null) {
				throw new IllegalArgumentException("Jogo não encontrado");
			}
			repositorio.buscarPorNome(nome);
			return true;
		}
		
	}
