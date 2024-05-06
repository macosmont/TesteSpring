package br.com.marcos.ProjetoTeste.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalDeTemporada,
                         @JsonAlias("imdbRating") String avaliacao,
                         @JsonAlias("imdbVotes") String quantidadeVotas){
}
