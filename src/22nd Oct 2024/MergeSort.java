public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,8,2,4,7};

        Divider(arr, 0, arr.length-1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void Divider(int[] arr,int l,int r){
        if(l >= r) return;

        int mid = (l+r)/2;

        Divider(arr, l, mid);
        Divider(arr, mid+1, r);

        Sorter(arr, l, mid, r);
    }

    static void Sorter(int[] arr,int l,int mid,int r){
        int n1 = mid-l+1;
        int n2 = r-mid;

        int[] larr = new int[n1];
        int[] rarr = new int[n2];

        for (int i = 0; i < n1; i++) {
            larr[i] = arr[l + i];
        }

        for (int j = 0; j < n2; j++) {
            rarr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (larr[i] <= rarr[j]) {
                arr[k] = larr[i];
                i++;
            } else {
                arr[k] = rarr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = larr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rarr[j];
            j++;
            k++;
        }
    }
}
