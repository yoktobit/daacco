package de.yoktobit.daacco.quarkus.dataaccess.impl.dao;

import java.util.stream.StreamSupport;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import de.yoktobit.daacco.quarkus.dataaccess.api.FooEntity;
import de.yoktobit.daacco.quarkus.dataaccess.api.dao.FooDao;
import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;

@ApplicationScoped
public class FooDaoImpl implements FooDao {

    @Inject
    PgPool client;

    @Override
    public Multi<FooEntity> findAll() {
        
        return client.query("SELECT * FROM foo").execute().onItem().transformToMulti(set -> Multi.createFrom().items(() -> StreamSupport.stream(set.spliterator(), false))).onItem().transform(this::mapRow);
    }
    
    public FooEntity mapRow(Row row) {

        return new FooEntity(row.getLong("id"), row.getString("name"));
    }
}
