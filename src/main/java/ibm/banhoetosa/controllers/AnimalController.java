package ibm.banhoetosa.controllers;

import ibm.banhoetosa.dtos.AnimalDto;
import ibm.banhoetosa.models.AnimalModel;
import ibm.banhoetosa.repositories.AnimalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal")
public class AnimalController {

  @Autowired
  AnimalRepository animalRepository;

  @PostMapping("/create")
  public ResponseEntity<Object> create(@RequestBody AnimalDto animal){
    var animalModel = new AnimalModel();
    BeanUtils.copyProperties(animal, animalModel);
    var animalCreated = animalRepository.save(animalModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(animalCreated);
  }

  @GetMapping("/list")
  public ResponseEntity<Object> listAll(){
    return ResponseEntity.ok().body(animalRepository.findAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<Object> getAnimalById(@PathVariable int id){
    var animalExists = animalRepository.findById(id);
    if(animalExists.isEmpty()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal não encontrado!");
    }
    return ResponseEntity.ok().body(animalExists.get());
  }
}
