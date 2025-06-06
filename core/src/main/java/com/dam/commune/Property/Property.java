package com.dam.commune.property;

import com.dam.commune.community.Community;
import com.dam.commune.owner.Owner;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;



@Entity
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "property_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "cadastral_reference", nullable = false, unique = true)
    private String cadastralReference;

    @Column(name= "square_meters", nullable = false)
    private Double squareMeters;

    private Double coefficient;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "community_id", nullable = false, updatable = false)
    @JsonIgnore
    private Community community;

     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "owner_id")
     @JsonIgnore
     private Owner owner;

}
