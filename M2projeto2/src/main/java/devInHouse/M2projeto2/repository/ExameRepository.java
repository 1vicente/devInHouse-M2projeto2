package devInHouse.M2projeto2.repository;

import devInHouse.M2projeto2.model.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer> {
}
