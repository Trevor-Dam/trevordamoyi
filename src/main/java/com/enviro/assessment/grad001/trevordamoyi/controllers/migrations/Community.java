package com.enviro.assessment.grad001.trevordamoyi.controllers.migrations;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "community")
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "communityid", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "area", nullable = false, length = 100)
    private String area;

    @NotNull
    @Column(name = "communityscore", nullable = false)
    private Integer communityscore;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "averageinfractions", nullable = false)
    private Double averageinfractions;

}