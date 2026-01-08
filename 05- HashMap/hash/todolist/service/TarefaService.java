package todolist.service;
import java.util.HashMap;

import todolist.model.Tarefa;
import todolist.repository.TarefaRepository;

public class TarefaService {

	private TarefaRepository repositorio;
	private Tarefa tarefa;
	
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
	//Listar
	public HashMap<Integer, Tarefa> listarTodos() {
		return repositorio.listarTarefas();
	}
	
	//Marcar como concluido
	public boolean tarefaConcluida(int id) {
		Tarefa tarefa = repositorio.buscarTarefa(id);
		if(tarefa == null) {
		System.out.println("Erro, tarefa com ID invalido");
		return false;
		}else if (tarefa.getEstado() == true) {
			System.out.println("Tarefa já concluida.");
			return false;
		}else {
			System.out.println("Tarefa concluida com sucesso.");
			tarefa.setEstado(true);
			return true;
		}
		
	}
	
}