package solutions;

import java.util.*;

/*
* Дан целочисленный массив nums и целое число k, верните k наиболее
часто встречающихся элементов. Вернуть ответ в любом порядке.
Примечание. Сложность должна быть O(n*log(n)). Докажите сложность.
*/

public class TaskC1 {

    public static void start() {
        int[] nums = {1, 2, 3, 3, 3, 3, 58, 58, 58, 58, 6, 6, 6, 6, 0, 6, 6, 0, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;

        System.out.println("Для массива nums");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.print("\n\n");

        System.out.println(k + " наиболее часто повторяющихся элементов: ");
        for (int res : GetKMostFrequent(nums, k)) {
            System.out.print(res + " ");
        }
    }

    private static int[] GetKMostFrequent(int[] nums, int k) {

        //Создаём Hashmap, где ключ - элемент массива, а значение - число его повторений
        Map<Integer, Integer> occurrences = new HashMap<>();

        //Заполняем HashMap
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        //Полученные пары ключ-значение отсортировать по значению, но для HashMap это сделать невозможно, поэтому
        //переносим пары в List
        List<Map.Entry<Integer, Integer>> sortedOccurrences = new ArrayList<>(occurrences.entrySet());

        //сортируем пары по значению
        sortedOccurrences.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        //В sortedOccurrences пары выстроены так, что чем чаще повторяется элемент, тем ближе он к началу ArrayList-а
        //Таким образом, k наиболее повторяющихся элементов nums занимают первые k элементов sortedOccurrences
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sortedOccurrences.get(i).getKey();
        }

        return result;
    }
}
// доказательство сложности

/*
    // O(1)
    Map<Integer, Integer> occurrences = new HashMap<>();

    // O(n)
    for (int num : nums) {
        occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
    }

    // O(n)
    List<Map.Entry<Integer, Integer>> sortedOccurences = new ArrayList<>(occurrences.entrySet());

    // O(n log n), так как используется сортировка слиянием
    sortedOccurences.sort((a, b) -> b.getValue().compareTo(a.getValue()));

    // не зависит от n
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
        result[i] = sortedOccurences.get(i).getKey();
    }

    Получаем O(1) + O(n) + O(n) + O(n log n) = O(n log n)
 */