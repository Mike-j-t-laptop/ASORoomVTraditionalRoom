package aso.asoroomvtraditionalroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface Playlist_trackDao{

	@Insert()
	 Long insertPlaylist_track(Playlist_track playlist_track);

	@Insert()
	 Long[] insertPlaylist_track(Playlist_track... playlist_track);

	@Update()
	 int updatePlaylist_track(Playlist_track playlist_track);

	@Update()
	 int updatePlaylist_track(Playlist_track... playlist_track);

	@Delete()
	int deletePlaylist_track(Playlist_track playlist_track);

	@Delete()
	int deletePlaylist_track(Playlist_track... playlist_track);

	@Query("SELECT * FROM `playlist_track`")
	List<Playlist_track> getEveryPlaylist_track();

	@Query("SELECT count() FROM playlist_track")
	long getRowCount();
}
