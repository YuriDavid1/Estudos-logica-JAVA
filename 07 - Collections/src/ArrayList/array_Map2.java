package ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class array_Map2 {
	public static void main(String[]args) {

	List<String> TurmaA = new ArrayList<>();
	List<String> TurmaB = new ArrayList<>();
	Map<String, List<String>> turma = new HashMap<>();
	
	TurmaA.add("Yuri");
	TurmaA.add("Maria");
	TurmaA.add("João");
	
	TurmaB.add("Luiz");
	TurmaB.add("Julia");
	TurmaB.add("Gabriel");
	
	turma.put("Turma A", TurmaA);
	turma.put("Turma B", TurmaB);
	
	List<String> listaA = turma.get("Turma A");
	
	for(String nomes : listaA) {
		System.out.println(nomes);
	}
	
	List<String> listaB = turma.get("Turma B");
	
	for(String nome : listaB) {
		System.out.println(nome);
	}
}

	
}
