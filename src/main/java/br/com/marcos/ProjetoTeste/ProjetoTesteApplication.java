package br.com.marcos.ProjetoTeste;

import br.com.marcos.ProjetoTeste.Principal.Principal;
import br.com.marcos.ProjetoTeste.Repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoTesteApplication implements CommandLineRunner {
	@Autowired
	private SerieRepository repositorio;
	public static void main(String[] args) {
		SpringApplication.run(ProjetoTesteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var principal = new Principal(repositorio);
		principal.exibeMenu();

	}
}