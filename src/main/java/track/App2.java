package track;

import java.util.*;


public class App2 {

    private static boolean isStringSame(String s1, String s2) {
        return s1.equals(s2);
    }

    private static int max_length(String[] inputs) {
        Set<String> coinedWords = new HashSet<>();
        int coinedWordsCounter = 0;
        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < inputs.length; j++) {
                if (i != j && inputs[i] != null && inputs[j] != null
                        && isStringSame(inputs[i].substring(inputs[i].length() - 2), inputs[j].substring(0, 2))) {
                    StringBuilder sb = new StringBuilder(inputs[i]);
                    sb.append(inputs[j].substring(2));
                    return sb.toString().length();
//                    coinedWords.add(sb.toString());
//                    coinedWordsCounter++;
                }
            }
        }

//        if (coinedWordsCounter > 0) {
//            int maxLength = 0;
//            Iterator<String> coinedItr = coinedWords.iterator();
//            while (coinedItr.hasNext())
//            {
//                String coinedWord = coinedItr.next();
//                if (coinedWord.length() > maxLength)
//                    maxLength = coinedWord.length();
//            }
//            return maxLength;
//        } else
            return -1;

    }

    public static void main(String[] args) {

//        String[] lines = getStdin();

        String[] lines = {"10","cca","bdaaacccaad","dcdbac","dcadbbba","bab","dcad","bddddcbd","d","ddd","ac"};
//        String[] lines = {"2","thirty","tycoon"};
        int inputSize = Integer.parseInt(lines[0]);
        String[] inputs = new String[inputSize];
        int inputCounter = 0;
        for (int i = 0, l = lines.length; i < l; i++) {
            if (i > 0 && lines[i].length() > 2) {
                inputs[inputCounter] = lines[i];
                inputCounter++;
            }
        }
        String[] finalInputs = new String[inputCounter];
        for (int i = 0; i < inputCounter; i++) {
            finalInputs[i] = inputs[i];
        }
        Arrays.sort(finalInputs,((o1, o2) -> o2.length() - o1.length()));
        System.out.println(max_length(finalInputs));
    }


    private static String[] getStdin() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        return lines.toArray(new String[lines.size()]);
    }
}
