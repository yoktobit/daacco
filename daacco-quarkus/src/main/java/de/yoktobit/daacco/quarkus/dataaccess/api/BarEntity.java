package de.yoktobit.daacco.quarkus.dataaccess.api;

public class BarEntity {
    
    private Long id;

    private String name = "";

    public BarEntity(Long id, String name) {
        
        this.id = id;
        this.name = name;
    }
}
