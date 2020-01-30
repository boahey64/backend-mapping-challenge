package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.mappers.BlockDtoMapperGeneric;
import com.mhp.coding.challenges.mapping.mappers.ImageMapper;
import com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlockDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextBlockTest {
    private TextBlock objectUnderTest = aTextBlock(5);


    ImageMapper imageMapper = new ImageMapper();

    @Test
    public void map_text_block_to_text_block_dto() {
        TextBlockDto expected = aTextBlockDto(5);

        TextBlockDto actual = new BlockDtoMapperGeneric<>(TextBlockDto.class).getType(
                objectUnderTest.map(imageMapper));

        assertEquals(expected.getSortIndex(), actual.getSortIndex());
        assertEquals(expected.getText(), actual.getText());
    }

    private TextBlockDto aTextBlockDto(int sortIndex) {
        TextBlockDto textBlockDto = new TextBlockDto(sortIndex);
        textBlockDto.setText("Dies ist ein Text");

        return textBlockDto;
    }

    private TextBlock aTextBlock(int sortIndex) {
        TextBlock textBlock = new TextBlock();
        textBlock.setSortIndex(sortIndex);
        textBlock.setText("Dies ist ein Text");
        return textBlock;
    }
}