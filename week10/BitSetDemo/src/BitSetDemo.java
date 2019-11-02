import com.sun.org.apache.xalan.internal.xsltc.dom.BitArray;

import java.util.Arrays;
import java.util.BitSet;

/**
 * 文件名：BitSetDemo.java
 * 功能描述：位向量操作Demo
 */
public class BitSetDemo {
    public static void main(String[] args) {
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);

        for (int i = 0; i < 16; i++) {
            if(i%2 == 0)
                bits1.set(i);
            if(i%5 == 0)
                bits2.set(i);
        }

        System.out.printf("bits1中二进制位内容为1的索引：%s\n",bits1.toString());
        System.out.printf("bits2中二进制位内容为1的索引：%s\n",bits2.toString());

        System.out.print("bits1：");
        for (int i = 0; i < 16; i++) {
            if (bits1.get(i))
                System.out.printf("%2d",1);
            else
                System.out.printf("%2d",0);
        }

        System.out.print("\nbits2：");
        for (int i = 0; i < 16; i++) {
            if (bits2.get(i))
                System.out.printf("%2d",1);
            else
                System.out.printf("%2d",0);
        }


        bits1.and(bits2);
        System.out.printf("\nbits1和bits2进行[与]运算后：%s\n",bits1);
        System.out.print("bits1：");
        for (int i = 0; i < 16; i++) {
            if (bits1.get(i))
                System.out.printf("%2d",1);
            else
                System.out.printf("%2d",0);
        }

        bits1.or(bits2);
        System.out.printf("\nbits1和bits2进行[或]运算后：%s\n",bits1);
        System.out.print("bits1：");
        for (int i = 0; i < 16; i++) {
            if (bits1.get(i))
                System.out.printf("%2d",1);
            else
                System.out.printf("%2d",0);
        }

        bits1.xor(bits2);
        System.out.printf("\nbits1和bits2进行[异或]运算后：%s\n",bits1);
        System.out.print("bits1：");
        for (int i = 0; i < 16; i++) {
            if (bits1.get(i))
                System.out.printf("%2d",1);
            else
                System.out.printf("%2d",0);
        }
    }
}
