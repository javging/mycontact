package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.domain.Block;
import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.repository.BlockRepository;
import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlocks() {
        return personRepository.findByBlockIsNull();
    }

    public List<Person> getPeopleByName(String name) {
        List<Person> peopleWithName = personRepository.findByName(name);
        return peopleWithName;
    }

    @Transactional
    public List<Person> getPeopleByBirthday(LocalDate birthday) {
        List<Person> todayBirthdayPeople = personRepository.findByMonthOfBirthdayAndDayOfBirthday(birthday.getMonthValue(), birthday.getDayOfMonth());
        LocalDate nextDay = birthday.plusDays(1);
        System.out.println(nextDay);
        List<Person> tomorrowBirthdayPeople = personRepository.findByMonthOfBirthdayAndDayOfBirthday(nextDay.getMonthValue(), nextDay.getDayOfMonth());

        return Stream.concat(todayBirthdayPeople.stream(), tomorrowBirthdayPeople.stream()).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id) {
//        Person person = personRepository.findById(id).get();
        Person person = personRepository.findById(id).orElse(null); // 원래는 아래처럼 존재여부 따져야 하는데, orElse 로 축약

//        Optional<Person> person = personRepository.findById(id);

//        if (person.isPresent()) return person.get();
//        else return null;

        log.info("person: {}", person); // 나중에 필요 없으면 로그 출력되지 않도록 설정할 수 있음

        return person;
    }
}
