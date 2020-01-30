package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.mappers.BlockDtoMapperGeneric;
import com.mhp.coding.challenges.mapping.mappers.ImageMapper;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.db.ImageSize;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GalleryBlockTest {
    GalleryBlock objectUnderTest = aGalleryBlock(4);

    ImageMapper imageMapper = new ImageMapper();

    @Test
    public void map_gallery_block_to_gallery_block_dto() {
        GalleryBlockDto expected = anExpectedGalleryBlockDto(4);

        GalleryBlockDto actual = new BlockDtoMapperGeneric<>(GalleryBlockDto.class).getType(
                objectUnderTest.map(imageMapper));

        assertEquals(expected.getSortIndex(), actual.getSortIndex());
        assertEquals(expected.getImages(), actual.getImages());
    }

    private GalleryBlockDto anExpectedGalleryBlockDto(int sortIndex) {
        GalleryBlockDto galleryBlockDto = new GalleryBlockDto(sortIndex);
        List<ImageDto> imageDtos = anExpectedImageDtoList();
        galleryBlockDto.setImages(imageDtos);
        return galleryBlockDto;
    }

    private List<ImageDto> anExpectedImageDtoList() {
        List<ImageDto> imageDtos = new ArrayList<>();
        ImageDto imageDto = new ImageDto();
        imageDto.setUrl("http://fakeurl.com/test.png");
        imageDto.setImageSize(ImageSize.LARGE);
        imageDto.setId(12L);
        imageDtos.add(imageDto);

        return imageDtos;
    }

    GalleryBlock aGalleryBlock(int sortIndex) {
        GalleryBlock galleryBlock = new GalleryBlock();
        galleryBlock.setSortIndex(sortIndex);
        List<Image> images = anImageList();
        galleryBlock.setImages(images);
        return galleryBlock;
    }

    private List<Image> anImageList() {
        List<Image> images = new ArrayList<>();
        Image image = new Image();
        image.setId(12L);
        image.setUrl("http://fakeurl.com/test.png");
        image.setImageSize(ImageSize.LARGE);
        images.add(image);
        return images;
    }

}