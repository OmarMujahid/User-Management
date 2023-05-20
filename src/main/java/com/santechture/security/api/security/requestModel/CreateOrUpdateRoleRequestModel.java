package com.santechture.security.api.security.requestModel;

import com.santechture.security.data.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrUpdateRoleRequestModel {
    private Integer id;
    private String name;
    private String title;
    private String titleAr;
    private boolean isActive;

    public Role toEntity(){
        return Role.builder()
                .id(id)
                .name(name)
                .title(title)
                .titleAr(titleAr)
                .isActive(isActive)
                .build();
    }
}
