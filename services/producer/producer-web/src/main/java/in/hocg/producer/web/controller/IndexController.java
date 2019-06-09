package in.hocg.producer.web.controller;

import in.hocg.producer.facade.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
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
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class IndexController {
    
    private final ProducerService producerService;
    
    @GetMapping("/worked")
    public ResponseEntity ok() {
        return ResponseEntity.ok("Ok Producer " + producerService.sayHello("hocgin"));
    }
    
}
