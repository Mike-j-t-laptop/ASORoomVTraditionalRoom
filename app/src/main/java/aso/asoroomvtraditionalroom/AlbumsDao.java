package aso.asoroomvtraditionalroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface AlbumsDao{

	@Insert()
	 Long insertAlbums(Albums albums);

	@Insert()
	 Long[] insertAlbums(Albums... albums);

	@Update()
	 int updateAlbums(Albums albums);

	@Update()
	 int updateAlbums(Albums... albums);

	@Delete()
	int deleteAlbums(Albums albums);

	@Delete()
	int deleteAlbums(Albums... albums);

	@Query("SELECT * FROM `albums`")
	List<Albums> getEveryAlbums();

	@Query("SELECT AlbumId  FROM albums WHERE Title LIKE :searchArg")
	Long[] findAlbumIdsByTitle(String searchArg);

	@Query("SELECT count() FROM albums")
	long getRowCount();

}
