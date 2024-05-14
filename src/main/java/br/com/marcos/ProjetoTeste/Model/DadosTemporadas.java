package br.com.marcos.ProjetoTeste.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporadas(@JsonAlias("Season") Integer temporada,
                              @JsonAlias("Episodes") List<DadosEpisodios> episodios) {

}
