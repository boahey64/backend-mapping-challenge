package com.mhp.coding.challenges.mapping.repositories;

import com.mhp.coding.challenges.mapping.models.db.Article;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArticleRepositoryTest {
    private ArticleRepository serviceUnderTest = new ArticleRepository();

    @Test
    public void find_by_id_for_existing_id() {
        Article article = serviceUnderTest.findBy(1001L);

        assertEquals("Max Mustermann", article.getAuthor());
        assertEquals("Article Description 1001", article.getDescription());
        assertEquals("Article Nr.: 1001", article.getTitle());
        assertEquals("Hans Müller", article.getLastModifiedBy());

    }

    @Ignore
    @Test
    public void find_by_id_for_not_existing_id() {
        Article article = serviceUnderTest.findBy(1002L);

        assertEquals("Max Mustermann", article.getAuthor());
        assertEquals("Article Description 1001", article.getDescription());
        assertEquals("Article Nr.: 1001", article.getTitle());
        assertEquals("Hans Müller", article.getLastModifiedBy());

    }

}