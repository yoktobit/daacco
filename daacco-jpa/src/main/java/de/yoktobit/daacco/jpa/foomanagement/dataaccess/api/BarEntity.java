package de.yoktobit.daacco.jpa.foomanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    @GeneratedValue
    private Long id;

    @Builder.Default
    private String name = "";
}
