package com.luma.luma.Repository;

import com.luma.luma.Model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, String> {

}
