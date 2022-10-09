// Online Java Compiler
// Use this editor to write, compile and run your Java code online

package Tree;

public class FenwickTree {
    // 0 based indexing
    int[] ft;
    int size;

    FenwickTree(int size) {
        ft = new int[size];
        this.size = size;
    }

    int sum(int r) {
        int val = 0;
        for (; r >= 0; r = (r & (r + 1)) - 1)
            val += ft[r];
        return val;
    }

    int sum(int l, int r) {
        return sum(r) - sum(l - 1);
    }

    void add(int idx, int delta) {
        for (; idx < size; idx = idx | (idx + 1))
            ft[idx] += delta;
    }


}