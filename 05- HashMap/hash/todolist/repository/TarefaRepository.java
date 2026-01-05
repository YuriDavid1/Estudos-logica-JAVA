package todolist.repository;
import java.util.HashMap;

import todolist.model.*;

public class TarefaRepository {
	
	HashMap<Integer, Tarefa> tarefaHash = new HashMap<>();
	
	
	//Função salvar Tarefa
	public void salvarTarefa(Tarefa tarefa) {
		tarefaHash.put(tarefa.getID(), tarefa);
	}
	
	//Função buscar tarefa por ID
	public Tarefa buscarporID (int id) {
		return tarefaHash.get(id);
	}

	// Função remover por ID
	public void removerporId(int id) {
		tarefaHash.remove(id);
	}
	
	//Função listar Todas tarefa
	public HashMap<Integer, Tarefa>  listarTodos(){
		return tarefaHash;
	}
    
}
