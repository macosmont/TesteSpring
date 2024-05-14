package br.com.marcos.ProjetoTeste.Model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodios {
    private Integer temporada;
    private String titulo;
    private Integer numeroEp;
    private LocalDate dataLancemento;
    private Double avalicao;

    public Episodios(Integer numerotemporada, DadosEpisodios dadosEpisodios) {
        this.temporada = numerotemporada;
        this.titulo = dadosEpisodios.titulo();
        this.numeroEp = dadosEpisodios.numero();
        try {
            this.avalicao = Double.valueOf(dadosEpisodios.avalicao());
        } catch (NumberFormatException ex) {
            this.avalicao = 0.0;
        }
        try {
            this.dataLancemento = LocalDate.parse(dadosEpisodios.dataLancemento());
        } catch (DateTimeParseException ex) {
            this.dataLancemento = null;
        }
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTemporada() {
        return temporada;
    }
    public void setTemporada(String temporada) {
        this.temporada = Integer.valueOf(temporada);
    }

    public Integer getNumeroEp() {
        return numeroEp;
    }
    public void setNumeroEp(Integer numeroEp) {
        this.numeroEp = numeroEp;
    }

    public LocalDate getDataLancemento() {
        return dataLancemento;
    }
    public void setDataLancemento(LocalDate dataLancemento) {
        this.dataLancemento = dataLancemento;
    }

    public Double getAvalicao() {
        return avalicao;
    }
    public void setAvalicao(Double avalicao) {
        this.avalicao = avalicao;
    }

    @Override
    public String toString() {
        return "temporada= " + temporada +
                ", titulo= " + titulo + '\'' +
                ", numeroEp=" + numeroEp +
                ", dataLancemento=" + dataLancemento +
                ", avalicao=" + avalicao;
    }
}
