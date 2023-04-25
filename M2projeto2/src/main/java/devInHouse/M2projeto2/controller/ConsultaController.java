package devInHouse.M2projeto2.controller;

import devInHouse.M2projeto2.dto.ConsultaDTO;
import devInHouse.M2projeto2.dto.MedicoDTO;
import devInHouse.M2projeto2.model.Consulta;
import devInHouse.M2projeto2.model.Medico;
import devInHouse.M2projeto2.service.ConsultaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaService service;

    @PostMapping
    public ResponseEntity<Consulta> salva(@RequestBody @Valid ConsultaDTO consultaDTO, UriComponentsBuilder uriBuilder){
        Consulta consulta = service.salvar(consultaDTO);
        URI uri = uriBuilder.path("/api/consulta/{id}").buildAndExpand(consulta.getId()).toUri();
        return ResponseEntity.created(uri).body(consulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> edita(@RequestBody @Valid ConsultaDTO consultaDTO, @PathVariable("id") Integer id){
        Consulta consulta = service.atualizar(consultaDTO, id);
        return ResponseEntity.ok(consulta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> lista(@PathVariable("id") Integer id){
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
