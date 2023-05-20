package com.santechture.security.api.security.requestModel;

import com.santechture.security.data.model.Facility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrUpdateFacilityRequestModel {
    private String facilityName;
    private String facilityLicense;
    private int facilityId;
    private String arabicFacilityName;

    public Facility toEntity() {
        return Facility.builder()
                .facilityId(facilityId)
                .facilityName(facilityName)
                .facilityLicense(facilityLicense)
                .arabicFacilityName(arabicFacilityName)
                .build();
    }





}
