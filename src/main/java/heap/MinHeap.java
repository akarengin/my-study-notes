package heap;

import java.util.*;

public class MinHeap {
    static Map<Integer, Integer> valueIndex = new HashMap<>();
    static int[] heap = new int[500002];
    static int heapSize = 0;

    static void insertVal(int val) {
        if (heapSize == 0) {
            heap[++heapSize] = val;
            valueIndex.put(val, heapSize);
            return;
        }
        heap[++heapSize] = val;
        valueIndex.put(val, heapSize);
        int iter = heapSize;
        while (iter > 1) {
            if (heap[iter] < heap[iter / 2]) {
                valueIndex.put(heap[iter], iter / 2);
                valueIndex.put(heap[iter / 2], iter);
                int temp = heap[iter];
                heap[iter] = heap[iter / 2];
                heap[iter / 2] = temp;
                iter /= 2;
            } else
                break;
        }
    }

    static void deleteVal(int val) {
        int index = valueIndex.get(val);
        valueIndex.put(val, 0);
        valueIndex.put(heap[heapSize], index);
        heap[index] = heap[heapSize--];
        while (true) {
            int leftChild = 2 * index, rightChild = 2 * index + 1;
            if (leftChild <= heapSize) {
                if (rightChild <= heapSize) {
                    if (heap[index] > heap[leftChild] || heap[index] > heap[rightChild]) {
                        int swapIndex = (heap[leftChild] < heap[rightChild]) ? leftChild : rightChild;
                        valueIndex.put(heap[swapIndex], index);
                        valueIndex.put(heap[index], swapIndex);
                        int temp = heap[index];
                        heap[index] = heap[swapIndex];
                        heap[swapIndex] = temp;
                        index = swapIndex;
                    } else
                        break;
                } else {
                    if (heap[index] > heap[leftChild]) {
                        valueIndex.put(heap[leftChild], index);
                        valueIndex.put(heap[index], leftChild);
                        int temp = heap[index];
                        heap[index] = heap[leftChild];
                        heap[leftChild] = temp;
                        index = leftChild;
                    } else
                        break;
                }
            } else
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int type = scanner.nextInt();
            if (type == 1) {
                int val = scanner.nextInt();
                insertVal(val);
            } else if (type == 2) {
                int val = scanner.nextInt();
                deleteVal(val);
            } else {
                System.out.println(heap[1]);
            }
        }
        scanner.close();
    }
}
