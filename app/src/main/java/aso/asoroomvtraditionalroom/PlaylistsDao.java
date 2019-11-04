package aso.asoroomvtraditionalroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface PlaylistsDao{

	@Insert()
	 Long insertPlaylists(Playlists playlists);

	@Insert()
	 Long[] insertPlaylists(Playlists... playlists);

	@Update()
	 int updatePlaylists(Playlists playlists);

	@Update()
	 int updatePlaylists(Playlists... playlists);

	@Delete()
	int deletePlaylists(Playlists playlists);

	@Delete()
	int deletePlaylists(Playlists... playlists);

	@Query("SELECT * FROM `playlists`")
	List<Playlists> getEveryPlaylists();

	@Query("SELECT count() FROM playlists")
	long getRowCount();
}
