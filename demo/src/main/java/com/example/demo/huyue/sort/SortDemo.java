package com.example.demo.huyue.sort;

import java.util.ArrayList;

/**
 * @author huyue01@sinovatech.com 2019/4/1 12:44
 */
public class SortDemo {
    private static void maoPaoSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(arr.toString());
    }

    private static void xuanzeSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        System.out.println(arr.toString());
    }

    private static void insertSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int j;
            for (j = i - 1; j >= 0 && arr[i] < arr[j]; j--) {

            }
            //这里跳出内层循环，a[i]应被插入到a[j]后
            int tmp = arr[i];
            for (int k = i; k > j + 1; k--) {
                arr[k] = arr[k - 1];
            }
            arr[j + 1] = tmp;
        }
        System.out.println(arr.toString());
    }

    private static void xierSort(int[] arr) {
        int length = arr.length;
        int h = 1;
        while (h < length / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            int n, i, j, k;
            //分割后，产生n个子序列
            for (n = 0; n < h; n++) {
                //分别对每个子序列进行插入排序
                for (i = n + h; i < length; i += h) {
                    for (j = i - h; j >= 0 && arr[i] < arr[j]; j -= h) {

                    }
                    int tmp = arr[i];
                    for (k = i; k > j + h; k -= h) {
                        arr[k] = arr[k - h];
                    }
                    arr[j + h] = tmp;
                }
            }
            h = h / 3;
        }
    }

    private static void guibinSort(int[] arr, int low, int mid, int high) {
        int i = low; //左数组下一个要进行比较的元素的索引
        int j = mid + 1; //右数组下一个要进行比较的元素的索引
        int N = high + 1; //本次归并的元素数目
        int[] tmpArray = new int[N]; //用于暂时存放比较后的元素
        for (int k = low; k <= high; k++) {
            if (i > mid) {  //左数组元素已全比较完
                tmpArray[k] = arr[j++];
            } else if (j > high) { //右数组元素已全比较完
                tmpArray[k] = arr[i++];
            } else if (arr[j] < arr[i]) { //右数组元素小于左数组
                tmpArray[k] = arr[j++];
            } else {  //右数组元素大于等于左数组
                tmpArray[k] = arr[i++];
            }
        }
        for (int k = low; k < N; k++) {
            arr[k] = tmpArray[k];
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (high <= low) {
            return;
        }

        int i = low + 1;
        int j = high + 1;
        int p = arr[low];
        while (true) {
            while (arr[++i] < p) {
                if (i == high) {
                    break;
                }
            }
            while (arr[--j] > p) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            exchange(arr,i,j);
        }

        exchange(arr,low,j);

        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);

        System.out.println(arr.toString());
    }


    private static void heapSort(int[] a) {
        int N = a.length - 1;
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exchange(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void sink(int[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && a[j] < a[j + 1]) {
                j++;
            }
            if (a[k] >= a[j]) {
                break;
            }
            exchange(a, k, j);
            k = j;
        }
    }

    private static void exchange(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<Integer>(k);
        int low = 0;
        int high = input.length - 1;
        int j = partition(input, low, high);
        while (j != k-1){
            if (j > k-1){
                high = j - 1;
            } else {
                low = j + 1;
            }
            partition(input, low, high);
        }

        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private static int partition(int[] a, int low, int high) {
        int i = low;
        int j = high + 1;

        int p = a[low];
        while (true) {
            while (a[++i] < p) {
                if (i == high) {
                    break;
                }
            }

            while (a[--j] > p) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        exchange(a, low, j);
        return j;
    }
}
