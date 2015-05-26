package projecto4.grupo1.albertoricardo;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class UserEJB
 */
@Stateless
public class UserEJB implements UserEJBLocal {
	@PersistenceContext(name="Playlist")
	EntityManager em;

	/**
	 * Default constructor. 
	 */
	public UserEJB() {

	}


	@Override
	public void populate() {
	}

	@Override
	public List<User> firstLetter(String letter) {
		Query q = em.createQuery("select u from User u where email like :l"); // 'User' é a classe adicionada no persistence.xml
		q.setParameter("l", letter);
		@SuppressWarnings("unchecked")
		List<User> usr = q.getResultList();
		return usr;
	}

	/* (non-Javadoc)
	 * @see projecto4.grupo1.albertoricardo.ejb.EJBRemote#verifyLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean verifyLogin(String email, String password) {
		boolean verified;
		Query q = em.createQuery("select u from User u where u.email like :e");
		q.setParameter("e", email);
		try {
			User usr = (User) q.getSingleResult();
			if (usr.getPassword().equals(password)) verified = true;
			else verified = false;
		} catch (NoResultException nre) {
			nre.printStackTrace();
			verified = false;
		}

		return verified;
	}

	/* (non-Javadoc)
	 * @see projecto4.grupo1.albertoricardo.ejb.EJBRemote#registerUser(java.lang.String, java.lang.String)
	 */
	@Override
	public void registerUser(String username, String password) {
		User u = new User(username, password);
		em.persist(u);
	}

	@Override
	public int getUserID(String username) {
		int id = -1;
		Query q = em.createQuery("select u from User u where u.email like :e");
		q.setParameter("e", username);
		User u = (User) q.getSingleResult();
		id = u.getId();
		return id;
	}

}
