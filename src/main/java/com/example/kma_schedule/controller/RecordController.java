package com.example.kma_schedule.controller;

import com.example.kma_schedule.database.entity.Record;
import com.example.kma_schedule.exceptions.RecordNotFoundException;
import com.example.kma_schedule.service.RecordService;
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
@RequestMapping("/records")
public class RecordController {

    private static final Logger logger = LogManager.getLogger(DisciplineController.class);
    private static final Marker marker = MarkerManager.getMarker("Discipline");

    @Autowired
    private RecordService recordService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Record> getAll(){
        return recordService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Record get(@PathVariable Integer id) throws RecordNotFoundException {
        Optional<Record> optionalRecord = recordService.getById(id);

        if(optionalRecord.isPresent()){
            return optionalRecord.get();
        }else{
            throw new RecordNotFoundException("Can not find record with id "+id);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        recordService.deleteById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Record record){
        recordService.addNewRecord(record);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody Record record){
        recordService.update(record);
    }

    @ExceptionHandler({ RecordNotFoundException.class })
    public ResponseEntity<Object> handleRecordNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
