package org.geekbang.java.many.data.source.fx.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.geekbang.java.many.data.source.annotation.ReadOnlyDataBase;
import org.geekbang.java.many.data.source.fx.config.DynamicDataSourceConfig;
import org.geekbang.java.many.data.source.fx.constant.DataSourceConstant;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(org.geekbang.java.many.data.source.annotation.ReadOnlyDataBase)")
    public void datasourcePointCut() {}
    
    @Around("datasourcePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        ReadOnlyDataBase rodb = method.getAnnotation(ReadOnlyDataBase.class);
        
        if (rodb != null) {
            if (rodb.readOnly()) {
                String slave = loadBalance();
                DynamicDataSourceConfig.setDataSource(slave);
            } else {
                DynamicDataSourceConfig.setDataSource(DataSourceConstant.MASTER);
            }
        } else {
            DynamicDataSourceConfig.setDataSource(DataSourceConstant.SLAVE_ONE);
        }
        try {
            return joinPoint.proceed();
        } finally {
            DynamicDataSourceConfig.clearDataSource();
//            throwable.printStackTrace();
        }
    }

    private String loadBalance() {
        Random random = new Random();
        int f = random.nextInt(2) + 1;
        switch (f) {
            case 1:
                return DataSourceConstant.MASTER;
            case 2:
                return DataSourceConstant.SLAVE_TOW;
            case 3:
                return DataSourceConstant.SLAVE_ONE;
            default:
                return null;
        }
    }
}
