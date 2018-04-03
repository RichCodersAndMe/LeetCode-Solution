package _729;
// remove the line of `package xxx.xxx.xxx.xxx;` when you commit it

import java.util.TreeMap;

/**
 * @author relish
 * @since 2018/04/02
 */

class MyCalendar {

    public MyCalendar() {

    }

    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public boolean book(int start, int end) {
        TreeMap<Integer, Integer> d = new TreeMap<>(map);
        d.put(start, d.getOrDefault(start, 0) + 1);
        d.put(end, d.getOrDefault(end, 0) - 1);
        int sum = 0;
        for (Integer integer : d.values()) {
            sum += integer;
            if (sum > 1) {
                return false;
            }
        }
        map = new TreeMap<>(d);
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // returns true
        System.out.println(myCalendar.book(15, 25)); // returns false
        System.out.println(myCalendar.book(20, 30)); // returns true
    }
}

