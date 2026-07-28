class MyHashSet {

    private boolean[] set;

    // Constructor
    public MyHashSet() {
        set = new boolean[1000001];
    }

    // Add a key
    public void add(int key) {
        set[key] = true;
    }

    // Remove a key
    public void remove(int key) {
        set[key] = false;
    }

    // Check if key exists
    public boolean contains(int key) {
        return set[key];
    }
}
