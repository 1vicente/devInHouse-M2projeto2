package devInHouse.M2projeto2.service;

import devInHouse.M2projeto2.dto.ConsultaDTO;
import devInHouse.M2projeto2.mapper.ConsultaMapper;
import devInHouse.M2projeto2.model.Consulta;
import devInHouse.M2projeto2.repository.ConsultaRepository;
import devInHouse.M2projeto2.repository.MedicoRepository;
import devInHouse.M2projeto2.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository repository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ConsultaMapper mapper;
    public Consulta salvar(ConsultaDTO consultaDTO) {
        Consulta consulta = mapper.map(consultaDTO);
        consulta.setIdMedico(medicoRepository.findById(consultaDTO.getId_medico()).orElse(null));;
        consulta.setIdPaciente(pacienteRepository.findById(consultaDTO.getId_paciente()).orElse(null));;
        return repository.save(consulta);
    }

    public Consulta atualizar(ConsultaDTO consultaDTO, Integer id) {
        Consulta consultaEncontrada = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (consultaDTO.getMotivo() != null || consultaDTO.getMotivo().length() > 0) {
            consultaEncontrada.setMotivo(consultaDTO.getMotivo());
        }
        if (consultaDTO.getDescProblema() != null || consultaDTO.getDescProblema().length() > 0) {
            consultaEncontrada.setDescProblema(consultaDTO.getDescProblema());
        }
        if (consultaDTO.getMedicacaoReceitada() != null || consultaDTO.getMedicacaoReceitada().length() > 0) {
            consultaEncontrada.setMedicacaoReceitada(consultaDTO.getMedicacaoReceitada());
        }
        if (consultaDTO.getDosagensPrecaucoes() != null || consultaDTO.getDosagensPrecaucoes().length() > 0) {
            consultaEncontrada.setDosagensPrecaucoes(consultaDTO.getDosagensPrecaucoes());
        }
        if (consultaDTO.getId_medico() != null) {
            consultaEncontrada.setIdMedico(medicoRepository.findById(consultaDTO.getId_medico()).orElse(null));
        }
        if (consultaDTO.getId_paciente() != null) {
            consultaEncontrada.setIdPaciente(pacienteRepository.findById(consultaDTO.getId_paciente()).orElse(null));
        }


        return repository.save(consultaEncontrada);

    }

    public Optional<Consulta> lista(Integer id) {
        return repository.findById(id);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
