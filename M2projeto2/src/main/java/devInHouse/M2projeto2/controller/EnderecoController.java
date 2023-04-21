package devInHouse.M2projeto2.controller;

import devInHouse.M2projeto2.dto.ConsultaDTO;
import devInHouse.M2projeto2.dto.EnderecoDTO;
import devInHouse.M2projeto2.model.Consulta;
import devInHouse.M2projeto2.model.Endereco;
import devInHouse.M2projeto2.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService service;

    @PostMapping
    public ResponseEntity<Endereco> salva(@RequestBody EnderecoDTO enderecoDTO, UriComponentsBuilder uriBuilder){
        Endereco endereco = service.salvar(enderecoDTO);
        URI uri = uriBuilder.path("/api/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(endereco);
    }

    @GetMapping
    public List<Endereco> listaTodos(){
        return service.listar();
    }
}
