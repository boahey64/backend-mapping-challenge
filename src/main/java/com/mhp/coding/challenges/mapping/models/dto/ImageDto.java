package com.mhp.coding.challenges.mapping.models.dto;

import com.mhp.coding.challenges.mapping.models.db.ImageSize;

import java.util.Objects;

public class ImageDto {

    private Long id;

    private String url;

    private ImageSize imageSize;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageSize getImageSize() {
        return imageSize;
    }

    public void setImageSize(ImageSize imageSize) {
        this.imageSize = imageSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ImageDto{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", imageSize=" + imageSize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageDto imageDto = (ImageDto) o;
        return Objects.equals(id, imageDto.id) &&
                Objects.equals(url, imageDto.url) &&
                imageSize == imageDto.imageSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, imageSize);
    }
}
