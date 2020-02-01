package com.mhp.coding.challenges.mapping.models.db.blocks;

import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.Assert.*;

public class NoMappingBlockTest {

    @Test
    public void map_no_mapping_block_to_no_mapping_block_dto() {
        NoMappingBlock objectUnderTest = new NoMappingBlock();

        Throwable e = null;

        try {
            objectUnderTest.map();
        } catch (Throwable ex) {
            e = ex;
        }

        assertTrue(e instanceof NotImplementedException);

    }
}