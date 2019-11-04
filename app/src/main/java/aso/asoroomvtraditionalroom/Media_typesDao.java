package aso.asoroomvtraditionalroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface Media_typesDao{

	@Insert()
	 Long insertMedia_types(Media_types media_types);

	@Insert()
	 Long[] insertMedia_types(Media_types... media_types);

	@Update()
	 int updateMedia_types(Media_types media_types);

	@Update()
	 int updateMedia_types(Media_types... media_types);

	@Delete()
	int deleteMedia_types(Media_types media_types);

	@Delete()
	int deleteMedia_types(Media_types... media_types);

	@Query("SELECT * FROM `media_types`")
	List<Media_types> getEveryMedia_types();

	@Query("SELECT count() FROM media_types")
	long getRowCount();
}
