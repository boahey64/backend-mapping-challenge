package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlockDto;

public class ImageBlock extends ArticleBlock {

    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public ArticleBlockDto map() {
        ImageBlockDto imageBlockDto = new ImageBlockDto(this.getSortIndex());
        imageBlockDto.setImage(this.getImage().map());

        return imageBlockDto;
    }

}
