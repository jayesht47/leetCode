package line;

import java.util.*;

public class LogAnalyser {

    public static HashMap<String, Integer> sortByValue(Map<String, Integer> inputMap) {
        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(inputMap.entrySet());
        List<Map.Entry<String, Integer>> list2 = new LinkedList<>(inputMap.entrySet());
        Collections.sort(list, Map.Entry.comparingByValue());
        Collections.reverse(list);
        //checking if both are same
        if (list.equals(list2)) {
            Collections.sort(list, Map.Entry.comparingByKey());
        }
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> oneVal : list) {
            temp.put(oneVal.getKey(), oneVal.getValue());
        }
        return temp;
    }

    public String[] solution(int n, String[] logs) {

        Map<String, Integer> uriMap = new HashMap<>();

        for (String oneLog : logs) {
            String uri = oneLog.split(" ")[2];
            if (oneLog.split(" ")[1].equals("200")) {
                if (uriMap.containsKey(uri))
                    uriMap.put(uri, uriMap.get(uri) + 1);
                else
                    uriMap.put(uri, 1);
            }
        }

        HashMap<String, Integer> res = sortByValue(uriMap);

        int numberOfRecords = Math.min(res.size(), n);
        int counter = 0;

        String[] resultArr = new String[numberOfRecords];

        for (String key : res.keySet()) {
            if (numberOfRecords == 0)
                break;
            resultArr[counter] = key;
            counter++;
            numberOfRecords--;
        }
        return resultArr;

    }

}
