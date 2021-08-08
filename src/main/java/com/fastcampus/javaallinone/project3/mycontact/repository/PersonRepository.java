package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);
    List<Person> findByBlockIsNull();
//    Person findByBloodType(String bloodType);
    List<Person> findByBloodType(String bloodType);
//    List<Person> findByBirthdayBetween(LocalDate startDay, LocalDate endDay);
    @Query(value="select person from Person person where person.birthday.monthOfBirthday=?1") // JPQL??? 미쳤다... 이런거 만들꺼면 그냥 SQL 날리고 말지...
    List<Person> findByMonthOfBirthday(int monthOfBirthday);

    @Query(value="select person from Person person where person.birthday.monthOfBirthday=?1 and person.birthday.dayOfBirthday=?2")
    List<Person> findByMonthOfBirthdayAndDayOfBirthday(int monthOfBirthday, int dayOfBirthday);

    @Query(value="select person from Person person where person.birthday.monthOfBirthday=:monthOfBirthday and person.birthday.dayOfBirthday=:dayOfBirthday")
    //쿼리 써줄거면 메서드 네임은 아무 상관 없는거고...
    List<Person> anyName(@Param("monthOfBirthday") int monthOfBirthday, @Param("dayOfBirthday") int dayOfBirthday); // @Param으로 위에 쿼리에 입력할 변수를 지정할 때, 인덱스 대신 사용할 이름 넣어줄 수 있음...
    // 진짜 난리 났다... 개복잡하네

    // nativeQuery=true 옵션으로 그냥 쿼리 넣어줄 수도 있음.. 차라리 이게 낫네 ... 결국 이런게 필요하지...
//    @Query(value="select id, name, age, blood_type, address, day_of_birthday, month_of_birthday, year_of_birthday, block_id, hobby, job, phone_number from person where person.month_of_birthday=:monthOfBirthday and person.day_of_birthday=:dayOfBirthday", nativeQuery = true)
    // 컬럼 전부 다 가져와야 하는듯,, Block 객체는 block_id만 속성으로 들어가있음.
    @Query(value="select * from person where person.month_of_birthday=:monthOfBirthday and person.day_of_birthday=:dayOfBirthday", nativeQuery = true)
    List<Person> nativeQueryTest(@Param("monthOfBirthday") int monthOfBirthday, @Param("dayOfBirthday") int dayOfBirthday);

}
