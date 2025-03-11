package com.hplearn.tagservice.repository;

import com.hplearn.tagservice.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("SELECT DISTINCT t FROM Tag t WHERE t.id IN :tagIds")
    List<Tag> findByTagIds(@Param("tagIds") List<Long> tagIds);

    @Query("SELECT DISTINCT i.id FROM Tag t JOIN t.itemIds i WHERE t.id IN :tagIds")
    Set<Long> findItemIdsByTagIds(@Param("tagIds") List<Long> tagIds);
}
