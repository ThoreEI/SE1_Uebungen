package klausuren;

public class CleanCodeDemo {
    private KeyValuePair[] keyValuePairs = new KeyValuePair[1000];

    private int indexNewEntry = 0;

    public boolean insertKeyValuePair(int key, String value) {
        if (indexNewEntry < keyValuePairs.length)
           checkIfKeyIsAlreadyInserted(key);




        keyValuePairs[indexNewEntry].key = key;
        keyValuePairs[indexNewEntry].value = value;
        indexNewEntry++;

        return true;
    }

    private void  checkIfKeyIsAlreadyInserted(int key) {
        for (int currentBucket = 0; currentBucket < indexNewEntry; currentBucket++)
            if (keyValuePairs[currentBucket].key == key)
                replaceBucketNewValue(currentBucket);

    }

    private void replaceBucketNewValue(int currentBucket) {

    }
}
class KeyValuePair {
    public int key;
    public String value;


}

