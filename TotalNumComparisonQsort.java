public class TotalNumComparisonQsort {
    public static Integer count = 0;

    @Test
    public void quickSortPrograms() throws IOException {
        File file = new File("user.dir/week3_QuickSort.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        int[] a = new int[10000];
        int i = 0;
        String st;
        while ((st = br.readLine()) != null)
            a[i++] = Integer.parseInt(st);
//        int[] a = {2,1,3,5,6,4};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        System.out.println(count);
    }

    private void sort(int[] a, int left, int right) {
        if (left < right) {
            int partitionedIndex = partition(a, left, right);
            count += right - left;
            sort(a, left, partitionedIndex - 1);
            sort(a, partitionedIndex + 1, right);
        }
    }

    private int partition(int[] a, int left, int right) {
        int pivot = a[left];
        int i = left + 1;
        for (int j = left + 1; j <= right; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i - 1, left);
        return i - 1;
    }

    private int partition1(int[] a, int left, int right) {
        swap(a, left, right);
        int pivot = a[left];
        int i = left + 1;
        for (int j = left + 1; j <= right; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i - 1, left);
        return i - 1;
    }

    private int partition2(int[] a, int left, int right) {
        int median = findMedian(a, left, right);
        swap(a, left, median);
        int pivot = a[left];
        int i = left + 1;
        for (int j = left + 1; j <= right; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i - 1, left);
        return i - 1;
    }
}