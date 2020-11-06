package com.gituhub.sammejanderson.meetingroom.model;

import lombok.*;

import javax.persistence.*;


//lombok
@Getter
@ToString // em caso de erros futuros, olhar parte 3
@Setter
@AllArgsConstructor
@NoArgsConstructor
//JPA
@Entity
@Table(name = "meetingroom")
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "startHour", nullable = false)
    private String startHour;

    @Column(name = "name", nullable = false)
    private String endHour;


}


