package com.example;

import com.github.database.rider.core.api.dataset.DataSetFormat;
import com.github.database.rider.core.api.exporter.BuilderType;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.dbunit.dataset.filter.IColumnFilter;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DBSnapshot {
  String value() default "dataSource";

  String[] tableNames() default {};

  // classpath: src/test/resources/
  String expected() default "datasets/expected/${class}-${method}.xml";

  // filepath
  String actual() default "datasets/actual/${class}-${method}";

  DataSetFormat actualFormat() default DataSetFormat.XML;

  BuilderType builderType() default BuilderType.DEFAULT;

  boolean skip() default false;

  Class<? extends IColumnFilter>[] columnFilters() default {};

  DatabaseAssertionMode assertionMode() default DatabaseAssertionMode.NON_STRICT;
}
