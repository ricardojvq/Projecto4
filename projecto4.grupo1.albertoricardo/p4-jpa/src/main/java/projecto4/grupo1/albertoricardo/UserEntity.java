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
public class UserEntity {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(unique=true,nullable=false)
	private String email;
	@Column(nullable=false)
	private String password;
	@OneToMany(mappedBy="userOwner")
	private List<MusicEntity> uploadedMusics;
	@OneToMany(mappedBy="userOwner")
	private List<PlaylistEntity> userPlaylists;

	public UserEntity() {
		super();
	}

	public UserEntity(String email, String password) {
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
