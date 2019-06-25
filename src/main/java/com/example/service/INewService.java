package com.example.service;

import com.example.dto.CategoryDTO;
import com.example.dto.NewDTO;

import java.util.List;

public interface INewService {
    List<NewDTO> findAll();
    NewDTO insert(NewDTO newDTO);
    NewDTO findById(long id);
    NewDTO update(NewDTO updateNew, long id);

    void deleteNew(long[] ids);
}
