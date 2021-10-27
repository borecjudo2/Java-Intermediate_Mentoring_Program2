package com.epam.task3;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class Cassandra {

  public static void main(String[] args) {
    try (CqlSession session = CqlSession.builder().build()) {
      ResultSet rs = session.execute("select release_version from system.local");
      Row row = rs.one();
      System.out.println("----");
      System.out.println(row.getString("release_version"));
    }
  }

}
