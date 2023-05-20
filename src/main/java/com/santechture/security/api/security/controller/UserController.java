package com.santechture.security.api.security.controller;
import com.santechture.security.api.security.model.ApiResponse;
import com.santechture.security.api.security.requestModel.CreateOrEditUserRequestModel;
import com.santechture.security.api.security.requestModel.ResetPasswordRequestModel;
import com.santechture.security.data.model.User;
import com.santechture.security.data.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/user")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers(){
        return ApiResponse.<List<User>>builder()
                .Data(userServices.getAllUsers())
                .code(HttpStatus.FOUND.value())
                .message("List of all users.")
                .build()
                .toResponseEntity();
    }


    @PostMapping("/user")
    public ResponseEntity<ApiResponse<User>>  addUser(@RequestBody CreateOrEditUserRequestModel requestModel){
        return ApiResponse.<User>builder()
                .Data(userServices.addUser(requestModel.toEntity()))
                .code(HttpStatus.CREATED.value())
                .message("user " + requestModel.getUserName() + " created successfully.")
                .build()
                .toResponseEntity();
    }

    @PutMapping("/user")
    public ResponseEntity<ApiResponse<User>>  editUser(@RequestBody CreateOrEditUserRequestModel requestModel){
        return ApiResponse.<User>builder()
                .Data(userServices.editUser(requestModel.toEntity()))
                .code(HttpStatus.OK.value())
                .message("user " + requestModel.getUserName() + " edited successfully.")
                .build()
                .toResponseEntity();
    }

    @PutMapping("/user/activation")
    public ResponseEntity<ApiResponse<User>> userActivation(@RequestBody CreateOrEditUserRequestModel requestModel){
        return ApiResponse.<User>builder()
                .Data(userServices.userActivation(requestModel.toEntity()))
                .code(HttpStatus.OK.value())
                .message("user " + requestModel.getUserName() + " edited successfully.")
                .build()
                .toResponseEntity();
    }

    @PutMapping("/user/resetPassword")
    public ResponseEntity<ApiResponse<User>> resetPassword(@RequestBody ResetPasswordRequestModel requestModel){
        return ApiResponse.<User>builder()
                .Data(userServices.resetPassword(requestModel.getUserId()
                        , requestModel.getOldPassword()
                        , requestModel.getNewPassword()))
                .code(HttpStatus.OK.value())
                .message("password changed successfully")
                .build()
                .toResponseEntity();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteUser(@PathVariable Integer id){
        userServices.deleteUserById(id);
        return ApiResponse.<Boolean>builder()
                .Data(true)
                .code(HttpStatus.OK.value())
                .message("user with id " + id + " deleted successfully")
                .build()
                .toResponseEntity();
    }





}
