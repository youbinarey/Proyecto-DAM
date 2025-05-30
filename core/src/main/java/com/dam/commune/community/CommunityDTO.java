package com.dam.commune.community;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityDTO {
    private Long id;
    
    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @NotNull(message = "Postal code cannot be null")
    private String postalCode;
    
    private int propertiesCount;

    private boolean elevator;
    private int numFlats;
    private int numparkings;
    private int numStorageRooms;
    private boolean reducedMobilityAccess;

    private String bankAccountNumber;
}
