package in.hocg.consumer.web.service;

/**
 * Created by hocgin on 2020/5/11.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface SeataService {
    
    /**
     * 1. a[db - ✔️] -> b[db - ✖️]
     * > 目标结果: a 数据被回滚
     *
     * @return
     */
    Long planA(String message);
    
    /**
     * 2. a[db - ✔️] -> b[db - ✔️] -> b[db - ✖️]
     * > 目标结果: a 数据被回滚, b 数据被回滚
     *
     * @param message
     * @return
     */
    Long planB(String message);
    
    /**
     * 3. a[db - ✔️] -> b[db - ✔️] -> a[db - ✔️] -> a[✖️]
     * > 目标结果: a 数据被回滚, b 数据被回滚
     *
     * @param message
     * @return
     */
    Long planC(String message);
    
}
