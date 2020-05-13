package in.hocg.consumer.web.service.impl;

import in.hocg.consumer.basic.Conts;
import in.hocg.consumer.web.manager.ConsumerManager;
import in.hocg.consumer.web.manager.SeataConsumer;
import in.hocg.consumer.web.service.SeataService;
import in.hocg.producer.facade.manager.ProducerManager;
import in.hocg.producer.facade.manager.SeataProducer;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Created by hocgin on 2020/5/11.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class SeataServiceImpl implements SeataService {
    @Reference(version = Conts.DUBBO_VERSION)
    private ProducerManager producerManager;
    @Reference(version = Conts.DUBBO_VERSION)
    private ConsumerManager consumerManager;
    @Reference(version = Conts.DUBBO_VERSION)
    private SeataConsumer seataConsumer;
    @Reference(version = Conts.DUBBO_VERSION)
    private SeataProducer seataProducer;
    
    @Override
    @GlobalTransactional
    public Long planA(String message) {
        final Long id = producerManager.saveRecord(message);
        seataConsumer.throwException(String.format("%s 异常", message));
        return id;
    }
    
    @Override
    @GlobalTransactional
    public Long planB(String message) {
        final Long producerId = producerManager.saveRecord(message);
    
        final Long consumerId = consumerManager.saveRecord(message);
        
        seataConsumer.throwException(String.format("%s 异常", message));
        return null;
    }
    
    @Override
    @GlobalTransactional
    public Long planC(String message) {
        final Long producerId = producerManager.saveRecord(message);
    
        final Long consumerId = consumerManager.saveRecord(message);
    
        final Long saveProduct = seataConsumer.saveProduct(message);
    
        throw new UnsupportedOperationException(String.format("%s 异常", message));
    }
}
