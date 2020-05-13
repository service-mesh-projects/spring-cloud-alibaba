package in.hocg.consumer.web.service.impl;

import in.hocg.consumer.basic.AbstractSpringBootTest;
import in.hocg.consumer.web.service.SeataService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by hocgin on 2020/5/13.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
class SeataServiceImplTest extends AbstractSpringBootTest {
    @Autowired
    private SeataService seataService;
    
    @Test
    void planA() throws Exception {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            // 构建请求
            mockMvc.perform(MockMvcRequestBuilders.get("/seata/plan-a")
                    .accept(MediaType.ALL))
                    // 进行结果验证
                    .andExpect(status().is(500));
        });
    }
}