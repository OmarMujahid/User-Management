package com.santechture.security.api.security.controller;
import com.santechture.security.api.security.model.ApiResponse;
import com.santechture.security.api.security.requestModel.CreateOrUpdateFacilityUserRequestModel;
import com.santechture.security.data.model.FacilityUser;
import com.santechture.security.data.services.FacilityUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacilityUserController {

    @Autowired
    FacilityUserServices facilityUserServices;

    @GetMapping("/facilityUser")
    public ResponseEntity<ApiResponse<List<FacilityUser>>> getAllFacilityUser(){
        return ApiResponse.<List<FacilityUser>>builder()
                .Data(facilityUserServices.getAllfacilityUsers())
                .code(HttpStatus.FOUND.value())
                .message("All FacilityUser.")
                .build()
                .toResponseEntity();
    }


    @PostMapping("/facilityUser")
    public ResponseEntity<ApiResponse<FacilityUser>> addFacilityUser(@RequestBody CreateOrUpdateFacilityUserRequestModel requestModel){

        return ApiResponse.<FacilityUser>builder()
                .Data(facilityUserServices.AddFacilityUser(requestModel.toEntity()))
                .code(HttpStatus.CREATED.value())
                .message("FacilityUser Created")
                .build()
                .toResponseEntity();
    }

    @DeleteMapping("/facilityUser/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteFacilityUserById(@PathVariable Integer id){
        facilityUserServices.deletefacilityUser(id);

        return ApiResponse.<Boolean>builder()
                .Data(true)
                .code(HttpStatus.OK.value())
                .message("facilityUser with id " + id + " deleted successfully")
                .build()
                .toResponseEntity();

    }



}
