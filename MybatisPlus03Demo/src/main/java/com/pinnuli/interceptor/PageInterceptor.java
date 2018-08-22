package com.pinnuli.interceptor;

import java.sql.ResultSet;

import com.pinnuli.entity.Page;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;
import java.util.Properties;

/**
 * @author: pinnuli
 * @date: 18-8-22
 */

@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}))
public class PageInterceptor implements Interceptor {

    private String property;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        //配置文件中sql语句的id
        String id = mappedStatement.getId();
        if(id.matches(".+ByPage$")) {
            BoundSql boundSql = statementHandler.getBoundSql();
            //得到原始sql语句
            String sql = boundSql.getSql();
            //查询总条数
            String countSql = "select count(*) from (" + sql + ")a";

            Connection connection = (Connection) invocation.getArgs()[0];
            PreparedStatement countStatement = connection.prepareStatement(countSql);
            ParameterHandler parameterHandler= (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            ResultSet rs = countStatement.executeQuery();

            Map<?, ?> parameter = (Map<?, ?>) boundSql.getParameterObject();
            Page page = (Page) parameter.get("page");
            if(rs.next()) {
                page.setTotalNumber(rs.getInt(1));
            }
            //改造后 带分页的sql语句
            String pageSql = sql + " limit " + page.getDbIndex() + "," + page.getDbNumber();
            metaObject.setValue("delegate.boundSql.sql", pageSql);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    //用来获取plugin配置的属性值
    @Override
    public void setProperties(Properties properties) {
        this.property = properties.getProperty("test");
        System.out.println(this.property);
    }
}
