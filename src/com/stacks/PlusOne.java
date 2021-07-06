package com.stacks;

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
