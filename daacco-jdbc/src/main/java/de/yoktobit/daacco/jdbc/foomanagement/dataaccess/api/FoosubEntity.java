package de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("foosub")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoosubEntity {
    
    @Id
    private Long id;

    @Builder.Default
    private String subname = "";

}
