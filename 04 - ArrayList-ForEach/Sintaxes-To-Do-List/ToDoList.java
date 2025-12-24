package ArrayForEach;
import java.util.ArrayList;

public class ToDoList {
	
	public static void main(String[]args) {
	//SINTAXE CRIAÇÃO 
	ArrayList<String> minhasTarefas = new ArrayList<>();
	
	//ADICIONAR VALOR AO ARRAY
	minhasTarefas.add("Estudar Java");
	minhasTarefas.add("Fazer Exercícios");
	minhasTarefas.add("Pausa");
	
	//REMOVER VALOR DO ARRAY
	minhasTarefas.remove(2);
	
	//ALTERAR VALOR DE UM ARRAY
	minhasTarefas.set(0, "Estudar ArrayList");
	
	//VERIFICAR TAMANHO DO ARRAY
		System.out.println("Total de Tarefas Pendentes: " + minhasTarefas.size());
		
	//SINTAXE DO FOR EACH
		
		for(String tarefa: minhasTarefas) {
			System.out.println(tarefa);
		}
	}
}
