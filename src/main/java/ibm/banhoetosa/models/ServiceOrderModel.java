package ibm.banhoetosa.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class ServiceOrderModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id;

  @ManyToOne(targetEntity = CustomerModel.class)
  int id_customer;

  @Column(nullable = false)
  double total_price;

  @Column(nullable = false)
  LocalDateTime entry_time;

  LocalDateTime departure_time;
}
