package devInHouse.M2projeto2.service;

import devInHouse.M2projeto2.model.Estatistica;
import devInHouse.M2projeto2.repository.ConsultaRepository;
import devInHouse.M2projeto2.repository.ExameRepository;
import devInHouse.M2projeto2.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstatisticasService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private ExameRepository exameRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    private Estatistica listaQtd(){
        Estatistica estatistica = new Estatistica();
        estatistica.setQtdConsultas(consultaRepository.);
    }
}
