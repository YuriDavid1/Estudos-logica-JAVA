package hash;
import java.util.HashMap;

public class Main {

	public static void main(String[]args) {

		HashMap<String, Double> estoque = new HashMap<>();
		
		//Adicionar
		estoque.put("Playstation 5", 4000.00);
		estoque.put("Xbox Series S", 3800.00);
		estoque.put("Nintendo Switch", 2000.00);
		
		//Consultar
		System.out.println("O Playstation 5 custa R$" + estoque.get("Playstation 5"));

		//Verificar
		System.out.println("Tem computador? " + estoque.containsKey("Computador"));
		
		//Atualizar
		System.out.println("Promoção no Nintendo Switch!    R$" + estoque.put("Nintendo Switch", 1800.00));
		
		//Listar tudo
		System.out.println("Itens no estoque: " + estoque);
		
		//Remover
		estoque.remove("Xbox Series S");
		//Teste do remover
		System.out.println("Itens no estoque" + estoque);
	
	}
	
}
