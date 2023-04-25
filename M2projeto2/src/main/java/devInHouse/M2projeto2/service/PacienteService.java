package devInHouse.M2projeto2.service;

import devInHouse.M2projeto2.dto.PacienteDTO;
import devInHouse.M2projeto2.mapper.PacienteMapper;
import devInHouse.M2projeto2.model.Consulta;
import devInHouse.M2projeto2.model.Exame;
import devInHouse.M2projeto2.model.Paciente;
import devInHouse.M2projeto2.repository.ConsultaRepository;
import devInHouse.M2projeto2.repository.EnderecoRepository;
import devInHouse.M2projeto2.repository.ExameRepository;
import devInHouse.M2projeto2.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ExameRepository exameRepository;
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteMapper mapper;

    public List<?> listar(String nome){
        if (nome == null || nome == ""){
            return repository.findAll();
        } else {
            return repository.findByNomeCompletoContaining(nome);
        }
    }

    public Paciente salvar(PacienteDTO pacienteDTP) {

        Optional<Paciente> verificaDuplicado = repository.findByCpf(pacienteDTP.getCpf());
        if (verificaDuplicado.isPresent()) {
            throw new DataIntegrityViolationException("CPF já existente");
        } else {
            Paciente paciente = mapper.map(pacienteDTP);
            paciente.setEndereco(enderecoRepository.findById(pacienteDTP.getId_endereco()).orElse(null));
            return repository.save(paciente);
        }
    }

    public Paciente atualizar(PacienteDTO pacienteDTO, Integer id){
        Paciente pacienteEncontrado = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        //Paciente
        if (pacienteDTO.getListaAlergia() != null && pacienteDTO.getListaAlergia().length() > 0) {
            pacienteEncontrado.setListaAlergia(pacienteDTO.getListaAlergia());
        }
        if (pacienteDTO.getListaCuidadosE() != null && pacienteDTO.getListaCuidadosE().length() > 0) {
            pacienteEncontrado.setListaCuidadosE(pacienteDTO.getListaCuidadosE());
        }
        if (pacienteDTO.getContatoEmergencia() != null && pacienteDTO.getContatoEmergencia().length() > 0) {
            pacienteEncontrado.setContatoEmergencia(pacienteDTO.getContatoEmergencia());
        }
        if (pacienteDTO.getConvenio() != null && pacienteDTO.getConvenio().length() > 0) {
            pacienteEncontrado.setConvenio(pacienteDTO.getConvenio());
        }
        if (pacienteDTO.getNumeroConvenio() != null && pacienteDTO.getNumeroConvenio().length() > 0) {
            pacienteEncontrado.setNumeroConvenio(pacienteDTO.getNumeroConvenio());
        }
        if (pacienteDTO.getValidadeConvenio() != null && pacienteDTO.getValidadeConvenio().length() > 0) {
            pacienteEncontrado.setValidadeConvenio(pacienteDTO.getValidadeConvenio());
        }


        //Pessoa
        if (pacienteDTO.getNomeCompleto() != null && pacienteDTO.getNomeCompleto().length() > 0) {
            pacienteEncontrado.setNomeCompleto(pacienteDTO.getNomeCompleto());
        }
        if (pacienteDTO.getGenero() != null && pacienteDTO.getGenero().length() > 0) {
            pacienteEncontrado.setGenero(pacienteDTO.getGenero());
        }
        if (pacienteDTO.getDataNascimento() != null && pacienteDTO.getDataNascimento().length() > 0) {
            pacienteEncontrado.setDataNascimento(pacienteDTO.getDataNascimento());
        }
        if (pacienteDTO.getEstadoCivil() != null && pacienteDTO.getEstadoCivil().length() > 0) {
            pacienteEncontrado.setEstadoCivil(pacienteDTO.getEstadoCivil());
        }
        if (pacienteDTO.getTelefone() != null && pacienteDTO.getTelefone().length() > 0) {
            pacienteEncontrado.setTelefone(pacienteDTO.getTelefone());
        }
        if (pacienteDTO.getEmail() != null && pacienteDTO.getEmail().length() > 0) {
            pacienteEncontrado.setEmail(pacienteDTO.getEmail());
        }
        if (pacienteDTO.getNaturalidade() != null && pacienteDTO.getNaturalidade().length() > 0) {
            pacienteEncontrado.setNaturalidade(pacienteDTO.getNaturalidade());
        }
        return repository.save(pacienteEncontrado);

    }

    public Optional<Paciente> listarId(Integer id) {
        return repository.findById(id);
    }

    public void deletar(Integer id) {
        List<Optional<Consulta>> listaConsulta =  consultaRepository.findByIdPaciente_id(id);
        List<Optional<Exame>> listaExame = exameRepository.findByIdPaciente_id(id);
        List<Integer> idConsultas = new ArrayList<>();
        List<Integer> idExames = new ArrayList<>();

        if (listaConsulta.size() >= 1 || listaExame.size() >= 1){
            for (int i = 0; listaConsulta.size() > i; i++) {
                Optional<Consulta> consultasPaciente = listaConsulta.get(i);
                idConsultas.add(consultasPaciente.get().getId());
            }

            for (int i = 0; listaExame.size() > i; i++) {
                Optional<Exame> examesPaciente = listaExame.get(i);
                idExames.add(examesPaciente.get().getId());
            }
            throw new RuntimeException("Paciente com consulta(s) "+idConsultas.toString()+" e/ou exame(s) "+ idExames +" cadastrado(s)");
        } else {
            Paciente pacienteEncontrado = repository.findById(id).orElseThrow(EntityNotFoundException::new);
            repository.deleteById(id);
        }
    }
}
