package aso.asoroomvtraditionalroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version=1,entities = {
		Albums.class,
		Artists.class,
		Customers.class,
		Employees.class,
		Genres.class,
		Invoices.class,
		Invoice_items.class,
		Media_types.class,
		Playlists.class,
		Playlist_track.class,
		Tracks.class
})
public abstract class AppDatabase extends RoomDatabase {

	public static final String DBNAME = "RoomAssetConversion.db";

	public abstract AlbumsDao getAlbumsDao();
	public abstract ArtistsDao getArtistsDao();
	public abstract CustomersDao getCustomersDao();
	public abstract EmployeesDao getEmployeesDao();
	public abstract GenresDao getGenresDao();
	public abstract InvoicesDao getInvoicesDao();
	public abstract Invoice_itemsDao getInvoice_itemsDao();
	public abstract Media_typesDao getMedia_typesDao();
	public abstract PlaylistsDao getPlaylistsDao();
	public abstract Playlist_trackDao getPlaylist_trackDao();
	public abstract TracksDao getTracksDao();
}