package ibm.banhoetosa.dtos;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ServiceOrderDto {

  int id_customer;
  double total_price;
  LocalDateTime entry_time;

}
