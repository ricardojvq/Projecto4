package projecto4.grupo1.albertoricardo.user;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import projecto4.grupo1.albertoricardo.UserEJBLocal;
import projecto4.grupo1.albertoricardo.security.PasswordEncryptor;

@Named
@RequestScoped
public class UserLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private UserEJBLocal userejb;

	@Inject
	private UserLogged userlog;

	private int id;
	private String email;
	private String originalMail;
	private String password;
	private String result = "";

	public String doLogin() {
		String destiny = "";
		if (userejb.verifyLogin(this.email, this.password)) {
			System.out.println(email);
			setFacesContext();
			userlog.setEmail(originalMail);
			try {
				userlog.setName(userejb.getName(email));
				userlog.setId(userejb.getUserID(email));
			} catch (NoResultException nre) {
				// Sem resultados
			}
			destiny="/Authorized/entry.xhtml?faces-redirect=true";
			result = "Login válido";
		} else { 
			result = "Login inválido: "+password;
			destiny = "";
		}
		return destiny;
	}

	public void setFacesContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ext = context.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("logged", "yes");
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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





}
