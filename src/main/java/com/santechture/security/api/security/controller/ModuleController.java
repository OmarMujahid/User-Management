//package com.santechture.security.api.security.controller;//package com.santechture.security.api.controller;
//import com.santechture.security.api.security.model.ApiResponse;
//import com.santechture.security.api.security.requestModel.CreateOrUpdateModuleRequestModel;
//import com.santechture.security.data.model.Application;
//import com.santechture.security.data.model.Module;
//import com.santechture.security.data.model.Role;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class ModuleController {
//    @GetMapping("/module")
//    public ResponseEntity<ApiResponse<List<Module>>> getAllModules(){
//        return ApiResponse.<List<Module>>builder()
////                .Data(moduleServices.getAllModules())
//                .code(HttpStatus.FOUND.value())
//                .message("All Modules.")
//                .build()
//                .toResponseEntity();
//    }
//
//    @GetMapping("/module")
//    public ResponseEntity<ApiResponse<Module>> getModuleById(@PathVariable Integer id){
//        return ApiResponse.<Module>builder()
////              .Data(moduleServices.getModuleById())
//                .code(HttpStatus.FOUND.value())
//                .message(id+" : Module.")
//                .build()
//                .toResponseEntity();
//    }
//
//    @PostMapping("/module")
//    public ResponseEntity<ApiResponse<Module>> addModule(@RequestBody CreateOrUpdateModuleRequestModel requestModel){
//        return ApiResponse.<Module>builder()
//                .Data(moduleServices.addModule(requestModel.toEntity()
//                ))
//                .code(HttpStatus.CREATED.value())
//                .message("Module created successfully")
//                .build()
//                .toResponseEntity();
//    }
//
//    @PutMapping("/module")
//    public ResponseEntity<ApiResponse<Module>> editModule(@RequestBody CreateOrUpdateModuleRequestModel requestModel){
//        return ApiResponse.<Module>builder()
//                .Data(moduleServices.addModule(
//                        requestModel.toEntity()
//                ))
//                .code(HttpStatus.CREATED.value())
//                .message("Module edited successfully")
//                .build()
//                .toResponseEntity();
//    }
//}
