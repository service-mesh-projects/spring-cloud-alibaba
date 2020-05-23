package in.hocg.consumer.web.service.impl;

import in.hocg.consumer.web.entity.Consumer;
import in.hocg.consumer.web.mapper.ConsumerMapper;
import in.hocg.consumer.web.service.ConsumerService;
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
public class ConsumerServiceImpl extends AbstractServiceImpl<ConsumerMapper, Consumer>
        implements ConsumerService {
    
    public String index() {
        return "worked";
    }
    
    @Override
    public String sayHello(String name) {
        return "This is Consumer";
    }
    
}
