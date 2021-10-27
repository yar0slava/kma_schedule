package com.example.kma_schedule.controller;

import com.example.kma_schedule.database.entity.Record;
import com.example.kma_schedule.service.RecordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/records")
public class RecordController {

    private static final Logger logger = LogManager.getLogger(DisciplineController.class);
    private static final Marker marker = MarkerManager.getMarker("Discipline");

    @Autowired
    private RecordService recordService;

    @GetMapping("/")
    public List<Record> getAll(){
        return recordService.getAll();
    }

    @GetMapping("/{id}")
    public Record get(@PathVariable Integer id){
        Optional<Record> optionalRecord = recordService.getById(id);

        if(optionalRecord.isPresent()){
            return optionalRecord.get();
        }else{
//            throw new
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        recordService.deleteById(id);
    }

    @PostMapping()
    public void create(@RequestBody Record record){
        recordService.addNewRecord(record);
    }

    @PutMapping()
    public void update(@RequestBody Record record){
        recordService.update(record);
    }
}
