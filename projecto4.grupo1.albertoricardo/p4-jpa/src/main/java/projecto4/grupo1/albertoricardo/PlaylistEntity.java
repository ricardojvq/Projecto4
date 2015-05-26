package projecto4.grupo1.albertoricardo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table (name="playlists")
public class PlaylistEntity{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false,unique=true)
	private int id;
	@Column(nullable=false,unique=true)
	private String name;
	@ManyToMany
	List<MusicEntity>musics;
	@ManyToOne
	private UserEntity userOwner;

	
//	static Logger logger = LoggerFactory.getLogger(PlaylistEntity.class);
	
	
	public PlaylistEntity() {
	
	}

	public PlaylistEntity(int id, String name, List<MusicEntity> musics) {
		this.id = id;
		this.name = name;
		this.musics = musics;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<MusicEntity> getMusics() {
		return musics;
	}


	public void setListMusic(List<MusicEntity> musics) {
		this.musics = musics;
	}
	
	
	
	
	
	
	
	
}
	