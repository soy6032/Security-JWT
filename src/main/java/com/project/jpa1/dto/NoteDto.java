package com.project.jpa1.dto;

import com.project.jpa1.entity.Note;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class NoteDto {

    private Long noteIdx;
    private Long userIdx;
    private String userId;
    private String noteTitle;
    private String noteContent;
    private String noteCreateTime;
    private String categoryName;

//    public NoteDto(Note note){
//        noteIdx = note.getNoteIdx();
//        userIdx = note.getUser().getUserIdx();
//        userId = note.getUser().getUserId();
//        noteTitle = note.getNoteTitle();
//        noteContent = note.getNoteContent();
//        noteCreateTime = note.getNoteCreateTime();
//        categoryName = note.getCategory().getCategoryName();
//    }
//
//    public NoteDto(Long noteIdx, Long userIdx, String userId, String noteTitle, String noteContent, String noteCreateTime, String categoryName){
//        this.noteIdx = noteIdx;
//        this.userIdx = userIdx;
//        this.userId = userId;
//        this.noteTitle = noteTitle;
//        this.noteContent = noteContent;
//        this.noteCreateTime = noteCreateTime;
//        this.categoryName = categoryName;
//    }


}
