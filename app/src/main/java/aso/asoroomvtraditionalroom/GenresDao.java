package aso.asoroomvtraditionalroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface GenresDao{

	@Insert()
	 Long insertGenres(Genres genres);

	@Insert()
	 Long[] insertGenres(Genres... genres);

	@Update()
	 int updateGenres(Genres genres);

	@Update()
	 int updateGenres(Genres... genres);

	@Delete()
	int deleteGenres(Genres genres);

	@Delete()
	int deleteGenres(Genres... genres);

	@Query("SELECT * FROM `genres`")
	List<Genres> getEveryGenres();

	@Query("SELECT count() FROM genres")
	long getRowCount();
}
