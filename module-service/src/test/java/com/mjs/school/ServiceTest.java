package com.mjs.school;

import static org.junit.jupiter.api.Assertions.*;

import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.service.dto.NewsDTO;
import com.mjc.school.service.exception.ServiceException;
import com.mjc.school.service.mapper.NewsMapper;
import com.mjc.school.service.interfaces.NewsService;
import com.mjc.school.service.impl.NewsServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

class ServiceTest {

    private final NewsService<NewsDTO> newsService = new NewsServiceImpl();
    private final NewsModel newsModelWithoutId = NewsModel.getBuilder()
            .setTitle("Test-title")
            .setContent("Test-content")
            .setAuthorId(1L)
            .build();
    private final NewsModel newsModelWithId = NewsModel.getBuilder()
            .setId(5L)
            .setTitle("TestTitle")
            .setContent("SetContent")
            .setAuthorId(1L)
            .build();

    @Test
    void mapToNewsDTO() {
        NewsDTO newsDTO = NewsMapper.INSTANCE.newsToNewsDTO(newsModelWithoutId);

        assertNotNull(newsDTO);
        assertEquals(newsDTO.getId(), newsModelWithoutId.getId());
        assertEquals(newsDTO.getTitle(), newsModelWithoutId.getTitle());
        assertEquals(newsDTO.getContent(), newsModelWithoutId.getContent());
        assertEquals(newsDTO.getCreateDate(), newsModelWithoutId.getCreateDate());
        assertEquals(newsDTO.getAuthorId(), newsModelWithoutId.getAuthorId());
    }

    @Test
    void createNews() throws ServiceException {
        NewsDTO newsDTO = newsService.createNews(NewsMapper.INSTANCE.newsToNewsDTO(newsModelWithoutId));

        assertEquals(newsModelWithoutId.getTitle(), newsDTO.getTitle());
        assertEquals(newsModelWithoutId.getContent(), newsDTO.getContent());
        assertEquals(newsModelWithoutId.getAuthorId(), newsDTO.getAuthorId());
    }

    @Test
    void updateNews() throws ServiceException {
        NewsDTO newsDTO = newsService.updateNews(NewsMapper.INSTANCE.newsToNewsDTO(newsModelWithId));

        assertEquals(newsModelWithId.getTitle(), newsDTO.getTitle());
        assertEquals(newsModelWithId.getContent(), newsDTO.getContent());
        assertEquals(newsModelWithId.getAuthorId(), newsDTO.getAuthorId());
    }

    @Test
    void deleteNews() throws ServiceException {
        List<NewsDTO> beforeDelete = newsService.getAllNews();
        newsService.deleteNews(10L);
        List<NewsDTO> afterDelete = newsService.getAllNews();
        assertNotEquals(beforeDelete.size(), afterDelete.size());
    }

    @Test
    void validationTest() {
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
