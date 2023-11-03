package com.project.jpa1.service;

import com.project.jpa1.dto.NoteDto;
import com.project.jpa1.dto.UserDto;
import com.project.jpa1.entity.Note;
import com.project.jpa1.entity.User;
import com.project.jpa1.repository.NoteRepository;
import com.project.jpa1.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

//    public List<NoteDto> list(){
//        List<Note> note = noteRepository.findAllByWithUserCategory();
//
//        List<NoteDto> result = note.stream()
//                .map(o -> new NoteDto(o)).collect(toList());
//
//        return result;
//    }


//    public List<NoteDto> list(){
//        List<NoteDto> note = noteRepository.findAllByWithUserCategory();
//        return note;
//    }

//    public List<NoteDto> Detail(Long noteIdx){
//        List<NoteDto> note = noteRepository.findAllWithUserCategoryById(noteIdx);
//        return note;
//    }


}
