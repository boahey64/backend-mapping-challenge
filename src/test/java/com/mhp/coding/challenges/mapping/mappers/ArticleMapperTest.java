package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Article;
import org.junit.Test;

public class ArticleMapperTest {

    ArticleMapper serviceUnderTest = new ArticleMapper();

    @Test
    public void map_article() {
        serviceUnderTest.map(anArticle());
    }

    private Article anArticle() {
        return new Article();
    }
}