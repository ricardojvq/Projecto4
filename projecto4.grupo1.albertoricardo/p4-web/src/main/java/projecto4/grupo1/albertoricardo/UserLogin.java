package projecto4.grupo1.albertoricardo;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@SessionScoped
public class UserLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static Logger logger = LoggerFactory.getLogger(UserLogin.class);

	@EJB
	private UserEJBLocal userejb;

	@Inject
	private UserLogged userlog;

	private int id;
	private String username;
	private String password;
	private String result = "";

	public String doLogin() {
		logger.trace("Iniciado login");
		logger.error("erro");
		String destiny = "";
		boolean verified = userejb.verifyLogin(this.username, this.password);
		if (verified) {
			logger.debug("Login verificado para "+username);
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
