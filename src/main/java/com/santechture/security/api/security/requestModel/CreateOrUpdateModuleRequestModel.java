package com.santechture.security.api.security.requestModel;

import com.santechture.security.data.model.Application;
import com.santechture.security.data.model.Module;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrUpdateModuleRequestModel {
    private int id;
    private String code;
    private String name;
    private String title;
    private String titleAr;
    private boolean isActive;

    private Integer application_id;

    public Module toEntity(){
        return Module.builder()
                .id(id)
                .code(code)
                .name(name)
                .title(title)
                .titleAr(titleAr)
                .isActive(isActive)
                .application(Application.builder().id(application_id).build())
                .build();
    }
}


