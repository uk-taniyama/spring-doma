package com.example.service;

import static org.junit.Assert.*;

import com.btmatthews.junit.rules.LoggingRule;
import com.example.dao.MstNewsDao;
import com.example.dto.NewsDto;
import com.example.entity.MstNews;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "../../../schema-dev.sql")
public class NewsServiceImplTest {

  @Autowired private NewsService service;
  @Autowired private MstNewsDao dao;

  @Rule public LoggingRule loggingRule = new LoggingRule();

  @Test
  public void addNews() throws Exception {

    NewsDto dto = new NewsDto();
    dto.setRoleId("100");
    dto.setSubject("表題100");
    dto.setUrl("http://a.b");
    service.addNews(dto);

    List<MstNews> mstNewses = dao.selectAll();
    assertEquals(1, mstNewses.size());
  }

  @Test
  @Sql(scripts = "../dao/data_news.sql")
  public void findNewsPage() {
    // 条件なし 1ページ
    Page<NewsDto> newsList = service.findNewsPage("", "", "", 0);
    System.out.println(newsList.getContent().size());
    System.out.println(newsList.getSize());
    System.out.println(newsList.getNumber());
    System.out.println(newsList.getNumberOfElements());
    System.out.println(newsList.getTotalElements());
    System.out.println(newsList.getTotalPages());

    assertEquals(11, newsList.getTotalElements());
    assertEquals(5, newsList.getNumberOfElements());
    assertEquals(3, newsList.getTotalPages());

    // 条件なし 2ページ
    newsList = service.findNewsPage("", "", "", 1);
    assertEquals(11, newsList.getTotalElements());
    assertEquals(5, newsList.getNumberOfElements());
    assertEquals(3, newsList.getTotalPages());

    // 条件なし 3ページ
    newsList = service.findNewsPage("", "", "", 2);
    assertEquals(11, newsList.getTotalElements());
    assertEquals(1, newsList.getNumberOfElements());
    assertEquals(3, newsList.getTotalPages());

    // 条件なし 1ページ
    newsList = service.findNewsPage(null, null, null, 0);
    assertEquals(11, newsList.getTotalElements());
    assertEquals(5, newsList.getNumberOfElements());
    assertEquals(3, newsList.getTotalPages());

    // 表題：テスト 1ページ
    newsList = service.findNewsPage("テスト", null, null, 0);

    assertEquals(9, newsList.getTotalElements());
    assertEquals(5, newsList.getNumberOfElements());
    assertEquals(2, newsList.getTotalPages());

    // 権限：ROLE_ADMIN
    newsList = service.findNewsPage(null, "ROLE_ADMIN", null, 0);
    assertEquals(2, newsList.getTotalElements());
    assertEquals(2, newsList.getNumberOfElements());
    assertEquals(1, newsList.getTotalPages());

    // URL:http://hoge/test2
    newsList = service.findNewsPage(null, null, "http://hoge/test2", 0);
    assertEquals(1, newsList.getTotalElements());
    assertEquals(1, newsList.getNumberOfElements());
    assertEquals(1, newsList.getTotalPages());
  }

  @Test
  @Sql(scripts = "../dao/data_news.sql")
  public void modifyNews() {
    Page<NewsDto> newsPage = service.findNewsPage(null, null, "http://hoge/test1", 0);
    NewsDto news = newsPage.getContent().get(0);

    assertEquals(0, news.getVersion());
    // 正常
    news.setSubject("更新後");
    service.modifyNews(news);

    newsPage = service.findNewsPage(null, null, "http://hoge/test1", 0);
    news = newsPage.getContent().get(0);

    assertEquals("更新後", news.getSubject());
    assertEquals(1, news.getVersion());

    // 楽観排他
    news.setSubject("更新後2");
    service.modifyNews(news);
    final NewsDto news_ = news;
    assertThrows(
        OptimisticLockingFailureException.class,
        () -> {
          news_.setSubject("更新後3");
          service.modifyNews(news_);
        });
  }
}
