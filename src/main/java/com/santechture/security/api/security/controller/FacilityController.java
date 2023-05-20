package com.santechture.security.api.security.controller;
import com.santechture.security.api.security.model.ApiResponse;
import com.santechture.security.api.security.requestModel.CreateOrUpdateFacilityRequestModel;
import com.santechture.security.data.model.Facility;
import com.santechture.security.data.repository.FacilityRepository;
import com.santechture.security.data.services.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;



    @GetMapping("/facilities")
    public ApiResponse<List<Facility>> getAllFacility(){
        return ApiResponse.<List<Facility>>builder()
                .Data(facilityService.getAllFacilities())
                .code(HttpStatus.FOUND.value())
                .message("List of all facility.")
                .build();
    }

    @PostMapping("/facilities")
    public ApiResponse<Facility> addFacility(CreateOrUpdateFacilityRequestModel requestModel){

        return ApiResponse.<Facility>builder()
                .Data(facilityService.createFacility(requestModel.toEntity()))
                .code(HttpStatus.CREATED.value())
                .message("facility created")
                .build();
    }


    @PutMapping("/facilities")
    public ApiResponse<Facility> updateFacility(@RequestBody CreateOrUpdateFacilityRequestModel requestModel){
        return ApiResponse.<Facility>builder()
                .Data(facilityService.updateFacility(requestModel.toEntity()))
                .code(HttpStatus.OK.value())
                .message("Facility updated successfully")
                .build();
    }

}

