package aprendizados;

import java.util.Scanner;

public class scanner {
	
	public  static void main (String[]args) {
		
		Scanner detectar = new Scanner(System.in);
		
		//Obter nome do usuário
		System.out.println("Qual é o  seu nome?");
		String nome = detectar.next();
		
		//Obter idade do usuário
		System.out.println("Qual é a sua idade?");
		int idade = detectar.nextInt();
		
		//Obter email do usuário
		System.out.println("Qual o seu endereço de email:");
		String email = detectar.next();
		
		//Saber se ele é empregado BOOL
		//System.out.println("Você já trabalha na área? (True/False)");
		//boolean trabalha = detectar.nextBoolean();
		
		//Saber se ele é empregado String
		System.out.println("Você já trabalha na área?(Sim/Não)");
		String trabalhaB = detectar.next().toLowerCase();
		
		//Concatenação para boolean
		//System.out.println("Seu nome é " + nome + " Você tem " + idade + " com o email: " + email + " e voce " + (trabalha ? "já trabalha":"ainda não") + " na area");
		
		
		//Concatenação para string
				System.out.println("Seu nome é " + nome + " Você tem " + idade + " com o email: " + email + " e voce " + trabalhaB + " trabalha na area");

		detectar.close();
	}

}
