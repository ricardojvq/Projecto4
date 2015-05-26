package projecto4.grupo1.albertoricardo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="playlists")
public class Playlist {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(unique=true)
	private String nome;
	@ManyToOne
	private User user;
	@ManyToMany(mappedBy="musicPlaylists")
	private List<Music> playlistsMusic;

	public Playlist() {
		super();
	}

	



}