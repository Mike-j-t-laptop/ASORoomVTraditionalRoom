package aso.asoroomvtraditionalroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "media_types"
)
public class Media_types{
	@PrimaryKey(autoGenerate = true)
	@NonNull
	@ColumnInfo(name = "MediaTypeId")
	private Long mediaTypeId;

	@ColumnInfo(name = "Name")
	private String name;

	public Media_types() {}

	@Ignore
	public Media_types(String name) {
		this.name = name;
	}

	public Long getMediaTypeId() {
		return this.mediaTypeId;
	}
	public void setMediaTypeId(Long mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
