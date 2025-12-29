package Poo2;
import java.util.ArrayList;


public class BancoService {

	private ArrayList<ContaBancaria> contas = new ArrayList<>();
	
	public void cadastrarConta(String titular) {
		ContaBancaria pessoa = new ContaBancaria(titular);
		contas.add(pessoa);
		int id = contas.size() -1;
		System.out.println("Numero da conta: " + id);

	}
	
	public void listarContas() {
		System.out.println("========== LISTA DE CONTAS ==========");
		System.out.println("ID  |  Titular  |  Saldo");
		for(int i = 0; i<contas.size(); i++) {
			ContaBancaria conta = contas.get(i);
	        System.out.println(i + "   |  " + conta.getTitular() + "  |  R$" + conta.getSaldo());
		}

	}
	
	public void depositarConta(int id, double valor) {
		if(id >= 0 && id < contas.size()) {
			contas.get(id).depositar(valor);					
			
		}else {
			System.out.println("Insira um ID de conta válido.");
		}	
		
	}
	
	public void sacarConta(int id, double saque) {
		if(id >=0 && id < contas.size()) {
			contas.get(id).sacar(saque);
		}else {
			System.out.println("Insira um ID de conta válido.");
		}

	}
	
	
}
