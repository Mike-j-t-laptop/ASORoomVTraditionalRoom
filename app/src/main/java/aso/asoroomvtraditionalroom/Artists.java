package aso.asoroomvtraditionalroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "artists"
)
public class Artists{
	@PrimaryKey(autoGenerate = true)
	@NonNull
	@ColumnInfo(name = "ArtistId")
	private Long artistId;

	@ColumnInfo(name = "Name")
	private String name;

	public Artists(){}

	@Ignore
	public Artists(String name){
		this.name = name;
	}

	public Long getArtistId() {
		return this.artistId;
	}
	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
