package projecto4.grupo1.albertoricardo;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

@Local
public interface UserEJBLocal {

	public abstract boolean verifyLogin(String email, String password);

	public abstract void registerUser(String username, String password);

	void populate();

	public abstract List<User> firstLetter(String letter);

	int getUserID(String username);

}