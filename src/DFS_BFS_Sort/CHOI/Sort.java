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


    public static void main(String[] args) {
        selection();
//        insertion();
    }
}
