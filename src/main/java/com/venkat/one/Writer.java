package com.venkat.one;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter<String> {

	@Override
	public void write(Chunk<? extends String> items) throws Exception {
		items.forEach(item -> System.out.println("From the Writer"));
	}

}
