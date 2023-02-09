package com.sewoomprojectv1.domain.common;

import com.sewoomprojectv1.converter.LocalDateTimeConverter;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    @Column(name = "CREATED_DATE", updatable = false)
    @Convert(converter= LocalDateTimeConverter.class)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "UPDATE_DATE")
    @Convert(converter= LocalDateTimeConverter.class)
    private LocalDateTime updateDate;

}