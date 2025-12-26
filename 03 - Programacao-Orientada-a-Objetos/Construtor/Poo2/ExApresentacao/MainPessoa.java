package Poo2;
import java.util.Scanner;

public class MainPessoa {
static Scanner ler = new Scanner(System.in);

	
	public static void main(String[]args) {
		String nome;
		int idade;
		String decisao;
		System.out.println("Digite seu Nome:");
		nome = ler.nextLine();
		System.out.println("Quantos anos você tem?");
		idade = ler.nextInt();
		ler.nextLine();
		
		Pessoa pessoa = new Pessoa(nome, idade);
		
		System.out.println("Deseja se apresentar? (S/N)");
		decisao = ler.nextLine();
		if(decisao.equalsIgnoreCase("S") || decisao.equalsIgnoreCase("Sim") ) {
			pessoa.apresentar();
		}else if(decisao.equalsIgnoreCase("N") || decisao.equalsIgnoreCase("Nao")){
		}else {
			System.out.println("Insira uma opção valida. (S/N)");
		}
			System.out.println("Deseja fazer aniversário?(S/N)");
			decisao = ler.nextLine();
					if(decisao.equalsIgnoreCase("N") || decisao.equalsIgnoreCase("Nao")) {
						System.out.println("Adeus");
					}else if(decisao.equalsIgnoreCase("Sim") || decisao.equalsIgnoreCase("S")) {
			pessoa.FazerAniversario();
			pessoa.apresentar();
					}else {
						System.out.println("Insira uma opção valida. (S/N)");
					}
		
		}
	
	}