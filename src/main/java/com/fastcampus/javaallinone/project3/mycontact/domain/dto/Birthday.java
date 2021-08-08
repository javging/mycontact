package com.fastcampus.javaallinone.project3.mycontact.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Embeddable
//@AllArgsConstructor
@NoArgsConstructor
@Data
public class Birthday {
//    private int yearOfBirthday;
    private Integer yearOfBirthday;
    // int -> null 허용 안됨
    // Integer -> null 허용됨

    @Min(1)
    @Max(12)
    private Integer monthOfBirthday;

    @Min(1)
    @Max(31)
    private Integer dayOfBirthday;

    // 위에 민맥스만으로는 2월 30일 같은 날짜 검증하기 어려우니 그냥 LocalDate만 받아서 생성되도록,,
    // 근데 아직 NoArgsConstructor 있어서 어찌어찌 하면 존재하지 않는 날짜 생성할 수 있음.
    public Birthday(LocalDate birthday) {
        this.yearOfBirthday = birthday.getYear();
        this.monthOfBirthday = birthday.getMonthValue();
        this.dayOfBirthday = birthday.getDayOfMonth();
    }
}
