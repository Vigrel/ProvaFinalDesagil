package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {
	private int id;
	private List<Track> tracks;
	private Map<String, Integer> ratings;
	
	public Playlist(int id) {
		this.id = id;
		this.tracks = new ArrayList<>();
		this.ratings = new HashMap<>();
	}
	
	public int getId() {
		return this.id;
	}
	
	public List<Track> getTracks() {
		return this.tracks;
	}
	
	public Map<String, Integer> getRatings() {
		return this.ratings;
	}
	
	public void addTrack(Track track) {
		this.tracks.add(track);
	}
	
	public void putRating(String name, int rate) {
		this.ratings.put(name, rate);		;
	}
	
	public double averageRatings() {
		double average = 0;
		for (Integer rate : this.ratings.values()) {
			average += rate;		
		}
		average = average/this.ratings.values().size();
		int ptInt = (int) average;
		double ptFrac = average - ptInt;
		
		if (ptFrac < 0.26) {
			return ptInt + 0.0;
		}
		if (ptFrac >= 0.74) {
			return ptInt + 1.0;
		}
		return ptInt + 0.5;
	}

}
