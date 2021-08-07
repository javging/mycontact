package com.fastcampus.javaallinone.project3.mycontact.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
//@ToString(exclude = "phoneNumber") // 스트링으로 exclude 시키는 것은 개발자가 실수할 여지가 있음
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor // 필수로 있어야 하는 것들만 받아서 만들어주는 생성자
public class Person {
    @Id
    @GeneratedValue
    private Long id;

//    @Getter
//    @Setter
    @NonNull
    private String name;

//    @Getter
//    @Setter
    @NonNull
    private int age;

//    @Getter
//    @Setter
    private String hobby;

//    @Getter
//    @Setter
    private String bloodType;

//    @Getter
//    @Setter
    private String address;

//    @Getter
//    @Setter
    private LocalDate birthday;

//    @Getter
//    @Setter
    private String job;

    @ToString.Exclude // 이렇게 빼주는게 더 실수할 여지 적음.
    private String phoneNumber;


//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public Person() {}
//
//    public Person(Long id, String name, int age, String hobby, String bloodType, String address, LocalDate birthday, String job, String phoneNumber) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.hobby = hobby;
//        this.bloodType = bloodType;
//        this.address = address;
//        this.birthday = birthday;
//        this.job = job;
//        this.phoneNumber = phoneNumber;
//    }
    // 생성자들도 일일이 생성하려면 힘듦...

    //    public String getHobby() {
//        return hobby;
//    }
//
//    public void setHobby(String hobby) {
//        this.hobby = hobby;
//    }
//
//    public String getBloodType() {
//        return bloodType;
//    }
//
//    public void setBloodType(String bloodType) {
//        this.bloodType = bloodType;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public LocalDate getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(LocalDate birthday) {
//        this.birthday = birthday;
//    }
//
//    public String getJob() {
//        return job;
//    }
//
//    public void setJob(String job) {
//        this.job = job;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", hobby='" + hobby + '\'' +
//                ", bloodType='" + bloodType + '\'' +
//                ", address='" + address + '\'' +
//                ", birthday=" + birthday +
//                ", job='" + job + '\'' +
//                '}';
//    } 필드가 추가될 때마다 새로 만들어줘야 함... 귀찮...

    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        Person person = (Person) obj;

        if(person.getAge() != this.getAge()) {
            return false;
        }

        if(!person.getName().equals(this.getName())) {
            return false;
        }

        return true;
    }
}
