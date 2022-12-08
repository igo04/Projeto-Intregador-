package br.com.gestaojogos.repository;

import br.com.gestaojogos.domain.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository("JogoRepository")
public interface JogoRepository extends JpaRepository<Jogo, UUID> {

    @Modifying
    @Transactional
    @Query(value = "update jogo c set c.descricao = :descricao where c.jogoId = :id")
    void updateByPreco(UUID id, float descricao);

    static Jogo findBydescricao(float descricao) {
        return null;
    }

    Jogo findByDescricao(Object descricao);
}
