public class Main{
    public static void main(String[] args){
        int[] arr = {12,11,13,5,6,7};

        Heapsort hs = new Heapsort();

        hs.sort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}

class Heapsort{
    void sort(int arr[]){
        int n = arr.length;
        for(int i = n/2; i >= 0; i--){
            heapify(arr,i,n);
        }

        for(int i = n-1; i >= 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr,0,i);
        }
    }

    void heapify(int[] arr,int idx, int len){
        int parent = idx;
        int left = 2*idx+1;
        int right = 2*idx+2;

        if(left < len && arr[parent] < arr[left]){
            int temp = arr[parent];
            arr[parent] = arr[left];
            arr[left] = temp;
        }

        if(right < len && arr[parent] < arr[right]){
            int temp = arr[parent];
            arr[parent] = arr[right];
            arr[right] = temp;
        }

        if(parent != idx){
            int temp = arr[parent];
            arr[parent] = arr[idx];
            arr[idx] = temp;

            heapify(arr,parent,len);
        }
    }
}