package in.hocg.producer.web.spi;

import in.hocg.producer.spi.SeataProducerSpi;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.context.annotation.Lazy;

/**
 * Created by hocgin on 2020/5/12.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service(version = "1.0.0", interfaceClass = SeataProducerSpi.class)
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class SeataProducerSpiImpl implements SeataProducerSpi {
    
    @Override
    public void throwException(String message) {
        throw new UnsupportedOperationException(message);
    }
}
