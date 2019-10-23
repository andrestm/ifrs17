package org.talend.designer.codegen.translators.databases.dbspecifics.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;
import java.util.List;
import java.util.Map;

public class THiveRowBeginJava
{
  protected static String nl;
  public static synchronized THiveRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveRowBeginJava result = new THiveRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_30 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_31 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_33 = " - Uses an existing connection ";
  protected final String TEXT_34 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_36 = " - Uses an existing connection. Connection URL: \" + conn_";
  protected final String TEXT_37 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_39 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_40 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_41 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\tconn_";
  protected final String TEXT_44 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_45 = ", dbUser_";
  protected final String TEXT_46 = ", dbPwd_";
  protected final String TEXT_47 = ");" + NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\tconn_";
  protected final String TEXT_49 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_50 = ");" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\tconn_";
  protected final String TEXT_52 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\tconn_";
  protected final String TEXT_54 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\tconn_";
  protected final String TEXT_56 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\tconn_";
  protected final String TEXT_58 = ".setAutoCommit(";
  protected final String TEXT_59 = ");" + NL + "\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\tlog.";
  protected final String TEXT_61 = "(\"";
  protected final String TEXT_62 = " - \" + ";
  protected final String TEXT_63 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t    \t\tlog.";
  protected final String TEXT_65 = "(\"";
  protected final String TEXT_66 = "\");" + NL + "\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_68 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_70 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_71 = ": pstmt_";
  protected final String TEXT_72 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_73 = " += (countEach_";
  protected final String TEXT_74 = " < 0 ? 0 : ";
  protected final String TEXT_75 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_76 = NL;
  protected final String TEXT_77 = NL + NL + "\t\t";
  protected final String TEXT_78 = NL + "\tjava.io.File localPigLatin_";
  protected final String TEXT_79 = " = new java.io.File(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tjava.io.FileWriter fw_";
  protected final String TEXT_80 = " = new java.io.FileWriter(localPigLatin_";
  protected final String TEXT_81 = ".getAbsoluteFile());" + NL + "\tjava.io.BufferedWriter bw_";
  protected final String TEXT_82 = " = new java.io.BufferedWriter(fw_";
  protected final String TEXT_83 = ");" + NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_84 = " = new StringBuilder();";
  protected final String TEXT_85 = " " + NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_86 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_89 = " = ";
  protected final String TEXT_90 = "; ";
  protected final String TEXT_91 = " " + NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_92 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_93 = ");";
  protected final String TEXT_94 = NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_95 = " = ";
  protected final String TEXT_96 = "; ";
  protected final String TEXT_97 = NL + "\t\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_98 = " = new org.talend.bigdata.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t\t+ \"AccountName=\"" + NL + "\t\t\t+ ";
  protected final String TEXT_99 = NL + "\t\t\t+ \";\"" + NL + "\t\t\t+ \"AccountKey=\" + wasbPassword_";
  protected final String TEXT_100 = ", ";
  protected final String TEXT_101 = ");" + NL + "\t\t\t\t" + NL + "\t\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_102 = " = new org.talend.bigdata.launcher.webhcat.QueryJob(azureFs_";
  protected final String TEXT_103 = ", org.talend.bigdata.launcher.utils.JobType.HIVE);" + NL + "\t\t\t\t\t\t" + NL + "\t\tinstance_";
  protected final String TEXT_104 = ".setCredentials(new org.talend.bigdata.launcher.security.HDInsightCredentials(";
  protected final String TEXT_105 = ", hdInsightPassword_";
  protected final String TEXT_106 = "));" + NL + "\t\tinstance_";
  protected final String TEXT_107 = ".setUsername(";
  protected final String TEXT_108 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_109 = ".setWebhcatEndpoint(\"https\", ";
  protected final String TEXT_110 = " + \":\" + ";
  protected final String TEXT_111 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_112 = ".setStatusFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_113 = "));" + NL + "\t\tinstance_";
  protected final String TEXT_114 = ".setRemoteFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_115 = "));";
  protected final String TEXT_116 = NL + "\t\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_117 = " = (org.talend.bigdata.launcher.webhcat.WebHCatJob) globalMap.get(\"conn_";
  protected final String TEXT_118 = "\");" + NL + "\t\t" + NL + "\t\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_119 = " = instance_";
  protected final String TEXT_120 = ".getFileSystem();\t\t" + NL + "\t\t" + NL + "\t\tjava.util.List<String> connectionCommandList_";
  protected final String TEXT_121 = " = (java.util.List<String>)globalMap.get(\"commandList_";
  protected final String TEXT_122 = "\");" + NL + "\t\tfor(String command : connectionCommandList_";
  protected final String TEXT_123 = ") {" + NL + "\t\t\tbw_";
  protected final String TEXT_124 = ".write(command);" + NL + "\t\t}";
  protected final String TEXT_125 = NL + "\t((org.talend.bigdata.launcher.webhcat.QueryJob)instance_";
  protected final String TEXT_126 = ").setFileToExecute(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tString wasbPath_";
  protected final String TEXT_127 = " = azureFs_";
  protected final String TEXT_128 = ".getFileSystemPrefix() + \"/\"\t+ instance_";
  protected final String TEXT_129 = ".getRemoteFolder()\t+ \"/libjars/\";" + NL;
  protected final String TEXT_130 = NL + "\t\t\t\tbw_";
  protected final String TEXT_131 = ".write(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_132 = " + \";\");" + NL + "\t\t\t\tbw_";
  protected final String TEXT_133 = ".write(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_134 = " + \";\");" + NL + "\t\t\t\tbw_";
  protected final String TEXT_135 = ".write(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_136 = " + \";\");";
  protected final String TEXT_137 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_138 = ".write(\"SET \"+";
  protected final String TEXT_139 = "+\"=\"+";
  protected final String TEXT_140 = " + \";\");";
  protected final String TEXT_141 = NL + "\t\t\tString dbname_";
  protected final String TEXT_142 = " = ";
  protected final String TEXT_143 = ";" + NL + "\t\t\tif(dbname_";
  protected final String TEXT_144 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_145 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_146 = ".trim())) {" + NL + "\t\t\t\tbw_";
  protected final String TEXT_147 = ".write(\"use \" + dbname_";
  protected final String TEXT_148 = " + \";\");" + NL + "\t\t\t}";
  protected final String TEXT_149 = NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_150 = " = new StringBuilder();" + NL + "\tString stagingBucketPath_";
  protected final String TEXT_151 = " = \"\";";
  protected final String TEXT_152 = NL + "        java.util.List<String> connectionCommandList_";
  protected final String TEXT_153 = " = new java.util.ArrayList<String>();  ";
  protected final String TEXT_154 = NL + "            connectionCommandList_";
  protected final String TEXT_155 = ".add(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_156 = " + \";\");" + NL + "            connectionCommandList_";
  protected final String TEXT_157 = ".add(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_158 = " + \";\");" + NL + "            connectionCommandList_";
  protected final String TEXT_159 = ".add(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_160 = " + \";\");";
  protected final String TEXT_161 = NL + "                connectionCommandList_";
  protected final String TEXT_162 = ".add(\"SET \"+";
  protected final String TEXT_163 = "+\"=\"+";
  protected final String TEXT_164 = " + \";\");";
  protected final String TEXT_165 = NL + NL + "        String dbname_";
  protected final String TEXT_166 = " = ";
  protected final String TEXT_167 = ";" + NL + "        if(dbname_";
  protected final String TEXT_168 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_169 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_170 = ".trim())) {" + NL + "            connectionCommandList_";
  protected final String TEXT_171 = ".add(\"use \" + dbname_";
  protected final String TEXT_172 = " + \";\");" + NL + "        }" + NL + "        " + NL + "        stagingBucketPath_";
  protected final String TEXT_173 = " = ";
  protected final String TEXT_174 = ";" + NL + "" + NL + "        org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob instance_";
  protected final String TEXT_175 = " =" + NL + "            new org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob.Builder()" + NL + "            .withTalendJobName(projectName + \"_\" + jobName + \"_\" + jobVersion.replace(\".\",\"_\") + \"_\" + pid)" + NL + "            .withClusterName(";
  protected final String TEXT_176 = ")" + NL + "            .withRegion(";
  protected final String TEXT_177 = ")" + NL + "            .withProjectId(";
  protected final String TEXT_178 = ")" + NL + "            .withJarsBucket(";
  protected final String TEXT_179 = ")";
  protected final String TEXT_180 = NL + "                .withServiceAccountCredentialsPath(";
  protected final String TEXT_181 = ")";
  protected final String TEXT_182 = NL + NL + "            .withInitialisationQueries(connectionCommandList_";
  protected final String TEXT_183 = ")" + NL + "            .build();";
  protected final String TEXT_184 = NL + "            for (String command: connectionCommandList_";
  protected final String TEXT_185 = " ) {" + NL + "                log.debug(\"Initialization command from ";
  protected final String TEXT_186 = ": \" + command);" + NL + "            }";
  protected final String TEXT_187 = NL + "        org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob instance_";
  protected final String TEXT_188 = " = (org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob) globalMap.get(\"conn_";
  protected final String TEXT_189 = "\");" + NL + "        stagingBucketPath_";
  protected final String TEXT_190 = " = (String) globalMap.get(\"stagingBucket_";
  protected final String TEXT_191 = "\");" + NL + "        instance_";
  protected final String TEXT_192 = ".clearQueriesCache();" + NL + "        instance_";
  protected final String TEXT_193 = ".clearLibJars();";
  protected final String TEXT_194 = NL + "\t\t";
  protected final String TEXT_195 = NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_196 = " = new StringBuilder();" + NL + "\tString stagingBucketPath_";
  protected final String TEXT_197 = " = \"\";";
  protected final String TEXT_198 = NL + "        java.util.List<String> connectionCommandList_";
  protected final String TEXT_199 = " = new java.util.ArrayList<String>();  ";
  protected final String TEXT_200 = NL + "            connectionCommandList_";
  protected final String TEXT_201 = ".add(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_202 = " + \";\");" + NL + "            connectionCommandList_";
  protected final String TEXT_203 = ".add(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_204 = " + \";\");" + NL + "            connectionCommandList_";
  protected final String TEXT_205 = ".add(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_206 = " + \";\");";
  protected final String TEXT_207 = NL + "                connectionCommandList_";
  protected final String TEXT_208 = ".add(\"SET \"+";
  protected final String TEXT_209 = "+\"=\"+";
  protected final String TEXT_210 = " + \";\");";
  protected final String TEXT_211 = NL + NL + "        String dbname_";
  protected final String TEXT_212 = " = ";
  protected final String TEXT_213 = ";" + NL + "        if(dbname_";
  protected final String TEXT_214 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_215 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_216 = ".trim())) {" + NL + "            connectionCommandList_";
  protected final String TEXT_217 = ".add(\"use \" + dbname_";
  protected final String TEXT_218 = " + \";\");" + NL + "        }" + NL + "" + NL + "\t \tString api_token_";
  protected final String TEXT_219 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_220 = ");" + NL + "\t" + NL + "\t\torg.talend.bigdata.launcher.qubole.QuboleHiveClient instance_";
  protected final String TEXT_221 = " =" + NL + "\t\t\tnew org.talend.bigdata.launcher.qubole.QuboleHiveClient.Builder()" + NL + "\t\t\t\t.setApiKey(api_token_";
  protected final String TEXT_222 = ")" + NL + "\t\t\t\t";
  protected final String TEXT_223 = " .setApiEndpoint(";
  protected final String TEXT_224 = ") ";
  protected final String TEXT_225 = NL + "\t\t\t\t.build();" + NL + "        ";
  protected final String TEXT_226 = NL + "            for (String command: connectionCommandList_";
  protected final String TEXT_227 = " ) {" + NL + "                log.debug(\"Initialization command from ";
  protected final String TEXT_228 = ": \" + command);" + NL + "            }";
  protected final String TEXT_229 = NL + "        org.talend.bigdata.launcher.qubole.QuboleHiveClient instance_";
  protected final String TEXT_230 = " = (org.talend.bigdata.launcher.qubole.QuboleHiveClient) globalMap.get(\"conn_";
  protected final String TEXT_231 = "\");" + NL + "        java.util.List<String> connectionCommandList_";
  protected final String TEXT_232 = " = null;" + NL + "        if (globalMap.containsKey(\"conn_init_statements_";
  protected final String TEXT_233 = "\")) {" + NL + "        \tconnectionCommandList_";
  protected final String TEXT_234 = " = (java.util.List<String>) globalMap.get(\"conn_init_statements_";
  protected final String TEXT_235 = "\");" + NL + "        \tglobalMap.remove(\"conn_init_statements_";
  protected final String TEXT_236 = "\");" + NL + "        }";
  protected final String TEXT_237 = NL + "\t\t";
  protected final String TEXT_238 = NL;
  protected final String TEXT_239 = NL + NL + "java.sql.Connection conn_";
  protected final String TEXT_240 = " = null;";
  protected final String TEXT_241 = NL + "\t\tSystem.setProperty(\"java.io.tmpdir\", ";
  protected final String TEXT_242 = ");";
  protected final String TEXT_243 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_244 = ");";
  protected final String TEXT_245 = NL + "\t\tconn_";
  protected final String TEXT_246 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_247 = "\");" + NL + "" + NL + "\t\tString dbname_";
  protected final String TEXT_248 = " = (String)globalMap.get(\"";
  protected final String TEXT_249 = "\");" + NL + "    \tif(dbname_";
  protected final String TEXT_250 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_251 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_252 = ".trim())) {" + NL + "        \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_253 = " = conn_";
  protected final String TEXT_254 = ".createStatement();" + NL + "        \tgoToDatabase_";
  protected final String TEXT_255 = ".execute(\"use \" + dbname_";
  protected final String TEXT_256 = ");" + NL + "        \tgoToDatabase_";
  protected final String TEXT_257 = ".close();" + NL + "    \t}" + NL + "" + NL + "    \tString dbUser_";
  protected final String TEXT_258 = " = (String)globalMap.get(\"";
  protected final String TEXT_259 = "\");" + NL + "" + NL + "    \tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_260 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "\t\tif(dbUser_";
  protected final String TEXT_261 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_262 = ".trim())) {" + NL + "\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_263 = ");" + NL + "\t\t\t//make relative file path work for hive" + NL + "\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_264 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_265 = NL + "\t\t\tif(true) {" + NL + "\t\t\t\tthrow new java.lang.Exception(\"The distribution ";
  protected final String TEXT_266 = " does not support this version of Hive . Please check your component configuration.\");" + NL + "\t\t\t}";
  protected final String TEXT_267 = NL + "\t\t\tif(true) {" + NL + "\t\t\t\tthrow new java.lang.Exception(\"The distribution ";
  protected final String TEXT_268 = " does not support this connection mode . Please check your component configuration.\");" + NL + "\t\t\t}";
  protected final String TEXT_269 = NL + "\t\t\tif(true) {" + NL + "\t\t\t\tthrow new java.lang.Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t}";
  protected final String TEXT_270 = NL + "\t\t\t\tSystem.setProperty(";
  protected final String TEXT_271 = " ,";
  protected final String TEXT_272 = ");";
  protected final String TEXT_273 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_274 = ");" + NL + "\t\t\t";
  protected final String TEXT_275 = NL + "\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"false\");" + NL + "\t\t\t\t";
  protected final String TEXT_276 = NL + "\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"true\");" + NL + "\t\t\t\t";
  protected final String TEXT_277 = NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_278 = ");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_279 = ");" + NL + "" + NL + "    \t\t";
  protected final String TEXT_280 = NL + NL + "    \t\t";
  protected final String TEXT_281 = NL + "        \tString decryptedMetastorePassword_";
  protected final String TEXT_282 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_283 = ");" + NL + "   \t\t \t";
  protected final String TEXT_284 = NL + "        \tString decryptedMetastorePassword_";
  protected final String TEXT_285 = " = ";
  protected final String TEXT_286 = ";" + NL + "\t\t\t";
  protected final String TEXT_287 = NL + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", decryptedMetastorePassword_";
  protected final String TEXT_288 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_289 = ");" + NL + "\t\t\t";
  protected final String TEXT_290 = NL + "\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.principal\", ";
  protected final String TEXT_291 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.keytab\", ";
  protected final String TEXT_292 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_293 = NL;
  protected final String TEXT_294 = NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_295 = ", ";
  protected final String TEXT_296 = ");";
  protected final String TEXT_297 = NL + "\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_298 = ");";
  protected final String TEXT_299 = NL + "\t\t\tSystem.setProperty(\"";
  protected final String TEXT_300 = "\", ";
  protected final String TEXT_301 = ");";
  protected final String TEXT_302 = NL + "\t\tString dbUser_";
  protected final String TEXT_303 = " = ";
  protected final String TEXT_304 = ";" + NL + "" + NL + "\t\t";
  protected final String TEXT_305 = NL + NL + "\t\t";
  protected final String TEXT_306 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_307 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_308 = ");";
  protected final String TEXT_309 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_310 = " = ";
  protected final String TEXT_311 = "; ";
  protected final String TEXT_312 = NL + NL + "\t\tString dbPwd_";
  protected final String TEXT_313 = " = decryptedPassword_";
  protected final String TEXT_314 = ";" + NL;
  protected final String TEXT_315 = NL + "            String username_";
  protected final String TEXT_316 = " = ";
  protected final String TEXT_317 = ";" + NL + "            if(username_";
  protected final String TEXT_318 = "!=null && !\"\".equals(username_";
  protected final String TEXT_319 = ".trim())) {" + NL + "                System.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_320 = ");" + NL + "            }";
  protected final String TEXT_321 = NL + "        globalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_322 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_323 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_324 = " + \":\" + ";
  protected final String TEXT_325 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\tString url_";
  protected final String TEXT_326 = " = \"jdbc:";
  protected final String TEXT_327 = "://\";";
  protected final String TEXT_328 = NL + "\t\t\t\tif(dbUser_";
  protected final String TEXT_329 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_330 = ".trim())) {" + NL + "\t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_331 = ");" + NL + "\t\t\t\t\t//make relative file path work for hive" + NL + "\t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_332 = ");" + NL + "\t\t\t\t}";
  protected final String TEXT_333 = NL + "                        System.setProperty(\"pname\", \"MapRLogin\");" + NL + "                        System.setProperty(\"https.protocols\", \"TLSv1.2\");" + NL + "                        System.setProperty(\"mapr.home.dir\", ";
  protected final String TEXT_334 = ");" + NL + "                        System.setProperty(\"hadoop.login\", ";
  protected final String TEXT_335 = ");";
  protected final String TEXT_336 = NL + "\t\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_337 = ", ";
  protected final String TEXT_338 = ");";
  protected final String TEXT_339 = NL + "\t\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_340 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_341 = ");";
  protected final String TEXT_342 = NL + "\t\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_343 = " = ";
  protected final String TEXT_344 = ";";
  protected final String TEXT_345 = NL + "\t\t\t\t\t\t\tString url_";
  protected final String TEXT_346 = " = \"jdbc:";
  protected final String TEXT_347 = "://\" + ";
  protected final String TEXT_348 = " + \":\" + ";
  protected final String TEXT_349 = " + \"/\" + ";
  protected final String TEXT_350 = " + \";principal=\" + ";
  protected final String TEXT_351 = "+\";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_352 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_353 = ";";
  protected final String TEXT_354 = NL + "\t\t\t\t\t\t\tString url_";
  protected final String TEXT_355 = " = \"jdbc:";
  protected final String TEXT_356 = "://\" + ";
  protected final String TEXT_357 = " + \":\" + ";
  protected final String TEXT_358 = " + \"/\" + ";
  protected final String TEXT_359 = " + \";principal=\" + ";
  protected final String TEXT_360 = "+\";sasl.qop=auth-conf\";";
  protected final String TEXT_361 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_362 = " = \"jdbc:";
  protected final String TEXT_363 = "://\" + ";
  protected final String TEXT_364 = " + \":\" + ";
  protected final String TEXT_365 = " + \"/\" + ";
  protected final String TEXT_366 = " + \";principal=\" + ";
  protected final String TEXT_367 = ";";
  protected final String TEXT_368 = NL + "                        com.mapr.login.client.MapRLoginHttpsClient maprLogin_";
  protected final String TEXT_369 = " = new com.mapr.login.client.MapRLoginHttpsClient();" + NL + "                        maprLogin_";
  protected final String TEXT_370 = ".getMapRCredentialsViaKerberos(";
  protected final String TEXT_371 = ", ";
  protected final String TEXT_372 = ");";
  protected final String TEXT_373 = NL + "                        System.setProperty(\"pname\", \"MapRLogin\");" + NL + "                        System.setProperty(\"https.protocols\", \"TLSv1.2\");" + NL + "                        System.setProperty(\"mapr.home.dir\", ";
  protected final String TEXT_374 = ");" + NL + "                        com.mapr.login.client.MapRLoginHttpsClient maprLogin_";
  protected final String TEXT_375 = " = new com.mapr.login.client.MapRLoginHttpsClient();";
  protected final String TEXT_376 = NL + "                            System.setProperty(\"hadoop.login\", ";
  protected final String TEXT_377 = ");";
  protected final String TEXT_378 = NL + "                            maprLogin_";
  protected final String TEXT_379 = ".setCheckUGI(false);";
  protected final String TEXT_380 = NL + "                            String decryptedMaprPassword_";
  protected final String TEXT_381 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_382 = ");";
  protected final String TEXT_383 = NL + "                            String decryptedMaprPassword_";
  protected final String TEXT_384 = " = ";
  protected final String TEXT_385 = ";";
  protected final String TEXT_386 = NL + "                \t\t\t\tmaprLogin_";
  protected final String TEXT_387 = ".getMapRCredentialsViaPassword(";
  protected final String TEXT_388 = ", ";
  protected final String TEXT_389 = ", decryptedMaprPassword_";
  protected final String TEXT_390 = ", ";
  protected final String TEXT_391 = ", \"\");" + NL + "                \t\t\t\t";
  protected final String TEXT_392 = NL + "                \t\t\t\tmaprLogin_";
  protected final String TEXT_393 = ".getMapRCredentialsViaPassword(";
  protected final String TEXT_394 = ", ";
  protected final String TEXT_395 = ", decryptedMaprPassword_";
  protected final String TEXT_396 = ", ";
  protected final String TEXT_397 = ");" + NL + "                \t\t\t\t";
  protected final String TEXT_398 = NL + "\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_399 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_400 = ");";
  protected final String TEXT_401 = NL + "\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_402 = " = ";
  protected final String TEXT_403 = ";";
  protected final String TEXT_404 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_405 = " = \"jdbc:";
  protected final String TEXT_406 = "://\" + ";
  protected final String TEXT_407 = " + \":\" + ";
  protected final String TEXT_408 = " + \"/\" + ";
  protected final String TEXT_409 = "+ \";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_410 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_411 = ";";
  protected final String TEXT_412 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_413 = " = \"jdbc:";
  protected final String TEXT_414 = "://\" + ";
  protected final String TEXT_415 = " + \":\" + ";
  protected final String TEXT_416 = " + \"/\" + ";
  protected final String TEXT_417 = ";";
  protected final String TEXT_418 = NL + "\t\t\t\tString additionalJdbcSettings_";
  protected final String TEXT_419 = " = ";
  protected final String TEXT_420 = ";" + NL + "\t\t\t\tif(!\"\".equals(additionalJdbcSettings_";
  protected final String TEXT_421 = ".trim())) {" + NL + "\t\t\t\t\tif(!additionalJdbcSettings_";
  protected final String TEXT_422 = ".startsWith(\";\")) {" + NL + "\t\t\t\t\t\tadditionalJdbcSettings_";
  protected final String TEXT_423 = " = \";\" + additionalJdbcSettings_";
  protected final String TEXT_424 = ";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_425 = " += additionalJdbcSettings_";
  protected final String TEXT_426 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_427 = NL + "\t\tString driverClass_";
  protected final String TEXT_428 = " = \"";
  protected final String TEXT_429 = "\";" + NL + "\t\tjava.lang.Class.forName(driverClass_";
  protected final String TEXT_430 = ");" + NL + "\t\t";
  protected final String TEXT_431 = NL + "\t\t";
  protected final String TEXT_432 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_433 = " - Connection attempt to '\" + url_";
  protected final String TEXT_434 = " + \"' with the username '\" + dbUser_";
  protected final String TEXT_435 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_436 = NL + "\t\t\tconn_";
  protected final String TEXT_437 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_438 = ");";
  protected final String TEXT_439 = NL + "\t\t\tconn_";
  protected final String TEXT_440 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_441 = ", dbUser_";
  protected final String TEXT_442 = ", dbPwd_";
  protected final String TEXT_443 = ");";
  protected final String TEXT_444 = NL + "\t\t";
  protected final String TEXT_445 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_446 = " - Connection to '\" + url_";
  protected final String TEXT_447 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_448 = NL + NL + "\t\tjava.sql.Statement init_";
  protected final String TEXT_449 = " = conn_";
  protected final String TEXT_450 = ".createStatement();";
  protected final String TEXT_451 = NL + "        \tinit_";
  protected final String TEXT_452 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_453 = ");" + NL + "\t    \tinit_";
  protected final String TEXT_454 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_455 = ");";
  protected final String TEXT_456 = NL + "\t\tinit_";
  protected final String TEXT_457 = ".execute(\"SET dfs.namenode.kerberos.principal=\" + ";
  protected final String TEXT_458 = ");";
  protected final String TEXT_459 = NL + "\t\t\tinit_";
  protected final String TEXT_460 = ".execute(\"SET mapreduce.jobtracker.kerberos.principal=\" + ";
  protected final String TEXT_461 = ");";
  protected final String TEXT_462 = NL + "\t\t\tinit_";
  protected final String TEXT_463 = ".execute(\"SET yarn.resourcemanager.principal=\" + ";
  protected final String TEXT_464 = ");";
  protected final String TEXT_465 = NL + "        \t\tinit_";
  protected final String TEXT_466 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "        \t\tinit_";
  protected final String TEXT_467 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_468 = ");";
  protected final String TEXT_469 = NL + "\t\t\t\tinit_";
  protected final String TEXT_470 = ".execute(\"SET mapreduce.jobhistory.address=\" + ";
  protected final String TEXT_471 = ");" + NL + "    \t\t\t";
  protected final String TEXT_472 = NL + "\t\t\t\tinit_";
  protected final String TEXT_473 = ".execute(\"SET yarn.resourcemanager.scheduler.address=\" + ";
  protected final String TEXT_474 = ");";
  protected final String TEXT_475 = NL + "                init_";
  protected final String TEXT_476 = ".execute(\"SET dfs.client.use.datanode.hostname=true\");";
  protected final String TEXT_477 = NL + "\t\t\t\tinit_";
  protected final String TEXT_478 = ".execute(\"SET fs.default.name=\" + ";
  protected final String TEXT_479 = ");";
  protected final String TEXT_480 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_481 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_482 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_483 = ".execute(\"SET mapreduce.job.map.output.collector.class=org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "\t\t\t\t\tinit_";
  protected final String TEXT_484 = ".execute(\"SET mapreduce.job.reduce.shuffle.consumer.plugin.class=org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_485 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_486 = ".execute(\"SET mapreduce.application.classpath=";
  protected final String TEXT_487 = "\");";
  protected final String TEXT_488 = NL + "\t\t\t\tinit_";
  protected final String TEXT_489 = ".execute(\"SET yarn.application.classpath=";
  protected final String TEXT_490 = "\");";
  protected final String TEXT_491 = NL + "    \t\t\tinit_";
  protected final String TEXT_492 = ".execute(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_493 = ");" + NL + "    \t\t\tinit_";
  protected final String TEXT_494 = ".execute(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_495 = ");" + NL + "    \t\t\tinit_";
  protected final String TEXT_496 = ".execute(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_497 = ");";
  protected final String TEXT_498 = NL + "\t\t\t\tinit_";
  protected final String TEXT_499 = ".execute(\"SET \"+";
  protected final String TEXT_500 = "+\"=\"+";
  protected final String TEXT_501 = ");";
  protected final String TEXT_502 = NL + NL + "\t\t";
  protected final String TEXT_503 = NL + "        \t";
  protected final String TEXT_504 = NL;
  protected final String TEXT_505 = NL + "    \t\tinit_";
  protected final String TEXT_506 = ".execute(\"SET hive.execution.engine=tez\");";
  protected final String TEXT_507 = NL + "                        System.err.println(\"Please set the path of Tez lib in 'Tez lib path'!\");";
  protected final String TEXT_508 = NL;
  protected final String TEXT_509 = NL + "        String username_";
  protected final String TEXT_510 = " = (";
  protected final String TEXT_511 = " != null && !\"\".equals(";
  protected final String TEXT_512 = ")) ? ";
  protected final String TEXT_513 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_514 = " = null;";
  protected final String TEXT_515 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_516 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_517 = ".set(\"";
  protected final String TEXT_518 = "\", ";
  protected final String TEXT_519 = ");" + NL + "        ";
  protected final String TEXT_520 = NL + "            conf_";
  protected final String TEXT_521 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_522 = NL + "        \t\tconf_";
  protected final String TEXT_523 = ".set(";
  protected final String TEXT_524 = " ,";
  protected final String TEXT_525 = ");" + NL + "        \t";
  protected final String TEXT_526 = NL + "            username_";
  protected final String TEXT_527 = " = null;" + NL + "    \t\tconf_";
  protected final String TEXT_528 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_529 = ");" + NL + "    \t\t";
  protected final String TEXT_530 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_531 = ", ";
  protected final String TEXT_532 = ");" + NL + "    \t\t";
  protected final String TEXT_533 = NL + "\t\t\tconf_";
  protected final String TEXT_534 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_535 = "+\",\"+username_";
  protected final String TEXT_536 = ");" + NL + "        \tfs_";
  protected final String TEXT_537 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_538 = ");";
  protected final String TEXT_539 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_540 = " == null || \"\".equals(username_";
  protected final String TEXT_541 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_542 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_543 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_544 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_545 = ".get(\"";
  protected final String TEXT_546 = "\")),conf_";
  protected final String TEXT_547 = ",username_";
  protected final String TEXT_548 = ");" + NL + "        \t}\t";
  protected final String TEXT_549 = NL + "                    String hdfsUserName_";
  protected final String TEXT_550 = " = (";
  protected final String TEXT_551 = " != null && !\"\".equals(";
  protected final String TEXT_552 = ")) ? ";
  protected final String TEXT_553 = " : System.getProperty(\"user.name\");" + NL + "                    String tezLibPath_";
  protected final String TEXT_554 = " = \"/tmp/\" + hdfsUserName_";
  protected final String TEXT_555 = " + \"/talend_tez_libs/";
  protected final String TEXT_556 = "\";";
  protected final String TEXT_557 = NL + "                    String tezLibPath_";
  protected final String TEXT_558 = " = ";
  protected final String TEXT_559 = ";";
  protected final String TEXT_560 = NL + "                fs_";
  protected final String TEXT_561 = ".mkdirs(new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_562 = "));";
  protected final String TEXT_563 = NL + "                String[] classPaths_";
  protected final String TEXT_564 = " = System.getProperty(\"java.class.path\").split(";
  protected final String TEXT_565 = "String.valueOf(globalMap.get(\"current_client_path_separator\"))";
  protected final String TEXT_566 = "System.getProperty(\"path.separator\")";
  protected final String TEXT_567 = ");" + NL + "                String tezLibLocalPath_";
  protected final String TEXT_568 = " = null;" + NL + "                for(String classPath_";
  protected final String TEXT_569 = " : classPaths_";
  protected final String TEXT_570 = "){";
  protected final String TEXT_571 = NL + "                        if(classPath_";
  protected final String TEXT_572 = ".endsWith(\"";
  protected final String TEXT_573 = "\")){" + NL + "                            org.apache.hadoop.fs.Path tezJarPath_";
  protected final String TEXT_574 = " = new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_575 = " + \"/";
  protected final String TEXT_576 = "\");" + NL + "                            if(!fs_";
  protected final String TEXT_577 = ".exists(tezJarPath_";
  protected final String TEXT_578 = ")){" + NL + "                                fs_";
  protected final String TEXT_579 = ".copyFromLocalFile(false, false, new org.apache.hadoop.fs.Path(classPath_";
  protected final String TEXT_580 = "), tezJarPath_";
  protected final String TEXT_581 = ");" + NL + "                            }" + NL + "                        }";
  protected final String TEXT_582 = NL + "                }";
  protected final String TEXT_583 = NL + "                String tezLibPath_";
  protected final String TEXT_584 = " = ";
  protected final String TEXT_585 = ";";
  protected final String TEXT_586 = NL + "\t\t\tStringBuilder script_";
  protected final String TEXT_587 = " = new StringBuilder();" + NL + "\t\t\tString[] tezLibPaths_";
  protected final String TEXT_588 = " = tezLibPath_";
  protected final String TEXT_589 = ".split(\",\");" + NL + "\t\t\tscript_";
  protected final String TEXT_590 = ".append(\"SET tez.lib.uris=\");" + NL + "\t\t\tint tezLibPathCount_";
  protected final String TEXT_591 = " = 1;" + NL + "\t\t\tfor(String tezLibPathKey_";
  protected final String TEXT_592 = " : tezLibPaths_";
  protected final String TEXT_593 = "){" + NL + "\t\t\t\t script_";
  protected final String TEXT_594 = ".append(";
  protected final String TEXT_595 = " + \"/\" + tezLibPathKey_";
  protected final String TEXT_596 = ");" + NL + "\t\t\t\t if(tezLibPathCount_";
  protected final String TEXT_597 = " < tezLibPaths_";
  protected final String TEXT_598 = ".length){" + NL + "\t\t\t\t \tscript_";
  protected final String TEXT_599 = ".append(\",\");" + NL + "\t\t\t\t }" + NL + "\t\t\t\t tezLibPathCount_";
  protected final String TEXT_600 = "++;" + NL + "\t\t\t}" + NL + "\t\t\tinit_";
  protected final String TEXT_601 = ".execute(script_";
  protected final String TEXT_602 = ".toString());" + NL + "\t\t";
  protected final String TEXT_603 = NL + "            \t";
  protected final String TEXT_604 = NL + "\t\tinit_";
  protected final String TEXT_605 = ".close();" + NL + "" + NL + "    \tString dbname_";
  protected final String TEXT_606 = " = ";
  protected final String TEXT_607 = ";" + NL + "    \tif(dbname_";
  protected final String TEXT_608 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_609 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_610 = ".trim())) {" + NL + "        \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_611 = " = conn_";
  protected final String TEXT_612 = ".createStatement();" + NL + "        \tgoToDatabase_";
  protected final String TEXT_613 = ".execute(\"use \" + dbname_";
  protected final String TEXT_614 = ");" + NL + "        \tgoToDatabase_";
  protected final String TEXT_615 = ".close();" + NL + "    \t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_616 = NL + "    \t\tjava.sql.Statement statement_";
  protected final String TEXT_617 = " = conn_";
  protected final String TEXT_618 = ".createStatement();" + NL + "    \t\t";
  protected final String TEXT_619 = NL + "    \t\t\tstatement_";
  protected final String TEXT_620 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_621 = ");" + NL + "    \t\t";
  protected final String TEXT_622 = NL + NL + "        \t";
  protected final String TEXT_623 = NL + "        \t\tstatement_";
  protected final String TEXT_624 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_625 = ");" + NL + "        \t";
  protected final String TEXT_626 = NL + NL + "\t\t\t";
  protected final String TEXT_627 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_628 = ".execute(\"SET zookeeper.znode.parent=\"+";
  protected final String TEXT_629 = ");" + NL + "\t\t\t";
  protected final String TEXT_630 = NL + NL + "\t\t\t";
  protected final String TEXT_631 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_632 = ".execute(\"SET hbase.security.authentication=kerberos\");" + NL + "\t\t\t\tstatement_";
  protected final String TEXT_633 = ".execute(\"SET hbase.rpc.engine=org.apache.hadoop.hbase.ipc.SecureRpcEngine\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_634 = NL + "\t\t\t\t\tstatement_";
  protected final String TEXT_635 = ".execute(\"SET hbase.master.kerberos.principal=\"+";
  protected final String TEXT_636 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_637 = NL + "\t\t\t\t";
  protected final String TEXT_638 = NL + "\t\t\t\t\tstatement_";
  protected final String TEXT_639 = ".execute(\"SET hbase.regionserver.kerberos.principal=\"+";
  protected final String TEXT_640 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_641 = NL + "\t\t\t";
  protected final String TEXT_642 = NL + NL + "        \t";
  protected final String TEXT_643 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_644 = ".execute(\"add jar \"+";
  protected final String TEXT_645 = ");" + NL + "    \t\t";
  protected final String TEXT_646 = NL + "    \t\tstatement_";
  protected final String TEXT_647 = ".close();";
  protected final String TEXT_648 = NL + "\t\tthrow new java.lang.UnsupportedOperationException(\"Parquet is only supported if the distribution uses embedded Hive version 0.10 or later.\");";
  protected final String TEXT_649 = NL + "\t\t\troutines.system.GetJarsToRegister getJarsToRegister_";
  protected final String TEXT_650 = " = new routines.system.GetJarsToRegister();";
  protected final String TEXT_651 = NL + "\t\t\t\t";
  protected final String TEXT_652 = NL + "\tclass GetHiveJarsToRegister_";
  protected final String TEXT_653 = " extends routines.system.GetJarsToRegister {" + NL + "\t\t" + NL + "\t\tprivate String uploadJarToHDFS(String jar) throws Exception {" + NL + "\t\t\t";
  protected final String TEXT_654 = NL;
  protected final String TEXT_655 = NL + "        String username_";
  protected final String TEXT_656 = " = (";
  protected final String TEXT_657 = " != null && !\"\".equals(";
  protected final String TEXT_658 = ")) ? ";
  protected final String TEXT_659 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_660 = " = null;";
  protected final String TEXT_661 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_662 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_663 = ".set(\"";
  protected final String TEXT_664 = "\", ";
  protected final String TEXT_665 = ");" + NL + "        ";
  protected final String TEXT_666 = NL + "            conf_";
  protected final String TEXT_667 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_668 = NL + "        \t\tconf_";
  protected final String TEXT_669 = ".set(";
  protected final String TEXT_670 = " ,";
  protected final String TEXT_671 = ");" + NL + "        \t";
  protected final String TEXT_672 = NL + "            username_";
  protected final String TEXT_673 = " = null;" + NL + "    \t\tconf_";
  protected final String TEXT_674 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_675 = ");" + NL + "    \t\t";
  protected final String TEXT_676 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_677 = ", ";
  protected final String TEXT_678 = ");" + NL + "    \t\t";
  protected final String TEXT_679 = NL + "\t\t\tconf_";
  protected final String TEXT_680 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_681 = "+\",\"+username_";
  protected final String TEXT_682 = ");" + NL + "        \tfs_";
  protected final String TEXT_683 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_684 = ");";
  protected final String TEXT_685 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_686 = " == null || \"\".equals(username_";
  protected final String TEXT_687 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_688 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_689 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_690 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_691 = ".get(\"";
  protected final String TEXT_692 = "\")),conf_";
  protected final String TEXT_693 = ",username_";
  protected final String TEXT_694 = ");" + NL + "        \t}\t";
  protected final String TEXT_695 = NL + "\t\t\t";
  protected final String TEXT_696 = NL + "\t\t\t" + NL + "\t\t\tString pathUsername_";
  protected final String TEXT_697 = " = username_";
  protected final String TEXT_698 = " == null ? org.apache.hadoop.security.UserGroupInformation.getLoginUser().getShortUserName() : username_";
  protected final String TEXT_699 = ";" + NL + "\t\t\tfs_";
  protected final String TEXT_700 = ".mkdirs(new org.apache.hadoop.fs.Path(\"/user/\" + pathUsername_";
  protected final String TEXT_701 = " + \"/tmp\"), new org.apache.hadoop.fs.permission.FsPermission(org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL));" + NL + "\t\t\tfs_";
  protected final String TEXT_702 = ".copyFromLocalFile(false, true, new org.apache.hadoop.fs.Path(jar), new org.apache.hadoop.fs.Path(\"/user/\" + pathUsername_";
  protected final String TEXT_703 = " + \"/tmp\"));" + NL + "\t\t\treturn ";
  protected final String TEXT_704 = " + \"/user/\" + pathUsername_";
  protected final String TEXT_705 = " + \"/tmp/\" + new java.io.File(jar).getName();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\tString classPathLine = super.replaceJarPaths(originalClassPathLine);" + NL + "\t\t\tString hdfsPath = uploadJarToHDFS(classPathLine);" + NL + "\t\t\treturn hdfsPath;" + NL + "\t\t}" + NL + "\t}" + NL + "\t\t\t\tGetHiveJarsToRegister_";
  protected final String TEXT_706 = " getJarsToRegister_";
  protected final String TEXT_707 = " = new GetHiveJarsToRegister_";
  protected final String TEXT_708 = "();";
  protected final String TEXT_709 = NL + "\t\t\tjava.sql.Statement addJar_";
  protected final String TEXT_710 = " = null;";
  protected final String TEXT_711 = NL + "\t\t\t\t\t\t\taddJar_";
  protected final String TEXT_712 = " = conn_";
  protected final String TEXT_713 = ".createStatement();" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\taddJar_";
  protected final String TEXT_714 = ".execute(\"add jar \" + getJarsToRegister_";
  protected final String TEXT_715 = ".replaceJarPaths(\"";
  protected final String TEXT_716 = "\").replace(\"maprfs\", \"hdfs\"));" + NL + "\t\t\t\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\t\t\taddJar_";
  protected final String TEXT_717 = ".close();" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_718 = NL + "                                bw_";
  protected final String TEXT_719 = ".write(\"ADD JAR \" + wasbPath_";
  protected final String TEXT_720 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_721 = ".replaceJarPaths(\"";
  protected final String TEXT_722 = "\")).getName() + \";\");" + NL + "                                libjars_";
  protected final String TEXT_723 = ".append(getJarsToRegister_";
  protected final String TEXT_724 = ".replaceJarPaths(\"";
  protected final String TEXT_725 = "\") + \",\");";
  protected final String TEXT_726 = NL + "                                // Qubole hive 2.1 supports parquet by default.";
  protected final String TEXT_727 = NL + "                                    log.debug(\"Query for ";
  protected final String TEXT_728 = ": \" + \"ADD JAR \" + stagingBucketPath_";
  protected final String TEXT_729 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_730 = ".replaceJarPaths(\"";
  protected final String TEXT_731 = "\")).getName() + \";\");";
  protected final String TEXT_732 = NL + "                                instance_";
  protected final String TEXT_733 = ".addQuery(\"ADD JAR \" + stagingBucketPath_";
  protected final String TEXT_734 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_735 = ".replaceJarPaths(\"";
  protected final String TEXT_736 = "\")).getName() + \";\");" + NL + "                                libjars_";
  protected final String TEXT_737 = ".append(getJarsToRegister_";
  protected final String TEXT_738 = ".replaceJarPaths(\"";
  protected final String TEXT_739 = "\") + \",\");";
  protected final String TEXT_740 = NL + "\t        if(conn_";
  protected final String TEXT_741 = ".getAutoCommit()) {" + NL + "\t            conn_";
  protected final String TEXT_742 = ".setAutoCommit(false);" + NL + "\t        }" + NL + "\t        int commitEvery_";
  protected final String TEXT_743 = " = ";
  protected final String TEXT_744 = ";" + NL + "\t        int commitCounter_";
  protected final String TEXT_745 = " = 0;" + NL + "\t        ";
  protected final String TEXT_746 = NL + "\t\t\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_747 = " = conn_";
  protected final String TEXT_748 = ".prepareStatement(";
  protected final String TEXT_749 = ");" + NL + "\t\t";
  protected final String TEXT_750 = NL + "\t\tjava.sql.Statement stmt_";
  protected final String TEXT_751 = " = conn_";
  protected final String TEXT_752 = ".createStatement();" + NL + "\t\t";
  protected final String TEXT_753 = NL + "\tString query_";
  protected final String TEXT_754 = " = \"\";" + NL + "\tboolean whetherReject_";
  protected final String TEXT_755 = " = false;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			useExistConnection(node, true);
		}

		public void useExistConnection(INode node, boolean needUserAndPassword){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    if (cid.contains("tImpala") || cid.contains("tHive")) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_34);
    } else if (!needUserAndPassword){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    } else {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			if ("SSO".equals(ElementParameterParser.getValue(node, "__JDBC_URL__"))){
				connectWithSSO();
			} else {
				connect();
			}
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
			connect_end();
		}
		
		public void connectWithSSO(){
			connect_begin_noUser();
			
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    
			connect_end();
		}

		public void connect_begin(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"debug",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"debug",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_59);
    
		}

		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_60);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_63);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_64);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_66);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_75);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    stringBuffer.append(TEXT_76);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();
	String processId = node.getProcess().getId();

	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");

	String commitEvery = "0";//ElementParameterParser.getValue(node, "__COMMIT_EVERY__");//hive jdbc not support setAutoCommit
	String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));

	boolean useParquet = "true".equals(ElementParameterParser.getValue(node,"__USE_PARQUET__"));

    String theDistribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
    String theVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

	String quboleClusterLabel = null;
	String quboleEndpoint = null;
	String encryptedToken = null;
    if("true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"))) {
        String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
            if(connection!=null && connection.equals(pNode.getUniqueName())) {
                theDistribution = ElementParameterParser.getValue(pNode, "__DISTRIBUTION__");
                theVersion = ElementParameterParser.getValue(pNode, "__HIVE_VERSION__");
				if (ElementParameterParser.getBooleanValue(pNode, "__QUBOLE_CLUSTER__")) {
					quboleClusterLabel = ElementParameterParser.getValue(pNode, "__QUBOLE_CLUSTER_LABEL__");
				}
            }
        }
    } else {
	    // without connection
	    encryptedToken = ElementParameterParser.getEncryptedValue(node, "__QUBOLE_API_TOKEN__");
		if (ElementParameterParser.getBooleanValue(node, "__QUBOLE_ENDPOINT__")) {
			quboleEndpoint = ElementParameterParser.getValue(node, "__QUBOLE_ENDPOINT_URL__");
		}
		if (ElementParameterParser.getBooleanValue(node, "__QUBOLE_CLUSTER__")) {
			quboleClusterLabel = ElementParameterParser.getValue(node, "__QUBOLE_CLUSTER_LABEL__");
		}
	}

    org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
    try {
        hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(theDistribution, theVersion);
    } catch (java.lang.Exception e) {
        e.printStackTrace();
        return "";
    }
    boolean isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

	if(hiveDistrib.isExecutedThroughWebHCat()) {
		// Distribution: WebHCat

    stringBuffer.append(TEXT_77);
    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
	if("false".equals(useExistingConn)) {
		String passwordFieldName = "__HDINSIGHT_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_87);
    
		} else {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_90);
    
		}
			
		passwordFieldName = "__WASB_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_93);
    
		} else {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_96);
    
		}

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HDINSIGHT_USERNAME__"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_USERNAME__"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_HOST__"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_PORT__"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STATUSDIR__"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(ElementParameterParser.getValue(node, "__REMOTE_FOLDER__"));
    stringBuffer.append(TEXT_115);
    
	} else {
		String azureConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
	}

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
		if("false".equals(useExistingConn)) { // This variable is declared and initialized in the GetAzureConnection.javajet
			boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
			if(setMemory) {
				String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
				String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
				String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_136);
    
			}

			List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
			if(advProps!=null) {
				for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_140);
    
				}
			}

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
		}
    } else if(hiveDistrib.isGoogleDataprocDistribution()) {
		// Distribution: Google Dataproc

    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    
	if("false".equals(useExistingConn)) {

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
        boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
        if(setMemory) {
            String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
            String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
            String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_160);
    
        }

        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        if(advProps!=null) {
            for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_164);
    
            }
        }

    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_JARS_BUCKET__"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_CLUSTER_ID__"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_REGION__"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_PROJECT_ID__"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_JARS_BUCKET__"));
    stringBuffer.append(TEXT_179);
    
            if(ElementParameterParser.getBooleanValue(node, "__DEFINE_PATH_TO_GOOGLE_CREDENTIALS__")) {

    stringBuffer.append(TEXT_180);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PATH_TO_GOOGLE_CREDENTIALS__"));
    stringBuffer.append(TEXT_181);
                  
            }

    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
        if(isLog4jEnabled) {

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
        }
	} else {
		String dataprocConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(dataprocConnection);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(dataprocConnection);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    
	}

    
	} else if (hiveDistrib.isQuboleDistribution()) {  // get qubole connection
		// Distribution: Qubole

    stringBuffer.append(TEXT_194);
    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
	if("false".equals(useExistingConn)) {

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    
        boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
        if(setMemory) {
            String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
            String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
            String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_206);
    
        }

        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        if(advProps!=null) {
            for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_210);
    
            }
        }

    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(encryptedToken);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
     if (quboleEndpoint != null) {
    stringBuffer.append(TEXT_223);
    stringBuffer.append(quboleEndpoint);
    stringBuffer.append(TEXT_224);
    } 
    stringBuffer.append(TEXT_225);
    
        if(isLog4jEnabled) {

    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    
        }
	} else {
		String quboleConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(quboleConnection);
    stringBuffer.append(TEXT_236);
    
	}

    
	} else {
		// Distribution: other than WebHCat, Dataproc, Qubole

    stringBuffer.append(TEXT_237);
    stringBuffer.append(TEXT_238);
     // Connect to Hive Server 2 using JDBC 
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    
	boolean setTempPath = "true".equals(ElementParameterParser.getValue(node, "__SET_TEMP_PATH__"));
	if(setTempPath) {
		String tempPath = ElementParameterParser.getValue(node, "__TEMP_PATH__");

    stringBuffer.append(TEXT_241);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_242);
    
	}

	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_243);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_244);
    

	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;
		String db = "db_" + connection;
		String dbUser = "dbUser_" + connection;
		
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(dbUser);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    
	} else {
		String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
		String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
		String fsDefalutName = "fs.default.name";
		String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");

		boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
		boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
		List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");

    	String storeByHBase = ElementParameterParser.getValue(node, "__STORE_BY_HBASE__");
    	String zookeeperQuorumForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
    	String zookeeperClientPortForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");

    	boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
		String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");

		String hbaseMasterPrincipal = ElementParameterParser.getValue(node, "__HBASE_MASTER_PRINCIPAL__");
		String hbaseRegionServerPrincipal = ElementParameterParser.getValue(node, "__HBASE_REGIONSERVER_PRINCIPAL__");

    	String defineRegisterJar = ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__");
    	List<Map<String, String>> registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");

		boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));

		boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
		boolean securityIsEnabled = useKrb && (isCustom || (hiveDistrib.doSupportKerberos() && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer))));
		boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
		boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
		boolean securedEmbeddedHive2 = securedEmbedded && "HIVE2".equalsIgnoreCase(hiveServer);

		String hivePrincipal = ElementParameterParser.getValue(node, "__HIVE_PRINCIPAL__");
		boolean useSsl = "true".equals(ElementParameterParser.getValue(node, "__USE_SSL__"));
		String sslTrustStore = ElementParameterParser.getValue(node, "__SSL_TRUST_STORE__");
		String sslStorepasswordFieldName = "__SSL_TRUST_STORE_PASSWORD__";

        boolean useMapRTicket = ElementParameterParser.getBooleanValue(node, "__USE_MAPRTICKET__");
        String mapRTicketUsername = ElementParameterParser.getValue(node, "__MAPRTICKET_USERNAME__");
        String mapRTicketCluster = ElementParameterParser.getValue(node, "__MAPRTICKET_CLUSTER__");
        String mapRTicketDuration = ElementParameterParser.getValue(node, "__MAPRTICKET_DURATION__");

        boolean setMapRHomeDir = ElementParameterParser.getBooleanValue(node, "__SET_MAPR_HOME_DIR__");
        String mapRHomeDir = ElementParameterParser.getValue(node, "__MAPR_HOME_DIR__");

        boolean setMapRHadoopLogin = ElementParameterParser.getBooleanValue(node, "__SET_HADOOP_LOGIN__");
        String mapRHadoopLogin = ElementParameterParser.getValue(node, "__HADOOP_LOGIN__");

        String passwordFieldName = "";

		if(hiveServer!=null && !"".equals(hiveServer.trim()) && (isCustom || hiveDistrib.doSupportHive2())) {
			hiveServer = hiveServer.toLowerCase();
			if ("hive2".equals(hiveServer)) {
				javaDbDriver = "org.apache.hive.jdbc.HiveDriver";
			}
		} else {
			hiveServer = "hive";
		}

		if(("hive".equals(hiveServer) && !hiveDistrib.doSupportHive1()) || ("hive2".equals(hiveServer) && !hiveDistrib.doSupportHive2())) {

    stringBuffer.append(TEXT_265);
    stringBuffer.append(hiveDistrib.getVersion());
    stringBuffer.append(TEXT_266);
    
		}

		if(("STANDALONE".equals(connectionMode) && !hiveDistrib.doSupportStandaloneMode()) || ("EMBEDDED".equals(connectionMode) && !hiveDistrib.doSupportEmbeddedMode())) {

    stringBuffer.append(TEXT_267);
    stringBuffer.append(hiveDistrib.getVersion());
    stringBuffer.append(TEXT_268);
    
		}

		if("STANDALONE".equals(connectionMode) && "hive".equals(hiveServer) && !hiveDistrib.doSupportHive1Standalone()) {

    stringBuffer.append(TEXT_269);
    
		}

		if(hadoopProps.size() > 0){
			for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_270);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_272);
    
			}
		}

		if(securedEmbedded) {
			String metastoreUrl = ElementParameterParser.getValue(node, "__METASTORE_JDBC_URL__");
			String driverClass = ElementParameterParser.getValue(node, "__METASTORE_CLASSNAME__");
			String metastoreUsername = ElementParameterParser.getValue(node, "__METASTORE_USERNAME__");
			boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
			String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
			String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_273);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_274);
    if(securedEmbeddedHive2){
				// Disable authorization when using local HiveServer2 in secure mode
				
    stringBuffer.append(TEXT_275);
    
			}else{
				
    stringBuffer.append(TEXT_276);
    
			}
			
    stringBuffer.append(TEXT_277);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_279);
    
    		passwordFieldName = "__METASTORE_PASSWORD__";
    		
    stringBuffer.append(TEXT_280);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_283);
    } else {
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_286);
    }
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_289);
    
			if(securedEmbeddedHive2){
				
    stringBuffer.append(TEXT_290);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_PRINCIPAL__"));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_KEYTAB__"));
    stringBuffer.append(TEXT_292);
    
			}
			
    stringBuffer.append(TEXT_293);
    
			if(useKeytab) {

    stringBuffer.append(TEXT_294);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_296);
    
			}
		}

		if(((isCustom && !useYarn) || (!isCustom && hiveDistrib.isHadoop1())) && setMapredJT) {
			String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_297);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_298);
    
		}

		if(setNamenode) {
			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_299);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_301);
    
		}

    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_304);
    
		passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_305);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_308);
    } else {
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_311);
    }
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    
        boolean setHadoopUser = "true".equals(ElementParameterParser.getValue(node, "__SET_HADOOP_USER__"));
        if (setHadoopUser) {
            String hadoopUser = ElementParameterParser.getValue(node, "__HADOOP_USER__");
            
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    
        }
        
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    
		if("EMBEDDED".equals(connectionMode) && (isCustom || hiveDistrib.doSupportEmbeddedMode())) {

    stringBuffer.append(TEXT_323);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_327);
    
			if(isCustom || (!isCustom && hiveDistrib.doSupportImpersonation())) {

    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    
			}
		} else if("STANDALONE".equals(connectionMode) && (isCustom || hiveDistrib.doSupportStandaloneMode())) {
				if(securedStandaloneHive2) {
					// using keytab with HiveServer2 in standalone mode
					boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
					String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
					String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
                    
					if ((isCustom || hiveDistrib.doSupportMapRTicket()) && useMapRTicket) {
                        
    stringBuffer.append(TEXT_333);
    stringBuffer.append(setMapRHomeDir ? mapRHomeDir : "\"/opt/mapr\"" );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(setMapRHadoopLogin ? mapRHadoopLogin : "\"kerberos\"");
    stringBuffer.append(TEXT_335);
    
                    }
					if(useKeytab) {

    stringBuffer.append(TEXT_336);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_338);
    
					}
					// Using SSL in Secure Mode
					if(useSsl && hiveDistrib.doSupportSSL()){
						// Does the distrib support SSL + KERBEROS
						if(hiveDistrib.doSupportSSLwithKerberos()){
							if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_341);
    
							}else{

    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append( ElementParameterParser.getValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_344);
    
							}

    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
						// Does the distrib support only SASL-QOP + KERBEROS
						} else {
						

    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_360);
    
						}
					}else{

    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_367);
    
					}
					if ((isCustom || hiveDistrib.doSupportMapRTicket()) && useMapRTicket) {
                        
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_372);
    
                    }
				} else {
                    // Mapr ticket
				    if ((isCustom || hiveDistrib.doSupportMapRTicket()) && useMapRTicket) {
                        passwordFieldName = "__MAPRTICKET_PASSWORD__";
                        
    stringBuffer.append(TEXT_373);
    stringBuffer.append(setMapRHomeDir ? mapRHomeDir : "\"/opt/mapr\"" );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    
                        if (setMapRHadoopLogin) {
                            
    stringBuffer.append(TEXT_376);
    stringBuffer.append(mapRHadoopLogin);
    stringBuffer.append(TEXT_377);
    
                        } else {
                            
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    
                        }
                        if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_382);
    } else {
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_385);
    }
                        	if(hiveDistrib.doSupportMaprTicketV52API()){
                				
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(mapRTicketUsername);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_391);
    
                			} else {
                				
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(mapRTicketUsername);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_397);
    
                			}
                    }

                    // Using SSL in non Secure Mode
					if(useSsl && hiveDistrib.doSupportSSL()){
						if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_400);
    
						}else{

    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append( ElementParameterParser.getValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_403);
    
						}

    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    
					}else{

    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_417);
    
					}
				}
				String additionalJdbcSettings = ElementParameterParser.getValue(node, "__HIVE_ADDITIONAL_JDBC__");

    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(additionalJdbcSettings);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    
			}

    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    
	   		log4jCodeGenerateUtil.debugConnectionParams(node);
		
    stringBuffer.append(TEXT_431);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    }
    
		if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_438);
    
		} else {

    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    
		}

    stringBuffer.append(TEXT_444);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_447);
    }
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    
    	if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
        	String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
       		String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_455);
    
	}

	boolean isKerberosAvailableHadoop2 = !isCustom && hiveDistrib.isHadoop2() && hiveDistrib.doSupportKerberos();
	boolean isHadoop2 = !isCustom && hiveDistrib.isHadoop2();
	boolean isKerberosAvailableHadoop1 = !isCustom && hiveDistrib.isHadoop1() && hiveDistrib.doSupportKerberos();

	if(securedEmbedded) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");

    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_458);
    
		if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
			String jobtrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(jobtrackerPrincipal);
    stringBuffer.append(TEXT_461);
    
		}
		if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
			String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");

    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_464);
    
		}

	}

    	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));

    	if((isCustom && useYarn) || (!isCustom && isHadoop2)) {
    		if(setResourceManager) {
    			String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_468);
    
			}

			boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
			if(setJobHistoryAddress) {
				String jobHistoryAddress = ElementParameterParser.getValue(node,"__JOBHISTORY_ADDRESS__");
    			
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_471);
    
			}

    		boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
    		if(setSchedulerAddress) {
    			String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_474);
    
			}

            if ("true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"))) {
                
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    
            }

    		if("true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"))) {
    			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_479);
    
			}

			if("EMBEDDED".equals(connectionMode) && (isCustom || hiveDistrib.doSupportEmbeddedMode())) {
				boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
				if((isCustom && useYarn && crossPlatformSubmission) || (!isCustom && hiveDistrib.doSupportCrossPlatformSubmission())) {

    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    
				}

				if("MAPR410".equals(hiveVersion)){

    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    
				}

				if(hiveDistrib.doSupportCustomMRApplicationCP()){

    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(hiveDistrib.getCustomMRApplicationCP());
    stringBuffer.append(TEXT_487);
    
				}


    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(hiveDistrib.getYarnApplicationClasspath());
    stringBuffer.append(TEXT_490);
    
			}

    		boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
    		if(setMemory) {
    			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
    			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
    			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_497);
    
			}
		}

		List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
		if(advProps!=null) {
			for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_500);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_501);
    
			}
		}

    stringBuffer.append(TEXT_502);
    
		if(("false").equals(useExistingConn)){
		
    stringBuffer.append(TEXT_503);
    stringBuffer.append(TEXT_504);
    
class PrepareTez{
	public void invoke(INode node, String cid){
        String hiveDistribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

        org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
        try {
            hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(hiveDistribution, hiveVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        boolean isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

        boolean changePathSeparator = !hiveDistrib.isExecutedThroughWebHCat();

        String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
        boolean useTez = "tez".equals(ElementParameterParser.getValue(node, "__EXECUTION_ENGINE__"));
    	boolean supportTez = (isCustom || hiveDistrib.doSupportTezForHive()) && "EMBEDDED".equals(connectionMode);
    	if(supportTez && useTez){
    	
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    
            if(advProps != null){
                for(Map<String, String> item : advProps){
                    if("\"tez.lib.uris\"".equals(item.get("PROPERTY"))){
                    
    stringBuffer.append(TEXT_507);
      
                    }
                }
            }
            boolean installTez = "INSTALL".equals(ElementParameterParser.getValue(node, "__TEZ_LIB__"));
            if(installTez){
                //prepare the folder
                
    stringBuffer.append(TEXT_508);
    
class GetFileSystem{
	public void invoke(INode node, String cid){
        String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
        List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
        String user = null;
        
        String fsDefaultNameKey = "fs.default.name";
        
        String distribution = null;
        String hadoopVersion = null;
        boolean isCustom = false;

        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    
        distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));

        org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;
        try {
            hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
        
        
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_519);
    
        if(mrUseDatanodeHostname && (isCustom || hdfsDistrib.doSupportUseDatanodeHostname())){
        
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_524);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_525);
     
    		}
    	}
        	
    	if((hdfsDistrib.doSupportKerberos() && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_529);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_530);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_532);
    
    		}
    	}
    	
    	if(hdfsDistrib.doSupportGroup()){
    		
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    
        }else{
        
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    
        }
    }
}

      
                (new GetFileSystem()).invoke(node, cid);
                String tezLibFolder = ElementParameterParser.getValue(node, "__TEZ_LIB_FOLDER__");
                boolean useDefaultTezLibFolder = "\"/tmp/{USERNAME}/talend_tez_libs/{custom|HIVE_VERSION}\"".equals(tezLibFolder);
                if(useDefaultTezLibFolder){
                
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(isCustom?"custom":hiveVersion);
    stringBuffer.append(TEXT_556);
    
                }else{
                
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(tezLibFolder);
    stringBuffer.append(TEXT_559);
    
                }
                
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    
                List<String> tezLibJarsName = new java.util.ArrayList<String>();
                if(isCustom){
                    List<Map<String,String>> tezLibJarsNameValue = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__TEZ_LIB_NAME__");
                    for(Map<String, String> tezLibJarsNameV : tezLibJarsNameValue){
                        tezLibJarsName.add(tezLibJarsNameV.get("JAR_NAME"));
                    }
                }else{
                    String tezLibJarsNameValue = ElementParameterParser.getValue(node, "__TEZ_JARS_NAME__");
                    if(tezLibJarsNameValue != null && !"".equals(tezLibJarsNameValue)){
                        tezLibJarsName = java.util.Arrays.asList(tezLibJarsNameValue.split(","));
                    }
                }
                
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    if(changePathSeparator){
    stringBuffer.append(TEXT_565);
    }else{
    stringBuffer.append(TEXT_566);
    }
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    
                    for(String jarName : tezLibJarsName){
                    
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    
                    }
                    
    stringBuffer.append(TEXT_582);
    
            }else{
            
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TEZ_LIB_PATH__"));
    stringBuffer.append(TEXT_585);
    
            }
            //define the location of tez lib    
            
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__"));
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    
    	}
    }
}

    stringBuffer.append(TEXT_603);
    
            	(new PrepareTez()).invoke(node, cid);
        }
    	
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    if("true".equalsIgnoreCase(storeByHBase) && (isCustom || hiveDistrib.doSupportHBaseForHive())) {
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_621);
    }
    stringBuffer.append(TEXT_622);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_625);
    }
    stringBuffer.append(TEXT_626);
    if(setZNodeParent && zNodeParent!=null && !"".equals(zNodeParent) && !"\"\"".equals(zNodeParent)) {
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_629);
    }
    stringBuffer.append(TEXT_630);
    if(useKrb){
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    if(hbaseMasterPrincipal!=null && !"".equals(hbaseMasterPrincipal) && !"\"\"".equals(hbaseMasterPrincipal)){
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(hbaseMasterPrincipal);
    stringBuffer.append(TEXT_636);
    }
    stringBuffer.append(TEXT_637);
    if(hbaseRegionServerPrincipal!=null && !"".equals(hbaseRegionServerPrincipal) && !"\"\"".equals(hbaseRegionServerPrincipal)){
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(hbaseRegionServerPrincipal);
    stringBuffer.append(TEXT_640);
    }
    stringBuffer.append(TEXT_641);
    }
    stringBuffer.append(TEXT_642);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
        		for(Map<String, String> jar : registerJarForHBase){
        			String path = jar.get("JAR_PATH");
        			if(path == null || "".equals(path) || "\"\"".equals(path)) {
        				continue;
        			}
        	
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_645);
    
    			}
    		}

    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    
	  	}
	}

    
	}

	String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
	boolean setFsDefaultName = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
	String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	INode connectionInformationNode = node;

	if("true".equals(useExistingConn) && !hiveDistrib.useCloudLauncher()) {
		connectionMode = "";
		setFsDefaultName = false;
		fsDefaultName = "";
		dbuser = "";
		String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
		for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
			if(connection!=null && connection.equals(pNode.getUniqueName())) {
				connectionMode = ElementParameterParser.getValue(pNode, "__CONNECTION_MODE__");
				setFsDefaultName = "true".equals(ElementParameterParser.getValue(pNode, "__SET_FS_DEFAULT_NAME__"));
				fsDefaultName = ElementParameterParser.getValue(pNode, "__FS_DEFAULT_NAME__");
				dbuser = ElementParameterParser.getValue(pNode, "__USER__");
				connectionInformationNode = pNode;
				break;
			}
		}
	}

	boolean isParquetSupported = isCustom || hiveDistrib.doSupportParquetFormat();
	if(useParquet && !isParquetSupported) {

    stringBuffer.append(TEXT_648);
    
	}

	// Register jars to handle parquet format.

	java.util.List<String> jarsToRegister = null;
	java.util.List<String> jars = null;
	boolean generateAddJarCodeForAll = useParquet;
	if(generateAddJarCodeForAll) {
		String[] commandLine = new String[] {"<command>"};
		try {
			commandLine = ProcessorUtilities.getCommandLine("win32",true, processId, "",org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, new String[]{});
		} catch (ProcessorException e) {
			e.printStackTrace();
		}

		jarsToRegister = new java.util.ArrayList();

		jarsToRegister.add("snappy-java");
		jarsToRegister.add("parquet-hive-bundle");

		for (int j = 0; j < commandLine.length; j++) {
			if(commandLine[j].contains("jar")) {
				jars = java.util.Arrays.asList(commandLine[j].split(";"));
				break;
			}
		}
	}

	if(jarsToRegister!=null && jars!=null) {
		if("EMBEDDED".equalsIgnoreCase(connectionMode) || hiveDistrib.useCloudLauncher()) {

    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_650);
    
		} else {
			generateAddJarCodeForAll = false;
			if(setFsDefaultName) {
				generateAddJarCodeForAll = true;

    stringBuffer.append(TEXT_651);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(TEXT_654);
    
class GetFileSystem{
	public void invoke(INode node, String cid){
        String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
        List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
        String user = null;
        
        String fsDefaultNameKey = "fs.default.name";
        
        String distribution = null;
        String hadoopVersion = null;
        boolean isCustom = false;

        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_660);
    
        distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));

        org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;
        try {
            hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
        
        
    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_665);
    
        if(mrUseDatanodeHostname && (isCustom || hdfsDistrib.doSupportUseDatanodeHostname())){
        
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_670);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_671);
     
    		}
    	}
        	
    	if((hdfsDistrib.doSupportKerberos() && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_675);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_676);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_678);
    
    		}
    	}
    	
    	if(hdfsDistrib.doSupportGroup()){
    		
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_684);
    
        }else{
        
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_694);
    
        }
    }
}

    stringBuffer.append(TEXT_695);
    
			(new GetFileSystem()).invoke(connectionInformationNode, cid);
			
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_703);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    
			}
		}

		if(generateAddJarCodeForAll) {

    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_710);
    
			for(int i=0; i<jarsToRegister.size(); i++) {
				String jarToRegister = jarsToRegister.get(i);
				for(int j=0; j<jars.size(); j++) {
					if(jars.get(j).contains(jarToRegister)) {
						if(!hiveDistrib.useCloudLauncher()) { // Then we use the created SQL statement to add the jars.

    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_715);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_717);
    
						} else { // cloud distribution
                            if(hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_718);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_721);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_724);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_725);
    
                            } else if (hiveDistrib.isQuboleDistribution()) {

    stringBuffer.append(TEXT_726);
    
                            } else { // dataproc
                                if(isLog4jEnabled) {

    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_728);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_729);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_730);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_731);
    
                                }

    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_733);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_734);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_735);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_736);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_738);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_739);
    
                            }
                        }
					}
				}
			}
		}
	}

	// End of parquet format handling.

	if(!("true").equals(useExistingConn) && !hiveDistrib.useCloudLauncher()) {
	    if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
	        
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_741);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_743);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_745);
    
	    }
	}

	if(!hiveDistrib.useCloudLauncher()) {
		if (usePrepareStatement) {
		
    stringBuffer.append(TEXT_746);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_747);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_748);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_749);
    
		}
		
    stringBuffer.append(TEXT_750);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_751);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_752);
    
	}

    stringBuffer.append(TEXT_753);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_754);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_755);
    return stringBuffer.toString();
  }
}
