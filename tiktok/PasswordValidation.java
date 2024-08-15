package tiktok;
// Password Validation
import java.util.ArrayList;
import java.util.List;

public class PasswordValidation {
    
    public static List<String> validatePasswords(List<String> passwords, List<String> weakPassword) {
        List<String> retVal = new ArrayList<>();
        

        for(String password: passwords) {
            boolean level = isWeak(password, weakPassword);
            
            if(level) {
                retVal.add("weak");
            } else {
                retVal.add("strong");
            }

        }

        return retVal;

    }

    public static boolean isWeak(String password, List<String> dictionary) {
        // shorter than 6 char
        if(password.length() < 6) {
            return true;
        }

        if(password.equals(password.toUpperCase()) || password.equals(password.toLowerCase())) {
            return true;
        }

        if(password.matches("^[0-9]+$")) {
            return true;
        }



        // password is in dict
        if(dictionary.contains(password)) {
            return true;
        }

        // Substring is a word in dict
        for(String word: dictionary) {
            if(word.length() > password.length()) {
                continue;
            }

            if(password.contains(word)) {
                return true;
            }

        }
        return false;


    }

    public static void main(String[] args) {
        // Example usage
        List<String> passwords = List.of("iliketoCoDe", "teaMAKEsmehappy", "abracaDabra", "pasSword", "blackcoffeeIsthebest");
        List<String> commonWords = List.of("coffee", "coding", "happy");

        List<String> results = validatePasswords(passwords, commonWords);

        for (int i = 0; i < passwords.size(); i++) {
            System.out.println(passwords.get(i) + ": " + results.get(i));
        }
    }
}