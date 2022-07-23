class Solution {
    private int[] countArr;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        countArr = new int[n];

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr);

        return Arrays.stream(countArr).boxed().toList();
    }

    public void mergeSort(Pair[] arr) {
        int n = arr.length;
        if (n < 2) return;

        Pair[] leftHalf = Arrays.copyOfRange(arr, 0, n / 2);
        Pair[] rightHalf = Arrays.copyOfRange(arr, n / 2, n);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(arr, leftHalf, rightHalf);
    }

    private void merge(Pair[] arr, Pair[] leftHalf, Pair[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0, rightCounter = 0;
        while (i < leftSize && j < rightSize) {
            if (rightHalf[j].val < leftHalf[i].val) {
                arr[k++] = rightHalf[j++];
                rightCounter++;

            } else {
                countArr[leftHalf[i].index] += rightCounter;
                arr[k++] = leftHalf[i++];
            }
        }

        while (i < leftSize) {
            countArr[leftHalf[i].index] += rightCounter;
            arr[k++] = leftHalf[i++];
        }

        while (j < rightSize) {
            arr[k++] = rightHalf[j++];
        }
    }
}

class Pair {
    int val;
    int index;
    
    public Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}
