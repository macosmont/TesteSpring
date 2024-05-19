package br.com.marcos.ProjetoTeste.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private String anoTotal;
    @Enumerated(EnumType.STRING)
    private Categoria genero;
    private String sinopse;
    private String poster;
    private Integer totalDeTemporada;
    private Double avaliacao;
    private String quantidadeVotas;
    private String atores;
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episodio> episodios = new ArrayList<>();

    public Serie(){}

    public Serie(DadosSerie dadosSerie){
        this.atores = dadosSerie.atores();
        this.titulo = dadosSerie.titulo();
        this.anoTotal = dadosSerie.anoTotal();
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        this.sinopse = dadosSerie.sinopse();
        this.poster = dadosSerie.poster();
        this.totalDeTemporada = dadosSerie.totalDeTemporada();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0.0);
        this.quantidadeVotas = dadosSerie.quantidadeVotas();
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }
    public void setEpisodios(List<Episodio> episodios) {
        episodios.forEach(e -> e.setSerie(this));
        this.episodios = episodios;
    }

    public String getAtores() {
        return atores;
    }
    public void setAtores(String atores) {
        this.atores = atores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnoTotal() {
        return anoTotal;
    }
    public void setAnoTotal(String anoTotal) {
        this.anoTotal = anoTotal;
    }

    public Categoria getGenero() {
        return genero;
    }
    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getPoster() {
        return poster;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getTotalDeTemporada() {
        return totalDeTemporada;
    }
    public void setTotalDeTemporada(Integer totalDeTemporada) {
        this.totalDeTemporada = totalDeTemporada;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getQuantidadeVotas() {
        return quantidadeVotas;
    }
    public void setQuantidadeVotas(String quantidadeVotas) {
        this.quantidadeVotas = quantidadeVotas;
    }

    @Override
    public String toString() {
        return
                ", titulo='" + titulo + '\'' +
                        ", atores='" + atores + '\'' +
                        ", Episodios='" + episodios + '\'' +
                        ", genero=" + genero +
                        ", sinopse='" + sinopse + '\'' +
                        ", poster='" + poster + '\'' +
                        ", totalDeTemporada=" + totalDeTemporada +
                        ", avaliacao=" + avaliacao +
                        ", quantidadeVotas='" + quantidadeVotas + '\'' +
                        '}';
    }
}
