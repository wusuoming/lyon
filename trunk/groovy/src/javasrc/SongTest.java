package javasrc;

import static org.junit.Assert.*;
import groovy.Song;

import org.junit.Test;

public class SongTest {

    @Test
    public void testToString() {
        Song song = new Song();
        song.setArtist("严艺丹");
        song.setName("三寸天堂");
        song.setGenre("疤痕体");
        assertEquals("三寸天堂是一首疤痕体风格的乐曲，由严艺丹演奏", song.toString());
    }

    @Test
    public void testGetGenre() {
        fail("Not yet implemented");
    }

}
