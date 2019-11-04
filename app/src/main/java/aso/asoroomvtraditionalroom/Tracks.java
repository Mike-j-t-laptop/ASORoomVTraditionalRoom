package aso.asoroomvtraditionalroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "tracks",
	indices = {
			@Index(name = "IFK_TrackAlbumId",value = {"AlbumId"}),
		
			@Index(name = "IFK_TrackGenreId",value = {"GenreId"}),
		
			@Index(name = "IFK_TrackMediaTypeId",value = {"MediaTypeId"})
	}
	,foreignKeys = {
		@ForeignKey(
			entity=Media_types.class
			,childColumns = {
				"MediaTypeId"
			}
			,parentColumns = {
				"MediaTypeId"
			}
		),
		@ForeignKey(
			entity=Genres.class
			,childColumns = {
				"GenreId"
			}
			,parentColumns = {
				"GenreId"
			}
		),
		@ForeignKey(
			entity=Albums.class
			,childColumns = {
				"AlbumId"
			}
			,parentColumns = {
				"AlbumId"
			}
		)
	}
)
public class Tracks{
	@PrimaryKey(autoGenerate = true)
	@NonNull
	@ColumnInfo(name = "TrackId")
	private Long trackId;

	@NonNull
	@ColumnInfo(name = "Name")
	private String name;

	@NonNull
	@ColumnInfo(name = "AlbumId")
	private Long albumId;

	@NonNull
	@ColumnInfo(name = "MediaTypeId")
	private Long mediaTypeId;

	@NonNull
	@ColumnInfo(name = "GenreId")
	private Long genreId;

	@ColumnInfo(name = "Composer")
	private String composer;

	@NonNull
	@ColumnInfo(name = "Milliseconds")
	private Long milliseconds;

	@ColumnInfo(name = "Bytes")
	private Long bytes;

	@NonNull
	@ColumnInfo(name = "UnitPrice")
	private String unitPrice;

	public Tracks(){}

	@Ignore
	public Tracks(
			String name,
			Long albumId, Long mediaTypeId, Long genreId,
			String composer,
			Long milliseconds,
			Long bytes,
			String unitPrice
			) {
		this.name = name;
		this.albumId = albumId;
		this.mediaTypeId = mediaTypeId;
		this.genreId = genreId;
		this.composer = composer;
		this.milliseconds = milliseconds;
		this.bytes = bytes;
		this.unitPrice = unitPrice;
	}

	public Long getTrackId() {
		return this.trackId;
	}
	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAlbumId() {
		return this.albumId;
	}
	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}
	public Long getMediaTypeId() {
		return this.mediaTypeId;
	}
	public void setMediaTypeId(Long mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}
	public Long getGenreId() {
		return this.genreId;
	}
	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}
	public String getComposer() {
		return this.composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public Long getMilliseconds() {
		return this.milliseconds;
	}
	public void setMilliseconds(Long milliseconds) {
		this.milliseconds = milliseconds;
	}
	public Long getBytes() {
		return this.bytes;
	}
	public void setBytes(Long bytes) {
		this.bytes = bytes;
	}
	public String getUnitPrice() {
		return this.unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

}
