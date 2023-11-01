import java.util.LinkedList;

public class HashMap<K, V> {

        private static class Node<K,V> {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Node<K, V>>[] table;
    private int size;

    public HashMap() {
        table = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value){
        int index = getHash(key);

        if(table[index] == null){
            table[index] = new LinkedList<>();
        }

        for( Node<K,V> node : table[index]){
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
        }

        table[index].add(new Node<>(key, value));
        size++;
    }

    public V get(K key){
        int index = getHash(key);

        if (table[index] != null) {
            for (Node<K, V> node : table[index]) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
        }
        return null;
    }

    private int getHash(K key){
        int hash = key.hashCode();
        return hash % table.length;
    }

    public int size() {
        return size;
    }

    public void remove(K key){
        int index = getHash(key);

        if(table.index != null){
            for(Node<K,V> node : table[index]){
                if(node.key.equals(key)){
                    table[index].remove(node);
                    size--;
                    return ;
                }
            }
        }
    }
//
}
