package ibm.banhoetosa.controllers;

import ibm.banhoetosa.dtos.CustomerDto;
import ibm.banhoetosa.models.CustomerModel;
import ibm.banhoetosa.repositories.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
  @Autowired
  CustomerRepository customerRepository;

  @PostMapping("/create")
  public ResponseEntity<Object> create(@RequestBody CustomerDto customer){
    var customerModel = new CustomerModel();
    BeanUtils.copyProperties(customer, customerModel);
    var customerCreated = customerRepository.save(customerModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(customerCreated);
  }

  @GetMapping("/list")
  public ResponseEntity<Object> listAll(){
    return ResponseEntity.ok().body(customerRepository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getCustomer(@PathVariable int id){
    var customerExists = customerRepository.findById(id);
    if(customerExists.isEmpty()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
    }
    return ResponseEntity.ok().body(customerExists.get());
  }

}
