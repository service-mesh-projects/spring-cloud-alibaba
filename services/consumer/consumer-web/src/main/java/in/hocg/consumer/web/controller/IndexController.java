package in.hocg.consumer.web.controller;

import in.hocg.producer.facade.service.ProducerService;
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
    
    @Reference(version = "1.0.0")
    private ProducerService producerService;
    
    @GetMapping("/worked")
    public ResponseEntity ok() {
        return ResponseEntity.ok("Consumer -dubbo-> Producer" + producerService.sayHello("hocgin"));
    }
    
}
