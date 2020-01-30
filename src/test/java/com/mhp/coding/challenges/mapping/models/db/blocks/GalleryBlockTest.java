package com.mhp.coding.challenges.mapping.models.db.blocks;

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
    GalleryBlock objectUnderTest = anGalleryBlock();

    ImageMapper imageMapper = new ImageMapper();

    @Test
    public void map_gallery_block_to_gallery_block_dto() {
        GalleryBlockDto expected = anExpectedGalleryBlockDto();

        // TODO remove casting
        GalleryBlockDto actual = (GalleryBlockDto)objectUnderTest.map(imageMapper);

        assertEquals(expected.getImages(), actual.getImages());
    }

    private GalleryBlockDto anExpectedGalleryBlockDto() {
        GalleryBlockDto galleryBlockDto = new GalleryBlockDto(4);
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

    GalleryBlock anGalleryBlock() {
        GalleryBlock galleryBlock = new GalleryBlock();
        galleryBlock.setSortIndex(3);
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