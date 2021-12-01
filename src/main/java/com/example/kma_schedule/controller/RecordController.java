package com.example.kma_schedule.controller;

import com.example.kma_schedule.dto.RecordDto;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/records")
public class RecordController {

    private static final Logger logger = LogManager.getLogger(RecordController.class);
    private static final Marker marker = MarkerManager.getMarker("Record");

    @Autowired
    private RecordService recordService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String getAll(Model model){
        model.addAttribute("records", recordService.getAll());
        return "records";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<RecordDto> getAll(){
        System.out.println("HERE RECORDS");
        return recordService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public RecordDto get(@PathVariable Integer id) throws RecordNotFoundException {
        Optional<RecordDto> optionalRecord = recordService.getById(id);

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
    public void create(@Valid @RequestBody RecordDto record){
        recordService.addNewRecord(record);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody RecordDto record){
        recordService.update(record);
    }

    //Активує обробку на рівні свого контролеру
    @ExceptionHandler({ RecordNotFoundException.class })
    public ResponseEntity<Object> handleRecordNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
