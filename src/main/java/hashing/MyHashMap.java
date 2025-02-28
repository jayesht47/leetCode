package hashing;


import java.util.ArrayList;
import java.util.List;

/**
 * HashMap Impl with open address hash collision resolution
 * https://leetcode.com/problems/design-hashmap
 */
public class MyHashMap {

    public class BasicPair {
        private Integer key;
        private Integer value;

        public BasicPair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

    }

    private int capacity;
    private int size;
    private List<BasicPair>[] hashMap;

    public MyHashMap() {
        capacity = 4;
        hashMap = new List[capacity];
        size = 0;
    }


    private int hash(int key) {
        return key % capacity;
    }

    private void deepCopyList(List<BasicPair> list1, List<BasicPair> list2) {
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != null)
                list2.add(new BasicPair(list1.get(i).key, list1.get(i).value));
        }
    }

    private void reHash() {
        List[] oldMap = new List[hashMap.length];
        for (int i = 0; i < oldMap.length; i++) {
            if (hashMap[i] != null) {
                List<BasicPair> list = new ArrayList<>();
                deepCopyList(hashMap[i], list);
                oldMap[i] = list;
            }
        }
        capacity *= 2;
        hashMap = new List[capacity];
        size = 0;
        for (int i = 0; i < oldMap.length; i++) {
            if (oldMap[i] != null) {
                List<BasicPair> list = oldMap[i];
                list.forEach(basicPair -> put(basicPair.key, basicPair.value));
            }
        }
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (hashMap[index] == null) {
            ArrayList<BasicPair> arr = new ArrayList<>();
            arr.add(new BasicPair(key, value));
            hashMap[index] = arr;
        } else {
            List<BasicPair> list = hashMap[index];
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null && list.get(i).key == key) {
                    list.get(i).value = value;
                    if (size >= capacity / 2) reHash();
                    return;
                }
            }
            hashMap[index].add(new BasicPair(key, value));
        }
        size++;
        if (size >= capacity / 2) reHash();
    }

    public int get(int key) {
        int index = hash(key);
        if (hashMap[index] != null) {
            for (int i = 0; i < hashMap[index].size(); i++) {
                if (hashMap[index].get(i) != null && hashMap[index].get(i).key == key)
                    return hashMap[index].get(i).value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        if (hashMap[index] != null) {
            for (int i = 0; i < hashMap[index].size(); i++) {
                if (hashMap[index].get(i) != null && hashMap[index].get(i).key == key) {
                    hashMap[index].set(i, null);
                    size--;
                }
            }
            for (BasicPair bp : hashMap[index]) {
                if (bp != null) {
                    return;
                }
            }
            hashMap[index] = null;
        }
    }
}
