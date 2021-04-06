package de.yoktobit.daacco.quarkus;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import javax.inject.Inject;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.yoktobit.daacco.quarkus.dataaccess.api.BarEntity;
import de.yoktobit.daacco.quarkus.dataaccess.api.FooEntity;
import de.yoktobit.daacco.quarkus.dataaccess.api.dao.BarDao;
import de.yoktobit.daacco.quarkus.dataaccess.api.dao.FooDao;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Multi;

@QuarkusTest
public class DaaccoQuarkusApplicationTest {

    private static final Logger LOG = LoggerFactory.getLogger(DaaccoQuarkusApplicationTest.class);

    @Inject
    BarDao barDao;

    @Inject
    FooDao fooDao;
    
    @Test
    public void selectsDataByVertx() {
        
        StopWatch stop = new StopWatch();
		stop.start();
		Multi<FooEntity> loadedFooEntitiesMulti = fooDao.findAll();
        List<FooEntity> loadedFooEntities = loadedFooEntitiesMulti.collect().asList().await().indefinitely();
		stop.stop();
		LOG.info("Quarkus-Variante Find Foo Dauer: {}", stop.getTime(TimeUnit.MILLISECONDS));
		stop.reset();
        stop.start();
		IntStream.range(0, 1000).forEach((i) -> {
			BarEntity barEntity = barDao.findByName("BARNAME1").await().indefinitely();
			assertNotNull(barEntity);
		});
		stop.stop();
		LOG.info("Quarkus-Variante Find Bar Dauer {}", stop.getTime(TimeUnit.MILLISECONDS));
		
        assertTrue(loadedFooEntities.size() == 100000);
    }

}