package com.mjc.school.service;

import com.mjc.school.dto.NewsDTO;
import com.mjc.school.entity.Author;
import com.mjc.school.entity.News;

import java.util.List;
import java.util.Optional;

public interface NewsService<T extends NewsDTO> {

    T createNews(String title, String content, Long authorId);

    List<T> getAllNews();

    T getNewsById(Long id);

    T updateNews(String title, String content, Long authorId);

    boolean deleteNews(Long id);

}
