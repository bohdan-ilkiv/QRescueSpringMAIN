package com.example.qrescue.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }


    @GetMapping
    public List<Data> getStudents(){
        return dataService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Data data){
        dataService.addNewStudent(data);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        dataService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent (
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        dataService.updateStudent(studentId, name, email);
    }
}
