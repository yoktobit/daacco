package de.yoktobit.daacco.quarkus.dataaccess.api;

public class FooEntity {
    
    Long id;

    String name = "";

    public FooEntity(Long id, String name) {

        this.id = id;
        this.name = name;
    }
}
