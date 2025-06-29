package com.dam.commune.property.flat;

import com.dam.commune.property.Property;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("FLAT")
public class Flat extends Property {
    private Integer floorNumber;
    private String letter;
    private Integer roomCount;
    private Integer bathroomCount;

}
