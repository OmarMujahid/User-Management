package com.santechture.security.api.security.requestModel;

import com.santechture.security.data.model.Role;
import com.santechture.security.data.model.RoleUser;
import com.santechture.security.data.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrUpdateRoleUserRequestModel {
    private Integer id;
    private Integer roleId;
    private Integer userId;

    public RoleUser toEntity(){
        RoleUser roleUser = RoleUser.builder()
                .role(Role.builder().id(roleId).build())
                .user(User.builder().id(userId).build())
                .build();
        if(id != null) roleUser.setId(id);
        return roleUser;
    }

}
