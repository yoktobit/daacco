package de.yoktobit.daacco.jpa.foomanagement.dataaccess.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FOOSUB")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoosubEntity {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "SUBNAME")
    @Builder.Default
    private String subName = "";

    @ManyToOne
    @JoinColumn(name = "FOO_ID")
    private FooEntity fooEntity;
}
