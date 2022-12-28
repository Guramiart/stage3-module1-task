package com.mjc.school.service;

import com.mjc.school.dto.NewsDTO;
import com.mjc.school.entity.Author;
import com.mjc.school.entity.News;

import java.util.List;
import java.util.Optional;

public interface NewsService<T extends NewsDTO> {

    Optional<T> createNews(String title, String content, Long authorId);

    List<T> getAllNews();

    Optional<T> getNewsById(Long id);

    Optional<T> updateNews(String title, String content, Long authorId);

    boolean deleteNews(Long id);

}
