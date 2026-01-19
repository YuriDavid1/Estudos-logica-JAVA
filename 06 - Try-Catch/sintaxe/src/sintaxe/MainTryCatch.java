package sintaxe;
import java.util.Scanner;

public class MainTryCatch {

	static Scanner ler = new Scanner(System.in);
	
	public static void main(String[]args) {
		
		
		
		int num = 0;
		
			try {
			System.out.println("Insira um número que deseja dividir por 100.");
			num = ler.nextInt();
			int divisao = 100/num;
			System.out.println("O resultado da divisão é de: " +divisao);
		
			}catch(ArithmeticException e) {
			System.out.println("Erro: divisão por 0 é invalido.");
		}catch(java.util.InputMismatchException e) {
			System.out.println("Erro: digite apenas numeros inteiros.");	
		}finally {
			System.out.println("Programa finalizado.");
		}
	}
}