package com.cosmos;

import com.cosmos.mapper.DynamicMapper;
import com.cosmos.pojo.Dynamic;
import com.cosmos.utils.ResponseMsg;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AkiSoraApplicationTests {
    @Autowired
    private DynamicMapper dynamicMapper;
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Dynamic> userList = dynamicMapper.selectList(null);
        userList.forEach(System.out::println);
    }

}
