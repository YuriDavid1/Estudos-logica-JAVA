package jogos.model;
import java.util.List;
import java.util.ArrayList;

public class Usuario {

	int id;
	String nome;
	List<Emprestimo> historico;
	
	public Usuario (int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.historico = new ArrayList<>();
	}
	
	   public int getId() {
	        return id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public List<Emprestimo> getHistorico() {
	        return historico;
	    }

	    public void adicionarEmprestimo(Emprestimo emprestimo) {
	        historico.add(emprestimo);
	    }
	    
	    public void cancelarEmprestimo(Emprestimo emprestimo) {
	    	historico.remove(emprestimo);
	    }
	    
	    
	}

