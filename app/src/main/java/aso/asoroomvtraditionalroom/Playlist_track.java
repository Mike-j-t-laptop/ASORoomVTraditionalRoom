package aso.asoroomvtraditionalroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "playlist_track",
	primaryKeys = {"PlaylistId",
		"TrackId"},
	indices = {
			@Index(name = "IFK_PlaylistTrackTrackId",value = {"TrackId"})
	}
	,foreignKeys = {
		@ForeignKey(
			entity=Tracks.class
			,childColumns = {
				"TrackId"
			}
			,parentColumns = {
				"TrackId"
			}
		),
		@ForeignKey(
			entity=Playlists.class
			,childColumns = {
				"PlaylistId"
			}
			,parentColumns = {
				"PlaylistId"
			}
		)
	}
)
public class Playlist_track{
	@NonNull
	@ColumnInfo(name = "PlaylistId")
	private Long playlistId;

	@NonNull
	@ColumnInfo(name = "TrackId")
	private Long trackId;

	public Long getPlaylistId() {
		return this.playlistId;
	}
	public void setPlaylistId(Long playlistId) {
		this.playlistId = playlistId;
	}
	public Long getTrackId() {
		return this.trackId;
	}
	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}

}
