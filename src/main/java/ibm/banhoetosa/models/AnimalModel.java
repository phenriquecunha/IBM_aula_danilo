package ibm.banhoetosa.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_animal")
public class AnimalModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id;

  @Column(nullable = false)
  String name;
  @Column(nullable = false)
  int age;
  @Column(nullable = false)
  double weight;
  @OneToOne(targetEntity = CustomerModel.class)
  int id_customer;
}
