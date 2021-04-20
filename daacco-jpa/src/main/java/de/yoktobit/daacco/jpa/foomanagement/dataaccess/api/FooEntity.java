package de.yoktobit.daacco.jpa.foomanagement.dataaccess.api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FOO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FooEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SUB_SEQ")
    @SequenceGenerator(name="SUB_SEQ", sequenceName = "HIBERNATE_SEQUENCE", allocationSize = 50)
    private Long id;

    @Column(name = "NAME")
    @Builder.Default
    private String name = "";

    @OneToMany(mappedBy = "fooEntity", cascade = CascadeType.ALL)
    @Builder.Default
    private List<FoosubEntity> fooSubEntities = new ArrayList<>();
}
