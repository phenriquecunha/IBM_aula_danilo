package ibm.banhoetosa.repositories;

import ibm.banhoetosa.models.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalModel, Integer> {
}
