package com.example.qrescue.data;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DataService {

    private final DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<Data> getStudents(){
        return dataRepository.findAll();
    }

    public void addNewStudent(Data data) {
        Optional<Data> studentOptional = dataRepository
                .findStudentByEmail(data.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email is taken");
        }
        dataRepository.save(data);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = dataRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with id " + studentId + " doesn't exist");
        }
        dataRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email){
        Data data = dataRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " doesn't exist"));
        if (name != null && !name.isEmpty() && !Objects.equals(data.getName(), name)){
            data.setName(name);
        }
        if (email != null && !email.isEmpty() && !Objects.equals(data.getEmail(), email)){
            Optional<Data> studentOptional = dataRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Email is taken");
            }
            data.setEmail(email);
        }
    }
}
