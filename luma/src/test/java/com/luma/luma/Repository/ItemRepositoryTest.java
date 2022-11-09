package com.luma.luma.Repository;

import com.luma.luma.Model.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    Item item1 = null;
    Item newItem1 = null;

    @BeforeEach
    void setUp() {
        item1 = new Item();
        item1.setId("I001");
        item1.setCategory("Furniture");
        item1.setStatus('Y');
        item1.setDescription("medium brown chair");
        item1.setMake("Wood");
        item1.setValuation(1000);
        newItem1 = itemRepository.save(item1);
    }

    @AfterEach
    void tearDown() {
        itemRepository.deleteById("I001");
    }

    @Test
    public void addItem(){
        assertThat(newItem1).isNotNull();
        assertThat(item1.getDescription()).isEqualTo(newItem1.getDescription());
    }

    @Test
    public void getAllItems(){
        List<Item> itemList = itemRepository.findAll();
        assertThat(itemList).isNotNull();
        assertThat(itemList).anyMatch(c -> c.getCategory().equals(item1.getCategory()));
        assertThat(itemList).hasSize(1);
    }

    @Test
    public void findItemByID(){
        Item itm1 = itemRepository.findById(item1.getId()).orElse(null);
        Item itm2 = itemRepository.findById("I002").orElse(null);
        assertThat(itm1).isNotNull();
        assertThat(itm2).isNull();
        assertThat(itm1.getDescription()).isEqualTo(newItem1.getDescription());
    }

    @Test
    public void deleteByIdTest(){
        Item itm1 = itemRepository.findById(item1.getId()).orElse(null);
        itemRepository.deleteById(itm1.getId());
        List<Item> itemList = itemRepository.findAll();
        assertFalse(itemList.contains(itm1));
    }
}