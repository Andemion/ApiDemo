package fr.eni.demo.execption;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	private List<String> errors;
	
	public BusinessException() {
		super();
		errors = new ArrayList<String>();
	}
	
	public void addError(String msg) {
		errors.add(msg);
	}
	
	public List<String> getErrors(){
		return errors;
	}
	
	public boolean isErrors() {
		return errors.size() > 0;
	}

}
