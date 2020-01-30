package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.mappers.ImageMapper;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
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
    public ArticleBlockDto map(ImageMapper imageMapper) {
        ImageBlockDto imageBlockDto = new ImageBlockDto(this.getSortIndex());

        Image image = this.getImage();
        ImageDto imageDto = new ImageDto();
        imageDto.setId(image.getId());
        imageDto.setImageSize(image.getImageSize());
        imageDto.setUrl(image.getUrl());

        imageBlockDto.setImage(imageDto);
        return imageBlockDto;
    }
}
