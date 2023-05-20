//package com.santechture.security.api.security.controller;//package com.santechture.security.api.controller;
//import com.santechture.security.api.security.model.ApiResponse;
//import com.santechture.security.api.security.requestModel.CreateOrUpdateApplicationRequestModel;
//import com.santechture.security.data.model.Application;
//import com.santechture.security.data.model.Role;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class ApplicationController {
//    @GetMapping("/application")
//    public ResponseEntity<ApiResponse<List<Application>>> getAllApplications(){
//        return ApiResponse.<List<Application>>builder()
////                .Data(applicationServices.getAllApplications())
//                .code(HttpStatus.FOUND.value())
//                .message("All Applications.")
//                .build()
//                .toResponseEntity();
//    }
//
//    @GetMapping("/application")
//    public ResponseEntity<ApiResponse<Application>> getApplicationById(@PathVariable Integer id){
//        return ApiResponse.<Application>builder()
////                .Data(applicationServices.getApplicationById(id))
//                .code(HttpStatus.FOUND.value())
//                .message(id+" : User")
//                .build()
//                .toResponseEntity();
//    }
//
//    @PostMapping("/application")
//    public ResponseEntity<ApiResponse<Application>> addApplication(@RequestBody CreateOrUpdateApplicationRequestModel requestModel){
//        return ApiResponse.<Application>builder()
//                .Data(applicationServices.addApplication(requestModel.toEntity()))
//                .code(HttpStatus.CREATED.value())
//                .message("Application created successfully")
//                .build()
//                .toResponseEntity();
//    }
//
//    @PutMapping("/application")
//    public ResponseEntity<ApiResponse<Application>> updateApplication(@RequestBody CreateOrUpdateApplicationRequestModel requestModel){
//        return ApiResponse.<Application>builder()
//                .Data(applicationServices.editApplication
//                        (requestModel.toEntity()))
//                .code(HttpStatus.CREATED.value())
//                .message("Application updated successfully")
//                .build()
//                .toResponseEntity();
//    }
//
//
//}
