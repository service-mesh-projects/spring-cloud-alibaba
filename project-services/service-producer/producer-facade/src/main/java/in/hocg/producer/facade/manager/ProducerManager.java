package in.hocg.producer.facade.manager;

/**
 * Created by hocgin on 2020/5/13.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface ProducerManager {
    Long updateRecord(Long id, String context);
    
    Long insertRecord(String context);
    
    String findContextById(Long id);
    
    String sayHello(String name);
    
    Long updateRecordUseGT(Long id, String context);
    
    Long insertRecordForProducerIdUseGT(Long id, String append);
}
