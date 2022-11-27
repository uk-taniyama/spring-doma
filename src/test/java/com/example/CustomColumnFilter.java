package com.example;

import org.dbunit.dataset.Column;
import org.dbunit.dataset.filter.IColumnFilter;

public class CustomColumnFilter implements IColumnFilter {

  @Override
  public boolean accept(String tableName, Column column) {
    if (tableName.equals("MST_NEWS")) {
      switch (column.getColumnName()) {
        case "INSERT_DATE":
        case "VERSION":
        case "MST_NEWS_ID":
          return false;
      }
    }
    return true;
  }
}
