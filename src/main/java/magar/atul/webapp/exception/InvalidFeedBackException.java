package magar.atul.webapp.exception;

public class InvalidFeedBackException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidFeedBackException (String message){
		super(message);
	}
}