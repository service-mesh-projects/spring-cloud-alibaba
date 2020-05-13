package in.hocg.consumer.web.manager;

import in.hocg.producer.facade.manager.ProducerManager;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.context.annotation.Lazy;

/**
 * Created by hocgin on 2020/5/12.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service(version = "1.0.0", interfaceClass = SeataConsumer.class)
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class SeataManagerImpl implements SeataConsumer {
    
    private final ProducerManager producerManager;
    
    @Override
    public void throwException(String message) {
        throw new UnsupportedOperationException(message);
    }
    
    @Override
    public Long saveProduct(String context) {
        return producerManager.insertRecord(context);
    }
    
}
