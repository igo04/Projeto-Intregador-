package br.com.gestaojogos.service;

import br.com.gestaojogos.repository.JogoRepository;
import br.com.gestaojogos.domain.model.Jogo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JogoService {
    private static JogoRepository JogoRepository = null;
    public JogoService(JogoRepository massaRepository) {
        this.JogoRepository = massaRepository;
    }

    public static Jogo save(Jogo jogo){
        return JogoRepository.save(jogo);
    }

    public List<Jogo> findAll(){
        return JogoRepository.findAll();
    }

    public static Jogo findById(UUID id){
        return JogoRepository.findById(id).orElse(new Jogo());
    }

    public void deleteById(UUID id){
        JogoRepository.deleteById(id);
    }

    public void update(UUID id, float preco) {
        JogoRepository.updateByPreco(id, preco);
    }

    public Jogo findByPreco(float preco, Object descricao) {
        return JogoRepository.findByDescricao(descricao);
    }
}
