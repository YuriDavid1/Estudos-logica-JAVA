package aprendizados;

import java.util.Scanner;

public class DesafioWhile_Switch {

	public static void main(String[]args) {
		
		Scanner leitura = new Scanner(System.in);
		
		int caso = 0;
		int horas = 0;
		int minutos = 0;
		
			while(caso != 3) {
			System.out.println("=============MENU==============");
			System.out.println("[1]Converter minutos em horas");
			System.out.println("[2]Converter horas para minutos");
			System.out.println("[3]Sair");
			System.out.println("===============================");
			
			caso = leitura.nextInt();
			leitura.nextLine();
			
			switch(caso) {
			case 1: 
				System.out.println("Digite a quantidade de minutos que você deseja converter para horas:");
				minutos = leitura.nextInt();
				System.out.println(minutos + " Minutos convertidos para horas da o equivalente de: \n" + minutos/60 + "Horas");
				break;
			
			case 2: 
				System.out.println("Digitie a quantidade de horas que você deseja converter para minutos:");
				horas = leitura.nextInt();
				System.out.println(horas + " Horas convertidos para minutos da o equivalente de: \n" + horas*60 + "Minutos");
				break;
			case 3:
				break;
				default: 
					System.out.println("Selecione uma opção valida. (1 A 3)");
					break;
				}
			}
		}
	}
