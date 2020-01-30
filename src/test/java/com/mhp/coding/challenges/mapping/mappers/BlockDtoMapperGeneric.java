package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;

public class BlockDtoMapperGeneric<T> {
    private Class<T> block;
    public BlockDtoMapperGeneric(Class<T> block) {
        this.block = block;
    }

    public T getType(ArticleBlockDto articleBlockDto) {
        if (block.isInstance(articleBlockDto)) {
            T objAsType = block.cast(articleBlockDto);
            return objAsType;
        }
        return null;
    }
}