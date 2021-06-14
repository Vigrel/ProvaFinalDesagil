package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaylistTest {
	private static double DELTA = 0.000001;
	private Playlist playlist;

	@BeforeEach
	void setUp() {
		playlist = new Playlist(5);
		playlist.putRating("anitta", 1);
		playlist.putRating("ludmilla", 2);
	}

	@Test
	void testRoundDownToZero() {
		playlist.putRating("eller", 3);
		playlist.putRating("vinicius", 3);
		assertEquals(2.0, playlist.averageRatings(), DELTA);
	}

	@Test
	void testRoundUpToHalf() {
		playlist.putRating("eller", 1);
		assertEquals(1.5, playlist.averageRatings(), DELTA);
	}

	@Test
	void testRoundDownToHalf() {
		playlist.putRating("eller", 2);
		assertEquals(1.5, playlist.averageRatings(), DELTA);
	}

	@Test
	void testRoundUpToOne() {
		playlist.putRating("eller", 1);
		playlist.putRating("vinicius", 3);
		assertEquals(2.0, playlist.averageRatings(), DELTA);
	}
}
