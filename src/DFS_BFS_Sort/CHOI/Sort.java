package DFS_BFS_Sort.CHOI;

public class Sort {
    private static final int[] ORIGINAL_LIST = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

    public static int swap(int x, int y) { // 스왑
        return x;
    }

    public static void selection() { // 선택 정렬
        int[] list = ORIGINAL_LIST;
        int min = 0;

        for (int i = 0; i < list.length - 1; i++) {
            min = i;

            for (int j = i + 1; j < list.length; j++) {
                if (list[min] > list[j]) {
                    min = j;
                }
            }

            list[i] = swap(list[min], list[min] = list[i]);
        }

        for (int i : list)
            System.out.print(i + " ");
    }

    public static void insertion() { // 삽입 정렬
        int[] list = ORIGINAL_LIST;

        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0 && list[j - 1] > list[j]; j--) {  // j > 0 이고 j - 1 이 j 보다 작으면 계속
                list[j - 1] = swap(list[j], list[j] = list[j - 1]); // 스왑
            }
        }

        for (int i : list)
            System.out.print(i + " ");
    }

    public static void quick() { // 퀵 정렬
        int[] list = ORIGINAL_LIST;

        repeat(list, 0, list.length - 1);

        for (int i : list)
            System.out.print(i + " ");
    }

    public static void repeat(int[] temp, int start, int end) {
        if (start >= end)
            return;

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (true) {
            if (left > right)
                break;

            while (left <= end && temp[left] <= temp[pivot]) {
                left++;
            }

            while (right > start && temp[right] >= temp[pivot]) {
                right--;
            }

            if (left > right) {
                temp[left] = swap(temp[right], temp[right] = temp[left]);
            } else {
                temp[right] = swap(temp[left], temp[left] = temp[right]);
            }
        }

        repeat(temp, start, right - 1);
        repeat(temp, right + 1, end);

        for (int i : temp)
            System.out.print(i + " ");

    }


    public static void main(String[] args) {
//        selection();
//        insertion();
        quick();
    }
}
