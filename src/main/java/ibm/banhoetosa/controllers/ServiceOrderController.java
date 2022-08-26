package ibm.banhoetosa.controllers;


import ibm.banhoetosa.dtos.ServiceOrderDto;
import ibm.banhoetosa.models.ServiceOrderModel;
import ibm.banhoetosa.repositories.ServiceOrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/so")
public class ServiceOrderController {

  @Autowired
  ServiceOrderRepository serviceOrderRepository;

  @PostMapping("/create")
  public ResponseEntity<Object> create(@RequestBody ServiceOrderDto so){
    var soModel = new ServiceOrderModel();
    BeanUtils.copyProperties(so, soModel);
    var soCreated = serviceOrderRepository.save(soModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(soCreated);
  }

  @GetMapping("/list")
  public ResponseEntity<Object> listAll(){
    return ResponseEntity.ok().body(serviceOrderRepository.findAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<Object> getServiceOrderById(@PathVariable int id){
    var soExists = serviceOrderRepository.findById(id);
    if(soExists.isEmpty()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ordem de serviço não encontrada!");
    }
    return ResponseEntity.ok().body(soExists.get());
  }

  // Rota para retirar o animal do serviço (banho e/ou tosa)
  @PostMapping("/departure/{id}")
  public ResponseEntity<Object> departure(@PathVariable int id){
    var soExists = serviceOrderRepository.findById(id);
    if(soExists.isEmpty()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ordem de serviço não encontrada!");
    }

    // 'Setando' a data e hora de saida do animal 🐕
    soExists.get().setDeparture_time(LocalDateTime.now());
    return ResponseEntity.ok().body(soExists.get());

  }

  //TODO Método de update
  //NÃO DEU TEMPO 😿
}
