package com.example.kma_schedule.controller;

import com.example.kma_schedule.dto.DisciplineDto;
import com.example.kma_schedule.exceptions.DisciplineException;
import com.example.kma_schedule.service.DisciplineService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {

    private static final Logger logger = LogManager.getLogger(DisciplineController.class);
    private static final Marker marker = MarkerManager.getMarker("Discipline");

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DisciplineDto> getAll(){
        return disciplineService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<DisciplineDto> get(@PathVariable Integer id) throws DisciplineException {
        Optional<DisciplineDto> disciplinesObj = disciplineService.getById(id);
        if(!disciplinesObj.isPresent()) {
            throw new DisciplineException("Discipline not found for the Id: " + id);
        }
        return disciplinesObj;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        disciplineService.deleteById(id);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody DisciplineDto discipline) {
        disciplineService.update(discipline);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewDiscipline(@Valid @RequestBody DisciplineDto discipline) {
        disciplineService.addNewDiscipline(discipline);
    }

    //exception handler for discipline controller
    @ExceptionHandler(DisciplineException.class)
    public ResponseEntity<Object> handleValidationExceptions(
            DisciplineException exception, WebRequest request) {
        return new ResponseEntity<Object>(exception.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
