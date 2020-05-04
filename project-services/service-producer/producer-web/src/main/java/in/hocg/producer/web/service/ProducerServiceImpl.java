package in.hocg.producer.web.service;

import in.hocg.producer.facade.service.ProducerService;
import org.apache.dubbo.config.annotation.Service;

/**
 * Created by hocgin on 2019/3/24.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service(version = "1.0.0")
public class ProducerServiceImpl implements ProducerService {
    
    public String index() {
        return "worked";
    }
    
    @Override
    public String sayHello(String name) {
        return String.format("[ say Hello %s]", name);
    }
}
