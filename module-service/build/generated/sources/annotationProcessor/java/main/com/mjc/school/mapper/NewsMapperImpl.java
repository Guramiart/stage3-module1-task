package com.mjc.school.mapper;

import com.mjc.school.dto.NewsDTO;
import com.mjc.school.entity.News;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-29T17:12:39+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.1 (Oracle Corporation)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDTO newsToNewsDTO(News news) {
        if ( news == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String content = null;
        LocalDateTime createDate = null;
        LocalDateTime lastUpdateDate = null;
        Long authorId = null;

        id = news.getId();
        title = news.getTitle();
        content = news.getContent();
        createDate = news.getCreateDate();
        lastUpdateDate = news.getLastUpdateDate();
        authorId = news.getAuthorId();

        NewsDTO newsDTO = new NewsDTO( id, title, content, createDate, lastUpdateDate, authorId );

        return newsDTO;
    }
}
