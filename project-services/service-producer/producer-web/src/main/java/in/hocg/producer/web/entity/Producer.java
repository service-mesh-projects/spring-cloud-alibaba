package in.hocg.producer.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.producer.basic.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2020/5/12.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_producer")
public class Producer extends AbstractEntity<Producer> {
    @TableId
    private Long id;
    @TableField(value = "context")
    private String context;
    @TableField(value = "created_at")
    private LocalDateTime createdAt;
}
