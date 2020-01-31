package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.mappers.ImageMapper;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class GalleryBlock extends ArticleBlock {

    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public ArticleBlockDto map(ImageMapper imageMapper) {
        GalleryBlockDto galleryBlockDto = new GalleryBlockDto(this.getSortIndex());

        if(this.getImages() == null) {
            return galleryBlockDto;
        }

        List<ImageDto> imageDtos = this.getImages().stream()
                .filter(Objects::nonNull)
                .map(image -> imageMapper.map(image))
                .collect(toList());

        galleryBlockDto.setImages(imageDtos);

        return galleryBlockDto;
    }

    @Override
    public String toString() {
        return "GalleryBlock{" +
                "images=" + images +
                '}';
    }
}
