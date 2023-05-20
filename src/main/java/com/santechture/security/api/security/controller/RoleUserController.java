package com.santechture.security.api.security.controller;
import com.santechture.security.api.security.model.ApiResponse;
import com.santechture.security.api.security.requestModel.CreateOrUpdateRoleUserRequestModel;
import com.santechture.security.data.model.Role;
import com.santechture.security.data.model.RoleUser;
import com.santechture.security.data.model.User;
import com.santechture.security.data.services.RoleUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleUserController {

    @Autowired
    private RoleUserServices roleUserServices;

    @GetMapping("/roleUser")
    public ResponseEntity<ApiResponse<List<RoleUser>>> getAllRoleUsers(){
        return ApiResponse.<List<RoleUser>>builder()
                .Data(roleUserServices.getAllRoleUsers())
                .code(HttpStatus.FOUND.value())
                .message("List of all users.")
                .build()
                .toResponseEntity();
    }

    @PostMapping("/roleUser")
    public ResponseEntity<ApiResponse<RoleUser>> addRoleUser(CreateOrUpdateRoleUserRequestModel requestModel){

        return ApiResponse.<RoleUser>builder()
                .Data(roleUserServices.addRoleUser(Role.builder().id(requestModel.getRoleId()).build(), User.builder().id(requestModel.getUserId()).build()))
                .code(HttpStatus.CREATED.value())
                .message("RoleUser created")
                .build()
                .toResponseEntity();
    }

    @DeleteMapping("/roleUser/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteRoleUserById(@PathVariable Integer id){
        roleUserServices.deleteRoleUser(id);

        return ApiResponse.<Boolean>builder()
                .Data(true)
                .code(HttpStatus.OK.value())
                .message("roleUser with id " + id + " deleted successfully")
                .build()
                .toResponseEntity();
    }


}
