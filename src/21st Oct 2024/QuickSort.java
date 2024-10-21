public class QuickSort {
    static void quickSort(int[] arr, int st, int end) {
        if (st >= end) return;

        int PivotIdx = partition(arr, st, end);

        quickSort(arr, st, PivotIdx - 1);
        quickSort(arr, PivotIdx + 1, end);
    }

    static int partition(int[] arr, int st, int end) {
        int Pivot = arr[end];
        int i = st - 1;

        for (int j = st; j < end; j++) {
            if (arr[j] < Pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        int temp = arr[end];
        arr[end] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 11, 9, 8, 7};

        quickSort(arr, 0, arr.length - 1);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}