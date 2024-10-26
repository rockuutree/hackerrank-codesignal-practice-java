package RandomLC;
public class StringSum {
    public static void main (String[] args) {
        String a = "99";
        String b = "99";
        System.out.println(solution(a,b));


    }

    public static String solution(String a, String b) {
        int nLong = a.length();
        int nShort = b.length();
        String retVal = "";
        if(a.length() < b.length()) {
            nLong = b.length();
            nShort = a.length();
            for(int i = nShort; i < nLong; i++) {
                retVal = Character.toString(b.charAt(i)) + retVal;
            }
        } else {
            for(int i = nShort; i < nLong; i++) {
                retVal = Character.toString(a.charAt(i)) + retVal;
            }
        }
        
        for(int i = 0; i < nShort; i++) {
            int sum = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(i));
            retVal = retVal + Integer.toString(sum);
        }

        return retVal;


    }
}

/* claude better ans
 * 
 * 
 * public static String solution(String a, String b) {
        String result = "";
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0) {
                sum += Character.getNumericValue(a.charAt(i));
                i--;
            }
            if (j >= 0) {
                sum += Character.getNumericValue(b.charAt(j));
                j--;
            }
            result =  Integer.toString(sum) + result;
        }
        
        return result;
    }
 * 
 */
