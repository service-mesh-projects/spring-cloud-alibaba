package in.hocg.producer.web.service;

import in.hocg.producer.web.entity.Producer;
import in.hocg.services.common.AbstractService;

/**
 * Created by hocgin on 2019/4/23.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface ProducerService extends AbstractService<Producer> {
    String sayHello(String name);
}
