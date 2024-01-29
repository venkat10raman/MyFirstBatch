package com.venkat.one;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println(Thread.currentThread().getName());
		System.out.println("From the Processor");
		return item;
	}

}
