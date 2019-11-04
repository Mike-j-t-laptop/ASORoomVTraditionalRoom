package aso.asoroomvtraditionalroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ChronicleDBHelper chronicleDBHelper;
    long runnumber;
    boolean onCreateCalled = false;
    Context context;

    AppDatabase appDatabase;
    AlbumsDao albumsDao;
    ArtistsDao artistsDao;
    CustomersDao customersDao;
    EmployeesDao employeesDao;
    GenresDao genresDao;
    Invoice_itemsDao invoice_itemsDao;
    InvoicesDao invoicesDao;
    Media_typesDao media_typesDao;
    Playlist_trackDao playlist_trackDao;
    PlaylistsDao playlistsDao;
    TracksDao tracksDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        //Setup chronicle database and get the last run number (0 if none)
        chronicleDBHelper = ChronicleDBHelper.getInstance(this);
        runnumber = chronicleDBHelper.getLastRunNumber() + 1;

        LogTime.logIt("STARTED",chronicleDBHelper,runnumber);
        LogTime.logIt("Initialising Database",chronicleDBHelper,runnumber);
        appDatabase = Room.databaseBuilder(this,AppDatabase.class,"testdb")
                .allowMainThreadQueries()
                .addCallback(cb)
                .build();
        LogTime.logIt("Database Built",chronicleDBHelper,runnumber);
        albumsDao = appDatabase.getAlbumsDao();
        artistsDao = appDatabase.getArtistsDao();
        customersDao = appDatabase.getCustomersDao();
        employeesDao = appDatabase.getEmployeesDao();
        genresDao = appDatabase.getGenresDao();
        invoice_itemsDao = appDatabase.getInvoice_itemsDao();
        invoicesDao = appDatabase.getInvoicesDao();
        media_typesDao = appDatabase.getMedia_typesDao();
        playlist_trackDao = appDatabase.getPlaylist_trackDao();
        playlistsDao = appDatabase.getPlaylistsDao();
        tracksDao = appDatabase.getTracksDao();
        LogTime.logIt("DAO's initialised",chronicleDBHelper,runnumber);
        LogTime.logIt("Database Initialised",chronicleDBHelper,runnumber);
        LogTime.logIt("Force Opening Database",chronicleDBHelper,runnumber);
        appDatabase.getOpenHelper().getWritableDatabase().execSQL("PRAGMA foreign_keys = OFF;");
        LogTime.logIt("FORCE OPEN Completed",chronicleDBHelper,runnumber);
        if (onCreateCalled) {
            onCreateCalled = false;
            LoadDBFromRawResources.loadImportedDataFromRawResources(appDatabase.getOpenHelper().getWritableDatabase(),context,chronicleDBHelper,runnumber);
        }
        appDatabase.getOpenHelper().getWritableDatabase().setForeignKeyConstraintsEnabled(true);
        logRowCounts();
        LogTime.logIt("Adding additional data",chronicleDBHelper,runnumber);
        addSomeMediaTypes();
        addSomeArtistsAndAlbums();
        addSomeEmployeesAndCustomers();
        addSomeTracksToNamedAlbum();
        LogTime.logIt("Completed adding additional data",chronicleDBHelper,runnumber);
        logRowCounts();
        LogTime.logIt("CLOSING DATABSE",chronicleDBHelper,runnumber);
        appDatabase.close();
        LogTime.logIt("COMPLETED",chronicleDBHelper,runnumber);
        chronicleDBHelper.logAllRuns();
        chronicleDBHelper.logAllRunStats();
    }

    RoomDatabase.Callback cb = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            onCreateCalled = true;
        }
    };

    private void addSomeMediaTypes() {
        LogTime.logIt("Adding MediaTypes",chronicleDBHelper,runnumber);
        appDatabase.getMedia_typesDao().insertMedia_types(new Media_types("testaac"));
        appDatabase.getMedia_typesDao().insertMedia_types(new Media_types("testMP4"));
        appDatabase.getMedia_typesDao().insertMedia_types(new Media_types("testMP3"));
        appDatabase.getMedia_typesDao().insertMedia_types(new Media_types("testmpeg"));
        appDatabase.getMedia_typesDao().insertMedia_types(new Media_types("testjpeg"));
        LogTime.logIt("MediaTypes Addded",chronicleDBHelper,runnumber);
    }

    private void addSomeArtistsAndAlbums() {

        LogTime.logIt("Adding Artists",chronicleDBHelper,runnumber);
        long pinkFloyd = appDatabase.getArtistsDao().insertArtists( new Artists("Pink Floyd"));
        long elp = appDatabase.getArtistsDao().insertArtists(new Artists("Emerson, Lake and Palmer"));
        long genesis = appDatabase.getArtistsDao().insertArtists(new Artists("Genesis"));
        long yes = appDatabase.getArtistsDao().insertArtists(new Artists("Yes"));
        long wally = appDatabase.getArtistsDao().insertArtists(new Artists("Wally"));

        LogTime.logIt("Artists Added - Adding Albums",chronicleDBHelper,runnumber);

        appDatabase.getAlbumsDao().insertAlbums(new Albums("Dark Side of the Mooon",pinkFloyd));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Meddle",pinkFloyd));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("The Wall",pinkFloyd));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("UmmaGumma",pinkFloyd));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Atom Heart Mother",pinkFloyd));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("The Piper at the Gates of Dawn",pinkFloyd));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("A Saucerfull of Secrets",pinkFloyd));

        appDatabase.getAlbumsDao().insertAlbums(new Albums("Pictures at an Exhibition",elp));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Brain Salad Surgery",elp));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Trilogy",elp));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Tarkus",elp));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Emerson, Lake and Palmer",elp));

        appDatabase.getAlbumsDao().insertAlbums(new Albums("Yessongs",yes));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("The Yes Album",yes));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Close to the Edge",yes));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Relayer",yes));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Tales from Topographic Oceans",yes));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Fragile",yes));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Yes",yes));

        appDatabase.getAlbumsDao().insertAlbums(new Albums("From Genesis to Revalations",genesis));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Foxtrot",genesis));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Nursery Chrymes",genesis));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Selling England by the Pound",genesis));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("The Lamb Lies Down on Broadway",genesis));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Trespass",genesis));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Genesis Live",genesis));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Trick of the Tail",genesis));

        appDatabase.getAlbumsDao().insertAlbums(new Albums("Valley Gardens",wally));
        appDatabase.getAlbumsDao().insertAlbums(new Albums("Wally",wally));

        LogTime.logIt("Artists and Albums Added",chronicleDBHelper,runnumber);
    }

    private void addSomeEmployeesAndCustomers() {
        LogTime.logIt("Adding Employees",chronicleDBHelper,runnumber);
        //!!!!!!!!!! Note to be able to insert the first employee FK's need to be turned off else FK conflict
        SupportSQLiteDatabase db = appDatabase.getOpenHelper().getWritableDatabase();
        //db.setForeignKeyConstraintsEnabled(false);
        long self_reporting = employeesDao.getLastEmployeeId() + 1;
        long fredbloggs = employeesDao.insertEmployees( new Employees("Fred","Bloggs","Mr",
                employeesDao.getLastEmployeeId() + 1,
                "1957-03-14",
                "2019-01-01",
                "blah","Sydney","NSW","Australia","2000",
                "0000000000","0000000000","FredBloggs@nomail.com"));
        Log.d("EMPLOYEEID","Fred Bloggs' ID was " + String.valueOf(fredbloggs));
        //db.setForeignKeyConstraintsEnabled(true);
        employeesDao.insertEmployees(
                new Employees(
                        "Arthur","Anderson","Mr",
                        employeesDao.getLastEmployeeId() + 1, //<<<<<<< INSERT AS SELF REPORTING
                        "1974-96-30","2000-10-11",
                        "blah","Melbourne","VIC","Asutralia","3333",
                        "0000000000","0000000000","aa@nomail.com"));

        customersDao.insertCustomers(new Customers("Mary","Contrary","ACME","blah","Sydney","NSW","Australia","2000",
                "0000000000","0000000000","0000000000",fredbloggs));
        LogTime.logIt("Employees Added",chronicleDBHelper,runnumber);
    }


    private int addSomeTracksToNamedAlbum() {
        LogTime.logIt("Adding Tracks to Albums",chronicleDBHelper,runnumber);
        ArrayList<Tracks> tracksToAdd = new ArrayList<>();
        tracksToAdd.add(new Tracks("Valley Gardens",0L,1L,23L,"Wally",585000L,22000L,"10.00"));
        tracksToAdd.add(new Tracks("Nex Perce",0L,1L,23L,"Wally",305000L,12000L,"10.00"));
        tracksToAdd.add(new Tracks("The Mood I'm In",0L,1L,23L,"Wally",425000L,17000L,"10.00"));
        tracksToAdd.add(new Tracks("The Reason Why",0L,1L,23L,"Wally",1160000L,30000L,"10.00"));
        int tracksAdded = Albums.addTracksToNamedAlbum(albumsDao,tracksDao,"Valley Gardens",tracksToAdd);
        LogTime.logIt( tracksAdded + " Tracks added to Albums",chronicleDBHelper,runnumber);
        return tracksAdded;
    }

    private void logRowCounts() {
        long rcAlbums = albumsDao.getRowCount();
        long rcArtists = artistsDao.getRowCount();
        long rcCustomers = customersDao.getRowCount();
        long rcEmployees = employeesDao.getRowCount();
        long rcGenres = genresDao.getRowCount();
        long rcInvoiceItems = invoice_itemsDao.getRowCount();
        long rcInvoices = invoicesDao.getRowCount();
        long rcMediaTypes = media_typesDao.getRowCount();
        long rcPlayListTracks = playlist_trackDao.getRowCount();
        long rcPlayList = playlistsDao.getRowCount();
        long rcTracks = tracksDao.getRowCount();
        long rcTotal = rcAlbums + rcArtists + rcCustomers + rcEmployees + rcGenres + rcInvoiceItems
                + rcInvoices + rcMediaTypes + rcPlayListTracks + rcPlayList + rcTracks;
        Log.d("ROWCOUNTINFO",
                "Total Rows = " + rcTotal +
                        " Albums     = " + rcAlbums +
                        " Artists    = " + rcArtists +
                        " Customers  = " + rcCustomers +
                        " Genres     = " + rcGenres +
                        " Inv Items  = " + rcInvoiceItems +
                        " Invoices   = " + rcInvoices +
                        " Media Types= " + rcMediaTypes +
                        " PlayList T = " + rcPlayListTracks +
                        " PlayLists  = " + rcPlayList +
                        " Tracks     = " + rcTracks
        );
    }
}
