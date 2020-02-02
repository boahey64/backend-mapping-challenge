package com.mhp.coding.challenges.mapping.services;

import com.mhp.coding.challenges.mapping.exceptions.ArticleNotAvailableException;
import com.mhp.coding.challenges.mapping.mappers.ArticleMapper;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.repositories.ArticleRepository;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.util.streamex.StreamEx;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ArticleServiceTest {
    private ArticleMapper mapper = new ArticleMapper();


    @Test
    public void check_order_of_articles() {
        ArticleRepository repository = new ArticleRepository(false);
        ArticleService serviceUnderTest = new ArticleService(repository, mapper);

        List<ArticleDto> articleDtos = serviceUnderTest.list();

        assert(areArticleSorted(articleDtos));
    }

    @Test
    public void check_not_implemented_exception() {
        ArticleRepository repository = new ArticleRepository(true);
        ArticleService serviceUnderTest = new ArticleService(repository, mapper);;

        Throwable e = null;

        try {
            serviceUnderTest.list();
        } catch (Throwable ex) {
            e = ex;
        }

        assertTrue(e instanceof NotImplementedException);
    }

    private boolean areArticleSorted(List<ArticleDto> articleDtos) {
        return StreamEx.of(articleDtos)
                .pairMap((a, b) -> a.compareTo(b) <= 0)
                .allMatch(e -> e);
    }

}