package todolist.repository;
import java.util.HashMap;

import todolist.model.*;

public class TarefaRepository {
	
	HashMap<Integer, Tarefa> tarefasHash = new HashMap<>();
	
	
	//Função salvar Tarefa
	public void salvarTarefa(Tarefa tarefa) {
		tarefasHash.put(tarefa.getId() ,tarefa);
	}
	
	//Função buscar tarefa por ID
	public Tarefa buscarTarefa(int id) {
		return tarefasHash.get(id);
	}
	
	
	// Função remover por ID
	public void removerTarefa(int id) {
		tarefasHash.remove(id);
	}
	
	//Função listar Todas tarefa
	public HashMap<Integer, Tarefa> listarTarefas(){
		return tarefasHash;
	}
	
}
