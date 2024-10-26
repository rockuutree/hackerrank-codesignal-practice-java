public class Alternating {
    public static void main (String[] args) {
        int[] test1 = {0,4,3,2,1};
        int[] retVal = solution(test1);
        System.out.println(java.util.Arrays.toString(retVal));
        // Output = [0,1,4,2,3]
    }

    public static int[] solution(int[] array) {
        int[] retVal = new int[array.length];
        int start = 0;
        int end = array.length - 1;
        int i = 0;
        while(start <= end) {
            if(start == end) {
                retVal[i++] = array[start];
            } else {
                retVal[i++] = array[start];
                retVal[i++] = array[end];
            }
            start++;
            end--;
        }
        return retVal;
    }
}