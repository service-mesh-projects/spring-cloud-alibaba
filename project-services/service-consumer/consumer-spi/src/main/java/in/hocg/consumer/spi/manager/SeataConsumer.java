package in.hocg.consumer.spi.manager;

/**
 * Created by hocgin on 2020/5/12.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface SeataConsumer {
    void throwException(String message);
    
    Long saveProduct(String context);
}
