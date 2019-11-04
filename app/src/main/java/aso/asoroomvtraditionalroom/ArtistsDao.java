package aso.asoroomvtraditionalroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface ArtistsDao{

	@Insert()
	 Long insertArtists(Artists artists);

	@Insert()
	 Long[] insertArtists(Artists... artists);

	@Update()
	 int updateArtists(Artists artists);

	@Update()
	 int updateArtists(Artists... artists);

	@Delete()
	int deleteArtists(Artists artists);

	@Delete()
	int deleteArtists(Artists... artists);

	@Query("SELECT * FROM `artists`")
	List<Artists> getEveryArtists();

	@Query("SELECT count() FROM artists")
	long getRowCount();
}
