package in.hocg.consumer.web.spi;

import in.hocg.consumer.basic.Conts;
import in.hocg.consumer.spi.SeataConsumerSpi;
import in.hocg.producer.spi.ProducerSpi;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.context.annotation.Lazy;

/**
 * Created by hocgin on 2020/5/12.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service(version = Conts.DUBBO_VERSION, interfaceClass = SeataConsumerSpi.class)
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class SeataConsumerSpiImpl implements SeataConsumerSpi {
    
    private final ProducerSpi producerManager;
    
    @Override
    public void throwException(String message) {
        throw new UnsupportedOperationException(message);
    }
    
    @Override
    public Long saveProduct(String context) {
        return producerManager.insertRecord(context);
    }
    
}
