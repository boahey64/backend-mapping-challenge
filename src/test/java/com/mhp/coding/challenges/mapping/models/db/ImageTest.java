package com.mhp.coding.challenges.mapping.models.db;

import com.mhp.coding.challenges.mapping.models.dto.ImageDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImageTest {

    @Test
    public void map_image_to_image_dto() {
        Image objectUnderTest = anImage();

        ImageDto actual = objectUnderTest.map();

        assertEquals(objectUnderTest.getId(), actual.getId());
        assertEquals(objectUnderTest.getImageSize(), actual.getImageSize());
        assertEquals(objectUnderTest.getUrl(), actual.getUrl());
    }

    private Image anImage() {
        Image image = new Image();
        image.setId(1L);
        image.setImageSize(ImageSize.MEDIUM);
        image.setUrl("http://fakeurl.com/image.png");

        return image;
    }
}