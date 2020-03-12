package com.sun.travel.domain.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author sun
 * @since 2020-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Banner extends Model<Banner> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    @TableLogic
    private Boolean deleted;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
