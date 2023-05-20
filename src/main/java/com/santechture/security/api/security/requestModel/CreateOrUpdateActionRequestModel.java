package com.santechture.security.api.security.requestModel;

import com.santechture.security.data.model.Action;
import com.santechture.security.data.model.Group;
import com.santechture.security.data.model.Module;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrUpdateActionRequestModel {
    private int id;
    private String code;
    private String name;
    private String title;
    private String titleAr;
    private String url;
    private boolean isActive;
    private boolean isview;
    private Group group;
    private Module module;

    public Action toEntity(){
        return Action.builder()
                .id(id)
                .code(code)
                .name(name)
                .title(title)
                .titleAr(titleAr)
                .isActive(isActive)
                .isview(isview)
                .group(group)
                .module(module)
                .build();
    }
}


