package projecto4.grupo1.albertoricardo.ejb;

import java.util.List;

import javax.ejb.Local;

import projecto4.grupo1.albertoricardo.UserEntity;

@Local
public interface UserEJBLocal {

	public abstract boolean verifyLogin(String email, String password);

	public abstract void registerUser(String username, String password);

	void populate();

	public abstract List<UserEntity> firstLetter(String letter);

	int getUserID(String username);

}