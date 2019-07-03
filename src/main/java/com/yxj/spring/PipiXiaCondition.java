package com.yxj.spring;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring
 * @Description:
 * @Author: 阿杰
 * @CreateDate: 2019/1/22 22:35
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/1/22 22:35
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class PipiXiaCondition implements Condition {

    /**
     *当name不为空的时候，判断如果name中包含appName的时候返回true
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return true;
    }
}
