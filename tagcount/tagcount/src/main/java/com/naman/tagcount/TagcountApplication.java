/*
This TagCount application consistently increment the number in a database
when parallel threads are racing to increment the number.

@author Naman Agarwal
@version 1.0
@since Feb 07, 2021
*/

package com.naman.tagcount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class TagcountApplication {

	public static void main(String[] args) {
		SpringApplication.run(TagcountApplication.class, args);
	}

}
