package com.santechture.security.api.security.requestModel;

import com.santechture.security.data.model.Application;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrUpdateApplicationRequestModel {
    private int id;
    private String code;
    private String name;
    private String title;
    private String titleAr;
    private boolean isActive;

    public Application toEntity(){
        return Application.builder()
                .id(id)
                .code(code)
                .name(name)
                .title(title)
                .titleAr(titleAr)
                .isActive(isActive)
                .build();
    }
}


