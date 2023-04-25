package devInHouse.M2projeto2.repository;

import devInHouse.M2projeto2.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    List<Optional<Consulta>> findByIdPaciente_id(Integer id);
}
