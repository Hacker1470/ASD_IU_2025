package solutions;

/*
    Дан массив arr из N элементов. Назовем инверсией пару индексов (i, j),
    таких что i < j и arr[i] > arr[j]. Требуется определить количество инверсий в
    данном массиве и вывести их. Дать комментарии. Вычислить сложность.
 */

public class TaskA1 {
    public static void start() {
        int[] arr = {8, 6, 4, 3, 2, 1};
        System.out.println("Для массива arr");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("\n\n");

        System.out.println("Количество инверсий равно: " + InversionsCounter.getNumberOfInversions(arr));
    }
}
