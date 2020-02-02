package com.mhp.coding.challenges.mapping.repositories;

import com.mhp.coding.challenges.mapping.exceptions.ArticleNotAvailableException;
import com.mhp.coding.challenges.mapping.models.db.Article;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArticleRepositoryTest {

    @Test
    public void find_by_id_for_existing_id() {
        ArticleRepository serviceUnderTest = new ArticleRepository(false);

        Article article = serviceUnderTest.findBy(1001L);

        assertEquals("Max Mustermann", article.getAuthor());
        assertEquals("Article Description 1001", article.getDescription());
        assertEquals("Article Nr.: 1001", article.getTitle());
        assertEquals("Hans Müller", article.getLastModifiedBy());
    }


    @Test
    public void find_by_id_for_not_existing_id() {
        ArticleRepository serviceUnderTest = new ArticleRepository(false);
        Throwable e = null;

        try {
            serviceUnderTest.findBy(1002L);
        } catch (Throwable ex) {
            e = ex;
        }

        assertTrue(e instanceof ArticleNotAvailableException);
    }

}