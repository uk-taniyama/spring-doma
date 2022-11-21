package com.example.web;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Objects;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** ログイン画面のコントローラ. */
@Controller
@Slf4j
public class LoginController {
  @Autowired DataSource dataSource;

  @RequestMapping("loginForm")
  String loginForm() throws SQLException {
    try (Connection conn = dataSource.getConnection()) {
      DatabaseMetaData metaData = conn.getMetaData();
      ResultSet rs = metaData.getTables(null, null, null, null);
      ResultSetMetaData md = rs.getMetaData();
      int count = md.getColumnCount();
      for (int i = 1; i < count; i += 1) {
        log.info("COL:" + md.getColumnName(i));
      }
      while (rs.next()) {
        String line = "";
        for (int i = 1; i < count; i += 1) {
          if (i > 1) {
            line += ":";
          }
          line += Objects.toString(rs.getObject(i));
        }
        log.info(line);
      }
    }
    return "loginForm";
  }
}
