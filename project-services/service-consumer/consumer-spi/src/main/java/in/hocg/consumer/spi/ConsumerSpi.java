package in.hocg.consumer.spi;

/**
 * Created by hocgin on 2020/5/13.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface ConsumerSpi {
    Long updateRecord(Long id, String context);
    
    Long insertRecord(String context);
    
    String findContextById(Long id);
}
