package com.mhp.coding.challenges.mapping.controllers;


import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.services.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ArticleControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    private String path = "/article";

    @Test
    public void call_list_endpoint() throws Exception {
        when(articleService.list()).thenReturn(anArticleList());

        mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(path))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(3)))
                .andExpect(jsonPath("$[0].title", equalTo("the title")))
                .andExpect(jsonPath("$[0].description", equalTo("the description")))
                .andExpect(jsonPath("$[0].author", equalTo("Max Mustermann")))
        ;
    }

    @Test
    public void call_item_endpoint() throws Exception {
        when(articleService.articleForId(3L)).thenReturn(anArticleDto());

        mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(path + "/3"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", equalTo(3)))
                .andExpect(jsonPath("$.title", equalTo("the title")))
                .andExpect(jsonPath("$.description", equalTo("the description")))
                .andExpect(jsonPath("$.author", equalTo("Max Mustermann")))
        ;
    }

    private List<ArticleDto> anArticleList() {
        List<ArticleDto> articleList = new ArrayList<>();
        ArticleDto articleDto = anArticleDto();
        articleList.add(articleDto);
        return articleList;
    }

    private ArticleDto anArticleDto() {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(3L);
        articleDto.setTitle("the title");
        articleDto.setDescription("the description");
        articleDto.setAuthor("Max Mustermann");
        return articleDto;
    }

}