package devInHouse.M2projeto2.repository;

import devInHouse.M2projeto2.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findByCpf(String cpf);

    List<Optional<Paciente>> findByNomeCompletoContaining(String nome);

}
