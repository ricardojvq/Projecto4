package projecto4.grupo1.albertoricardo;

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
	private String username;
	private String password;
	private String result = "";

	public String doLogin() {
		String destiny = "";
		boolean verified = userejb.verifyLogin(this.username, this.password);
		if (verified) {
			setFacesContext();
			userlog.setEmail(username);
			try {
				userlog.setId(userejb.getUserID(username));
			} catch (NoResultException nre) {
				// Sem resultados
			}
			destiny="/Authorized/entry.xhtml?faces-redirect=true";
			LoginChoose.setShowLogin(false);
			result = "Verdadeiro";
		} else { 
			result = "Login inválido";
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
