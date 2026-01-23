package matricula.model;

public class Matricula {
	
	
	private final int id;
	private final Curso curso;
	private final Aluno aluno;
	
	public Matricula(int id, Aluno aluno, Curso curso) {
		this.id = id;
		this.aluno = aluno;
		this.curso = curso;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public Aluno getAluno() {
		return aluno;
	}
	
	public int getId() {
		return id;
	}
}
