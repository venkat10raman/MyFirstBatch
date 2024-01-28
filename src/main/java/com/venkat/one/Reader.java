package com.venkat.one;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String> {
	
	private AtomicInteger count = new AtomicInteger(10);

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		while (count.getAndDecrement() > 0) {
			return "venkat";
		}
		return null;
	}

}
