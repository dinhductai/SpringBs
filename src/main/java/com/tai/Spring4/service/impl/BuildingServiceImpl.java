package com.tai.Spring4.service.impl;

import com.tai.Spring4.model.BuildingDTO;
import com.tai.Spring4.repository.BuildingRepository;
import com.tai.Spring4.repository.entity.BuildingEntity;
import com.tai.Spring4.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Override
    public List<BuildingDTO> findAll(String name,Long districtId) {
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(name,districtId);
        List<BuildingDTO> result = new ArrayList<>();
        for(BuildingEntity item: buildingEntities){
            BuildingDTO building = new BuildingDTO();
            building.setName(item.getName());
            building.setAddress(item.getStreet()+", "+item.getWard());
            building.setNumberOfBasement(item.getNumberofbasement());
            result.add(building);
        }
        return result;
    }
}
