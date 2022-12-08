public class Pair<U, V> {

    private U first;
    private V second;

    public Pair(U first, V second) {

        this.first = first;
        this.second = second;
    }

    public U first() {
        return this.first;
    }

    public V second() {
        return this.second;
    }

}
