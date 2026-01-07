package todolist.service;
import todolist.model.Tarefa;
import todolist.repository.TarefaRepository;

public class TarefaService {

	private TarefaRepository repositorio;
	
	public TarefaService(TarefaRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	public boolean salvarTarefa(Tarefa tarefa) {
		
		//VALIDAR ID
		if(tarefa.getId() <= 0) {
			System.out.println("Número de tarefa invalido.");
		return false;
		}
		
		//Verificar se ID já existe
		if(repositorio.buscarTarefa(tarefa.getId()) != null) {
			System.out.println("Já existe uma tarefa nessa posição.");
		return false;
		}
		
		//Validar descrição
		if(tarefa.getDescricao() == null || tarefa.getDescricao().isEmpty()) {
			System.out.println("A descrição não pode ser vazia.");
			return false;
		}
		repositorio.salvarTarefa(tarefa);
		return true;
		
	}
	//Buscar tarefa por id
	public Tarefa buscarTarefaID(int id) {
		return repositorio.buscarTarefa(id);
	}
	
	//Remover tarefa por id
	public boolean removerTarefaVerifi(int id) {
		if(repositorio.buscarTarefa(id) == null) {
			System.out.println("Tarefa não existente com esse ID.");
			return false;
		}
		
		repositorio.removerTarefa(id);
		return true;
	}
	
}
