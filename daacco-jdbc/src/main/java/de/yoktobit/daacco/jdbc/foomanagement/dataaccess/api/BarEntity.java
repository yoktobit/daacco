package de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api;

import com.querydsl.core.annotations.QueryEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("bar")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@QueryEntity
public class BarEntity {
    
    @Id
    private Long id;

    @Builder.Default
    private String name = "";
}
