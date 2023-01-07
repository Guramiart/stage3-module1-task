package com.mjc.school.repository.source;

import com.mjc.school.repository.constants.RepoConstants;
import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.util.Utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataSource {

    private static DataSource instance;
    private final List<NewsModel> newsModelList;
    private final List<AuthorModel> authorModelList;

    private DataSource(List<AuthorModel> authorModelList) {
        this.authorModelList = authorModelList;
        newsModelList = initNewsList();
    }

    public static DataSource getInstance() {
        if(instance == null) {
            List<AuthorModel> authorModelList = initAuthorList();
            instance = new DataSource(authorModelList);
        }
        return instance;
    }

    private static List<AuthorModel> initAuthorList() {
        List<AuthorModel> authorModels = new ArrayList<>();
        for(long i = 1; i <= RepoConstants.NEWS_LIMIT; ++i) {
            authorModels.add(AuthorModel.getBuilder()
                    .setId(i)
                    .setName(Utils.getRandomData(RepoConstants.AUTHOR_SOURCE))
                    .build());
        }
        return authorModels;
    }

    private List<NewsModel> initNewsList() {
        List<NewsModel> newsModels = new ArrayList<>();
        for(long i = 1; i <= RepoConstants.NEWS_LIMIT; ++i) {
            LocalDateTime date = Utils.getRandomDate();
            newsModels.add(NewsModel.getBuilder()
                    .setId(i)
                    .setTitle(Utils.getRandomData(RepoConstants.NEWS_SOURCE))
                    .setContent(Utils.getRandomData(RepoConstants.CONTENT_SOURCE))
                    .setCreateDate(date)
                    .setLastUpdateDate(date)
                    .setAuthorId(authorModelList.get(new Random().nextInt(authorModelList.size())).getId())
                    .build());
        }
        return newsModels;
    }

    public List<NewsModel> getNewsList() {
        return newsModelList;
    }

    public NewsModel addNewsToList(NewsModel entity) {
        entity.setId(newsModelList.size() + 1L);
        newsModelList.add(entity);
        return entity;
    }

    public boolean removeNewsFromList(NewsModel entity) {
        return newsModelList.remove(entity);
    }

}
