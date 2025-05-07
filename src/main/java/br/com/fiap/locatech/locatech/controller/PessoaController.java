package br.com.fiap.locatech.locatech.controller;

import br.com.fiap.locatech.locatech.entities.Pessoa;
import br.com.fiap.locatech.locatech.services.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PessoaController.class);

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    // http:localhost:8080/pessoas?page=1&size=10
    //

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {

        LOGGER.info("Iniciando busca por todas as pessoas");

        List<Pessoa> pessoas = pessoaService.findAll(page, size);

        LOGGER.info("Busca por todas as pessoas concluída com sucesso");

        return ResponseEntity.ok(pessoas);
    }

    // http:localhost:8080/pessoas/1

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> findById(
            @PathVariable("id") Long id
    ) {

        LOGGER.info("Iniciando busca por pessoa com ID: {}", id);

        Optional<Pessoa> pessoa = pessoaService.findById(id);

        LOGGER.info("Busca por pessoa com ID: {} concluída com sucesso", id);

        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<Void> save(
            @RequestBody Pessoa pessoa
    ) {

        LOGGER.info("Iniciando salvamento da pessoa: {}", pessoa);

        this.pessoaService.save(pessoa);

        LOGGER.info("Pessoa {} salva com sucesso", pessoa.getNome());

        var status = HttpStatus.CREATED;

        return ResponseEntity.status(status.value()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable("id") Long id,
            @RequestBody Pessoa pessoa
    ) {

        LOGGER.info("Iniciando atualização da pessoa com ID: {}", id);

        this.pessoaService.update(pessoa, id);

        LOGGER.info("Pessoa com ID: {} atualizada com sucesso", id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable("id") Long id
    ) {

        LOGGER.info("Iniciando deleção da pessoa com ID: {}", id);

        this.pessoaService.delete(id);

        LOGGER.info("Pessoa com ID: {} deletada com sucesso", id);

        var status = HttpStatus.NO_CONTENT;

        return ResponseEntity.status(status.value()).build();
    }

}
