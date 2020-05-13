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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
    
    private final static ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(10, 10,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>());
    
    @Override
    @GlobalTransactional
    public Long planA(String message) {
        final Long id = producerManager.insertRecord(message);
        seataConsumer.throwException(String.format("%s 异常", message));
        return id;
    }
    
    @Override
    @GlobalTransactional
    public Long planB(String message) {
        final Long producerId = producerManager.insertRecord(message);
        
        final Long consumerId = consumerManager.insertRecord(message);
        
        seataConsumer.throwException(String.format("%s 异常", message));
        return null;
    }
    
    @Override
    @GlobalTransactional
    public Long planC(String message) throws InterruptedException {
        final Long producerId = producerManager.insertRecord(message);
        
        EXECUTOR_SERVICE.submit(() -> {
            producerManager.updateRecord(producerId, message + ":update");
        });
        
        // 保证线程被执行
        Thread.sleep(500);
        
        throw new UnsupportedOperationException(String.format("%s 异常", message));
    }
    
    @Override
    @GlobalTransactional
    public String planC2(String message) throws InterruptedException {
        final Long producerId = producerManager.insertRecord(message);
        
        EXECUTOR_SERVICE.submit(() -> {
            producerManager.updateRecordUseGT(producerId, message + ":update");
        });
        
        // 保证线程被执行
        Thread.sleep(500);
        
        throw new UnsupportedOperationException(String.format("%s 异常", message));
    }
    
    @Override
    @GlobalTransactional
    public String planD() throws InterruptedException {
        final Long producerId = producerManager.insertRecord("1");
        
        EXECUTOR_SERVICE.submit(() -> {
            producerManager.updateRecord(producerId, "2");
        });
        
        // 保证线程被执行
        Thread.sleep(500);
        final String context = producerManager.findContextById(producerId);
        return "ID: " + producerId + ", Context = " + context;
    }
    
    @Override
    @GlobalTransactional
    public String planE(String message) throws InterruptedException {
        final Long producerId = producerManager.insertRecord(message);
        EXECUTOR_SERVICE.submit(() -> {
            producerManager.insertRecordForProducerIdUseGT(producerId, ":INSERT");
        });
        
        // 保证线程被执行
        Thread.sleep(500);
        
        throw new UnsupportedOperationException(String.format("%s 异常", message));
    }
}
