package br.com.marcos.ProjetoTeste.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Year;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("Year") String anoTotal,
                         @JsonAlias("Genre") String genero,
                         @JsonAlias("Plot") String sinopse,
                         @JsonAlias("Poster") String poster,
                         @JsonAlias("totalSeasons") Integer totalDeTemporada,
                         @JsonAlias("imdbRating") String avaliacao,
                         @JsonAlias("imdbVotes") String quantidadeVotas,
                         @JsonAlias("Actors") String atores){
}
