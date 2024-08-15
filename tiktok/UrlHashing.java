package tiktok;
public class UrlHashing {
    public static String hashString(String url, String hashString, int k) {
        StringBuilder retVal = new StringBuilder();
        int n = url.length();
        int m = hashString.length();

        for(int i = 0; i < n; i += k) {
            String block = url.substring(i, Math.min(i + k, n));
            int hashValue = hash(block);
            char hashChar = hashString.charAt(hashValue % m);
            retVal.append(hashChar);
        }


        return retVal.toString();
    }

    public static int hash(String block) {
        int hashValue = 0;
        for(char c : block.toCharArray()) {
            hashValue += getCharValue(c);
        }

        return hashValue;
    }
    
    public static int getCharValue(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else if (c == ':') {
            return 26;
        } else if (c == '/') {
            return 27;
        } else {
            return 28;
        }   
    }


    public static void main(String[] args) {
        String url = "https://xyz.com";
        String hashString = "pqrst";
        int k = 4;

        String hashedURL = hashString(url, hashString, k);
        System.out.println("Hashed URL: " + hashedURL);
    }
}
