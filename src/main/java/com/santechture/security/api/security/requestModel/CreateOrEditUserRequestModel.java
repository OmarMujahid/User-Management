package com.santechture.security.api.security.requestModel;

import com.santechture.security.data.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrEditUserRequestModel {
    private Integer id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;


    public User toEntity(){
        return User.builder()
                .id(id)
                .userName(userName)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .isActive(isActive)
                .build();
    }

}
