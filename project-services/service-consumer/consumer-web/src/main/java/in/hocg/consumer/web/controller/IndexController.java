package in.hocg.consumer.web.controller;

import in.hocg.consumer.basic.Conts;
import in.hocg.producer.spi.ProducerSpi;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hocgin on 2019/3/24.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@RestController
public class IndexController {
    
    @Reference(version = Conts.DUBBO_VERSION)
    private ProducerSpi producerManager;
    
    @GetMapping("/worked")
    public ResponseEntity ok() {
        return ResponseEntity.ok("Consumer -dubbo-> Producer" + producerManager.sayHello("hocgin"));
    }
    
}
