package guest.service;

public class ServiceException extends Exception {

	public ServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public ServiceException(String arg0) {
		super(arg0);

	}
	
}
