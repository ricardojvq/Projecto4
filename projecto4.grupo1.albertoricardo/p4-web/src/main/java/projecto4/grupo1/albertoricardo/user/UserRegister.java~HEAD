package projecto4.grupo1.albertoricardo.user;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import projecto4.grupo1.albertoricardo.ejb.UserEJBLocal;



@Named
@SessionScoped
public class UserRegister implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	static Logger log = LoggerFactory.getLogger(UserRegister.class);

	@EJB
	private UserEJBLocal userejb;

	private String email;
	private String emailConfirm;
	private String password;
	private String passwordConfirm;
	private String result = "";

	public String addNewUser() {
		String destiny = "";
	//	log.info("add new user");
		if (email.equals(emailConfirm) && password.equals(passwordConfirm)) {
			try {
			//	log.info("try add new user");
				userejb.registerUser(email, password);
				result = "Adicionado";
				LoginChoose.setShowRegister(false);
				destiny="login.xhtml?faces-redirect=true";
			} catch(Exception e) {
		//		log.info("exception add new user");
				result = "Já existente";
				destiny="login.xhtml?faces-redirect=true";
			}
		}
		
	//	log.info("return add new user");

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
