package devInHouse.M2projeto2.mapper;

import devInHouse.M2projeto2.dto.EnderecoDTO;
import devInHouse.M2projeto2.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnderecoMapper {
    Endereco map(EnderecoDTO source);
    EnderecoDTO map(Endereco source);
}
