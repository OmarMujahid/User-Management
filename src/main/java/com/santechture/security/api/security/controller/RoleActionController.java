package com.santechture.security.api.security.controller;
import com.santechture.security.api.security.model.ApiResponse;
import com.santechture.security.api.security.requestModel.CreateOrUpdateRoleActionRequestModel;
import com.santechture.security.data.model.Action;
import com.santechture.security.data.model.Role;
import com.santechture.security.data.model.RoleAction;
import com.santechture.security.data.services.RoleActionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleActionController {

    @Autowired
    private RoleActionServices roleActionServices;

    @GetMapping("/roleAction")
    public ResponseEntity<ApiResponse<List<RoleAction>>> getAllRoleActions(){
        return ApiResponse.<List<RoleAction>>builder()
                .Data(roleActionServices.getallroleaction())
                .code(HttpStatus.FOUND.value())
                .message("All roleAction.")
                .build()
                .toResponseEntity();
    }

    @PostMapping("/roleAction")
    public ResponseEntity<ApiResponse<RoleAction>> addRoleAction(@RequestBody CreateOrUpdateRoleActionRequestModel requestModel){

        return ApiResponse.<RoleAction>builder()
                .Data(roleActionServices.addRoleAction(Role.builder().id(requestModel.getRoleId()).build(), Action.builder().id(requestModel.getActionId()).build()))
                .code(HttpStatus.CREATED.value())
                .message("RoleAction Created")
                .build()
                .toResponseEntity();
    }



    @DeleteMapping("/roleAction/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteRoleActionById(@PathVariable Integer id){
        roleActionServices.deleteRoleAction(id);

        return ApiResponse.<Boolean>builder()
                .Data(true)
                .code(HttpStatus.OK.value())
                .message("roleAction with id " + id + " deleted successfully")
                .build()
                .toResponseEntity();

    }

}
