package devInHouse.M2projeto2.service;

import devInHouse.M2projeto2.dto.ExameDTO;
import devInHouse.M2projeto2.mapper.ExameMapper;
import devInHouse.M2projeto2.model.Exame;
import devInHouse.M2projeto2.repository.ExameRepository;
import devInHouse.M2projeto2.repository.MedicoRepository;
import devInHouse.M2projeto2.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExameService {
    @Autowired
    private ExameRepository repository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ExameMapper mapper;

    public Exame salvar(ExameDTO exameDTO) {
        Exame exame = mapper.map(exameDTO);
        exame.setIdMedico(medicoRepository.findById(exameDTO.getId_medico()).orElse(null));;
        exame.setIdPaciente(pacienteRepository.findById(exameDTO.getId_paciente()).orElse(null));
        return repository.save(exame);
    }

    public Exame atualizar(ExameDTO exameDTO, Integer id) {
        Exame exameEncontrado = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (exameDTO.getNome() != null || exameDTO.getNome().length() > 0) {
            exameEncontrado.setNome(exameDTO.getNome());
        }
        if (exameDTO.getData() != null || exameDTO.getData().length() > 0) {
            exameEncontrado.setData(exameDTO.getData());
        }
        if (exameDTO.getTipo() != null || exameDTO.getTipo().length() > 0) {
            exameEncontrado.setTipo(exameDTO.getTipo());
        }
        if (exameDTO.getLaboratorio() != null || exameDTO.getLaboratorio().length() > 0) {
            exameEncontrado.setLaboratorio(exameDTO.getLaboratorio());
        }
        if (exameDTO.getUrl() != null || exameDTO.getUrl().length() > 0) {
            exameEncontrado.setUrl(exameDTO.getUrl());
        }
        if (exameDTO.getResultado() != null || exameDTO.getResultado().length() > 0) {
            exameEncontrado.setResultado(exameDTO.getResultado());
        }
        if (exameDTO.getId_medico() != null) {
            exameEncontrado.setIdMedico(medicoRepository.findById(exameDTO.getId_medico()).orElse(null));
        }
        if (exameDTO.getId_paciente() != null) {
            exameEncontrado.setIdPaciente(pacienteRepository.findById(exameDTO.getId_paciente()).orElse(null));
        }

        return repository.save(exameEncontrado);
    }

    public Optional<Exame> lista(Integer id) {
        return repository.findById(id);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

}
