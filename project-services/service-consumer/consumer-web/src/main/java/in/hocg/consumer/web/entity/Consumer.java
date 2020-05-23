package in.hocg.consumer.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.services.common.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Created by hocgin on 2020/5/12.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@TableName("t_consumer")
@EqualsAndHashCode(callSuper = true)
public class Consumer extends AbstractEntity<Consumer> {
    @TableId
    private Long id;
    @TableField(value = "context")
    private String context;
    @TableField(value = "created_at")
    private Date createdAt;
}
