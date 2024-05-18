package br.com.marcos.ProjetoTeste.Repository;

import br.com.marcos.ProjetoTeste.Model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
