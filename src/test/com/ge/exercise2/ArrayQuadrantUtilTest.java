package com.ge.exercise2;

import org.junit.Assume;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayQuadrantUtilTest {

    @Test
    public void getQuadrantValuesTest() {
        Object[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getQuadrantValues(0, 0));

        Object[] expectedResult = {'a', 'b', 'e', 'f'};
        assertArrayEquals(expectedResult, util.getQuadrantValues(0, 0));
    }
    
    @Test
    public void getArrayRowTest() {
        Object[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getArrayRow(1));

        Object[] expectedResult = {'e', 'f', 'g', 'h'};
        assertArrayEquals(expectedResult, util.getArrayRow(1));
    }
    
    @Test
    public void getArrayColumnnTest() {
        Object[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getArrayColumn(1));

        Object[] expectedResult = {'b', 'f', 'j', 'n'};
        assertArrayEquals(expectedResult, util.getArrayColumn(1));
    }
}