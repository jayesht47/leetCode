package string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/rearrange-spaces-between-words/
 */
public class RearrangeSpacesBetweenWords {
    public String reorderSpaces(String text) {

        String newText = text.strip();
        String[] words = newText.split(" ");
        List<String> finalWords = new ArrayList<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                finalWords.add(word);
            }
        }

        int spaceCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                spaceCount++;
        }
        if (finalWords.size() == 1) {
            StringBuilder result = new StringBuilder(finalWords.get(0));
            for (int i = 0; i < spaceCount; i++) {
                result.append(" ");
            }
            return result.toString();
        }

        StringBuilder result = new StringBuilder();
        int equalSpaces = spaceCount / (finalWords.size() - 1);
        int extraSpaces = spaceCount % (finalWords.size() - 1);

        for (int i = 0; i < finalWords.size(); i++) {
            String oneWord = finalWords.get(i);
            result.append(oneWord);
            if (i != finalWords.size() - 1) {
                for (int j = 0; j < equalSpaces; j++) {
                    result.append(" ");
                }
            }
        }

        for (int i = 0; i < extraSpaces; i++) {
            result.append(" ");
        }

        return result.toString();
    }
}
