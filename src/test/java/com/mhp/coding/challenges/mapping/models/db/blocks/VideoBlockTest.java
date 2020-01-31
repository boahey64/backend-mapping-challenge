package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.mappers.BlockDtoMapperGeneric;
import com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlockDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VideoBlockTest {
    @Test
    public void map_video_block_to_video_block_dto() {
        VideoBlockDto expected = anExpectedVideoBlockDto();

        VideoBlock objectUnderTest = aVideoBlock();

        VideoBlockDto actual = callMapAndSetType(objectUnderTest);

        assertEquals(expected.getType(), actual.getType());
        assertEquals(expected.getUrl(), actual.getUrl());
    }

    private VideoBlockDto anExpectedVideoBlockDto() {
        VideoBlockDto videoBlockDto = new VideoBlockDto(3);
        videoBlockDto.setType(VideoBlockType.VIMEO);
        videoBlockDto.setUrl("http://fakevideo.com/video.avi");

        return videoBlockDto;
    }


    private VideoBlockDto callMapAndSetType(VideoBlock galleryBlock) {
        return new BlockDtoMapperGeneric<>(VideoBlockDto.class).getType(
                galleryBlock.map(null));
    }

    private VideoBlock aVideoBlock() {
        VideoBlock videoBlock = new VideoBlock();
        videoBlock.setSortIndex(3);
        videoBlock.setType(VideoBlockType.VIMEO);
        videoBlock.setUrl("http://fakevideo.com/video.avi");

        return videoBlock;
    }
}