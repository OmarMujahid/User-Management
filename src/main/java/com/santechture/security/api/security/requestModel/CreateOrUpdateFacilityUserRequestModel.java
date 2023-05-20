package com.santechture.security.api.security.requestModel;

import com.santechture.security.data.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreateOrUpdateFacilityUserRequestModel {

        private Integer id;
        private Integer facilityId;
        private Integer UserId;

        public FacilityUser toEntity(){
            return FacilityUser.builder()
                    .id(id)
                    .facility(Facility.builder().facilityId(facilityId).build())
                    .user(User.builder().id(UserId).build())
                    .build();
        }

    }
