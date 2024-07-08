package com.multi.ex02.lambda_function;

import java.util.function.*;
import java.util.*;

class LambdaFunc2 {
	// 기본 형일 경우에는 xxxSupplier를 활용하면 된다. 
	// Supplier, BooleanSupplier, IntSupplier, DoubleSupplier, LongSupplier
	
	public static void main(String[] args) {
		IntSupplier s = () -> (int) (Math.random() * 100) + 1;
		IntConsumer c = i -> System.out.print(i + ", ");
		IntPredicate p = i -> i % 2 == 0;
		IntUnaryOperator op = i -> i / 10 * 10; // i의 일의 자리를 없앤다.

		List<Integer> list = new ArrayList<>();
		makeRandomList(list, s);
		printFormat(list, c);
		printEvenNum(list, p, c);
		List<Integer> newList = makeNewList(list, op);
		System.out.println(newList);
	}

	public static void makeRandomList(List<Integer> list, IntSupplier s) {
		for (int i = 0; i < 10; i++) {
			list.add(s.getAsInt());
		}
	}

	public static void printFormat(List<Integer> list, IntConsumer c) {
		System.out.print("[");
		for (int v : list) {
			c.accept(v);
		}
		System.out.println("]");
	}

	public static void printEvenNum(List<Integer> list, IntPredicate p, IntConsumer c) {
		System.out.print("[");
		for (int v : list) {
			if (p.test(v)) {
				c.accept(v);
			}
		}
		System.out.println("]");
	}
	
	public static List<Integer> makeNewList(List<Integer> list, IntUnaryOperator op) {
		List<Integer> newList = new ArrayList<Integer>(list.size());
		for (int v : list) {
			newList.add(op.applyAsInt(v));
		}
		return newList;
	}
}
