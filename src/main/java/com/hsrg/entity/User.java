package com.hsrg.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author nzf
 * @since 2023-05-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private Long userId;

    private String nickName;

    private String imageUrl;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;


}
