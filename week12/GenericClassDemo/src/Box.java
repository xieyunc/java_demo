/**
 * 文件名：Box.java
 * 功能描述：泛型类的定义
 */
public class Box<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
