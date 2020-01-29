package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.db.ImageSize;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.GalleryBlock;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ArticleMapperTest {
    private static final Logger log = LoggerFactory.getLogger(ArticleMapperTest.class);

    ArticleMapper serviceUnderTest = new ArticleMapper();

    @Test
    public void map_article() {
        Article article = anArticle();
        log.info("ARTICLE: {}", article);
        ArticleDto actual = serviceUnderTest.map(article);
        log.info("ArticleDTO: {}", actual);

        assertEquals(actual.getTitle(), article.getTitle());
        assertEquals(actual.getDescription(), article.getDescription());
        assertEquals(actual.getAuthor(), article.getAuthor());
    }

    private Article anArticle() {
        Article article = new Article();
        article.setTitle("Article Nr.: 1001");
        article.setDescription("Article Description 1001");
        article.setAuthor("Max Mustermann");


        Set<ArticleBlock> articleBlocks = new HashSet<>();
        articleBlocks.add(aGalleryBlock());
        article.setBlocks(articleBlocks);

        return article;
    }

    private GalleryBlock aGalleryBlock() {
        List<Image> images = createImages();
        GalleryBlock galleryBlock = new GalleryBlock();
        galleryBlock.setImages(images);

        return galleryBlock;
    }

    private List<Image> createImages() {
        Image image = anImage();
        List<Image> images = new ArrayList<>();
        images.add(image);
        return images;
    }

    private Image anImage() {
        Image image = new Image();
        image.setId(1000L);
        image.setImageSize(ImageSize.MEDIUM);
        image.setUrl("http://boahey.com/myimage.png");
        return image;
    }
}