package ibm.banhoetosa.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_customer")
public class CustomerModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id;

  @Column(nullable = false)
  String name;
  @Column(nullable = false)
  String tel;
}
