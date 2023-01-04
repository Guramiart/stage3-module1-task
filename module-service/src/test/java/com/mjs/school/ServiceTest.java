package com.mjs.school;

import static org.junit.jupiter.api.Assertions.*;

import com.mjc.school.dto.NewsDTO;
import com.mjc.school.entity.News;
import com.mjc.school.exception.ServiceException;
import com.mjc.school.mapper.NewsMapper;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.impl.NewsServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ServiceTest {

    private final NewsService<NewsDTO> newsService = new NewsServiceImpl();
    private final News newsWithoutId = News.getBuilder()
            .setTitle("Test-title")
            .setContent("Test-content")
            .setAuthorId(1L)
            .build();
    private final News newsWithId = News.getBuilder()
            .setId(5L)
            .setTitle("TestTitle")
            .setContent("SetContent")
            .setAuthorId(1L)
            .build();

    @Test
    public void mapToNewsDTO() {
        NewsDTO newsDTO = NewsMapper.INSTANCE.newsToNewsDTO(newsWithoutId);

        assertNotNull(newsDTO);
        assertEquals(newsDTO.getId(), newsWithoutId.getId());
        assertEquals(newsDTO.getTitle(), newsWithoutId.getTitle());
        assertEquals(newsDTO.getContent(), newsWithoutId.getContent());
        assertEquals(newsDTO.getCreateDate(), newsWithoutId.getCreateDate());
        assertEquals(newsDTO.getAuthorId(), newsWithoutId.getAuthorId());
    }

    @Test
    public void createNews() throws ServiceException {
        NewsDTO newsDTO = newsService.createNews(NewsMapper.INSTANCE.newsToNewsDTO(newsWithoutId)).get();

        assertEquals(newsWithoutId.getTitle(), newsDTO.getTitle());
        assertEquals(newsWithoutId.getContent(), newsDTO.getContent());
        assertEquals(newsWithoutId.getAuthorId(), newsDTO.getAuthorId());
    }

    @Test
    public void updateNews() throws ServiceException {
        NewsDTO newsDTO = newsService.updateNews(NewsMapper.INSTANCE.newsToNewsDTO(newsWithId)).get();

        assertEquals(newsWithId.getTitle(), newsDTO.getTitle());
        assertEquals(newsWithId.getContent(), newsDTO.getContent());
        assertEquals(newsWithId.getAuthorId(), newsDTO.getAuthorId());
    }

    @Test
    public void deleteNews() {
        List<NewsDTO> beforeDelete = newsService.getAllNews();
        newsService.deleteNews(10L);
        List<NewsDTO> afterDelete = newsService.getAllNews();
        assertNotEquals(beforeDelete.size(), afterDelete.size());
    }

    @Test
    public void validationTest() {
        NewsDTO invalidTitle = new NewsDTO();
        invalidTitle.setTitle("T");
        invalidTitle.setContent("Content");
        NewsDTO invalidContent = new NewsDTO();
        invalidContent.setTitle("TestTitle");
        invalidContent.setContent("C");
        assertThrows(ServiceException.class, () -> newsService.createNews(invalidTitle));
        assertThrows(ServiceException.class, () -> newsService.createNews(invalidContent));
        assertThrows(ServiceException.class, () -> newsService.updateNews(invalidTitle));
        assertThrows(ServiceException.class, () -> newsService.updateNews(invalidContent));
    }
}
