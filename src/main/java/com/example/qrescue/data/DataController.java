package com.example.qrescue.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/data")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }


    @GetMapping
    public List<Data> getData(){
        return dataService.getData();
    }

    @PostMapping
    public void registerNewData(@RequestBody Data data){
        dataService.addNewData(data);
    }

    @DeleteMapping(path = "{dataId}")
    public void deleteStudent(@PathVariable("dataId") Long dataId){
        dataService.deleteData(dataId);
    }

    @PutMapping(path = "{dataId}")
    public void updateData (
            @PathVariable("dataId") Long dataId,
            @RequestParam(required = false) Long num_of_residents,
            @RequestParam(required = false) Long fire_exits){
        dataService.updateData(dataId, num_of_residents, fire_exits);
    }
}
