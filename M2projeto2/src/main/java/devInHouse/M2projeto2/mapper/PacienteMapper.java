package devInHouse.M2projeto2.mapper;

import devInHouse.M2projeto2.dto.MedicoDTO;
import devInHouse.M2projeto2.dto.PacienteDTO;
import devInHouse.M2projeto2.model.Medico;
import devInHouse.M2projeto2.model.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PacienteMapper {
    Paciente map(PacienteDTO source);
    PacienteDTO map(Paciente source);
}
