package devInHouse.M2projeto2.mapper;

import devInHouse.M2projeto2.dto.ConsultaDTO;
import devInHouse.M2projeto2.model.Consulta;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConsultaMapper {
    Consulta map(ConsultaDTO source);
    ConsultaDTO map(Consulta source);
}
