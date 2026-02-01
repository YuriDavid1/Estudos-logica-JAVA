		package matricula.view;
		import java.util.InputMismatchException;
import java.util.Scanner;
	
	import matricula.model.Aluno;
import matricula.model.Curso;
import matricula.model.EstadoCurso;
import matricula.model.Matricula;
import matricula.repository.AlunosRepository;
	import matricula.repository.CursosRepository;
	import matricula.repository.MatriculaRepository;
	import matricula.service.AlunoService;
	import matricula.service.CursosService;
	import matricula.service.MatriculaService;
		
		public class Menu {
		
			private AlunoService alunoService;
			private CursosService cursoService;
			private MatriculaService matriculaService;
			private Scanner ler = new Scanner(System.in);
			private int total = 0;
			
			public Menu() {
				AlunosRepository alunoRepositorio = new AlunosRepository();
				alunoService = new AlunoService(alunoRepositorio);
				CursosRepository cursosRepositorio = new CursosRepository();
				cursoService = new CursosService(cursosRepositorio);
				MatriculaRepository matriculaRepositorio = new MatriculaRepository();
				matriculaService = new MatriculaService(matriculaRepositorio, alunoRepositorio, cursosRepositorio);
			}
			
			public void exibirMenu() {
				int opcao = 0;
		
			do {
			System.out.println("==========BEM-VINDO==========");
			System.out.println("[1] Aluno");
			System.out.println("[2] Cursos");
			System.out.println("[3] Matricula");
			System.out.println("Insira uma das opções para acessar mais informações sobre.");
			opcao = ler.nextInt();
			ler.nextLine();
			
			switch(opcao) {
			case 1 -> System.out.println("[1] ");
	
			default -> System.out.println("Insira uma opção válida");
			}
			
			}while(opcao !=0);
		
			}
			
			public void menuAluno() {
				int opcaoAluno;
				do {
				System.out.println("[1] Cadastrar aluno");
				System.out.println("[2] Buscar aluno");
				System.out.println("[3] Remover aluno");
				System.out.println("[4] Listar todos os alunos");
				System.out.println("[0] Voltar");
				System.out.println("Insira a opção desejada:");
				opcaoAluno = ler.nextInt();
				ler.nextLine();
				
				switch(opcaoAluno) {
				case 1 -> {
					try {
				System.out.println("Insira o ID do aluno: ");
				int id = ler.nextInt();
				ler.nextLine();
				
				System.out.println("Insira o nome do aluno: ");
				String nome = ler.nextLine();
				
				System.out.println("Insira a idade do aluno: ");
				int idade = ler.nextInt();
				ler.nextLine();
				
				Aluno aluno = new Aluno (id, nome, idade);
				alunoService.cadastrarAluno(aluno);
				System.out.println("Aluno cadastrado com sucesso.");
				}catch(IllegalArgumentException e) {
					System.out.println("Erro: " +e.getMessage());
				}catch(Exception e) {
					System.out.println("Erro inesperado.");
					}
				}
				
				case 2 -> {
				    try {
				        System.out.println("Insira o nome do aluno:");
				        String nome = ler.nextLine();
				        Aluno aluno = alunoService.buscarPorNome(nome);
				        System.out.println("ID: " + aluno.getId());
				        System.out.println("Nome: " + aluno.getNome());
				        System.out.println("Idade: " + aluno.getIdade());

				        try {
				            Matricula matricula = matriculaService.buscarPorAlunoId(aluno.getId());
				            Curso curso = matricula.getCurso();
				            System.out.println("Cursando: " + curso.getNome());
				        } catch (IllegalArgumentException e) {
				            System.out.println("Cursando: nenhum curso");
				        }
				    } catch (IllegalArgumentException e) {
				        System.out.println("Erro: " + e.getMessage());
				    } catch (Exception e) {
				        System.out.println("Erro inesperado.");
				    }
				}

				case 3 ->{
					try {
						System.out.println("Insira o nome do aluno:");
						String nome = ler.nextLine();
						Aluno aluno = alunoService.buscarPorNome(nome);
						alunoService.removerAluno(aluno.getId());
						System.out.println("Aluno removido com êxito.");
					}catch(IllegalArgumentException e){
						System.out.println("Erro: " + e.getMessage());
						}catch(Exception e) {
						System.out.println("Erro inesperado.");
						}
					}
				
				case 4 ->{
				for(Aluno aluno: alunoService.listarTodos().values()) {
					System.out.println("Nome: " +  aluno.getNome() + 
							           "Idade: " + aluno.getIdade());
					total++;
				}
				System.out.println("Quantidade total de alunos: " + total);
					}
				}
				}while(opcaoAluno != 0);
			}
			
			public void menuCurso() {
				int opcaoCurso;
				do {
				System.out.println("[1] Cadastrar curso");
				System.out.println("[2] Buscar curso");
				System.out.println("[3] Remover curso");
				System.out.println("[4] Listar todos os cursos");
				System.out.println("[5] Alterar estado do curso");
				System.out.println("[0] Voltar");
				System.out.println("Insira a opção desejada:");
				opcaoCurso = ler.nextInt();
				ler.nextLine();
				
				switch(opcaoCurso) {
				case 1 -> 	{
				try {
					System.out.println("Insira o ID do curso: ");
					int id = ler.nextInt();
					ler.nextLine();
					
					System.out.println("Insira o nome do curso: ");
					String nome = ler.nextLine();
					
					System.out.println("Insira a carga horaria: ");
					int cargaHoraria = ler.nextInt();
					ler.nextLine();
					Curso curso = new Curso(id, nome, cargaHoraria);
					
					System.out.println("Curso criado com êxito.");
					cursoService.criarCurso(curso);
				}catch(IllegalArgumentException e ) {
					System.out.println("Erro: " + e.getMessage());
				}catch(Exception e) {
					System.out.println("Erro inesperado.");
					}
				}
				case 2 -> 	{
					try {
					System.out.println("Insira o nome do curso que deseja buscar: ");
					String nome = ler.nextLine();
					cursoService.buscarPorNome(nome);
					Curso curso = cursoService.buscarPorNome(nome);
					System.out.println("Curso: " + curso.getNome() +
									   "Carga horaria: " + curso.getCargaHoraria() +
									   "Estado: " + curso.getEstado());
					}catch(IllegalArgumentException e) {
						System.out.println("Erro: " + e.getMessage());
					}catch(Exception e) {
						System.out.println("Erro inesperado");
						}
					}
				case 3 ->	{
					try{
					System.out.println("Insira o nome do curso que deseja remover: ");
					String nome = ler.nextLine();
					Curso curso = cursoService.buscarPorNome(nome);
					cursoService.removerCurso(curso.getId());
					System.out.println("Curso removido com êxito.");
					}catch(IllegalArgumentException e ) {
						System.out.println("Erro: " + e.getMessage());
					}catch(Exception e) {
						System.out.println("Erro inesperado.");
					}
				}
				case 4 ->	{
				for(Curso curso : cursoService.listarCursos().values()) {
					System.out.println("Nome: " + curso.getNome() + 
							           "Carga horaria: " + curso.getCargaHoraria() + 
							           "Estado: " + curso.getCargaHoraria());
					
				}
				}
				case 5 -> {
					System.out.println("Insira o curso que deseja alterar: ");
					String nome = ler.nextLine();
					Curso curso = cursoService.buscarPorNome(nome);
					System.out.println("Estado atual do curso: " + curso.getEstado());
					System.out.println("[1] Ativo");
					System.out.println("[2] Inativo");
					System.out.println("[3] Cancelado");
					System.out.println("Insira para a opção que deseja alterar o curso: ");
					int opcao = ler.nextInt();
					ler.nextLine();
					switch(opcao) {
					case 1 -> {
					EstadoCurso estado = EstadoCurso.ATIVO;
					curso.setEstado(estado);
					}
					case 2 ->{
						EstadoCurso estado = EstadoCurso.INATIVO;
						curso.setEstado(estado);
					}
					case 3 ->{
						EstadoCurso estado = EstadoCurso.CANCELADO;
						curso.setEstado(estado);
					}
					default ->{
						System.out.println("Erro. Opção invalida.");
					}
					}
				}
				
				case 0 ->{
					return;
				}
				
				default ->{
					System.out.println("Opção invalida.");
					}
				}
					}while(opcaoCurso != 0);
			}
			
			public void menuMatricula() {
				int opcaoMatricula;
				do {
				System.out.println("[1] Matricular aluno");
				System.out.println("[2] Buscar matricula");
				System.out.println("[3] Remover curso");
				System.out.println("[4] Listar todos os cursos");
				System.out.println("[5] Alterar estado do curso");
				System.out.println("[0] Voltar");
				System.out.println("Insira a opção desejada:");
				opcaoMatricula = ler.nextInt();
				ler.nextLine();		
				
				switch(opcaoMatricula) {
				case 1 ->{
					System.out.println("Insira o nome do aluno que deseja matricular");
					String nomeAluno = ler.nextLine();
					Aluno aluno = alunoService.buscarPorNome(nomeAluno);
					System.out.println("Insira o nome do curso: ");
					String nomeCurso = ler.nextLine();
					Curso curso = cursoService.buscarPorNome(nomeCurso);
					System.out.println("Insira o número de matricula que deseja registrar ao aluno: ");
					int idMatricula = ler.nextInt();
					matriculaService.criarMatricula(idMatricula, aluno.getId(), curso.getId());
					System.out.println("Matricula realizada com sucesso.");
					
					}
				
				case 2 ->{
					System.out.println("Insira o nome do aluno que deseja buscar a mátricula: ");
					String nome = ler.nextLine();
					Matricula matricula = matriculaService.buscarPorAluno(nome);
					System.out.println("Curso: " + matricula.getCurso() + 
							           "Número de mátricula:" + matricula.getId());
					 
					}
				}
				
				}while(opcaoMatricula != 0);
			}
}