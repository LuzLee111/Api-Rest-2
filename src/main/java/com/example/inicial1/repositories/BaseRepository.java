package com.example.inicial1.repositories;

import com.example.inicial1.entities.Base;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, Id> { //en general para todos

}
