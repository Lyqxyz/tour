package com.tour.app;

import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.entity.Tag;
import com.tour.app.model.mapper.TagMapper;
import com.tour.app.service.ContentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppApplicationTests {

    @Autowired
    TagMapper tagMapper;

    @Autowired
    ContentService contentService;
    @Test
    public void contextLoads() {

    }

}
