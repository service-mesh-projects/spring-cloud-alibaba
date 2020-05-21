package in.hocg.consumer.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.services.common.AbstractEntity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2020/5/12.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@TableName("t_consumer")
public class Consumer extends AbstractEntity<Consumer> {
    @TableId
    private Long id;
    @TableField(value = "context")
    private String context;
    @TableField(value = "created_at")
    private LocalDateTime createdAt;
}
