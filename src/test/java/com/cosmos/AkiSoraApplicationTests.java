package com.cosmos;

import com.cosmos.modules.dynamic.mapper.DynamicMapper;
import com.cosmos.modules.dynamic.service.DynamicService;
import com.cosmos.modules.dynamic.vo.Dynamic;
import com.cosmos.modules.user.service.AkiUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AkiSoraApplicationTests {
    @Autowired
    private DynamicService dynamicService;
    @Autowired
    private DynamicMapper dynamicMapper;
    @Autowired
    private AkiUserService akiUserService;
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Dynamic> userList = dynamicMapper.selectList(null);
        userList.forEach(System.out::println);
    }
}
