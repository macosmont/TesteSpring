package br.com.marcos.ProjetoTeste.Repository;

import br.com.marcos.ProjetoTeste.Model.Categoria;
import br.com.marcos.ProjetoTeste.Model.Episodio;
import br.com.marcos.ProjetoTeste.Model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);

    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, double avaliacao);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero(Categoria categoria);

   List<Serie> findByTotalDeTemporadaLessThanEqualAndAvaliacaoGreaterThanEqual(int totalDeTemporada, double avaliacao);

    @Query(" select s from Serie s WHERE s.totalDeTemporada <= :totalDeTemporada AND s.avaliacao>= :avaliacao")
    List<Serie> serieTempEAvalia (int totalDeTemporada, double avaliacao);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:trechoEpisodio%")
    List<Episodio> episodiosPorTrecho(String trechoEpisodio);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie ORDER BY avaliacao DESC LIMIT 5")
    List<Episodio> topEpisodiosPorSerie(Serie serie);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie AND YEAR(e.dataLancemento) >= :anoLancamento")
    List<Episodio> episodiosPorSerieEAno(Serie serie, int anoLancamento);

}
