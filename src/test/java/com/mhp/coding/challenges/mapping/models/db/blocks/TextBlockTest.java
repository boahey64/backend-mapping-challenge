package com.mhp.coding.challenges.mapping.models.db.blocks;

import com.mhp.coding.challenges.mapping.mappers.BlockDtoMapperGeneric;
import com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlockDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TextBlockTest {
    @Test
    public void map_text_block_to_text_block_dto() {
        TextBlockDto expected = aTextBlockDto(5);

        TextBlock objectUnderTest = aTextBlock(5);

        TextBlockDto actual = callMapAndSetType(objectUnderTest);

        assertEquals(expected.getSortIndex(), actual.getSortIndex());
        assertEquals(expected.getText(), actual.getText());
    }

    @Test
    public void map_text_block_without_text_field_to_text_block_dto() {
        TextBlockDto expected = aTextBlockDtoWithoutText(4);

        TextBlock objectUnderTest = aTextBlockWithoutText(4);

        TextBlockDto actual = callMapAndSetType(objectUnderTest);

        assertEquals(expected.getSortIndex(), actual.getSortIndex());
        assertEquals(expected.getText(), actual.getText());
        assertNull(actual.getText());
    }

    private TextBlockDto callMapAndSetType(TextBlock textBlock) {
        return new BlockDtoMapperGeneric<>(TextBlockDto.class).getType(
                textBlock.map());
    }

    private TextBlockDto aTextBlockDto(int sortIndex) {
        TextBlockDto textBlockDto = new TextBlockDto(sortIndex);
        textBlockDto.setText("Dies ist ein Text");

        return textBlockDto;
    }

    private TextBlockDto aTextBlockDtoWithoutText(int sortIndex) {
        TextBlockDto textBlockDto = new TextBlockDto(sortIndex);

        return textBlockDto;
    }

    private TextBlock aTextBlock(int sortIndex) {
        TextBlock textBlock = new TextBlock();
        textBlock.setSortIndex(sortIndex);
        textBlock.setText("Dies ist ein Text");
        return textBlock;
    }

    private TextBlock aTextBlockWithoutText(int sortIndex) {
        TextBlock textBlock = new TextBlock();
        textBlock.setSortIndex(sortIndex);
        return textBlock;
    }

}