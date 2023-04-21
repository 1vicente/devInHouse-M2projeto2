package devInHouse.M2projeto2.mapper;

import devInHouse.M2projeto2.dto.MedicoDTO;
import devInHouse.M2projeto2.model.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicoMapper {

    Medico map(MedicoDTO source);
    MedicoDTO map(Medico source);
}
