%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository=%cd%/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/dom4j-1.6.1.jar;../lib/jtds-1.3.1-patch.jar;../lib/log4j-1.2.17.jar;../lib/talend_DB_mssqlUtil-1.2-20171017.jar;../lib/talendcsv.jar;elt_prueba_3_0_1.jar; lp_prueba1.elt_prueba_3_0_1.ELT_Prueba_3  %*