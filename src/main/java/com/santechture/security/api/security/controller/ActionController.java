//package com.santechture.security.api.security.controller;//package com.santechture.security.api.controller;
//import com.santechture.security.api.security.model.ApiResponse;
//import com.santechture.security.api.security.requestModel.CreateOrUpdateActionRequestModel;
//import com.santechture.security.data.model.Action;
//import com.santechture.security.data.model.Application;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class ActionController {
//    @GetMapping("/action")
//    public ResponseEntity<ApiResponse<List<Action>>> getAllActions(){
//        return ApiResponse.<List<Action>>builder()
//                .Data(actionServices.getAllActions())
//                .code(HttpStatus.FOUND.value())
//                .message("All Actions.")
//                .build()
//                .toResponseEntity();
//    }
//
//    @GetMapping("/action")
//    public ResponseEntity<ApiResponse<Action>> getActionById(@PathVariable Integer id){
//        return ApiResponse.<Action>builder()
//                .Data(actionServices.getActionById(id))
//                .code(HttpStatus.FOUND.value())
//                .message(id+" : Action")
//                .build()
//                .toResponseEntity();
//    }
//
//    @PostMapping("/action")
//    public ResponseEntity<ApiResponse<Action>> addAction(@RequestBody CreateOrUpdateActionRequestModel requestModel){
//        return ApiResponse.<Action>builder()
//                .Data(actionServices.addAction(
//                        requestModel.toEntity()
//                ))
//                .code(HttpStatus.CREATED.value())
//                .message("Action created successfully")
//                .build()
//                .toResponseEntity();
//    }
//
//    @PutMapping("/action")
//    public ResponseEntity<ApiResponse<Action>> updateAction(@RequestBody CreateOrUpdateActionRequestModel requestModel){
//        return ApiResponse.<Action>builder()
//                .Data(actionServices.editAction
//                        (
//                                requestModel.toEntity()
//                        ))
//                .code(HttpStatus.CREATED.value())
//                .message("Action updated successfully")
//                .build()
//                .toResponseEntity();
//    }
//}
