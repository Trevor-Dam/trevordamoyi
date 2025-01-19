package com.enviro.assessment.grad001.trevordamoyi.controllers.migrations;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scoreid", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "userid", nullable = false)
    private User userid;

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