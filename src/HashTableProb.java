import java.util.LinkedList;

public class HashTableProb {
    public static void main(String[] args) {
        // Linear Probing
        HashtableLinearProbing lhashTable = new HashtableLinearProbing(5);

        lhashTable.insert("Apple");
        lhashTable.insert("Blue");
        lhashTable.insert("Namaskaram");
        lhashTable.insert("Hey");

        lhashTable.display();

        // Quadratic Probing
        HashtableQuadraticProbing qhashTable = new HashtableQuadraticProbing(5);

        qhashTable.insert("Apple");
        qhashTable.insert("Blue");
        qhashTable.insert("Namaskaram");
        qhashTable.insert("Hey");

        qhashTable.display();

        
        // Seperate Chaining
        HashtableSeperateChaining schashTable = new HashtableSeperateChaining(5);

        schashTable.insert("Apple");
        schashTable.insert("Blue");
        schashTable.insert("Namaskaram");
        schashTable.insert("Hey");

        schashTable.display();
    }
}

class HashtableLinearProbing{
    String[] hashtable;
    int capacity;

    HashtableLinearProbing(int capacity){
        hashtable = new String[capacity];
        this.capacity = capacity;
    }

    int hash(String key){
        return Math.abs(key.hashCode() % capacity);
    }

    void insert(String key){
        int hashIdx = hash(key);

        while(hashtable[hashIdx] != null){
            hashIdx = (hashIdx + 1) % capacity;
        }

        hashtable[hashIdx] = key;
    }

    void display(){
        for(int i = 0; i < capacity; i++){
            if(hashtable[i] != null){
                System.out.println(i + " " + hashtable[i]);
            }else{
                System.out.println(i + " NULL");
            }
        }
    }
}

class HashtableQuadraticProbing{
    String[] hashtable;
    int capacity;

    HashtableQuadraticProbing(int capacity){
        hashtable = new String[capacity];
        this.capacity = capacity;
    }

    int hash(String key){
        return Math.abs(key.hashCode() % capacity);
    }

    void insert(String key){
        int hashIdx = hash(key);
        int i = 1;

        while(hashtable[hashIdx] != null){
            hashIdx = (hashIdx + i) % capacity;
            i++;
        }

        hashtable[hashIdx] = key;
    }

    void display(){
        for(int i = 0; i < capacity; i++){
            if(hashtable[i] != null){
                System.out.println(i + " " + hashtable[i]);
            }else{
                System.out.println(i + " NULL");
            }
        }
    }
}

class HashtableSeperateChaining{
    LinkedList<String>[] arr;
    int capacity;

    HashtableSeperateChaining(int capacity){
        arr = (LinkedList<String>[]) new LinkedList[capacity];
        this.capacity = capacity;

        for(int i = 0; i < capacity; i++){
            arr[i] = new LinkedList<String>();
        }
    }

    int hash(String key){
        return Math.abs(key.hashCode() % capacity);
    }

    void insert(String key){
        int hashIdx = hash(key);

        arr[hashIdx].add(key);
    }

    void display(){
        for(int i = 0; i < capacity; i++){
            if(arr[i].size() > 0){
                System.out.println(i + " -> " + arr[i]);
            }else{
                System.out.println(i + " -> NULL");
            }
        }
    }
}