package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

//@Repository //JpaRepository extends 하기 때문에 굳이 안해줘도 됨
public interface BlockRepository extends JpaRepository<Block, Long> {
}
