package in.hocg.consumer.web.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * Created by hocgin on 2019/3/24.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service(version = "1.0.0")
@Component
public class ConsumerServiceImpl implements ConsumerService {
    
    public String index() {
        return "worked";
    }
    
    @Override
    public String sayHello(String name) {
        return "This is Consumer";
    }
}
