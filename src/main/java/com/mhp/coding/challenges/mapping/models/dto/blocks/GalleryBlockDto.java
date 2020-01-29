package com.mhp.coding.challenges.mapping.models.dto.blocks;

import com.mhp.coding.challenges.mapping.models.dto.ImageDto;

import java.util.List;
import java.util.Objects;

public class GalleryBlockDto extends ArticleBlockDto {

    private List<ImageDto> images;

    public List<ImageDto> getImages() {
        return images;
    }

    public void setImages(List<ImageDto> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "GalleryBlockDto{" +
                "images=" + images +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GalleryBlockDto that = (GalleryBlockDto) o;
        return Objects.equals(images, that.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(images);
    }
}
