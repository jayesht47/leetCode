package hashing;


/**
 * HashMap Impl with open address hash collision resolution
 *
 * Note: This approach has a problem with handling hash collision as the open address implementation done
 * is linear hence consider the following scenario
 * Trying to insert Pair(a,oldVal) into hashmap
 * hash for element a is calculated to be 111 but in our array 111 is already occupied
 * hence we look for 112 which is also occupied now since 113rd element is empty we push the pair containing
 * a as key in 113rd index.
 * The Pair whose key's hash was at 112 index gets removed.
 * Now we get a call to put a new Pair (a,newVal)
 * so Ideally the 113rd element should be replaced but what ends up happening is
 * since 112nd node is empty we insert Pair(a,newVal) at 112 which results in duplicates and
 * also possible incorrect resolution of values when fetching via get if we do a reHash in between
 */
public class MyHashMap {

    class BasicPair {
        private Integer key;
        private Integer value;

        public BasicPair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

    }

    private int capacity;
    private int size;
    private BasicPair[] hashMap;

    public MyHashMap() {
        capacity = 4;
        hashMap = new BasicPair[capacity];
        size = 0;
    }


    private int hash(int key) {
        return key % capacity;
    }

    private void reHash() {
        BasicPair[] oldMap = new BasicPair[hashMap.length];
        for (int i = 0; i < oldMap.length; i++) {
            if (hashMap[i] != null)
                oldMap[i] = new BasicPair(hashMap[i].key, hashMap[i].value);
        }
        capacity *= 2;
        hashMap = new BasicPair[capacity];
        size = 0;
        for (int i = 0; i < oldMap.length; i++) {
            if (oldMap[i] != null)
                put(oldMap[i].key, oldMap[i].value);
        }
    }

    public void put(int key, int value) {
        int index = hash(key);

        while (true) {
            if (hashMap[index] == null) {
                hashMap[index] = new BasicPair(key, value);
                size++;
                if (size >= (capacity / 2)) reHash();
                return;
            } else if (hashMap[index].key == key) {
                hashMap[index].value = value;
                return;
            }
            index++;
            index %= capacity;
        }
    }

    public int get(int key) {
        int index = hash(key);
        while (hashMap[index] != null) {
            if (hashMap[index].key == key) return hashMap[index].value;
            index++;
            index %= capacity;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        while (hashMap[index] != null) {
            if (hashMap[index].key == key) {
                hashMap[index] = null;
                size--;
            }
            index++;
            index %= capacity;
        }
    }
}
