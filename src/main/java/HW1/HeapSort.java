package HW1;

public class HeapSort {

    public static void heapSort(int[] array) {
        int n = array.length;

        // Построение max-кучи (пирамиды)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Извлечение элементов из кучи по одному и помещение на правильные позиции
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень (наибольший элемент) в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    // Функция для превращения поддерева с корнем i в max-кучу
    static void heapify(int[] array, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int left = 2 * i + 1; // Левый потомок узла i
        int right = 2 * i + 2; // Правый потомок узла i

        // Если левый потомок существует и больше корня
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // Если правый потомок существует и больше, чем текущий "наибольший" элемент
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Рекурсивно вызываем heapify для поддерева, затронутого заменой
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        int n = array.length;

        System.out.println("Исходный массив:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        heapSort(array);

        System.out.println("\nОтсортированный массив:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
