package br.com.gestaojogos.app.controller;

import br.com.gestaojogos.domain.model.Jogo;
import br.com.gestaojogos.service.JogoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = "rh")
@Tag(name = "RH Controller", description = "Controladora que gere o cadastro de jogos")
public class JogoController {
    private final JogoService jogoService;

    public JogoController(JogoService celularService, JogoService jogoService){
        this.jogoService = jogoService;

    }

    @PostMapping(value = "/jogo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cadastra um jogo", responses = {@ApiResponse(description = "Sucesso ao cadastrar", responseCode = "201", content = @Content)})
    ResponseEntity<Jogo> save(@RequestBody Jogo jogo) {
        return new ResponseEntity<>(jogoService.save(jogo), CREATED);
    }

    @GetMapping(value = "/jogo", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Lista de jogos", responses = {@ApiResponse(description = "Sucesso ao listar os jogos", responseCode = "200", content = @Content)})
    public static ResponseEntity<List<Jogo>> findAll() {
        return new ResponseEntity<>(jogoService.findAll(), OK);
    }

    @GetMapping(value = "/jogo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Localiza um cadastro de jogo por ID", responses = {@ApiResponse(description = "Sucesso ao consultar o jogo", responseCode = "200", content = @Content)})
    ResponseEntity<Jogo> findById(@PathVariable UUID id) {
        return new ResponseEntity<>(jogoService.findById(id), OK);
    }

    @PutMapping(value = "/jogo", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualiza jogo", responses = {@ApiResponse(description = "Sucesso ao atualizar", responseCode = "201", content = @Content)})
    ResponseEntity<?> update(@RequestBody Jogo jogo) {
        JogoService.save(jogo);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @DeleteMapping(value = "/jogo/{id}")
    @Operation(summary = "Exclui um cadastro de jogo pelo ID", responses = {@ApiResponse(description = "Sucesso ao apagar o cadastro", responseCode = "204")})
    ResponseEntity<?> deleteById(@PathVariable UUID id) {
        jogoService.deleteById(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
    @PatchMapping(value = "/jogo/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualizar descrição do jogo", responses = {@ApiResponse(description = "descrição do jogo", responseCode = "201", content = @Content)})
    ResponseEntity<?> updateDescricao(@PathVariable UUID id, @RequestBody float descricao) {
        jogoService.update(id, descricao);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
