package _8_6_TowersOfHanoi;

import java.util.Stack;

public class App {

    static class Tower {

        private Stack<Integer> disks;
        private int index;

        public Tower(int i) {
            this.disks = new Stack<>();
            this.index = i;
        }

        public int index() {
            return this.index;
        }

        public void add(int d) {
            if (!disks.isEmpty() && disks.peek() <= d) {
                System.out.println("Error placing disk " + d);
            } else {
                disks.push(d);
            }
        }

        public void moveTopTo(Tower t) {
            int top = disks.pop();
            t.add(top);
        }

        public void moveDisks(int n, Tower destination, Tower buffer) {
            if (n > 0) {
                moveDisks(n-1, buffer, destination);
                System.out.println("Move " + this.disks.peek() + " from " + this.index + " to " + destination.index);
                moveTopTo(destination);
                buffer.moveDisks(n-1, destination, this);
            }
        }

        @Override
        public String toString() {
            return this.disks.toString();
        }
    }

    public static void main(String[] args) {

        int n = 3;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i+1);
        }

        for (int i = 6; i > 0; i--) {
            towers[0].add(i);
        }

        for (Tower tower : towers) {
            System.out.println(tower);
        }

        towers[0].moveDisks(6, towers[2], towers[1]);

        for (Tower tower : towers) {
            System.out.println(tower);
        }
    }

}
