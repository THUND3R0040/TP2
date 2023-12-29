import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Step 1: Song class
class Song {
    private String title;
    private String artist;
    private int length; // in seconds

    public Song(String title, String artist, int length) {
        this.title = title;
        this.artist = artist;
        this.length = length;
    }

    public void playSong() {
        System.out.println("Playing: " + title + " by " + artist);
    }

    public int getSongLength() {
        return length;
    }
    //getters and setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

}

// Step 2: Album class
class Album {
    private String title;
    private List<Song> songs;

    public Album(String title) {
        this.title = title;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Added song to the album: " + song.getTitle());
    }

    public void removeSong(Song song) {
        songs.remove(song);
        System.out.println("Removed song from the album: " + song.getTitle());
    }

    public void listSongs() {
        System.out.println("Songs in the album '" + title + "':");
        for (Song song : songs) {
            System.out.println(song.getTitle() + " by " + song.getArtist());
        }
    }
    // Getters and Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    

}

// Step 3: Artist class
class Artist {
    private String name;
    private List<Album> albums;

    public Artist(String name) {
        this.name = name;
        this.albums = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        albums.add(album);
        System.out.println("Added album to the artist's collection: " + album.getTitle());
    }

    public void deleteAlbum(Album album) {
        albums.remove(album);
        System.out.println("Deleted album from the artist's collection: " + album.getTitle());
    }

    public void listAlbums() {
        System.out.println("Albums by artist '" + name + "':");
        for (Album album : albums) {
            System.out.println(album.getTitle());
        }
    }
}

// Step 4: User interface
interface User {
    void listen(Song song);

    void addToPlaylist(Song song);

    void removeFromPlaylist(Song song);

    void shufflePlaylist();
}

// Step 4: FreeUser class (implements User)
class FreeUser implements User {
    private String username;
    private List<Song> playlist;

    public FreeUser(String username) {
        this.username = username;
        this.playlist = new ArrayList<>();
    }

    @Override
    public void listen(Song song) {
        song.playSong();
    }

    @Override
    public void addToPlaylist(Song song) {
        playlist.add(song);
        System.out.println("Added song to the playlist: " + song.getTitle());
    }

    @Override
    public void removeFromPlaylist(Song song) {
        playlist.remove(song);
        System.out.println("Removed song from the playlist: " + song.getTitle());
    }

    @Override
    public void shufflePlaylist() {
        Collections.shuffle(playlist);
        System.out.println("Shuffled the playlist.");
    }
}

// Step 4: PremiumUser class (implements User)
class PremiumUser implements User {
    private String username;
    private List<Song> playlist;

    public PremiumUser(String username) {
        this.username = username;
        this.playlist = new ArrayList<>();
    }

    @Override
    public void listen(Song song) {
        song.playSong();
    }

    @Override
    public void addToPlaylist(Song song) {
        playlist.add(song);
        System.out.println("Added song to the playlist: " + song.getTitle());
    }

    @Override
    public void removeFromPlaylist(Song song) {
        playlist.remove(song);
        System.out.println("Removed song from the playlist: " + song.getTitle());
    }

    @Override
    public void shufflePlaylist() {
        Collections.shuffle(playlist);
        System.out.println("Shuffled the playlist.");
    }
}

// Step 5: Playlist class
class Playlist {
    private User user;
    private List<Song> songs;

    public Playlist(User user) {
        this.user = user;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Added song to the playlist: " + song.getTitle());
    }

    public void removeSong(Song song) {
        songs.remove(song);
        System.out.println("Removed song from the playlist: " + song.getTitle());
    }

    public void shuffleSongs() {
        Collections.shuffle(songs);
        System.out.println("Shuffled the playlist.");
    }
}

// Example usage:
public class OnlineMusicPlatform {
    public static void main(String[] args) {
        // Create instances of songs
        Song song1 = new Song("Song 1", "Artist A", 200);
        Song song2 = new Song("Song 2", "Artist B", 180);

        // Create instances of albums
        Album album1 = new Album("Album X");
        album1.addSong(song1);
        album1.addSong(song2);

        // Create instances of artists
        Artist artistA = new Artist("Artist A");
        artistA.addAlbum(album1);

        // Create instances of users
        User freeUser = new FreeUser("FreeUser123");
        User premiumUser = new PremiumUser("PremiumUser456");

        // Create instances of playlists
        Playlist freeUserPlaylist = new Playlist(freeUser);
        freeUserPlaylist.addSong(song1);
        freeUserPlaylist.addSong(song2);

        Playlist premiumUserPlaylist = new Playlist(premiumUser);
        premiumUserPlaylist.addSong(song1);
        premiumUserPlaylist.addSong(song2);

        // Demonstrate operations
        freeUser.listen(song1);
        premiumUser.addToPlaylist(song1);
        freeUserPlaylist.shuffleSongs();

        artistA.listAlbums();
    }
}

