package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;

public class ArticleBlockMapper {

    public ArticleBlockDto map(ArticleBlock articleBlock) {
        return new ArticleBlockDto();
    }
}