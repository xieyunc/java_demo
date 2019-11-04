import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//Random rand = new Random(System.currentTimeMillis());
		ThreadLocalRandom rand = ThreadLocalRandom.current();
		System.out.println("rand.nextBoolean():"+rand.nextBoolean());
		
		byte[] buffer = new byte[16];
		rand.nextBytes(buffer);
		
		System.out.println(Arrays.toString(buffer));
		
		//生成0.00~1.0之间的伪随机double数
		System.out.println("rand.nextDouble():"+rand.nextDouble());

		System.out.println("rand.nextFloat():"+rand.nextFloat());
		
		System.out.println("rand.nextGaussian():"+rand.nextGaussian());
		
		System.out.println("rand.nextInt():"+rand.nextInt());
		
		System.out.println("rand.nextInt(100):"+rand.nextInt(100));
		
		System.out.println("rand.nextLong():"+rand.nextLong());
	}

}
