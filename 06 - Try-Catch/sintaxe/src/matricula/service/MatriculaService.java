package matricula.service;

import matricula.model.Matricula;
import matricula.repository.MatriculaRepository;

public class MatriculaService {

	private MatriculaRepository repositorio;
	
public MatriculaService(MatriculaRepository repositorio) {
	this.repositorio = repositorio;
}
	
	
	public boolean criarMatricula(Matricula matricula) {
	if(matricula.getId() <= 0) {
		throw new IllegalArgumentException("O ID deve ser válido.");
	}
	if(repositorio.buscarPorId(matricula.getId()) != null) {
		throw new IllegalArgumentException("O ID inserido já está em uso.");
	}
	repositorio.criarMatricula(matricula);
	return true;	
	}
	
	public Matricula buscarPorId(int id) {
		if(repositorio.buscarPorId(id) == null) {
			throw new IllegalArgumentException("Este ID é inválido.");
		}
		return repositorio.buscarPorId(id);
	}
	
	
}
