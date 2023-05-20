package com.santechture.security.api.security.requestModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResetPasswordRequestModel {
    private Integer userId;
    private String oldPassword;
    private String newPassword;
}
