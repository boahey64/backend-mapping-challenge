package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.mappers.BlockDtoMapperGeneric;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlockDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImageBlockTest {

    @Test
    public void map_image_block_with_existing_image_to_image_block_dto() {
        ImageBlock objectUnderTest = anImageBlock();
        ImageBlockDto expected = anImageBlockDto(2);

        ImageBlockDto actual = callMapAndSetType(objectUnderTest);

        assertEquals(expected.getSortIndex(), actual.getSortIndex());
        assertEquals(expected.getImage(), actual.getImage());

    }

    @Test
    public void map_image_block_without_existing_image_to_image_block_dto() {
        ImageBlock objectUnderTest = anImageWithEmptyImageField();
        ImageBlockDto expected = anImageBlockDto(2);

        ImageBlockDto actual = callMapAndSetType(objectUnderTest);

        assertEquals(expected.getSortIndex(), actual.getSortIndex());
    }

    private ImageBlockDto callMapAndSetType(ImageBlock imageBlock) {
        return new BlockDtoMapperGeneric<>(ImageBlockDto.class).getType(
                imageBlock.map(null));
    }

    private ImageBlock anImageBlock() {
        ImageBlock imageBlock = new ImageBlock();
        imageBlock.setSortIndex(2);
        Image image = new Image();
        image.setId(3L);
        imageBlock.setImage(image);
        return imageBlock;
    }

    private ImageBlock anImageWithEmptyImageField() {
        ImageBlock imageBlock = new ImageBlock();
        imageBlock.setSortIndex(2);
        return imageBlock;
    }

    private ImageBlockDto anImageBlockDto(int sortIndex) {
        ImageBlockDto imageBlockDto = new ImageBlockDto(sortIndex);
        imageBlockDto.setSortIndex(sortIndex);
        ImageDto imageDto = new ImageDto();
        imageDto.setId(3L);
        imageBlockDto.setImage(imageDto);
        return imageBlockDto;
    }
}