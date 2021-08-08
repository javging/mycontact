package com.fastcampus.javaallinone.project3.mycontact.controller;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping(value="/api/person")
@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping()
//    public Person getPerson(@RequestParam(required = false, defaultValue = "1") Long id) {
        // @RequestParam 따로 없어도 자동으로 쿼리에서 받아오게 되긴 함. defaultValue, required 같은 설정 해줄 수 있음
    @RequestMapping(value="/{id}")
    public Person getPerson(@PathVariable Long id) { // /{id} id 자리에 들어간 값을 변수로 가져올 수 있음
        return personService.getPerson(id);
    }

    @GetMapping(value="/birthday-friends")
    public List<Person> getBirthdayFriends() {
        return personService.getPeopleByBirthday(LocalDate.now());
    }

}
