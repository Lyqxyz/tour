package com.tour.app.model.mapper;

import com.tour.app.model.entity.Email;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailMapper {

    Integer add(Email email);

    Email has(String email);

    Integer update(Email email);

    Email check(Email email);

}
