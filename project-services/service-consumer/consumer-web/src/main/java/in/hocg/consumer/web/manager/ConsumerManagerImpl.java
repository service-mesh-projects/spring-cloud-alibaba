package in.hocg.consumer.web.manager;

import in.hocg.consumer.web.entity.Consumer;
import in.hocg.consumer.web.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2020/5/13.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service(version = "1.0.0", interfaceClass = ConsumerManager.class)
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ConsumerManagerImpl implements ConsumerManager {
    private final ConsumerService service;
    
    @Override
    public Long updateRecord(Long id, String context) {
        final Consumer entity = new Consumer();
        entity.setId(id);
        entity.setContext(context);
        service.validInsertOrUpdate(entity);
        return entity.getId();
    }
    
    @Override
    public Long insertRecord(String context) {
        final Consumer entity = new Consumer();
        entity.setContext(context);
        entity.setCreatedAt(LocalDateTime.now());
        service.validInsert(entity);
        return entity.getId();
    }
    
    @Override
    public String findContextById(Long id) {
        final Consumer entity = service.getById(id);
        return entity.getContext();
    }
}
