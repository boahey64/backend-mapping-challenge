package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlockDto;

import java.util.Optional;

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


        Optional<ImageDto> imageDto = getImageDto();
        if(imageDto.isPresent()) {
            imageBlockDto.setImage(imageDto.get());
        }

        return imageBlockDto;
    }

    private Optional<ImageDto> getImageDto() {
        ImageDto imageDto = new ImageDto();
        Image image = this.getImage();
        if(image == null) {
            return Optional.empty();
        }
        imageDto.setId(image.getId());
        imageDto.setImageSize(image.getImageSize());
        imageDto.setUrl(image.getUrl());

        return Optional.of(imageDto);
    }
}
