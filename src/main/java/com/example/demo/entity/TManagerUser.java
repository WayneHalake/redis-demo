package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wayne
 * @since 2020-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TManagerUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private String userId;

    private String logName;

    private String logPwd;

    private String userName;

    /**
     * 手机号
     */
    private String mobilePhone;

    private String lastLogTime;

    /**
     * -1:无效,0:正常 1:冻结
     */
    private String userState;

    private String roleId;

    private String deptId;


}
