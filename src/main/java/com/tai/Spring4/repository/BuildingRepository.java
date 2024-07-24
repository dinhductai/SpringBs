package com.tai.Spring4.repository;

import com.tai.Spring4.repository.entity.BuildingEntity;

import java.util.List;

public interface BuildingRepository {
    List<BuildingEntity> findAll(String name,Long districtId);
}
