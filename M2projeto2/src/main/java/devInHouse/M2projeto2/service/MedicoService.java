package devInHouse.M2projeto2.service;

import devInHouse.M2projeto2.dto.MedicoDTO;
import devInHouse.M2projeto2.mapper.MedicoMapper;
import devInHouse.M2projeto2.model.Medico;
import devInHouse.M2projeto2.repository.MedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    @Autowired
    private MedicoMapper mapper;

    public List<Medico> listaTodos(){
        return repository.findAll();
    }

    public Medico salvar(MedicoDTO medicoDTO) {

        Optional<Medico> verificaDuplicado = repository.findByCpf(medicoDTO.getCpf());
        if (verificaDuplicado.isPresent()) {
            throw new DataIntegrityViolationException("CPF já existente");
        } else {
            Medico medico = mapper.map(medicoDTO);
            return repository.save(medico);
        }
    }

    public Medico atualizar(MedicoDTO medicoDTO, Integer id) {
        Medico medicoEncontrado = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        //Medico
        if (medicoDTO.getCrm() != null) {
            medicoEncontrado.setCrm(medicoDTO.getCrm());
        }
        if (medicoDTO.getEspecializacaoClinica() != null && medicoDTO.getEspecializacaoClinica().length() > 0) {
            medicoEncontrado.setEspecializacaoClinica(medicoDTO.getEspecializacaoClinica());
        }

        //Pessoa
        if (medicoDTO.getNomeCompleto() != null && medicoDTO.getNomeCompleto().length() > 0) {
            medicoEncontrado.setNomeCompleto(medicoDTO.getNomeCompleto());
        }
        if (medicoDTO.getGenero() != null && medicoDTO.getGenero().length() > 0) {
            medicoEncontrado.setGenero(medicoDTO.getGenero());
        }
        if (medicoDTO.getDataNascimento() != null && medicoDTO.getDataNascimento().length() > 0) {
            medicoEncontrado.setDataNascimento(medicoDTO.getDataNascimento());
        }
        if (medicoDTO.getEstadoCivil() != null && medicoDTO.getEstadoCivil().length() > 0) {
            medicoEncontrado.setEstadoCivil(medicoDTO.getEstadoCivil());
        }
        if (medicoDTO.getTelefone() != null && medicoDTO.getTelefone().length() > 0) {
            medicoEncontrado.setTelefone(medicoDTO.getTelefone());
        }
        if (medicoDTO.getEmail() != null && medicoDTO.getEmail().length() > 0) {
            medicoEncontrado.setEmail(medicoDTO.getEmail());
        }
        if (medicoDTO.getNaturalidade() != null && medicoDTO.getNaturalidade().length() > 0) {
            medicoEncontrado.setNaturalidade(medicoDTO.getNaturalidade());
        }

        return repository.save(medicoEncontrado);

    }

    public Medico atualizarSenha(MedicoDTO medicoDTO, Integer id) {
        Medico medicoEncontrado = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (medicoDTO.getSenhaAtual() != null && medicoDTO.getSenhaAtual().length() > 0) {
            if (medicoDTO.getSenhaAtual().equals(medicoEncontrado.getSenha())) {
                medicoEncontrado.setSenha(medicoDTO.getSenhaNova());
                return repository.save(medicoEncontrado);
            } else {
                throw new DataIntegrityViolationException("Senha atual não é válida.");
            }
        }
        return null;
    }
}
