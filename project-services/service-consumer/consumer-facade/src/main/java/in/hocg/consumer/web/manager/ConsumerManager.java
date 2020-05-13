package in.hocg.consumer.web.manager;

/**
 * Created by hocgin on 2020/5/13.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface ConsumerManager {
    Long saveRecord(String context);
    
    String findContextById(Long id);
}
