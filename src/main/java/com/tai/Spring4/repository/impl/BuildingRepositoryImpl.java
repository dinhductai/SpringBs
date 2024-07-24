package com.tai.Spring4.repository.impl;

import com.tai.Spring4.model.BuildingDTO;
import com.tai.Spring4.repository.BuildingRepository;
import com.tai.Spring4.repository.entity.BuildingEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasicc";
    static final String USER ="root";
    static final String PASS ="mysqlcuatai123*";

    @Override
    public List<BuildingEntity> findAll(String name,Long districtId) {
        StringBuilder sql = new StringBuilder("select * from building b where 1=1");
        if(name!=null && !name.equals(""))
        {
            sql.append(" and b.name like '%"+name+"%' ");
        }
        if(districtId!=null){
            sql.append(" and b.districtId = "+districtId+" ");
        }
        List<BuildingEntity> result = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql.toString())) {
            while (rs.next()) {
                BuildingEntity building = new BuildingEntity();
                building.setName(rs.getString("name"));
                building.setStreet(rs.getString("street"));
                building.setWard(rs.getString("ward"));
                building.setNumberofbasement(rs.getInt("numberofbasement"));
                result.add(building);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
