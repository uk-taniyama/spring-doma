package com.example;

import com.btmatthews.junit.rules.LoggingRule;
import com.example.dao.MstNewsDao;
import com.example.entity.MstNews;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@TestExecutionListeners({
  DependencyInjectionTestExecutionListener.class,
  DirtiesContextTestExecutionListener.class,
  TransactionalTestExecutionListener.class,
  CustomTestExecutionListener.class,
  DbUnitTestExecutionListener.class
})
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DbUnitTest {
  @Autowired private MstNewsDao dao;

  @Rule public LoggingRule loggingRule = new LoggingRule();

  @Test
  @ExpectedDatabase(
      table = "mst_news",
      value = "DbUnitTest_addNews.xml",
      columnFilters = CustomColumnFilter.class,
      assertionMode = DatabaseAssertionMode.NON_STRICT)
  public void addNews() throws Exception {
    MstNews dto = new MstNews();
    dto.setRoleId("100");
    dto.setSubject("表題100");
    dto.setUrl("http://a.b");
    dao.insert(dto);
  }
}
