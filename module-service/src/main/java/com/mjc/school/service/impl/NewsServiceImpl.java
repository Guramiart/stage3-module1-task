package com.mjc.school.service.impl;

import com.mjc.school.repository.interfaces.Repository;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.source.DataSource;
import com.mjc.school.service.constants.ServiceConstants;
import com.mjc.school.repository.impl.NewsRepository;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.ArgumentValidException;
import com.mjc.school.service.exception.ErrorCode;
import com.mjc.school.service.exception.NotFoundException;
import com.mjc.school.service.exception.ServiceException;
import com.mjc.school.service.mapper.NewsMapper;
import com.mjc.school.service.interfaces.NewsService;
import com.mjc.school.service.utils.NewsValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class NewsServiceImpl implements NewsService<NewsDto> {

    private final Repository<NewsModel> newsRepository;
    private final NewsValidator newsValidator = NewsValidator.getInstance();

    public NewsServiceImpl() {
        newsRepository = new NewsRepository();
    }

    @Override
    public List<NewsDto> readAllNews() {
        List<NewsDto> news = new ArrayList<>();
        for(NewsModel elem : newsRepository.readAll()) {
            news.add(NewsMapper.INSTANCE.newsToNewsDTO(elem));
        }
        return news;
    }

    @Override
    public NewsDto createNews(NewsDto news) throws ServiceException {
        try {
            newsValidator.validateDTO(news);
            NewsModel createNews = newsRepository.create(NewsMapper.INSTANCE.newsDTOtoNews(news));
            return NewsMapper.INSTANCE.newsToNewsDTO(createNews);
        } catch (ArgumentValidException | NotFoundException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public NewsDto readById(Long id) throws ServiceException {
        try {
            newsValidator.validateNewsId(id);
            isNewsExist(id);
            NewsModel news = newsRepository.readById(id);
            return NewsMapper.INSTANCE.newsToNewsDTO(news);
        } catch (ArgumentValidException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public NewsDto updateNews(NewsDto news) throws ServiceException{
        try {
            newsValidator.validateDTO(news);
            newsValidator.validateNewsId(news.getId());
            isNewsExist(news.getId());
            NewsModel updateNews = newsRepository.update(NewsMapper.INSTANCE.newsDTOtoNews(news));
            return NewsMapper.INSTANCE.newsToNewsDTO(updateNews);
        } catch (ArgumentValidException | NotFoundException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Boolean deleteNews(Long id) throws ServiceException {
        try {
            newsValidator.validateNewsId(id);
            isNewsExist(id);
            newsRepository.delete(id);
            return true;
        } catch (ArgumentValidException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    private void isNewsExist(Long id) throws ServiceException {
        Optional<NewsModel> newsModel = DataSource.getInstance().getNewsList()
                .stream()
                .filter(el -> Objects.equals(el.getId(), id))
                .findFirst();
        if(newsModel.isEmpty()) {
            throw new ServiceException(String.format(
                    ErrorCode.NOT_EXIST.getErrorMessage(), ServiceConstants.NEWS_PARAM, id));
        }
    }
}
