package _155;

import java.util.Arrays;

/**
 * @author relish
 * @since 2018/11/16
 */
class MinStack {

    Node top = null;

    class Node {
        int data;
        int min;
        Node prev;

        public Node(int data, int min, Node prev) {
            this.data = data;
            this.min = min;
            this.prev = prev;
        }
    }

    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int x) {
        if (top == null) {
            top = new Node(x, x, null);
        } else {
            int min = Math.min(x, top.min);
            Node t = top;
            top = new Node(x, min, t);
        }
    }

    public void pop() {
        Node prev = top.prev;
        if (prev == null) {
            top = null;
        } else {
            top = new Node(prev.data, prev.min, prev.prev);
        }
    }

    public int top() {
        return top.data;
    }

    public int getMin() {
        return top.min;
    }

    public static void main(String[] args) {
        deal(
                "[\"MinStack\",\"push\",\"push\",\"push\",\"getMin\",\"pop\",\"top\",\"getMin\"]",
                "[[],[-2],[0],[-3],[],[],[],[]]"
        );
        deal(
                "[\"MinStack\",\"push\",\"push\",\"push\",\"push\",\"getMin\",\"pop\",\"getMin\",\"pop\",\"getMin\",\"pop\",\"getMin\"]",
                "[[],[2],[0],[3],[0],[],[],[],[],[],[],[]]"
        );
        deal(
                "[\"MinStack\",\"push\",\"push\",\"push\",\"top\",\"pop\",\"getMin\",\"pop\",\"getMin\",\"pop\",\"push\",\"top\",\"getMin\",\"push\",\"top\",\"getMin\",\"pop\",\"getMin\"]",
                "[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]"
        );

    }


    private static MinStack minStack;
    private static String[] sb;

    private static void deal(String rawCommands, String data) {
        String[] commands = rawCommands.replaceAll("\\[|]", "").split(",");
        sb = new String[commands.length];
//        System.out.println(Arrays.toString(commands));
        for (int i = 0; i < commands.length; i++) {
            commands[i] = commands[i].replaceAll("\"", "");
        }

        String[] rawData = data.substring(1, data.length() - 1).split(",");
        int[][] arr = new int[rawData.length][1];
        for (int i = 0; i < rawData.length; i++) {
            String s = rawData[i].replaceAll("\\[|]", "");
            if ("".equals(s)) {
                arr[i] = new int[0];
            } else {
                arr[i] = new int[]{Integer.parseInt(s)};
            }
        }
        for (int i = 0; i < commands.length; i++) {
            sb[i] = parse(commands[i], arr[i]);
        }
        System.out.println(Arrays.toString(sb));
    }

    private static String parse(String command, int[] arr) {
        switch (command) {
            case "MinStack":
                minStack = new MinStack();
                return null;
            case "push":
                minStack.push(arr[0]);
                return null;
            case "getMin":
                return minStack.getMin() + "";
            case "pop":
                minStack.pop();
                return null;
            case "top":
                minStack.top();
                return minStack.top() + "";
        }
        return "";
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */