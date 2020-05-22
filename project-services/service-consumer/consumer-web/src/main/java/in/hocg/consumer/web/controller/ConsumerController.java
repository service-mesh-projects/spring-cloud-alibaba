package in.hocg.consumer.web.controller;

import in.hocg.consumer.web.entity.Consumer;
import in.hocg.consumer.web.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by hocgin on 2020/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ConsumerController {
    private final ConsumerService service;
    
    @GetMapping("/worked")
    public void worked() {
        final Consumer entity = new Consumer();
        entity.setContext(String.valueOf(System.currentTimeMillis()));
        entity.setCreatedAt(new Date());
        service.save(entity);
    }
}
