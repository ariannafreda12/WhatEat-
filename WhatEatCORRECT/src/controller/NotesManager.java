package controller;

import java.util.ArrayList;

import dao.NotesDao;
import model.Notes;

public class NotesManager {
	
	private static NotesManager instance = null;
	private Notes note;//singleton

    public NotesManager() {}

    public static NotesManager getInstance() {

        if (instance == null) {
            instance = new NotesManager();
        }
        return instance;
    }
    
    public Notes getNote() {
        return note;
     }

    public void setNote(Notes n){
    	note = n;
    }

    public static ArrayList<Notes> userNotes(String username) {
    	return NotesDao.userNotesDao(username);
    }
    
    public  boolean addNotes(String note, String username) {
    	return NotesDao.addNoteDao(note, username);
    }
}
