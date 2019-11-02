import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 文件名：StackDemo.java
 * 功能描述：Stack类使用Demo
 */
public class StackDemo {
    static void showPush(Stack<Integer> st, int v) {
        st.push(new Integer(v));//压入一个数据至栈中：入栈
        System.out.print("执行：push("+v+")后，");
        System.out.println("stack："+st);
    }

    static void showPop(Stack<Integer> st) {
        int v = (Integer) st.pop(); //从栈中取数：出栈
        System.out.print("执行：pop() -> 取出 "+v+" 后，");
        System.out.println("stack："+st);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();
        System.out.println("stack：" + st);
        showPush(st,10);
        showPush(st,20);
        showPush(st,30);

        if (!st.isEmpty())
            System.out.println("st.peek() -> 取出栈顶内容："+st.peek());
        int x = st.search(20);
        System.out.println("st.search(20) -> 查询20在栈中的位置为："+x);

        showPop(st);
        showPop(st);
        showPop(st);

        try {
            showPop(st); //之前已所数据取完了，此语句会抛出一个“空栈”异常
        } catch (EmptyStackException e) {
            System.out.println("捕获到一个对空栈进行访问的异常！");
        }
    }
}
