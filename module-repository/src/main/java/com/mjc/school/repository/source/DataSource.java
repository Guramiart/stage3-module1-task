package com.mjc.school.repository.source;

import com.mjc.school.repository.constants.RepoConstants;
import com.mjc.school.repository.entity.Author;
import com.mjc.school.repository.entity.News;
import com.mjc.school.repository.util.Utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataSource {

    private static DataSource instance;
    private final List<News> newsList;
    private final List<Author> authorList;

    private DataSource(List<Author> authorList) {
        this.authorList = authorList;
        newsList = initNewsList();
    }

    public static DataSource getInstance() {
        if(instance == null) {
            List<Author> authorList = initAuthorList();
            instance = new DataSource(authorList);
        }
        return instance;
    }

    private static List<Author> initAuthorList() {
        List<Author> authors = new ArrayList<>();
        for(long i = 1; i <= RepoConstants.NEWS_LIMIT; ++i) {
            authors.add(Author.getBuilder()
                    .setId(i)
                    .setName(Utils.getRandomData(RepoConstants.AUTHOR_SOURCE))
                    .build());
        }
        return authors;
    }

    private List<News> initNewsList() {
        List<News> news = new ArrayList<>();
        for(long i = 1; i <= RepoConstants.NEWS_LIMIT; ++i) {
            LocalDateTime date = Utils.getRandomDate();
            news.add(News.getBuilder()
                    .setId(i)
                    .setTitle(Utils.getRandomData(RepoConstants.NEWS_SOURCE))
                    .setContent(Utils.getRandomData(RepoConstants.CONTENT_SOURCE))
                    .setCreateDate(date)
                    .setLastUpdateDate(date)
                    .setAuthorId(authorList.get(new Random().nextInt(authorList.size())).getId())
                    .build());
        }
        return news;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public News addNewsToList(News entity) {
        entity.setId(newsList.size() + 1L);
        newsList.add(entity);
        return entity;
    }

    public boolean removeNewsFromList(News entity) {
        return newsList.remove(entity);
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

}
