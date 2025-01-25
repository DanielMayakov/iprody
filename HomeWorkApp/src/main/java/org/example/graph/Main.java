package org.example.graph;

public class Main {
    public static void main(String[] args) {
        // Пример карты
        int[][] map = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1}
        };

        // Используем DFS-реализацию
        Voyager dfsVoyager = new DfsVoyager();
        System.out.println("Количество островов (DFS): " + dfsVoyager.lookupIslands(copyMap(map)));

        // Используем BFS-реализацию
        Voyager bfsVoyager = new BfsVoyager();
        System.out.println("Количество островов (BFS): " + bfsVoyager.lookupIslands(copyMap(map)));
    }

    // Вспомогательный метод для копирования карты
    private static int[][] copyMap(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, original[0].length);
        }
        return copy;
    }
}
