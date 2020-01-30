package com.mhp.coding.challenges.mapping.models.dto.blocks;

import com.mhp.coding.challenges.mapping.models.dto.ImageDto;

public class ImageBlockDto extends ArticleBlockDto {

    private ImageDto image;

    public ImageBlockDto(int sortIndex) {
        super.setSortIndex(sortIndex);
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
    }
}
