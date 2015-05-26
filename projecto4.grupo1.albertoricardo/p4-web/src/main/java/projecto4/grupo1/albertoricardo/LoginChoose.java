package projecto4.grupo1.albertoricardo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class LoginChoose implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean showLogin = false;
	public static boolean showRegister = false;

	public boolean doShowLogin() {
		showLogin = true;
		showRegister = false;
		return showLogin;
	}

	public boolean doShowRegister() {
		showLogin = false;
		showRegister = true;
		return showRegister;
	}

	public boolean isShowLogin() {
		return showLogin;
	}

	public static void setShowLogin(boolean showL) {
		showLogin = showL;
	}

	public boolean isShowRegister() {
		return showRegister;
	}

	public static void setShowRegister(boolean showR) {
		showRegister = showR;
	}



}
