package com.santechture.security.api.security.controller;
import com.santechture.security.api.security.model.ApiResponse;
import com.santechture.security.api.security.requestModel.CreateOrUpdateGroupRequestModel;
import com.santechture.security.data.model.Group;
import com.santechture.security.data.services.GroupServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class GroupController {
    @Autowired
    private GroupServices groupServices;

    @GetMapping("/groups")
    public ApiResponse<List<Group>> getAllGroup(){
        return ApiResponse.<List<Group>>builder()
                .Data(groupServices.getallGroup())
                .code(HttpStatus.FOUND.value())
                .message("List of all groups.")
                .build();
    }
    @PostMapping("/groups")
    public ApiResponse<Group> addGroup(CreateOrUpdateGroupRequestModel requestModel){

        return ApiResponse.<Group>builder()
                .Data(groupServices.addGroup(requestModel.toEntity()))
                .code(HttpStatus.CREATED.value())
                .message("Group created")
                .build();
    }

    @PutMapping("/group")
    public ApiResponse<Group> updateGroup(@RequestBody CreateOrUpdateGroupRequestModel requestModel){
        return ApiResponse.<Group>builder()
                .Data(groupServices.editGroup(requestModel.toEntity()))
                .code(HttpStatus.OK.value())
                .message("Group updated successfully")
                .build();
    }





}
