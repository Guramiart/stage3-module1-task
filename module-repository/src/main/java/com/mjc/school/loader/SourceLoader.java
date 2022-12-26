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

    private static final String NEWS = "/news.txt";
    private static final String AUTHOR = "/author.txt";
    private static final String DELIMITER = ";";

    private final List<News> newsList = new ArrayList<>();
    private final List<Author> authorList = new ArrayList<>();

    public List<News> getNewsList() {
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream(NEWS))))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(DELIMITER);
                News news = News.getBuilder()
                        .setId(Long.parseLong(data[0]))
                        .setTitle(data[1])
                        .setContent(data[2])
                        .setCreateDate(LocalDateTime.parse(data[3]))
                        .setLastUpdateDate(LocalDateTime.parse(data[4]))
                        .setAuthorId(Long.parseLong(data[5]))
                        .build();
                newsList.add(news);
            }
            return newsList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Author> getAuthorList() {
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream(AUTHOR))))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(DELIMITER);
                authorList.add(new Author(Long.parseLong(data[0]), data[1]));
            }
            return authorList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
