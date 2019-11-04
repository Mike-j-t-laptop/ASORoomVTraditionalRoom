package aso.asoroomvtraditionalroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "albums",
	indices = {
			@Index(name = "IFK_AlbumArtistId",value = {"ArtistId"})
	}
	,foreignKeys = {
		@ForeignKey(
			entity=Artists.class
			,childColumns = {
				"ArtistId"
			}
			,parentColumns = {
				"ArtistId"
			}
		)
	}
)
public class Albums{

	@Ignore
	public static final int SEARCHMODE_STARTSWITH = 0;
	@Ignore
	public static final int SEARCHMODE_ENDSWITH = 1;
	@Ignore
	public static final int SEARCHMODE_CONTAINS = 2;
	@Ignore
	public static final int SEARCHMODE_MATCHES = 3;

	@PrimaryKey(autoGenerate = true)
	@NonNull
	@ColumnInfo(name = "AlbumId")
	private Long albumId;

	@NonNull
	@ColumnInfo(name = "Title")
	private String title;

	@NonNull
	@ColumnInfo(name = "ArtistId")
	private Long artistId;

	public Albums(){}

	@Ignore
	public Albums(String title,long  artistId) {
		this.title = title;
		this.artistId = artistId;
	}

	@Ignore
	public static String getSearchArg(String title, int searchMode) {
		String searchArg = title;
		switch (searchMode) {
			case SEARCHMODE_STARTSWITH:
				searchArg = title + "%";
				break;
			case SEARCHMODE_ENDSWITH:
				searchArg = "%" + title;
				break;
			case SEARCHMODE_CONTAINS:
				searchArg = "%" + title + "%";
				break;
			case SEARCHMODE_MATCHES:
				break;
		}
		return searchArg;
	}

	@Ignore
	public static int addTracksToNamedAlbum(AlbumsDao albumsDao, TracksDao tracksDao, String albumName, List<Tracks> tracksToAdd) {
		int rv = 0;
		if (albumName == null || albumName.length() < 1 || tracksToAdd == null || tracksToAdd.size() < 1) return rv;
		Long[] albumIdList = albumsDao.findAlbumIdsByTitle(Albums.getSearchArg(albumName,Albums.SEARCHMODE_MATCHES));
		if (albumIdList.length != 1) return rv;
		for (Long albumid: albumIdList) {
			for (Tracks t: tracksToAdd) {
				t.setAlbumId(albumid);
				if (tracksDao.insertTracks(t) > 0) {
					rv++;
				}
			}
		}
		return rv;
	}

	public Long getAlbumId() {
		return this.albumId;
	}
	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getArtistId() {
		return this.artistId;
	}
	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

}
