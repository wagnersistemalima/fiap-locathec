package br.com.fiap.locatech.locatech.controller;

import br.com.fiap.locatech.locatech.entities.Veiculo;
import br.com.fiap.locatech.locatech.services.VeiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VeiculoController.class);

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    // http:localhost:8080/veiculos?page=1&size=10

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAllVeiculos(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {

        LOGGER.info("Listando todos os veículos");

        var veiculos = this.veiculoService.findAll(page, size);

        return ResponseEntity.ok(veiculos);
    }

    // http:localhost:8080/veiculos/1

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> findVeiculoById(
            @PathVariable("id") Long id
    ) {

        LOGGER.info("Listando veículo com ID: {}", id);

        var veiculo = this.veiculoService.findVeiculoById(id);

        return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    public ResponseEntity<Void> saveVeiculo(
            @RequestBody Veiculo veiculo
    ) {

        LOGGER.info("Salvando veículo: {}", veiculo);

        this.veiculoService.saveVeiculo(veiculo);

        var status = HttpStatus.CREATED;

        return ResponseEntity.status(status.value()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVeiculo(
            @PathVariable("id") Long id,
            @RequestBody Veiculo veiculo

    ) {

        LOGGER.info("Atualizando veículo: {}", veiculo);

        this.veiculoService.updateVeiculo(veiculo, id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(
            @PathVariable("id") Long id
    ) {

        LOGGER.info("Deletando veículo com ID: {}", id);

        this.veiculoService.deleteVeiculo(id);

        var status = HttpStatus.NO_CONTENT;

        return ResponseEntity.status(status.value()).build();
    }

}
