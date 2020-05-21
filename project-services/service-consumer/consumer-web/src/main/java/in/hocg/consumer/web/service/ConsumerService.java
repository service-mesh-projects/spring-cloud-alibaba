package in.hocg.consumer.web.service;

import in.hocg.consumer.web.entity.Consumer;
import in.hocg.services.common.AbstractService;

/**
 * Created by hocgin on 2020/5/13.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface ConsumerService extends AbstractService<Consumer> {
    String sayHello(String name);
}
