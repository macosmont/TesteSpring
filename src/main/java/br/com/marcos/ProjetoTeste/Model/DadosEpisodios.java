package br.com.marcos.ProjetoTeste.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodios(@JsonAlias("Title") String titulo,
                             @JsonAlias("Released") String dataLancemento,
                             @JsonAlias("imdbRating") String avalicao,
                             @JsonAlias("imdbVotes") Integer quantidadeDeVotos) {
}
