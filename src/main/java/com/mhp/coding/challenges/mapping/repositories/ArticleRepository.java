package com.mhp.coding.challenges.mapping.repositories;

import com.mhp.coding.challenges.mapping.exceptions.ArticleNotAvailableException;
import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.db.ImageSize;
import com.mhp.coding.challenges.mapping.models.db.blocks.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ArticleRepository {
    private Map<Long, Article> articleMap = new HashMap<>();

    public ArticleRepository() {
        articleMap.put(1001L, createDummyArticle(1001L));
        articleMap.put(2002L, createDummyArticle(2002L));
        articleMap.put(3003L, createDummyArticle(3003L));
        articleMap.put(4004L, createDummyArticle(4004L));
        articleMap.put(5005L, createDummyArticle(5005L));

    }

    public List<Article> all(){
        return articleMap.values().stream().collect(Collectors.toList());
    }

    public Article findBy(Long id){
        Article article = articleMap.get(id);
        if(article == null) {
            throw new ArticleNotAvailableException("There is no article for id: " + id);
        }

        return articleMap.get(id);
    }

    public void create(Article article){
        //Ignore
    }

    private Article createDummyArticle(Long id) {
        final Article result = new Article();
        result.setId(id);
        result.setAuthor("Max Mustermann");
        result.setDescription("Article Description " + id);
        result.setTitle("Article Nr.: " + id);
        result.setLastModifiedBy("Hans Müller");
        result.setLastModified(new Date());
        result.setBlocks(createBlocks(id));
        return result;
    }

    private Set<ArticleBlock> createBlocks(Long articleId){
        final Set<ArticleBlock> result = new HashSet<>();

        final TextBlock textBlock = new TextBlock();
        textBlock.setText("Some Text for " + articleId);
        textBlock.setSortIndex(0);
        result.add(textBlock);

        final ImageBlock imageBlock = new ImageBlock();
        imageBlock.setImage(createImage(1L));
        textBlock.setSortIndex(1);
        result.add(imageBlock);

        final TextBlock secondTextBlock = new TextBlock();
        secondTextBlock.setText("Second Text for " + articleId);
        secondTextBlock.setSortIndex(2);
        result.add(secondTextBlock);

        final GalleryBlock galleryBlock = new GalleryBlock();
        secondTextBlock.setSortIndex(3);

        final List<Image> galleryImages = new ArrayList<>();
        galleryImages.add(createImage(2L));
        galleryImages.add(createImage(3L));
        galleryBlock.setImages(galleryImages);

        result.add(galleryBlock);

        final TextBlock thirdTextBlock = new TextBlock();
        thirdTextBlock.setText("Third Text for " + articleId);
        thirdTextBlock.setSortIndex(4);
        result.add(thirdTextBlock);

        final VideoBlock videoBlock = new VideoBlock();
        videoBlock.setType(VideoBlockType.YOUTUBE);
        videoBlock.setUrl("https://youtu.be/myvideo");
        videoBlock.setSortIndex(5);

        result.add(videoBlock);

        return result;
    }

    private Image createImage(Long imageId){
        final Image result = new Image();
        result.setId(imageId);
        result.setLastModified(new Date());
        result.setLastModifiedBy("Max Mustermann");
        result.setImageSize(ImageSize.LARGE);
        result.setUrl("https://someurl.com/image/" + imageId);
        return result;
    }
}
