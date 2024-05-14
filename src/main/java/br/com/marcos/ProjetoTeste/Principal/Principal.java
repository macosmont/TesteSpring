package br.com.marcos.ProjetoTeste.Principal;


import br.com.marcos.ProjetoTeste.Model.DadosEpisodios;
import br.com.marcos.ProjetoTeste.Model.DadosSerie;
import br.com.marcos.ProjetoTeste.Model.DadosTemporadas;
import br.com.marcos.ProjetoTeste.Model.Episodios;
import br.com.marcos.ProjetoTeste.Servicos.ConsumoApi;
import br.com.marcos.ProjetoTeste.Servicos.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner ler = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=d11e9a7b";
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu(){

        var menu = """
                1 - Buscar Série
                2 - Buscar Episodios
                
                0 - Sair
                """;
        System.out.println(menu);
        var opcao = ler.nextLine();
       /* switch (opcao){
            case 1:
        }*/


        System.out.println("Para a busca, digite o nome de série");
        var nomeSerie = ler.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);
        System.out.println("-------------------------------------------------------------------------------------------------");
        DadosEpisodios dadosEp = conversor.obterDados(json, DadosEpisodios.class);
        List<DadosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i<=dados.totalDeTemporada(); i++){
            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") +"&season=" + i + API_KEY);
            DadosTemporadas dadosTemporada = conversor.obterDados(json,DadosTemporadas.class);
            temporadas.add(dadosTemporada);
        }
        //temporadas.forEach(System.out::println);
        //temporadas.forEach(t -> t.episodios().forEach(e-> System.out.println(e.titulo())));
        List<DadosEpisodios> dadosEpisodios = temporadas.stream()
                .flatMap(t-> t.episodios().stream())
                .collect(Collectors.toList());

        dadosEpisodios.stream()
                .filter(e -> !e.avalicao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodios::avalicao).reversed())
                .limit(5);
                //.forEach(System.out::println);

        List<Episodios> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodios(t.temporada(), d))
                ).collect(Collectors.toList());
        episodios.forEach(System.out::println);

        System.out.println("Digite...");
        var trechoTitulo = ler.nextLine();
        Optional<Episodios> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
                .findFirst();
        if (episodioBuscado.isPresent()){
            System.out.println(episodioBuscado.get().getTemporada());
        } else {
            System.out.println("Deu ruim");
        }

    Map<Integer, Double> avaliacoesTemporada = episodios.stream()
            .filter(e-> e.getAvalicao()>0.0)
            .collect(Collectors.groupingBy(Episodios::getTemporada, Collectors.averagingDouble(Episodios::getAvalicao)));
        System.out.println(avaliacoesTemporada);

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e-> e.getAvalicao()>0.0)
                .collect(Collectors.summarizingDouble(Episodios::getAvalicao));
        System.out.println("Media da serie " + est.getAverage() +
                " Melhor Ep " + est.getMax() +
               " Pior Ep " + est.getMin());
    }
}
