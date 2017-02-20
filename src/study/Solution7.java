package study;

/**
 * Reverse Integer 反转整数，比如是123，变成321。 1.反转就是将整数反过来，其实就是先取余再除的过程。 第一次：123 % 10 =
 * 3; 123 / 10 = 12; 第二次：12 % 10 = 2; 12 / 10 = 1; 第三次：1 % 10 = 1; 1 / 10 = 0;
 * 以上余数321就是我们所想要的。那么问题来了，三次循环的余数分别是3、2、1，最后怎么才能变成321呢？
 * 可以看作是每一次循环，便是得到的余数向前进一位。比如，个位上的3，变成十位上的3，最后变成百位上的3。
 * 
 * 发现个问题： 整数123456789的反转结果是987654321。这是正确的 整数1234567891的反转结果是1987654321。这也是正确的
 * 整数1234567892的反转结果是-1307312975。这就奇怪了，从这里就不对了。
 * int类型的最大值为2147483647，最小值为-2147483648。 MIN_VALUE = 0x80000000 和 MAX_VALUE =
 * 0x7fffffff 就是补码表示的Integer的最小值(-2^31)和最大值(2^31-1)。 所以需要判断下给定的整数x是否越界。
 * 其实不需要判断给定的整数是否越界，因为在输入整数的时候，越界是编译不了的。
 * 我们需要判断的是反转之后的整数是否越界。——————>不是判断反转之后的整数是否越界，而是判断反转之后的整数是否是原来的整数反转的。
 * 比如1234567892，反转之后为-1307312975。反转的结果并没有越界，而不是原来反转的结果！
 * 
 * @author geyan
 *
 */
public class Solution7 {

	public static void main(String[] args) {

		int num = 1234567891;
		System.out.println("整数" + num + "反转结果为 " + reverse(num));

	}

	public static int reverse(int x) {
		/*
		 * // 判断给定整数是否越界，若越界，则返回0 if (x > Integer.MAX_VALUE || x <
		 * Integer.MIN_VALUE) { return 0; }
		 */
		int result = 0;
		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if ((newResult - tail) / 10 != result) {
				return 0;
			}
			result = newResult;
			x = x / 10;
		}
		return result;
		/*
		 * if (result < Integer.MAX_VALUE && result > Integer.MIN_VALUE) {
		 * return result; } return 0;
		 */
	}

}
