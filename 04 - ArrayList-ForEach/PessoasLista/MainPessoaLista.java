package Poo2;
import java.util.Scanner;
import java.util.ArrayList;

public class MainPessoaLista {

	static Scanner ler = new Scanner(System.in);
	static ArrayList<Pessoa> lista = new ArrayList<>();
	
	public static void main(String[]args) {
	int salvar;
	
		System.out.println("Quantas pessoas vão ser cadastradas?");
		salvar = ler.nextInt(); 
		ler.nextLine();
	
	for(int i = 0; i < salvar; i++) {
		System.out.println("Insira o nome:");
		String nomeI = ler.nextLine();
		
		System.out.println("Insira a idade:");
		int idadeI = ler.nextInt();
		ler.nextLine();
		
		Pessoa pessoa = new Pessoa(nomeI, idadeI);
		lista.add(pessoa);
	}
	//Listar todas as pessoas cadastradas
	System.out.println("====== Pessoas Cadastradas ======");
	for(int i = 0; i < lista.size(); i++) {
		lista.get(i).apresentar();
		}
	}
}
