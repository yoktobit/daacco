package de.yoktobit.daacco.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;
import org.testcontainers.junit.jupiter.Testcontainers;

import de.yoktobit.daacco.jpa.foomanagement.dataaccess.api.BarEntity;
import de.yoktobit.daacco.jpa.foomanagement.dataaccess.api.FooEntity;
import de.yoktobit.daacco.jpa.foomanagement.dataaccess.api.repo.BarRepository;
import de.yoktobit.daacco.jpa.foomanagement.dataaccess.api.repo.FooRepository;

@SpringBootTest
@Testcontainers
class DaaccoJpaApplicationTests {

	private static final Logger LOG = LoggerFactory.getLogger(DaaccoJpaApplicationTests.class);

	@Autowired
	private FooRepository fooRepository;

	@Autowired
	private BarRepository barRepository;

	@Test
	//@Sql(scripts = "inserts.sql")
	@Transactional
	void selectsEntities() {
		
		StopWatch stop = new StopWatch();
		stop.setKeepTaskList(true);
		stop.start(); 
		List<FooEntity> loadedFooEntities = fooRepository.findAll();
		stop.stop();
		LOG.info("Find Foo Dauer: {}", stop.getLastTaskTimeMillis());
		stop.start();
		IntStream.range(0, 1000).forEach((i) -> {
			BarEntity barEntity = barRepository.findByName("BARNAME1");
			assertThat(barEntity).isNotNull();
		});
		stop.stop();
		LOG.info("Find Bar Dauer {}", stop.getLastTaskTimeMillis());
		
		assertThat(loadedFooEntities).hasSize(100000);
	}

}
