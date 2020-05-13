package in.hocg.consumer.web.controller;

import in.hocg.consumer.basic.result.Result;
import in.hocg.consumer.web.service.SeataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hocgin on 2020/5/11.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@RestController
@RequestMapping("/seata")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class SeataController {
    private final SeataService service;
    
    @GetMapping("/plan-a")
    public Result planA() {
        return Result.success(service.planA("PLAN A"));
    }
    
    @GetMapping("/plan-b")
    public Result planB() {
        return Result.success(service.planB("PLAN B"));
    }
    
    @GetMapping("/plan-c")
    public Result planC() {
        return Result.success(service.planC("PLAN C"));
    }
    
}
