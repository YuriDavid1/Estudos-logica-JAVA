package sintaxes;
import java.util.HashMap;
import java.util.Map;


public class map {

	public static void main (String[]args) {
		
		Map <Integer, String> pessoas = new HashMap<>();
		
		//Adicionar
		pessoas.put(1, "Yuri");
		pessoas.put(2, "João");
		pessoas.put(10, "Maria");
		
		//Buscar pelo ID
		int idBusca = 1;
		System.out.println(pessoas.get(idBusca));
		
		//Buscar todos da lista
		System.out.println("Lista de pessoas");
		for(Integer a : pessoas.keySet()) {
			System.out.println("ID: " + a + "Nome:" +  pessoas.get(a));
		}
		
		
	//remover
		pessoas.remove(2);
		
		System.out.println("Lista de pessoas");
		for(Integer a : pessoas.keySet()) {
			System.out.println("ID: " + a + "Nome:" +  pessoas.get(a));
		
		}	
	}
	
}
