package com.pattern.demo.structural.core.flyweight;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MartixFactory {
	
	private static final Map<MatrixDefinition, Matrix> matrixMap = new HashMap<>();
	
	public static Matrix getMatrix(int rows, int columns) {
		if (Short.MAX_VALUE < rows || Short.MAX_VALUE < columns) throw new IllegalArgumentException();
		MatrixDefinition md = new MatrixDefinition((short)rows, (short)columns);
		Matrix m = matrixMap.get(md);
		if (m == null) {
			m = new Matrix(rows, columns);
			matrixMap.put(md, m);
		}
		return m;
	}
	
	@AllArgsConstructor @Getter
	private static class MatrixDefinition {
		final private short rows;
		final private short columns;
		@Override
		public boolean equals(Object obj) {
			MatrixDefinition m2 = (MatrixDefinition) obj;
			return m2.getColumns() == columns && m2.getRows() == rows;
		}
		@Override
		public int hashCode() {
			return (int)columns | ((int)rows << 16);
		}
	}

}
