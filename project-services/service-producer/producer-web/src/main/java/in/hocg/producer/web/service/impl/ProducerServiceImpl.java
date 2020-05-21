package in.hocg.producer.web.service.impl;

import in.hocg.producer.web.entity.Producer;
import in.hocg.producer.web.mapper.ProducerMapper;
import in.hocg.producer.web.service.ProducerService;
import in.hocg.services.common.AbstractServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Created by hocgin on 2019/3/24.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ProducerServiceImpl extends AbstractServiceImpl<ProducerMapper, Producer>
        implements ProducerService {
    
    public String index() {
        return "worked";
    }
    
    @Override
    public String sayHello(String name) {
        return String.format("[ say Hello %s]", name);
    }
}
