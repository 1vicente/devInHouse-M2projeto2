package devInHouse.M2projeto2.mapper;

import devInHouse.M2projeto2.dto.ExameDTO;
import devInHouse.M2projeto2.model.Exame;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExameMapper {
    Exame map(ExameDTO source);
    ExameDTO map(Exame source);
}
