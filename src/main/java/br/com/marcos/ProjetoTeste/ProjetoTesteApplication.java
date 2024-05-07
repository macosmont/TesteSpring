package br.com.marcos.ProjetoTeste;

import br.com.marcos.ProjetoTeste.Model.DadosEpisodios;
import br.com.marcos.ProjetoTeste.Model.DadosSerie;
import br.com.marcos.ProjetoTeste.Model.DadosTemporadas;
import br.com.marcos.ProjetoTeste.Principal.Principal;
import br.com.marcos.ProjetoTeste.Servicos.ConsumoApi;
import br.com.marcos.ProjetoTeste.Servicos.ConverteDados;
import com.sun.tools.javac.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProjetoTesteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTesteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();

	}
}
