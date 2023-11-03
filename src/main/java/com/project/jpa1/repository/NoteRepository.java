package com.project.jpa1.repository;

import com.project.jpa1.dto.NoteDto;
import com.project.jpa1.entity.Note;
import com.project.jpa1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
//    @Query("select n from Note n " +
//        "join fetch n.user " +
//        "join fetch n.category ")
//    List<Note> findAllByWithUserCategory();

//    @Query("select new com.project.jpa1.dto.NoteDto( n.noteIdx, n.user.userIdx, n.user.userId, n.noteTitle, n.noteContent, n.noteCreateTime, n.category.CategoryName) " +
//            "from Note n " +
//            "join n.user " +
//            "join n.category")
//    List<NoteDto> findAllByWithUserCategory();
//
//    @Query("select new com.project.jpa1.dto.NoteDto( n.noteIdx, n.user.userIdx, n.user.userId, n.noteTitle, n.noteContent, n.noteCreateTime, n.category.CategoryName) " +
//            "from Note n " +
//            "join n.user " +
//            "join n.category " +
//            "where n.noteIdx = :noteIdx")
//    List<NoteDto> findAllWithUserCategoryById(@Param("noteIdx") Long noteIdx);
//
//

}
