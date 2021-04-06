package de.yoktobit.daacco.r2dbc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import de.yoktobit.daacco.r2dbc.foomanagement.dataaccess.api.BarEntity;
import de.yoktobit.daacco.r2dbc.foomanagement.dataaccess.api.FooEntity;
import de.yoktobit.daacco.r2dbc.foomanagement.dataaccess.api.repo.BarRepository;
import de.yoktobit.daacco.r2dbc.foomanagement.dataaccess.api.repo.FooRepository;

@SpringBootTest
class DaaccoR2dbcApplicationTests {

	private static final Logger LOG = LoggerFactory.getLogger(DaaccoR2dbcApplicationTests.class);

	@Autowired
	private FooRepository fooRepository;

	@Autowired
	private BarRepository barRepository;

	@Test
	void selectsDataByR2dbcRepo() {

		StopWatch stop = new StopWatch();
		stop.setKeepTaskList(true);
		stop.start();
		Iterable<FooEntity> loadedFooEntities = fooRepository.findAll().toIterable();
		stop.stop();
		LOG.info("R2DBC-Variante Find Foo Dauer: {}", stop.getLastTaskTimeMillis());
		stop.start();
		IntStream.range(0, 1000).forEach((i) -> {
			BarEntity barEntity = barRepository.findByName("BARNAME1").block();
			assertThat(barEntity).isNotNull();
		});
		stop.stop();
		LOG.info("R2DBC-Variante Find Bar Dauer {}", stop.getLastTaskTimeMillis());
		
		assertThat(loadedFooEntities).hasSize(100000);
		assertThat(loadedFooEntities.iterator().next().getName()).isEqualTo("Foo1");
	}

}
