package com.stacks;
/*
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Example 3:

Input: digits = [0]
Output: [1]

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
 */
public class PlusOne {

	public static void main(String args[]) {

		int a[] = {9,9,9};
		int b[] = PlusOne.plusOne(a);
		for(Integer i : b)
			System.out.print(i+" ");
		
	}

	public static int[] plusOne(int[] a) {
		if (a.length == 1) {
			int sum = a[0] + 1;
			if (sum > 9) {
				int newArray[] = new int[2];
				newArray[0] = 1;
				newArray[1] = sum % 10;
				return newArray;
			} else {
				a[0] = sum;
				return a;
			}

		}

		boolean needsNewArray = false;

		int carry = 0, sum = 0;

		sum = a[a.length - 1] + 1;
		if (sum > 9) {
			a[a.length - 1] = sum % 10;
			carry = 1;
		} else {
			a[a.length - 1] = sum;
		}

		for (int i = a.length - 2; i >= 0; i--) {
			if (carry == 0) {
				break;
			} else if (i != 0) {
				sum = a[i] + carry;
				if (sum > 9) {
					a[i] = sum % 10;
					carry = 1;
				} else {
					a[i] = sum;
					break;
				}

			} else {
				sum = a[i] + carry;
				if (sum > 9) {
					a[i] = sum % 10;
					needsNewArray = true;
					break;
				} else {
					a[i] = sum;
					return a;
				}

			}

		}

		if (needsNewArray) {
			int newarray[] = new int[a.length + 1];
			newarray[0] = 1;
			for (int i = 0; i < a.length; i++) {
				newarray[i + 1] = a[i];
			}
			return newarray;
		}

		else
			return a;
	}

}
