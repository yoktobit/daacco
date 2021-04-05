package de.yoktobit.daacco.quarkus.dataaccess.impl.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import de.yoktobit.daacco.quarkus.dataaccess.api.BarEntity;
import de.yoktobit.daacco.quarkus.dataaccess.api.dao.BarDao;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;

@ApplicationScoped
public class BarDaoImpl implements BarDao {
    
    @Inject
    PgPool client;

    @Override
    public Uni<BarEntity> findByName(String name) {

        return client.preparedQuery("SELECT * FROM bar where name = $1").execute(Tuple.of(name)).map(RowSet::iterator).map(iterator -> iterator.hasNext() ? mapRow(iterator.next()) : null);
    }

    public BarEntity mapRow(Row row) {

        return new BarEntity(row.getLong("id"), row.getString("name"));
    }

}
