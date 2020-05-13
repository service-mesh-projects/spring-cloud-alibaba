package in.hocg.consumer.web.service;

/**
 * Created by hocgin on 2020/5/11.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface SeataService {
    
    Long planA(String message);
    
    Long planB(String message);
    
    Long planC(String message) throws InterruptedException;
    
    String planC2(String message) throws InterruptedException;
    
    String planD() throws InterruptedException;
    
    String planE(String message) throws InterruptedException;
}
