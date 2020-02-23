package com.ge.exercise2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayQuadrantUtil {
    private static final Logger logger = LogManager.getLogger(ArrayQuadrantUtil.class);

    Object[][] data;

    public ArrayQuadrantUtil(Object[][] data) {
        this.data = data;
    }
    
    public Object[] getArrayRow(int row) {
    	Object[] rowArray = new Object[data.length];
    	
    	for(int i=0;i<data.length;i++) {
    		rowArray[i] = data[row][i];
    	}
    	
    	return rowArray;
    }
    
    public Object[] getArrayColumn(int column) {
    	Object[] colArray = new Object[data.length];
    	
    	for(int i=0;i<data.length;i++) {
    		colArray[i] = data[i][column];
    	}
    	
    	return colArray;
    }

    public Object[] getQuadrantValues(int row, int column) {
    	Object[] quadrant = new Object[data.length];
    	
    	quadrant[0] = data[row][column];
    	quadrant[1] = data[row][column+1];
    	quadrant[2] = data[row+1][column];
    	quadrant[0] = data[row+1][column+1];
    	
        return quadrant;
    }
}
