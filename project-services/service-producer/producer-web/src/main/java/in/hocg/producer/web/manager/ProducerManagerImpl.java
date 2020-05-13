package in.hocg.producer.web.manager;

import in.hocg.producer.facade.manager.ProducerManager;
import in.hocg.producer.web.entity.Producer;
import in.hocg.producer.web.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2020/5/12.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service(version = "1.0.0", interfaceClass = ProducerManager.class)
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ProducerManagerImpl implements ProducerManager {
    private final ProducerService producerService;
    
    @Override
    public Long saveRecord(String context) {
        final Producer entity = new Producer();
        entity.setContext(context);
        entity.setCreatedAt(LocalDateTime.now());
        producerService.validInsert(entity);
        return entity.getId();
    }
    
    @Override
    public String findContextById(Long id) {
        final Producer entity = producerService.getById(id);
        return entity.getContext();
    }
    
    @Override
    public String sayHello(String name) {
        return producerService.sayHello(name);
    }
    
}
