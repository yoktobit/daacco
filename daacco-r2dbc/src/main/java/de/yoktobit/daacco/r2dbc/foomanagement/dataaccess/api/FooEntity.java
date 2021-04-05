package de.yoktobit.daacco.r2dbc.foomanagement.dataaccess.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("foo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FooEntity {
    
    @Id
    private Long id;

    @Builder.Default
    private String name = "";

    //@MappedCollection(idColumn = "foo_id")
    //@Builder.Default
    //private Set<FoosubEntity> fooSubEntities = new HashSet<>();
}
