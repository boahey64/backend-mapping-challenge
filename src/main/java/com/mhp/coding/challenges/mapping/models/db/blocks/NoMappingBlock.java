package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class NoMappingBlock extends ArticleBlock  {
    private String dummyValue;

    public String getDummyValue() {
        return dummyValue;
    }

    public void setDummyValue(String dummyValue) {
        this.dummyValue = dummyValue;
    }

    @Override
    public ArticleBlockDto map() {
        throw new NotImplementedException();
    }
}
