package br.com.marcos.ProjetoTeste;

import br.com.marcos.ProjetoTeste.Model.DadosSerie;
import br.com.marcos.ProjetoTeste.Servicos.ConsumoApi;
import br.com.marcos.ProjetoTeste.Servicos.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoTesteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTesteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=Friends&apikey=d11e9a7b");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
