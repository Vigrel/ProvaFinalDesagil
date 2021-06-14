package br.edu.insper.desagil.backend.model;

public class Track {
	private Artist artist;
	private String name;
	private int duration;
	
	public Track(Artist artist, String name, int duration) {
		this.artist = artist;
		this.name = name;
		this.duration = duration;
	}
	
	public Artist getArtist() {
		return this.artist;
	}

	public String getName() {
		return this.name;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public String getDurationString() {
		int minutos = duration/60;
		int segundos = duration%60;
		if (segundos < 10) {
			return minutos + ":0" + segundos;
		}
		return minutos + ":" + segundos;
	}
	
	public String getFullArtistName() {
		return this.artist.getName();
	}
}
