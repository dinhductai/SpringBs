package com.tai.Spring4.service;

import com.tai.Spring4.model.BuildingDTO;
import com.tai.Spring4.repository.entity.BuildingEntity;

import java.util.List;

public interface BuildingService {
    List<BuildingDTO> findAll(String name,Long districtId);
}
