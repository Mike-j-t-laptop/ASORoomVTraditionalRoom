package aso.asoroomvtraditionalroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "genres"
)
public class Genres{
	@PrimaryKey(autoGenerate = true)
	@NonNull
	@ColumnInfo(name = "GenreId")
	private Long genreId;

	@ColumnInfo(name = "Name")
	private String name;

	public Genres(){}

	@Ignore
	public Genres(String name){
		this.name = name;
	}

	public Long getGenreId() {
		return this.genreId;
	}
	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
