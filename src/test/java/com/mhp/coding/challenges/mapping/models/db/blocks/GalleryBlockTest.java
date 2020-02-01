package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.mappers.BlockDtoMapperGeneric;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.db.ImageSize;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GalleryBlockTest {

    @Test
    public void map_gallery_block_with_one_not_empty_image_in_image_list_to_gallery_block_dto() {
        GalleryBlock objectUnderTest = aGalleryBlock(4);

        GalleryBlockDto expected = anExpectedGalleryBlockDto(4);

        GalleryBlockDto actual = callMapAndSetType(objectUnderTest);

        assertEquals(expected.getSortIndex(), actual.getSortIndex());
        assertEquals(expected.getImages(), actual.getImages());
    }

    @Test
    public void map_gallery_block_with_empty_image_list_to_gallery_block_dto() {
        GalleryBlock objectUnderTest = aGalleryBlockWithEmptyImageList(4);

        GalleryBlockDto expected = anExpectedGalleryBlockDtoWithoutImageList(4);

        GalleryBlockDto actual = callMapAndSetType(objectUnderTest);

        assertEquals(expected.getSortIndex(), actual.getSortIndex());
        assertEquals(expected.getImages(), actual.getImages());
        assertNull(actual.getImages());
    }

    @Test
    public void map_gallery_block_with_empty_image_items_to_gallery_block_dto() {
        GalleryBlock objectUnderTest = aGalleryBlockWithEmptyImageItems(4);

        GalleryBlockDto expected = anExpectedGalleryBlockDtoWithEmptyImageItems(4);

        GalleryBlockDto actual = callMapAndSetType(objectUnderTest);

        assertEquals(expected.getSortIndex(), actual.getSortIndex());
        assertEquals(expected.getImages(), actual.getImages());
        assertEquals(emptyList(), actual.getImages());
    }

    private GalleryBlockDto callMapAndSetType(GalleryBlock galleryBlock) {
        return new BlockDtoMapperGeneric<>(GalleryBlockDto.class).getType(
                galleryBlock.map());
    }

    private GalleryBlockDto anExpectedGalleryBlockDto(int sortIndex) {
        GalleryBlockDto galleryBlockDto = new GalleryBlockDto(sortIndex);
        List<ImageDto> imageDtos = anExpectedImageDtoList();
        galleryBlockDto.setImages(imageDtos);
        return galleryBlockDto;
    }

    private GalleryBlockDto anExpectedGalleryBlockDtoWithEmptyImageItems(int sortIndex) {
        GalleryBlockDto galleryBlockDto = new GalleryBlockDto(sortIndex);
        List<ImageDto> imageDtos = emptyList();
        galleryBlockDto.setImages(imageDtos);
        return galleryBlockDto;
    }

    private GalleryBlockDto anExpectedGalleryBlockDtoWithoutImageList(int sortIndex) {
        GalleryBlockDto galleryBlockDto = new GalleryBlockDto(sortIndex);
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

    GalleryBlock aGalleryBlockWithEmptyImageItems(int sortIndex) {
        GalleryBlock galleryBlock = new GalleryBlock();
        galleryBlock.setSortIndex(sortIndex);
        List<Image> images = Lists.newArrayList(null, null);
        galleryBlock.setImages(images);
        return galleryBlock;
    }

    GalleryBlock aGalleryBlockWithEmptyImageList(int sortIndex) {
        GalleryBlock galleryBlock = new GalleryBlock();
        galleryBlock.setSortIndex(sortIndex);
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