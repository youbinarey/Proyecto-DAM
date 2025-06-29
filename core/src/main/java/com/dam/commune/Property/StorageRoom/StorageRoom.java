package com.dam.commune.property.storageRoom;

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
@DiscriminatorValue("STORAGEROOM")
public class StorageRoom extends Property {
  private Integer storageNumber;
}
