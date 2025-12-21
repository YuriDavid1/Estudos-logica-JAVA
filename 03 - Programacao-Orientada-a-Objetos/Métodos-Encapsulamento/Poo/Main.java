package Poo;

public class Main {
	
	public static void main(String[]args) {
		
		Carro PrimeiroCarro = new Carro("Fusca", 1980, 15_000.00);
		Carro SegundoCarro = new Carro("Ferrari", 2023, 1_900_000.00);
		
		
		//Método Set
		//PrimeiroCarro.setPreco(15_000.00);
		//SegundoCarro.setPreco(1_900_000.00);
		
		
	PrimeiroCarro.Informacoes();
	SegundoCarro.Informacoes();
		
	}

}
