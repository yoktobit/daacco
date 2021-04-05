package de.yoktobit.daacco.jdbc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.BarEntity;
import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.FooEntity;
import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.QBarEntity;
import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.dao.BarDao;
import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.dao.FooDao;
import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.repo.BarQueryDslRepository;
import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.repo.BarRepository;
import de.yoktobit.daacco.jdbc.foomanagement.dataaccess.api.repo.FooRepository;

@SpringBootTest
class DaaccoJdbcApplicationTests {

	private static final Logger LOG = LoggerFactory.getLogger(DaaccoJdbcApplicationTests.class);

	@Autowired
	private FooRepository fooRepository;

	@Autowired
	private BarRepository barRepository;

	@Autowired
	private BarQueryDslRepository barQueryDslRepository;

	@Autowired
	private FooDao fooDao;

	@Autowired
	private BarDao barDao;

	@Test
	@Transactional
	void selectsDataByPagingRepo() {

		StopWatch stop = new StopWatch();
		stop.setKeepTaskList(true);
		stop.start();
		Iterable<FooEntity> loadedFooEntities = fooRepository.findAll();
		stop.stop();
		LOG.info("Repo-Variante Find Foo Dauer: {}", stop.getLastTaskTimeMillis());
		stop.start();
		IntStream.range(0, 1000).forEach((i) -> {
			BarEntity barEntity = barRepository.findByName("BARNAME1");
			assertThat(barEntity).isNotNull();
		});
		stop.stop();
		LOG.info("Repo-Variante Find Bar Dauer {}", stop.getLastTaskTimeMillis());
		
		assertThat(loadedFooEntities).hasSize(100000);
	}


	@Test
	@Transactional
	void selectsDataByJdbcTemplate() {

		StopWatch stop = new StopWatch();
		stop.setKeepTaskList(true);
		stop.start();
		Iterable<FooEntity> loadedFooEntities = fooDao.findAll();
		stop.stop();
		LOG.info("JdbcTemplate-Variante Find Foo Dauer: {}", stop.getLastTaskTimeMillis());
		stop.start();
		IntStream.range(0, 1000).forEach((i) -> {
			BarEntity barEntity = barDao.findByName("BARNAME1");
			assertThat(barEntity).isNotNull();
		});
		stop.stop();
		LOG.info("JdbcTemplate-Variante Find Bar Dauer {}", stop.getLastTaskTimeMillis());
		
		assertThat(loadedFooEntities).hasSize(100000);
	}

	@Test
	@Transactional
	void selectsDataByQueryDsl() {

		StopWatch stop = new StopWatch();
		stop.setKeepTaskList(true);
		stop.start();
		Iterable<FooEntity> loadedFooEntities = fooRepository.findAll();
		stop.stop();
		LOG.info("QueryDsl/JDBC-Variante Find Foo Dauer: {}", stop.getLastTaskTimeMillis());
		stop.start();
		IntStream.range(0, 1000).forEach((i) -> {
			BarEntity barEntity = barQueryDslRepository.findOne(QBarEntity.barEntity.name.eq("BARNAME1")).orElse(null);
			assertThat(barEntity).isNotNull();
		});
		stop.stop();
		LOG.info("QueryDsl/JDBC-Variante Find Bar Dauer {}", stop.getLastTaskTimeMillis());
		
		assertThat(loadedFooEntities).hasSize(100000);
	}

}
