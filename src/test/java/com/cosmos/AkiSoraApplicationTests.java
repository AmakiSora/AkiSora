package com.cosmos;

import com.cosmos.mapper.Mapper;
import com.cosmos.pojo.Trend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AkiSoraApplicationTests {
    @Autowired
    private Mapper mapper;
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Trend> userList = mapper.selectList(null);
        userList.forEach(System.out::println);
    }

}
