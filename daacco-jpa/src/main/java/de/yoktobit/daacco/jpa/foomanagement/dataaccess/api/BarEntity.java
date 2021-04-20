package de.yoktobit.daacco.jpa.foomanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BAR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BarEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SUB_SEQ")
    @SequenceGenerator(name="SUB_SEQ", sequenceName = "HIBERNATE_SEQUENCE", allocationSize = 50)
    private Long id;

    @Builder.Default
    private String name = "";
}
