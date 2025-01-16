package com.hinhhoc;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Student {

    private String fullname;
    private boolean gender;
    @Default
    private Date birthday = new Date();
    @Default
    String photo = "photo.png";
    private double mark;

}
