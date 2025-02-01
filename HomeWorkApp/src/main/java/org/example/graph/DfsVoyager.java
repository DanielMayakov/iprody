package org.example.graph;

import java.util.Stack;

public class DfsVoyager implements Voyager {

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
                // Если нашли землю (1), запускаем DFS
                if (map[i][j] == 1) {
                    islandCount++;
                    dfs(map, i, j);
                }
            }
        }

        return islandCount;
    }

    private void dfs(int[][] map, int row, int col) {
        // Проверяем границы карты и значение текущей ячейки
        if (row < 0 || row >= map.length || col < 0 || col >= map[0].length || map[row][col] != 1) {
            return;
        }

        // Помечаем текущую ячейку как посещенную (изменяем на 2 или 0)
        map[row][col] = 2;

        // Рекурсивно обходим соседей (вверх, вниз, влево, вправо)
        dfs(map, row - 1, col); // вверх
        dfs(map, row + 1, col); // вниз
        dfs(map, row, col - 1); // влево
        dfs(map, row, col + 1); // вправо
    }
}

