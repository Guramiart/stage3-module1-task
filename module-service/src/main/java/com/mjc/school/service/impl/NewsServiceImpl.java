package com.mjc.school.service.impl;

import com.mjc.school.repository.dao.GenericDAO;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.service.constants.ServiceConstants;
import com.mjc.school.repository.impl.NewsDAO;
import com.mjc.school.service.dto.NewsDTO;
import com.mjc.school.service.exception.ArgumentValidException;
import com.mjc.school.service.exception.ErrorCode;
import com.mjc.school.service.exception.NotFoundException;
import com.mjc.school.service.exception.ServiceException;
import com.mjc.school.service.mapper.NewsMapper;
import com.mjc.school.service.interfaces.NewsService;
import com.mjc.school.service.utils.NewsValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewsServiceImpl implements NewsService<NewsDTO> {

    private final GenericDAO<NewsModel> newsDAO;

    public NewsServiceImpl() {
        newsDAO = new NewsDAO();
    }

    @Override
    public List<NewsDTO> getAllNews() {
        List<NewsDTO> news = new ArrayList<>();
        for(NewsModel elem : newsDAO.readAll()) {
            news.add(NewsMapper.INSTANCE.newsToNewsDTO(elem));
        }
        return news;
    }

    @Override
    public Optional<NewsDTO> createNews(NewsDTO news) throws ServiceException {
        Optional<NewsDTO> newsDTO = Optional.empty();
        try {
            NewsValidator.getInstance().validateDTO(news);
            Optional<NewsModel> optionalNews = newsDAO.create(NewsMapper.INSTANCE.newsDTOtoNews(news));
            if(optionalNews.isPresent()) {
                newsDTO = Optional.of(NewsMapper.INSTANCE.newsToNewsDTO(optionalNews.get()));
            }
            return newsDTO;
        } catch (ArgumentValidException | NotFoundException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Optional<NewsDTO> getNewsById(Long id) throws ServiceException {
        Optional<NewsModel> news = newsDAO.readById(id);
        try {
            NewsValidator.getInstance().validateNewsId(id);
            if(news.isEmpty()) {
                throw new ServiceException(String.format(
                        ErrorCode.NOT_EXIST.getErrorMessage(), ServiceConstants.NEWS_PARAM, id));
            }
            return Optional.of(NewsMapper.INSTANCE.newsToNewsDTO(news.get()));
        } catch (ArgumentValidException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Optional<NewsDTO> updateNews(NewsDTO news) throws ServiceException{
        try {
            NewsValidator.getInstance().validateDTO(news);
            NewsValidator.getInstance().validateNewsId(news.getId());
            Optional<NewsModel> updateNews = newsDAO.update(NewsMapper.INSTANCE.newsDTOtoNews(news));
            if(updateNews.isEmpty()) {
                throw new ServiceException(String.format(
                        ErrorCode.NOT_EXIST.getErrorMessage(), ServiceConstants.NEWS_PARAM, news.getId()));
            }
            return Optional.of(NewsMapper.INSTANCE.newsToNewsDTO(updateNews.get()));
        } catch (ArgumentValidException | NotFoundException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean deleteNews(Long id) throws ServiceException {
        try {
            NewsValidator.getInstance().validateNewsId(id);
            if(!newsDAO.delete(id)) {
                throw new ServiceException(String.format(
                        ErrorCode.NOT_EXIST.getErrorMessage(), ServiceConstants.NEWS_PARAM, id));
            }
            return true;
        } catch (ArgumentValidException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
