package devInHouse.M2projeto2.repository;

import devInHouse.M2projeto2.model.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer> {

    List<Optional<Exame>> findByIdPaciente_id(Integer id);
}
