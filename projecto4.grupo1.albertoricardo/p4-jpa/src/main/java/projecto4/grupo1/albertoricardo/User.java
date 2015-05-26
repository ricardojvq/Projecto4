package projecto4.grupo1.albertoricardo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="users")
public class User {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(unique=true,nullable=false)
	private String email;
	@Column(nullable=false)
	private String password;
	@OneToMany(mappedBy="user")
	private List<Music> uploadedMusics;
	@OneToMany(mappedBy="user")
	private List<Playlist> userPlaylists;

	public User() {
		super();
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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



	@Override
	public String toString() {
		return "ID: "+id+", E-mail: "+email+", password: "+password;
	}

	public int getId() {
		return id;
	}



}
