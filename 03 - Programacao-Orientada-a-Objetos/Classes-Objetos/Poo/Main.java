package Poo;

public class Main {
	
	public static void main(String[]args) {
		
		Carro PrimeiroCarro = new Carro();
		Carro SegundoCarro = new Carro();
		
		
		PrimeiroCarro.modelo = "Fusca";
		PrimeiroCarro.ano = 1980;
		PrimeiroCarro.preco = 15_000.00;
		
		SegundoCarro.modelo = "Ferrari";
		SegundoCarro.ano = 2023;
		SegundoCarro.preco = 1_900_000.00;
		
	PrimeiroCarro.Informacoes();
	SegundoCarro.Informacoes();
		
	}

}
