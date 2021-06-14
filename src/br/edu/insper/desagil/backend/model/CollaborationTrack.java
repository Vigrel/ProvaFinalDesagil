package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.List;

public class CollaborationTrack extends Track {
	private List<Artist> collaborators;
	
	public CollaborationTrack(Artist artist, List<Artist> collaborators, String name, int duration) {
		super(artist, name, duration);
		this.collaborators = collaborators; 
	}
	
	@Override
	public String getFullArtistName() {
		String feat = " (feat.";
		List<String> collaboratorsNames= new ArrayList<>();
		
		for (Artist collab:collaborators) {
			collaboratorsNames.add(" " + collab.getName());
		}
		feat += String.join(",", collaboratorsNames);
		feat += ")";		
		
		return super.getArtist().getName() + feat;
	}
}
