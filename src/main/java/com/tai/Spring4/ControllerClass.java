package com.tai.Spring4;

import com.tai.Spring4.model.BuildingDTO;
import com.tai.Spring4.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerClass {
//    static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasicc";
//    static final String USER ="root";
//    static final String PASS ="mysqlcuatai123*";
//
    @Autowired
    private BuildingService buildingService;
    @GetMapping(value = "/api/building/")
    public  List<BuildingDTO> showbuilding(@RequestParam(name = "name",required = false)String name,
                                           @RequestParam(name = "districtId" ,required = false)Long district,
                                           @RequestParam(name ="typeCode",required = false)List<String> typeCode
    ){
            List<BuildingDTO> res = buildingService.findAll(name,district);
        return res;
    }


}