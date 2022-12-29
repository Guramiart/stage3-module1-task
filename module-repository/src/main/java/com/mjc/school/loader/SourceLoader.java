package com.mjc.school.loader;

import com.mjc.school.entity.Author;
import com.mjc.school.entity.News;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SourceLoader {

    private static SourceLoader instance;
    private static final String NEWS = "/news.txt";
    private static final String AUTHOR = "/author.txt";
    private static final String DELIMITER = ";";

    private final List<News> newsList;
    private final List<Author> authorList;

    private static Long newsIncrement = 0L;
    private static Long authorIncrement = 0L;

    private SourceLoader() {
        newsList = initNewsList();
        authorList = initAuthorList();
    }

    public static SourceLoader getInstance() {
        if(instance == null) {
            instance = new SourceLoader();
        }
        return instance;
    }

    private List<News> initNewsList() {
        List<News> newsList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream(NEWS))))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(DELIMITER);
                newsList.add(News.getBuilder()
                        .setId(Long.parseLong(data[0]))
                        .setTitle(data[1])
                        .setContent(data[2])
                        .setCreateDate(LocalDateTime.parse(data[3]))
                        .setLastUpdateDate(LocalDateTime.parse(data[4]))
                        .setAuthorId(Long.parseLong(data[5]))
                        .build());
                newsIncrement++;
            }
            return newsList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Author> initAuthorList() {
        List<Author> authors = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream(AUTHOR))))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(DELIMITER);
                authors.add(Author.getBuilder()
                        .setId(Long.parseLong(data[0]))
                        .setName(data[1])
                        .build());
                authorIncrement++;
            }
            return authors;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<News> getNewsList() {
        return new ArrayList<>(newsList);
    }

    public News addNewsToList(News entity) {
        News news = News.getBuilder()
                .setId(++newsIncrement)
                .setContent(entity.getContent())
                .setTitle(entity.getTitle())
                .setLastUpdateDate(LocalDateTime.now())
                .setAuthorId(entity.getAuthorId())
                .build();
        newsList.add(news);
        return news;
    }

    public boolean removeNewsFromList(News entity) {
        return newsList.remove(entity);
    }

    public List<Author> getAuthorList() {
        return new ArrayList<>(authorList);
    }

}
