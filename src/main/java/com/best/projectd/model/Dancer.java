package com.best.projectd.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dancer {
	private Long id;
	private String firstName;
	private String lastName;
	private Style style;
	
}
