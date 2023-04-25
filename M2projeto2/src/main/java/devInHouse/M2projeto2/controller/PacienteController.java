package devInHouse.M2projeto2.controller;

import devInHouse.M2projeto2.dto.PacienteDTO;
import devInHouse.M2projeto2.model.Paciente;
import devInHouse.M2projeto2.service.PacienteService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<Paciente> salva(@RequestBody @Valid PacienteDTO pacienteDTO, UriComponentsBuilder uriBuilder) {
        Paciente paciente = service.salvar(pacienteDTO);
        URI uri = uriBuilder.path("/api/usuarios/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> edita(@RequestBody @Valid PacienteDTO pacienteDTO, @PathVariable("id") Integer id) {
        Paciente paciente = service.atualizar(pacienteDTO, id);
        return ResponseEntity.ok(paciente);
    }

    @GetMapping
    public List<?> lista(@RequestParam(required=false, name="nome") String nome) {
        return service.listar(nome);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> edita(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(service.listarId(id).get());
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleta(@PathVariable("id") Integer id) {
        try {
            System.out.println(id);
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException();
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}