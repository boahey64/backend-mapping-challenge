package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.mappers.ImageMapper;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlockDto;

public class VideoBlock extends ArticleBlock {

    private String url;

    private VideoBlockType type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public VideoBlockType getType() {
        return type;
    }

    public void setType(VideoBlockType type) {
        this.type = type;
    }

    @Override
    public ArticleBlockDto map(ImageMapper imageMapper) {
        VideoBlockDto videoBlockDto = new VideoBlockDto(this.getSortIndex());
        videoBlockDto.setType(this.getType());
        videoBlockDto.setUrl(this.getUrl());

        return videoBlockDto;
    }
}
