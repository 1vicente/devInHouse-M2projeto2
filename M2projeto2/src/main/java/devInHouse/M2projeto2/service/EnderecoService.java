package devInHouse.M2projeto2.service;

import devInHouse.M2projeto2.dto.EnderecoDTO;
import devInHouse.M2projeto2.mapper.EnderecoMapper;
import devInHouse.M2projeto2.model.Endereco;
import devInHouse.M2projeto2.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;
    @Autowired
    private EnderecoMapper mapper;
    public Endereco salvar(EnderecoDTO enderecoDTO) {
        Endereco endereco = mapper.map(enderecoDTO);
        return repository.save(endereco);
    }

    public List<Endereco> listar() {
        return repository.findAll();
    }
}
