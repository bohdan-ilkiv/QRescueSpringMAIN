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

    public List<Data> getData(){
        return dataRepository.findAll();
    }

    public void addNewData(Data data) {
        Optional<Data> dataOptional = dataRepository
                .findById(data.getId_building());
        if (dataOptional.isPresent()){
            throw new IllegalStateException("Data is the same");
        }
        dataRepository.save(data);
    }

    public void deleteData(Long id_building) {
        boolean exists = dataRepository.existsById(id_building);
        if(!exists){
            throw new IllegalStateException("Building with id " + id_building + " doesn't exist");
        }
        dataRepository.deleteById(id_building);
    }

    @Transactional
    public void updateData(Long dataId, Long num_of_residents, Long fire_exits){
        Data data = dataRepository.findById(dataId)
                .orElseThrow(() -> new IllegalStateException("Building with id " + dataId + " doesn't exist"));
        if (num_of_residents != null && num_of_residents >= 0 &&  !Objects.equals(data.getNum_of_residents(), num_of_residents)){
            data.setNum_of_residents(num_of_residents);
        }
        if (fire_exits != null && fire_exits >= 0 && !Objects.equals(data.getFire_exits(), fire_exits)){
            Optional<Data> studentOptional = dataRepository.findDataById(fire_exits);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Exits");
            }
            data.setFire_exits(fire_exits);
        }
    }
}
