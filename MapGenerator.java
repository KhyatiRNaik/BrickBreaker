import java.awt.*;

public class MapGenerator {
    public int map[][];
    public int brickHeight;
    public int brickWidth;

    public MapGenerator(int row, int col) {

        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = 1;
            }
        }

        brickWidth = 540 / col;
        brickHeight = 150 / row;
    }

    public void setBrick(int value, int r, int c) {
        map[r][c] = value;
    }

    public void draw(Graphics2D g) {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                if (map[i][j] > 0) {

                    // brick
                    Color baseColor = new Color(255, 215, 0); // Gold color
                    Color shadowColor = new Color(200, 160, 0); // darker gold for shadow
                    Color highlightColor = new Color(255, 230, 100); // lighter gold for highlight

                    int x = j * brickWidth + 80;
                    int y = i * brickHeight + 50;
                    int width = brickWidth;
                    int height = brickHeight;
                    int bevelSize = 25;

                    // base rectangle
                    g.setColor(baseColor);
                    g.fillRect(x, y, width, height);

                    // shadow effect
                    g.setColor(shadowColor);
                    g.fillRect(x, y + 25, width, height / 2);

                    // left bevel triangle
                    int[] xPointsLeft = { x, x, x + bevelSize - 5 };
                    int[] yPointsLeft = { y, y + 50, y + bevelSize };
                    g.setColor(highlightColor);
                    g.fillPolygon(xPointsLeft, yPointsLeft, 3);

                    // right bevel triangle
                    int[] xPointsRight = { x + width, x + width, x + width - bevelSize + 5 };
                    int[] yPointsRight = { y, y + 50, y + bevelSize };
                    g.setColor(shadowColor);
                    g.fillPolygon(xPointsRight, yPointsRight, 3);

                    // highlight effect
                    g.setColor(highlightColor);
                    g.drawRect(x, y, width, height);

                }
            }
        }

    }

}
