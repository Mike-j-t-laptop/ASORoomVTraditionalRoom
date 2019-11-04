package aso.asoroomvtraditionalroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "playlists"
)
public class Playlists{
	@PrimaryKey(autoGenerate = true)
	@NonNull
	@ColumnInfo(name = "PlaylistId")
	private Long playlistId;

	@ColumnInfo(name = "Name")
	private String name;

	public Long getPlaylistId() {
		return this.playlistId;
	}
	public void setPlaylistId(Long playlistId) {
		this.playlistId = playlistId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
