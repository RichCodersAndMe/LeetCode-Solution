package _732;

import java.util.TreeMap;

class MyCalendarThree {


    public MyCalendarThree() {
    }

    TreeMap<Integer, Integer> timeline = new TreeMap<>();

    public int book(int start, int end) {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);
        int sum = 0;
        int max = 0;
        for (Integer integer : timeline.values()) {
            sum += integer;
            max = Math.max(max, sum);
        }
        return max;
    }
}

class Main {
    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        System.out.println(myCalendarThree.book(10, 20));//1
        System.out.println(myCalendarThree.book(50, 60));//1
        System.out.println(myCalendarThree.book(10, 40));//2
        System.out.println(myCalendarThree.book(5, 15));//3
        System.out.println(myCalendarThree.book(5, 10));//3
        System.out.println(myCalendarThree.book(25, 55));//3
    }
}
