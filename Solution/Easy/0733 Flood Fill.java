class Solution {
   public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] newImage = Arrays.stream(image).map(int[]::clone).toArray(int[][]::new);
        if (image[sr][sc] == newColor) {
            return image;
        } else {
            newImage[sr][sc] = newColor;
            fillAdjacent(newImage, sr, sc, image[sr][sc], newColor);
            return newImage;
        }
    }

    private void fillAdjacent(int[][] newImage, int row, int column, int targetColor, int newColor) {
        try {
            if (newImage[row - 1][column] == targetColor) {
                newImage[row - 1][column] = newColor;
                fillAdjacent(newImage, row - 1, column, targetColor, newColor);
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (newImage[row + 1][column] == targetColor) {
                newImage[row + 1][column] = newColor;
                fillAdjacent(newImage, row + 1, column, targetColor, newColor);
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (newImage[row][column - 1] == targetColor) {
                newImage[row][column - 1] = newColor;
                fillAdjacent(newImage, row, column - 1, targetColor, newColor);
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (newImage[row][column + 1] == targetColor) {
                newImage[row][column + 1] = newColor;
                fillAdjacent(newImage, row, column + 1, targetColor, newColor);
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
    }
}
