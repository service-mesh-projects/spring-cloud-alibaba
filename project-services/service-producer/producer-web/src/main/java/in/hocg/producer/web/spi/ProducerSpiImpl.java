package in.hocg.producer.web.spi;

import in.hocg.producer.spi.ProducerSpi;
import in.hocg.producer.web.entity.Producer;
import in.hocg.producer.web.service.ProducerService;
import io.seata.spring.annotation.GlobalTransactional;
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
@Service(version = "1.0.0", interfaceClass = ProducerSpi.class)
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ProducerSpiImpl implements ProducerSpi {
    private final ProducerService producerService;
    
    @Override
    public Long updateRecord(Long id, String context) {
        final Producer entity = new Producer();
        entity.setId(id);
        entity.setContext(context);
        producerService.validInsertOrUpdate(entity);
        return entity.getId();
    }
    
    @Override
    public Long insertRecord(String context) {
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
    
    @Override
    @GlobalTransactional
    public Long updateRecordUseGT(Long id, String context) {
        return this.updateRecord(id, context);
    }
    
    @Override
    @GlobalTransactional
    public Long insertRecordForProducerIdUseGT(Long id, String append) {
        final String context = findContextById(id);
        return this.insertRecord(context + append);
    }
}
