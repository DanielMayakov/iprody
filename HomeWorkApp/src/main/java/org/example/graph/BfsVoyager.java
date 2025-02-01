package org.example.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BfsVoyager implements Voyager {

    @Override
    public int lookupIslands(int[][] map) {
        if (map == null || map.length == 0) {
            return 0;
        }

        int rows = map.length;
        int cols = map[0].length;
        int islandCount = 0;

        // Проходим по каждой ячейке карты
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Если нашли землю (1), запускаем BFS
                if (map[i][j] == 1) {
                    islandCount++;
                    bfs(map, i, j);
                }
            }
        }

        return islandCount;
    }

    private void bfs(int[][] map, int startRow, int startCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});

        // Помечаем стартовую ячейку как посещенную
        map[startRow][startCol] = 2;

        // Направления для движения: вверх, вниз, влево, вправо
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // Обходим соседние клетки
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Проверяем границы и значение соседней клетки
                if (newRow >= 0 && newRow < map.length && newCol >= 0 && newCol < map[0].length && map[newRow][newCol] == 1) {
                    queue.add(new int[]{newRow, newCol});
                    map[newRow][newCol] = 2; // Помечаем как посещенную
                }
            }
        }
    }
}

