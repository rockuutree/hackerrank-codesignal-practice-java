import java.util.ArrayList;
import java.util.List;

public class Boxes {
    public static void main(String[] args) {
        List<List<Integer>> operations = new ArrayList<>();
        // operations.add(List.of(0, 1, 3));
        // operations.add(List.of(0, 4, 2));
        // operations.add(List.of(1, 3, 4));
        // operations.add(List.of(1, 3, 2));
        operations.add(List.of(1,1,1));


        
        boolean[] result = solution(operations);
        
        // Print the result
        for (boolean b : result) {
            System.out.print(b + " ");
        }
    }

    public static boolean[] solution(List<List<Integer>> operations) {
        List<Boolean> answers = new ArrayList<>();
        List<List<Integer>> savedBox = new ArrayList<>();

        for(List<Integer> operation: operations) {
            int type = operation.get(0);
            int length = operation.get(1);
            int height = operation.get(2);

            if(type == 0) {
                savedBox.add(List.of(length, height));
            } else {
                boolean allFit = false;
                if(savedBox.isEmpty()) {
                    answers.add(true);
                } else {
                    for(List<Integer> box : savedBox) {
                        int a = box.get(0);
                        int b = box.get(1);
                        if((a < length && b < height) || (b < length && a < height)) {
                            allFit = true;
                        }
                    }
                    answers.add(allFit);
                }
            }
        }

        boolean[] retVal = new boolean[answers.size()];

        for(int i = 0; i < retVal.length; i++) {
            retVal[i] = answers.get(i);
        }
        return retVal;
    }
}