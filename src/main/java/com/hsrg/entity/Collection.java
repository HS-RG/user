package com.hsrg.entity;

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
public class Collection implements Serializable {

    private long userId;

    private String fileId;

    private LocalTime createTime;


}
