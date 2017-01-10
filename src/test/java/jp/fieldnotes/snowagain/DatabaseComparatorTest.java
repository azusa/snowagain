/*
 * Copyright 2017 Hiroyuki Onaka.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package jp.fieldnotes.snowagain;

import org.apache.ibatis.migration.DataSourceConnectionProvider;
import org.apache.ibatis.migration.FileMigrationLoader;
import org.apache.ibatis.migration.operations.UpOperation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lastaflute.di.core.SingletonLaContainer;
import org.lastaflute.di.core.factory.SingletonLaContainerFactory;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import java.io.File;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DatabaseComparatorTest {

    private TransactionManager tm;

    private DataSource ds;

    @BeforeEach
    public void before() throws  Exception{
        SingletonLaContainerFactory.init();
//        tm = SingletonLaContainer.getComponent(TransactionManager.class);
//        tm.begin();
        ds = SingletonLaContainer.getComponent(DataSource.class);
        Properties prop = new Properties();
        prop.load(DatabaseComparatorTest.class.getResourceAsStream("/development.properties"));
        FileMigrationLoader loader = new FileMigrationLoader(new File("src/test/resources/migration"), "UTF-8", prop);
        new UpOperation().operate(new DataSourceConnectionProvider(ds),loader, null, System.out);
    }

    @Test
    public void test() throws Exception {
        ds.getConnection().createStatement().execute("select * FROM DEPT");
    }

    @AfterEach
    public void after(){
        if (tm != null) {
            try {
                tm.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        SingletonLaContainerFactory.destroy();
    }
}