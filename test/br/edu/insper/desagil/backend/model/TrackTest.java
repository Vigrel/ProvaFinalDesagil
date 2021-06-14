package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackTest {
	private Track track;
	private Artist artist;
	
	@BeforeEach
	void setUp() {
		artist = new Artist("Anitta");
	}

	@Test
	void testZeroSeconds() {
		track = new Track(artist, "Moda de Viola", 0);
		assertEquals("0:00", track.getDurationString());
	}

	@Test
	void testFiveSeconds() {
		track = new Track(artist, "Moda de Viola", 5);
		assertEquals("0:05", track.getDurationString());
	}

	@Test
	void testTwentyFiveSeconds() {
		track = new Track(artist, "Moda de Viola", 25);
		assertEquals("0:25", track.getDurationString());
	}

	@Test
	void testOneMinuteZeroSeconds() {
		track = new Track(artist, "Moda de Viola", 60);
		assertEquals("1:00", track.getDurationString());
	}

	@Test
	void testOneMinuteFiveSeconds() {
		track = new Track(artist, "Moda de Viola", 65);
		assertEquals("1:05", track.getDurationString());
	}

	@Test
	void testOneMinuteTwentyFiveSeconds() {
		track = new Track(artist, "Moda de Viola", 85);
		assertEquals("1:25", track.getDurationString());
	}

	@Test
	void testTwoMinutesZeroSeconds() {
		track = new Track(artist, "Moda de Viola", 120);
		assertEquals("2:00", track.getDurationString());
	}

	@Test
	void testTwoMinutesFiveSeconds() {
		track = new Track(artist, "Moda de Viola", 125);
		assertEquals("2:05", track.getDurationString());
	}

	@Test
	void testTwoMinutesTwentyFiveSeconds() {
		track = new Track(artist, "Moda de Viola", 145);
		assertEquals("2:25", track.getDurationString());
	}

	@Test
	void testOneCollaborator() {
		track = new CollaborationTrack(artist, Arrays.asList(new Artist("Becky G")), "Banana", 195);
		assertEquals("Anitta (feat. Becky G)", track.getFullArtistName());
	}

	@Test
	void testTwoCollaborators() {
		track = new CollaborationTrack(artist, Arrays.asList(new Artist("Ludmilla"), new Artist("Snoop Dog")), "Banana", 195);
		assertEquals("Anitta (feat. Ludmilla, Snoop Dog)", track.getFullArtistName());
	}
}
