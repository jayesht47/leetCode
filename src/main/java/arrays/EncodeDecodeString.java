package arrays;

import java.util.List;

public class EncodeDecodeString {

    String SEPARATOR = "@SEP@";

    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str);
            sb.append(SEPARATOR);
        }
        sb.delete(sb.length() - SEPARATOR.length(), sb.length());
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        return List.of(str.split(SEPARATOR));
    }
}
