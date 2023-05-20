package com.santechture.security.api.security.controller;
import com.santechture.security.api.security.model.ApiResponse;
import com.santechture.security.api.security.requestModel.CreateOrUpdateRoleRequestModel;
import com.santechture.security.data.model.Role;
import com.santechture.security.data.services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleServices roleServices;

    @GetMapping("/role")
    public ResponseEntity<ApiResponse<List<Role>>> getAllRoles(){
        return ApiResponse.<List<Role>>builder()
                .Data(roleServices.getAllRoles())
                .code(HttpStatus.FOUND.value())
                .message("All Roles.")
                .build()
                .toResponseEntity();
    }


    @PostMapping("/role")
    public ResponseEntity<ApiResponse<Role>> addRole(@RequestBody CreateOrUpdateRoleRequestModel requestModel){
        return ApiResponse.<Role>builder()
                .Data(roleServices.addRole(requestModel.toEntity()))
                .code(HttpStatus.CREATED.value())
                .message("Role created successfully")
                .build()
                .toResponseEntity();
    }

    @PutMapping("/role")
    public ResponseEntity<ApiResponse<Role>> updateRole(@RequestBody CreateOrUpdateRoleRequestModel requestModel){
        return ApiResponse.<Role>builder()
                .Data(roleServices.editRole(requestModel.toEntity()))
                .code(HttpStatus.OK.value())
                .message("Role updated successfully")
                .build()
                .toResponseEntity();
    }



}
