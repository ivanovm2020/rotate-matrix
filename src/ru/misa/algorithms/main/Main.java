package ru.misa.algorithms.main;

public class Main {
    /*
    Имеется изображение, представленное матрицей N×N; каждый пиксел представлен 4 байтами.
    Напишите метод для поворота изображения на 90 градусов. Удастся ли вам выполнить эту операцию «на месте»?
     */
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0, 0}, {1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}};
        print(arr);
        rotate(arr, 4);
        System.out.println();
        print(arr);
    }
    static void print(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; ++layer) { // кол-во слоев 0(1)
            int first = layer;                        // 0(1)
            int last = n - 1 - layer;                 // 3(2)
            for (int i = first; i < last; ++i) {      // 0(3) 1(2)
                int offset = i - first;               // 0,1,2
                int top = matrix[first][i];                                  // Сохранить верхнюю сторону
                matrix[first][i] = matrix[last - offset][first];             // левая сторона -> верхняя сторона
                matrix[last - offset][first] = matrix[last][last - offset];  // нижняя сторона -> левая сторона
                matrix[last][last - offset] = matrix[i][last];               // правая сторона -> нижняя сторона
                matrix[i][last] = top;                                       // верхняя сторона -> правая сторона
            }
        }
    }
}