package controller;

import java.util.ArrayList;

import bean.NotesBean;
import dao.NotesDao;
import model.Notes;

public class NotesManager {
	
	private static NotesManager instance = null;
	private NotesBean note;//singleton

    public NotesManager() {}

    public static NotesManager getInstance() {

        if (instance == null) {
            instance = new NotesManager();
        }
        return instance;
    }
    
    public NotesBean getNote() {
        return note;
     }

    public void setNote(NotesBean n){
    	note = n;
    }

    public static ArrayList<Notes> userNotes(String username) {
    	return NotesDao.userNotesDao(username);
    }
    
    public  boolean addNotes(String note, String username) {
    	return NotesDao.addNoteDao(note, username);
    }
    public  Notes chooseNote(String note) {
    	return NotesDao.chooseNoteDao(note);
    }
    
    public  boolean modifyNote(String note, String noteModified) {
    	return NotesDao.modifyNoteDao(note, noteModified);
    }
    public  boolean deleteNotes(String note, String username) {
    	return NotesDao.deleteNoteDao(note, username);
    }
}
