package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Component
public class ArticleMapper {

    private ImageMapper imageMapper;

    @Autowired
    public ArticleMapper(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    public ArticleDto map(Article article){
        //TODO
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setAuthor(article.getAuthor());
        articleDto.setTitle(article.getTitle());
        articleDto.setDescription(article.getDescription());
        articleDto.setBlocks(getArticleBlockDtos(article));

        return articleDto;
    }

    private List<ArticleBlockDto> getArticleBlockDtos(Article article) {
        if(article.getBlocks() == null || article.getBlocks().isEmpty()) {
            return emptyList();
        }

        List<ArticleBlockDto> articleDtos = article.getBlocks().stream()
                    .filter(Objects::nonNull)
                    .map(articleBlock -> articleBlock.map(imageMapper))
                    .sorted()
                    .collect(toList());

        return articleDtos;
    }

    public Article map(ArticleDto articleDto) {
        // Nicht Teil dieser Challenge.
        return new Article();
    }
}
