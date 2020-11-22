package com.cg.healthassist.doctorpatient.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** This class is to validate 
 * 
 * @author Swathi
 *
 */

public class Validation {
	
	/* This method is to validate patient id */
	
	public boolean validateId(Integer validId) {
		String regex="^[0-9]";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=null;
		matcher =pattern.matcher(String.valueOf(validId));
		return matcher.matches();
	}  
}