package projecto4.grupo1.albertoricardo;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UserRegister implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private UserEJBLocal userejb;

	private String email;
	private String emailConfirm;
	private String password;
	private String passwordConfirm;
	private String result = "";

	public String addNewUser() {
		String destiny = "";
		if (email.equals(emailConfirm) && password.equals(passwordConfirm)) {
			try {
				userejb.registerUser(email, password);
				result = "Adicionado";
				LoginChoose.setShowRegister(false);
				destiny="login.xhtml?faces-redirect=true";
			} catch(Exception e) {
				result = "Já existente";
				destiny="login.xhtml?faces-redirect=true";
			}
		}

		return destiny;
	}



	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getEmailConfirm() {
		return emailConfirm;
	}



	public void setEmailConfirm(String emailConfirm) {
		this.emailConfirm = emailConfirm;
	}



	public String getPasswordConfirm() {
		return passwordConfirm;
	}



	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}





}
