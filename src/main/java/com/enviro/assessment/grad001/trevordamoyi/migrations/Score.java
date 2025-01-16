package com.enviro.assessment.grad001.trevordamoyi.migrations;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "scores", indexes = {
        @Index(name = "CONSTRAINT_INDEX_C9", columnList = "userid")
}, uniqueConstraints = {
        @UniqueConstraint(name = "CONSTRAINT_C", columnNames = {"scoreid"})
})
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scoreid", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "scoredate", nullable = false)
    private LocalDate scoredate;

    @NotNull
    @Column(name = "score", nullable = false)
    private Integer score;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "noofinfractions", nullable = false)
    private Integer noofinfractions;

}