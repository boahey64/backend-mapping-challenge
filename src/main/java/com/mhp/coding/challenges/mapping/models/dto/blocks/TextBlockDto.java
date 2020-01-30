package com.mhp.coding.challenges.mapping.models.dto.blocks;

public class TextBlockDto extends ArticleBlockDto {

    private String text;

    public TextBlockDto(int sortIndex) {
        super.setSortIndex(sortIndex);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
