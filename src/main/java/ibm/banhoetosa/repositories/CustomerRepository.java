package ibm.banhoetosa.repositories;

import ibm.banhoetosa.models.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel, Integer> {
}
