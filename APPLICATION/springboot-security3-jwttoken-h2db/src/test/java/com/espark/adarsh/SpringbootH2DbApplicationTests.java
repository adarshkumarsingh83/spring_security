package com.espark.adarsh;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.temporal.ChronoUnit;
import java.util.Date;

@SpringBootTest(classes = ApplicationMain.class)
class SpringbootH2DbApplicationTests {

	@Test
	void contextLoads() {
	}

	public static void main(String[] args) {
		Date newDate = Date.from(new Date().toInstant().plus(5, ChronoUnit.DAYS));
		System.out.println(newDate);
	}

}
