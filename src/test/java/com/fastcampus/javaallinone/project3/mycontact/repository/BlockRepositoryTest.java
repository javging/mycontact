package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Block;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class BlockRepositoryTest {
    @Autowired
    private BlockRepository blockRepository;

    @Test
    void crud() {
        Block block = new Block();
        block.setName("martin");
        block.setReason("친하지않아서");
        block.setStartDate(LocalDate.now());
        block.setEndDate(LocalDate.now());

        System.out.println(block);
        System.out.println(blockRepository);
        blockRepository.save(block);

        List<Block> blocks = blockRepository.findAll();

        assertThat(blocks.size()).isEqualTo(3);
        assertThat(blocks.get(2).getName()).isEqualTo("martin");

        blockRepository.delete(block);
    }

}