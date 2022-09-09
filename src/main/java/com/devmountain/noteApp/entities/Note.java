package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.NoteDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;


    }

    public Note(NoteDto noteDto) {
        if (noteDto.getBody() != null) {
            this.body = noteDto.getBody();
        }
    }

    //    public Note() {
//    }
//
//    public Note(Long id, String body) {
//        this.id = id;
//        this.body = body;
//    }
}
