package com.santechture.security.api.security.requestModel;

import com.santechture.security.data.model.Action;
import com.santechture.security.data.model.Role;
import com.santechture.security.data.model.RoleAction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrUpdateRoleActionRequestModel {
    private Integer id;
    private Integer roleId;
    private Integer actionId;

    public RoleAction toEntity(){
        return RoleAction.builder()
                .id(id)
                .role(Role.builder().id(roleId).build())
                .action(Action.builder().id(actionId).build())
                .build();
    }

}
