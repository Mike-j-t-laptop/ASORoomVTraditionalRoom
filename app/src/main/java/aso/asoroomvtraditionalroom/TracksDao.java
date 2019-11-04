package aso.asoroomvtraditionalroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface TracksDao{

	@Insert()
	 Long insertTracks(Tracks tracks);

	@Insert()
	 Long[] insertTracks(Tracks... tracks);

	@Update()
	 int updateTracks(Tracks tracks);

	@Update()
	 int updateTracks(Tracks... tracks);

	@Delete()
	int deleteTracks(Tracks tracks);

	@Delete()
	int deleteTracks(Tracks... tracks);

	@Query("SELECT * FROM `tracks`")
	List<Tracks> getEveryTracks();

	@Query("SELECT count() FROM tracks")
	long getRowCount();
}
