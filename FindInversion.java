public class FindInversion {
    public void findInversions() throws Exception {

        File file = new File("user.dir/IntegerArray.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        int[] n = new int[100000];
        int i = 0;
        String st;
        while ((st = br.readLine()) != null)
            n[i++] = Integer.parseInt(st);

//        int[] n = {1,5,3,4,2,6};
        long inversionCount = getInversionCount(n);
        System.out.println("array: " + Arrays.toString(n));
        System.out.println("count of inversions: "+ inversionCount);
    }

    private long getInversionCount(int[] n) {
        return sortAndCount(n, 0, n.length - 1);
    }

    private long sortAndCount(int[] n, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;

            long a = sortAndCount(n, start, mid);
            long b = sortAndCount(n, mid + 1, end);

            long x = mergeAndCount(n, start, mid, end);
            return a + b + x;
        }
        return 0;
    }

    private long mergeAndCount(int[] n, int start, int mid, int end) {
        long inversionCount = 0;
        int l1 = mid - start + 1;
        int l2 = end - mid;
        int left[] = new int[l1];
        int right[] = new int[l2];

        for(int i = 0; i < l1; i++) {
            left[i] = n[start + i];
        }

        for( int i = 0; i < l2; i++) {
            right[i] = n[mid + 1 + i];
        }


        int i = 0, j = 0, k = start;
        while( i < l1 && j < l2) {
            if(left[i] <= right[j]) {
                n[k++] = left[i++];
            } else {
                n[k++] = right[j++];
                inversionCount += l1 - i;
            }
        }

        while(i < l1) {
            n[k++] = left[i++];
        }

        while(j < l2) {
            n[k++] = right[j++];
        }

        return inversionCount;
    }

}
