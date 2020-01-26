package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static java.util.stream.Collectors.toList;

@Component
public class ArticleMapper {

    public ArticleDto map(Article article){
        //TODO
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setAuthor(article.getAuthor());
        articleDto.setTitle(article.getTitle());
        articleDto.setDescription(article.getDescription());

//        article.getBlocks().stream()
//                .filter(Objects::nonNull)
//                .map(mapper::map)
//                .collect(toList());

        return articleDto;
    }

    public Article map(ArticleDto articleDto) {
        // Nicht Teil dieser Challenge.
        return new Article();
    }
}
