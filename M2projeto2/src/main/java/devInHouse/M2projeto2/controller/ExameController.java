package devInHouse.M2projeto2.controller;

import devInHouse.M2projeto2.dto.ConsultaDTO;
import devInHouse.M2projeto2.dto.ExameDTO;
import devInHouse.M2projeto2.model.Consulta;
import devInHouse.M2projeto2.model.Exame;
import devInHouse.M2projeto2.repository.ExameRepository;
import devInHouse.M2projeto2.service.ExameService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/exames")
public class ExameController {
    @Autowired
    private ExameService service;
    @PostMapping
    public ResponseEntity<Exame> salva(@RequestBody @Valid ExameDTO exameDTO, UriComponentsBuilder uriBuilder){
        Exame exame = service.salvar(exameDTO);
        URI uri = uriBuilder.path("/api/exames/{id}").buildAndExpand(exame.getId()).toUri();
        return ResponseEntity.created(uri).body(exame);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Exame> edita(@RequestBody @Valid ExameDTO exameDTO, @PathVariable("id") Integer id){
        Exame exame = service.atualizar(exameDTO, id);
        return ResponseEntity.ok(exame);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Exame> lista(@PathVariable("id") Integer id){
        try {
            return ResponseEntity.ok(service.lista(id).get());
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleta(@PathVariable("id") Integer id){
        try {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException();
        }
    }
}
