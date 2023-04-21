package devInHouse.M2projeto2.controller;

import devInHouse.M2projeto2.dto.MedicoDTO;
import devInHouse.M2projeto2.model.Medico;
import devInHouse.M2projeto2.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class MedicoController {
    @Autowired
    private MedicoService service;
    @PostMapping
    public ResponseEntity<MedicoDTO> salva(@RequestBody @Valid MedicoDTO medicoDTO, UriComponentsBuilder uriBuilder) {
        Medico medico = service.salvar(medicoDTO);
        URI uri = uriBuilder.path("/api/usuarios/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(medicoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edita(@RequestBody @Valid MedicoDTO medicoDTO, @PathVariable("id") Integer id){
        Medico medico = service.atualizar(medicoDTO, id);
        return ResponseEntity.ok(medico);
    }

    @PutMapping("/{id}/senha")
    public ResponseEntity<?> atualizaSenha(@RequestBody MedicoDTO medicoDTO, @PathVariable("id") Integer id){
        Medico medico = service.atualizarSenha(medicoDTO, id);
        return ResponseEntity.ok(medico);
    }
    @GetMapping
    public List<Medico> listaTodos(){
        return service.listaTodos();
    }



}
