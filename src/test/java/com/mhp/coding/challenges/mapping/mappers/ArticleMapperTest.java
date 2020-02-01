package com.mhp.coding.challenges.mapping.mappers;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.db.ImageSize;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.GalleryBlock;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.util.streamex.StreamEx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ArticleMapperTest {
    private static final Logger log = LoggerFactory.getLogger(ArticleMapperTest.class);
    ArticleMapper serviceUnderTest = new ArticleMapper();

    @Test
    public void map_article_with_one_gallery_block() {
        Article article = anArticleWithOneGalleryBlock();
        log.info("ARTICLE: {}", article);
        ArticleDto actual = serviceUnderTest.map(article);
        log.info("ArticleDTO: {}", actual);

        assertEquals(actual.getTitle(), article.getTitle());
        assertEquals(actual.getDescription(), article.getDescription());
        assertEquals(actual.getAuthor(), article.getAuthor());

        assertNotNull(actual.getBlocks());
        assertEquals(actual.getBlocks().size(), 1);
        assert(actual.getBlocks().toArray()[0] instanceof GalleryBlockDto);

        GalleryBlockDto galleryBlockDto = (GalleryBlockDto)actual.getBlocks().toArray()[0];
        assertEquals(galleryBlockDto.getSortIndex(), aGalleryBlock(1).getSortIndex());
        assertEquals(galleryBlockDto.getImages().get(0).getId(), aGalleryBlock(1).getImages().get(0).getId());
        assertEquals(
                galleryBlockDto.getImages().get(0).getImageSize(),
                aGalleryBlock(1).getImages().get(0).getImageSize()
        );
        assertEquals(
                galleryBlockDto.getImages().get(0).getUrl(),
                aGalleryBlock(1).getImages().get(0).getUrl()
        );

    }

    @Test
    public void map_article_with_three_unsorted_gallery_blocks() {
        Article article = anArticleWithThreeGalleryBlock();
        log.info("ARTICLE: {}", article);
        ArticleDto actual = serviceUnderTest.map(article);
        log.info("ArticleDTO: {}", actual);

        assertEquals(actual.getTitle(), article.getTitle());
        assertEquals(actual.getDescription(), article.getDescription());
        assertEquals(actual.getAuthor(), article.getAuthor());

        assertNotNull(actual.getBlocks());
        assertEquals(actual.getBlocks().size(), 3);
        assert(actual.getBlocks().toArray()[0] instanceof GalleryBlockDto);

        assert(areBlocksSorted(actual));
    }

    private boolean areBlocksSorted(ArticleDto actual) {
        return StreamEx.of(actual.getBlocks())
                .pairMap((a, b) -> a.compareTo(b) <= 0)
                .allMatch(e -> e);
    }

    private Article anArticleWithOneGalleryBlock() {
        Article article = new Article();
        article.setTitle("Article Nr.: 1001");
        article.setDescription("Article Description 1001");
        article.setAuthor("Max Mustermann");


        Set<ArticleBlock> articleBlocks = new HashSet<>();
        articleBlocks.add(aGalleryBlock(1));
        article.setBlocks(articleBlocks);

        return article;
    }

    private Article anArticleWithThreeGalleryBlock() {
        Article article = new Article();
        article.setTitle("Article Nr.: 1001");
        article.setDescription("Article Description 1001");
        article.setAuthor("Max Mustermann");


        Set<ArticleBlock> articleBlocks = new HashSet<>();
        articleBlocks.add(aGalleryBlock(2));
        articleBlocks.add(aGalleryBlock(1));
        articleBlocks.add(aGalleryBlock(0));
        article.setBlocks(articleBlocks);

        return article;
    }

    private GalleryBlock aGalleryBlock(int sortIndex) {
        List<Image> images = createImages();
        GalleryBlock galleryBlock = new GalleryBlock();
        galleryBlock.setImages(images);
        galleryBlock.setSortIndex(sortIndex);

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