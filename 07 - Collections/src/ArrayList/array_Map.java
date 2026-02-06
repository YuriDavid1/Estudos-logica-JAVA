package ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class array_Map {

	 public static void main(String[] args) {

	        Map<String, List<String>> pedidosCliente = new HashMap<>();
	        adicionarPedido(pedidosCliente, "Yuri", "Pizza");
	        adicionarPedido(pedidosCliente, "Yuri", "Refrigerante");
	        adicionarPedido(pedidosCliente, "Maria", "Hamburguer");

	        for (String cliente : pedidosCliente.keySet()) {
	            System.out.println("Cliente: " + cliente);
	            List<String> pedidos = pedidosCliente.get(cliente);
	            for (String pedido : pedidos) {
	                System.out.println("- " + pedido);
	            }
	        }
	    }

	    private static void adicionarPedido(
	            Map<String, List<String>> mapa,
	            String cliente,
	            String pedido
	    ) {
	        mapa.putIfAbsent(cliente, new ArrayList<>());
	        mapa.get(cliente).add(pedido);
	    }
}