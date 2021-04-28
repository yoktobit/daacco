package de.yoktobit.daacco.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import de.yoktobit.daacco.jpa.foomanagement.dataaccess.api.BarEntity;
import de.yoktobit.daacco.jpa.foomanagement.dataaccess.api.FooEntity;
import de.yoktobit.daacco.jpa.foomanagement.dataaccess.api.repo.BarRepository;
import de.yoktobit.daacco.jpa.foomanagement.dataaccess.api.repo.FooRepository;

@SpringBootTest
class DaaccoJpaApplicationTests {

	private static final Logger LOG = LoggerFactory.getLogger(DaaccoJpaApplicationTests.class);

	@Autowired
	private FooRepository fooRepository;

	@Autowired
	private BarRepository barRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Transactional
	void selectsDataByJpaRepo() {
		
		StopWatch stop = new StopWatch();
		stop.setKeepTaskList(true);
		stop.start(); 
		List<FooEntity> loadedFooEntities = fooRepository.findAll();
		stop.stop();
		LOG.info("JPA-Variante Find Foo Dauer: {}", stop.getLastTaskTimeMillis());
		stop.start();
		IntStream.range(0, 1000).forEach((i) -> {
			BarEntity barEntity = barRepository.findByName("BARNAME1");
			assertThat(barEntity).isNotNull();
		});
		stop.stop();
		LOG.info("JPA-Variante Find Bar Dauer {}", stop.getLastTaskTimeMillis());
		
		assertThat(loadedFooEntities).hasSize(100000);
	}

	@Test
	@Transactional
	void insertsLotsOfDataNeverReallyExecuted() {

		for (int index = 1; index <= 1000; index++) {
			FooEntity fooEntity = new FooEntity();
			fooEntity.setName("ForLoop " + index);
			this.entityManager.persist(fooEntity);
			assertThat(fooEntity).isNotNull();
		}
	}

	@Test
	@Transactional
	void insertsLotsOfDataWithFlush() {

		for (int index = 1; index <= 1000; index++) {
			FooEntity fooEntity = new FooEntity();
			fooEntity.setName("ForLoop " + index);
			this.entityManager.persist(fooEntity);
			assertThat(fooEntity).isNotNull();
		}
		this.entityManager.flush();
	}

	@Test
	@Transactional
	void insertsLotsOfDataWithFlushForEach() {

		for (int index = 1; index <= 1000; index++) {
			FooEntity fooEntity = new FooEntity();
			fooEntity.setName("ForLoop " + index);
			this.entityManager.persist(fooEntity);
			this.entityManager.flush();
			assertThat(fooEntity).isNotNull();
		}
	}
}
