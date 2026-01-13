package solutions;

/*
* Сложность: n log n как для сортировки слиянием
*/
/*

*/
public class InversionsCounter {

    private static long inversions;

    public static long getNumberOfInversions(int[] input) {
        inversions = 0;
        mergeSort(input);
        return inversions;
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex] = left[leftIndex];
                leftIndex++;
            } else {
                /*
                * Получается так, что при слиянии массивов если присоединение левого массива к правому уже
                * порождает отсортированную последовательность, то инферсии в этом массиве быть не может, поскольку с
                * возрастанием индекса возрастает и значение
                *
                * Но если получается так, что число по индексу из правого массива меньше, чем из левого, то здесь
                * создаётся ситуация с инверсией. Рассчитываются они так, что элемент из правого массива в
                * таком случае с каждым элементом из левого массива образуют инверсию.
                *
                * При продвижении выше по дереву этот принцип сохраняется.
                *
                * */
                result[resultIndex] = right[rightIndex];
                inversions += (left.length - leftIndex);
                rightIndex++;
            }
            resultIndex++;
        }

        while (leftIndex < left.length) {
            result[resultIndex] = left[leftIndex];
            leftIndex++;
            resultIndex++;
        }

        while (rightIndex < right.length) {
            result[resultIndex] = right[rightIndex];
            rightIndex++;
            resultIndex++;
        }

        return result;
    }
}