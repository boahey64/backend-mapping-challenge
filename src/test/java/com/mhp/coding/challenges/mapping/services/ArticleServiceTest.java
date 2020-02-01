package com.mhp.coding.challenges.mapping.services;

import com.mhp.coding.challenges.mapping.mappers.ArticleMapper;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.repositories.ArticleRepository;
import org.junit.Test;

import javax.util.streamex.StreamEx;
import java.util.List;

public class ArticleServiceTest {
    private ArticleRepository repository = new ArticleRepository();

    private ArticleMapper mapper = new ArticleMapper();

    private ArticleService serviceUnderTest = new ArticleService(repository, mapper);

    @Test
    public void check_order_of_articles() {
        List<ArticleDto> articleDtos = serviceUnderTest.list();

        assert(areArticleSorted(articleDtos));
    }

    private boolean areArticleSorted(List<ArticleDto> articleDtos) {
        return StreamEx.of(articleDtos)
                .pairMap((a, b) -> a.compareTo(b) <= 0)
                .allMatch(e -> e);
    }

}