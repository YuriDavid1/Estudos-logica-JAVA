package jogos.view;

import jogos.repository.*;
import jogos.service.*;

public class Main {

    public static void main(String[] args) {

        JogoRepository jogoRepository = new JogoRepository();
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        EmprestimoRepository emprestimoRepository = new EmprestimoRepository();

        JogoService jogoService = new JogoService(jogoRepository);
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        EmprestimoService emprestimoService = new EmprestimoService(emprestimoRepository, usuarioService, jogoService);
        
        Menu menu = new Menu(emprestimoService, usuarioService, jogoService);
        menu.menuGeral();
    }
}