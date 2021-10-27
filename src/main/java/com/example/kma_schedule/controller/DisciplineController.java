package com.example.kma_schedule.controller;

import com.example.kma_schedule.database.entity.Discipline;
import com.example.kma_schedule.exceptions.DisciplineExceptionHandler;
import com.example.kma_schedule.service.DisciplineService;
import com.example.kma_schedule.service.DisciplineServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {

    private static final Logger logger = LogManager.getLogger(DisciplineController.class);
    private static final Marker marker = MarkerManager.getMarker("Discipline");

    @Autowired
    private DisciplineServiceImpl disciplineService;

    @GetMapping("/disciplines")
    @ResponseBody
    public List<Discipline> get(){
        return disciplineService.getAll();
    }


    @GetMapping("/disciplines/{id}")
    @ResponseBody
    public Optional<Discipline> get(@PathVariable Integer id) {
        Optional<Discipline> disciplinesObj = disciplineService.getById(id);
        if(!disciplinesObj.isPresent()) {
            throw new RuntimeException("Discipline not found for the Id: "+id);
        }
        return disciplinesObj;
    }

    @PostMapping("/disciplines")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewDiscipline(@Valid @RequestBody Discipline discipline) {
        disciplineService.addNewDiscipline(discipline);
    }

    //exception handler for discipline controller
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(DisciplineExceptionHandler.class)
//    public String handleValidationExceptions(MethodArgumentNotValidException ex) {
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}
