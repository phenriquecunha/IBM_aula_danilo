package ibm.banhoetosa.repositories;

import ibm.banhoetosa.models.ServiceOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrderModel, Integer> {
}
