package com.mjc.school.mapper;

import com.mjc.school.dto.NewsDTO;
import com.mjc.school.entity.News;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-07T02:47:20+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.2 (Oracle Corporation)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDTO newsToNewsDTO(News news) {
        if ( news == null ) {
            return null;
        }

        NewsDTO.NewsDTOBuilder newsDTO = NewsDTO.getBuilder();

        newsDTO.setId( news.getId() );
        newsDTO.setTitle( news.getTitle() );
        newsDTO.setContent( news.getContent() );
        newsDTO.setCreateDate( news.getCreateDate() );
        newsDTO.setLastUpdateDate( news.getLastUpdateDate() );
        newsDTO.setAuthorId( news.getAuthorId() );

        return newsDTO.build();
    }

    @Override
    public News newsDTOtoNews(NewsDTO newsDTO) {
        if ( newsDTO == null ) {
            return null;
        }

        News.NewsBuilder news = News.getBuilder();

        news.setId( newsDTO.getId() );
        news.setTitle( newsDTO.getTitle() );
        news.setContent( newsDTO.getContent() );
        news.setCreateDate( newsDTO.getCreateDate() );
        news.setLastUpdateDate( newsDTO.getLastUpdateDate() );
        news.setAuthorId( newsDTO.getAuthorId() );

        return news.build();
    }
}
