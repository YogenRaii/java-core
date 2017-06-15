package com.eprogrammerz.examples.algorithm.leetcode;

public class IntegerReverser {
	
	public static void main(String[] args) {
		System.out.println(reverse(12324));
		System.out.println(reverse(-12324));
		System.out.println(reverse(Integer.MAX_VALUE));
		
//		System.out.println(atoi("1234545454544"));
		
		System.out.println(pow(3, 2));
		System.out.println(pow(34.00515, -3));
		System.out.println(pow(1.00001, 1234567));
		System.out.println(pow(0.00001, 2147483647));
		System.out.println(pow(2.0000, -2147483648));
		
		System.out.println(superPow(2, new int[]{1,0}));
		System.out.println(superPow(2147483647, new int[]{2,0,0}));
	}

	public static int reverse(int x) {
		
		long result = 0;
		while(x != 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}
		
		return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE? 0 : (int) result;  
	}
	
	public static int atoi(String str) {
		if(str == null || str.isEmpty()) {
			throw new IllegalArgumentException("Invalid Input!!");
		}
		long num = 0;
		for(char ch: str.toCharArray()) {
			num = num * 10 + (ch - 48);
			if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE)
				throw new IllegalArgumentException("Integer value exceeded the limit!!!");
			
		}
		return (int)num;
	}
	
	public static double pow(double x, int n) {
		if(n == 0) return 1;
		else if(n < 0) {
			n = -n;
			x = 1/x;
			if(n == Integer.MIN_VALUE) {
				n = Integer.MAX_VALUE;
				x *= x;						
			}
		}
		return (n % 2 == 0)? pow(x * x, n/2) : x * pow(x * x, n/2);
	}
	
	public static int superPow(int a, int[] b) {
		
		int exp = 0;
		for(int i = 0; i < b.length; i++) {
			exp = exp * 10 + b[i];
		}
		System.out.println("pow("+a+","+exp+") = " + pow(a, exp));
		long res = (long) pow(a, exp);
		System.out.println(res);
		return (int) (res % 1337);
	}
}
