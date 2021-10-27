package com.epam.task3;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.deleteFrom;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.insertInto;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.selectFrom;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.update;
import static com.datastax.oss.driver.api.querybuilder.SchemaBuilder.createKeyspace;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CassandraTest {

  private static CqlSession session;

  private static final String KEYSPACE = "test_keyspace";
  private static final String TABLE = "test_table";
  private static final String COLUMN = "id";
  private static final Integer ENTITY_ID = 1;

  @BeforeAll
  static void init() {
    session = CqlSession.builder().build();
  }

  @AfterAll
  static void close() {
    session.execute(SchemaBuilder.dropTable(KEYSPACE, TABLE).build());
    session.execute(SchemaBuilder.dropKeyspace(KEYSPACE).build());
    session.close();
  }

  @Test
  @Order(1)
  void testCreateKeystore() {
    SimpleStatement statement = createKeyspace(KEYSPACE)
        .ifNotExists()
        .withSimpleStrategy(1)
        .build();

    ResultSet execute = session.execute(statement);

    assertThat(execute).isNotNull();
  }

  @Test
  @Order(2)
  void testCreateTable() {
    SimpleStatement statement = SchemaBuilder.createTable(KEYSPACE, TABLE)
        .ifNotExists()
        .withPartitionKey(COLUMN, DataTypes.INT)
        .withColumn("lastname", DataTypes.TEXT)
        .withColumn("firstname", DataTypes.TEXT)
        .build();

    ResultSet execute = session.execute(statement);

    assertThat(execute).isNotNull();
  }

  @Test
  @Order(3)
  void testInsert() {
    SimpleStatement statement = insertInto(KEYSPACE, TABLE)
        .value(COLUMN, literal(ENTITY_ID))
        .value("lastname", literal("John"))
        .value("firstname", literal("Doe"))
        .build();

    ResultSet rs = session.execute(statement);
    boolean applied = rs.wasApplied();

    assertThat(applied).isTrue();
  }

  @Test
  @Order(4)
  void testSelect() {
    SimpleStatement statement = selectFrom(KEYSPACE, TABLE).all()
        .whereColumn(COLUMN)
        .isEqualTo(literal(ENTITY_ID))
        .build();

    ResultSet set = session.execute(statement);

    assertThat(set.one().getInt(COLUMN)).isEqualTo(ENTITY_ID);
  }

  @Test
  @Order(5)
  void testUpdate() {
    SimpleStatement statement = update(KEYSPACE, TABLE)
        .usingTtl(60)
        .setColumn("lastname", literal("Testing"))
        .whereColumn(COLUMN)
        .isEqualTo(literal(ENTITY_ID))
        .build();

    ResultSet set = session.execute(statement);

    assertThat(set.wasApplied()).isTrue();
  }

  @Test
  @Order(6)
  void testDelete() {
    SimpleStatement statement = deleteFrom(KEYSPACE, TABLE)
        .whereColumn(COLUMN)
        .isEqualTo(literal(ENTITY_ID))
        .build();

    ResultSet set = session.execute(statement);

    assertThat(set.wasApplied()).isTrue();
  }


  @Test
  void testCQL() {
    ResultSet rs = session.execute("select release_version from system.local");
    Row row = rs.one();

    assertThat(row).isNotNull();
  }

}
