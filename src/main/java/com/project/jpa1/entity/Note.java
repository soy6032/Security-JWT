package com.project.jpa1.entity;

import com.project.jpa1.dto.NoteDto;
import com.project.jpa1.dto.UserDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noteIdx;

    @ManyToOne
    @JoinColumn(name = "userIdx")
    private User user;

    private String noteTitle;

    private String noteContent;

    private String noteCreateTime;

    @OneToOne
    @JoinColumn(name = "categoryIdx")
    private Category category;


}
