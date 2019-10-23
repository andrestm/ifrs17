package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSCPGetMainJava
{
  protected static String nl;
  public static synchronized TSCPGetMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPGetMainJava result = new TSCPGetMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tString[] sourceFileNames_";
  protected final String TEXT_2 = " = new String[]{";
  protected final String TEXT_3 = NL + "\t\t\t";
  protected final String TEXT_4 = ",";
  protected final String TEXT_5 = NL + "\t};" + NL + "\tjava.io.File dir_";
  protected final String TEXT_6 = " = null;" + NL + "\ttry{";
  protected final String TEXT_7 = NL + "\t\t\tfor (String sourceFile_";
  protected final String TEXT_8 = " : sourceFileNames_";
  protected final String TEXT_9 = ") {" + NL + "\t\t\t\tif (sourceFile_";
  protected final String TEXT_10 = " != null&& sourceFile_";
  protected final String TEXT_11 = ".length() != 0) {";
  protected final String TEXT_12 = NL + "\t\t\t\t\t\tsourceFile_";
  protected final String TEXT_13 = " = sourceFile_";
  protected final String TEXT_14 = ".replaceAll(\"\\\\\\\\\",\"/\");";
  protected final String TEXT_15 = NL + "\t\t\t\t\tint index_";
  protected final String TEXT_16 = "=sourceFile_";
  protected final String TEXT_17 = ".lastIndexOf(\"/\");" + NL + "\t\t\t\t\tif(index_";
  protected final String TEXT_18 = " >0){" + NL + "\t\t\t\t\t\tdir_";
  protected final String TEXT_19 = " = new java.io.File(";
  protected final String TEXT_20 = ");" + NL + "\t\t\t\t\t\tString extension_";
  protected final String TEXT_21 = "=\tsourceFile_";
  protected final String TEXT_22 = ".substring(index_";
  protected final String TEXT_23 = ",sourceFile_";
  protected final String TEXT_24 = ".length());" + NL + "\t\t\t\t\t\tjava.io.File file_";
  protected final String TEXT_25 = " = new java.io.File(dir_";
  protected final String TEXT_26 = ", extension_";
  protected final String TEXT_27 = ");" + NL + "\t\t\t\t\t\tif(!file_";
  protected final String TEXT_28 = ".exists()){" + NL + "\t\t\t\t\t\t  file_";
  protected final String TEXT_29 = ".getParentFile().mkdirs();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tjava.io.FileOutputStream out_";
  protected final String TEXT_30 = " = null;" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t//copy action" + NL + "\t\t\t\t\t\tjava.io.InputStream is_";
  protected final String TEXT_31 = " = null;" + NL + "\t\t\t\t\t\tbyte[] buffer_";
  protected final String TEXT_32 = " = new byte[8192];" + NL + "\t\t\t\t\t\tint receive_";
  protected final String TEXT_33 = " = -1;" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tout_";
  protected final String TEXT_34 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_35 = ", true);" + NL + "\t\t\t\t\t\t\tis_";
  protected final String TEXT_36 = " = scp_";
  protected final String TEXT_37 = ".get(sourceFile_";
  protected final String TEXT_38 = ");" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t    \t\t\t\twhile((receive_";
  protected final String TEXT_39 = " = is_";
  protected final String TEXT_40 = ".read(buffer_";
  protected final String TEXT_41 = "))!=-1) {" + NL + "\t\t    \t\t\t\t\tout_";
  protected final String TEXT_42 = ".write(buffer_";
  protected final String TEXT_43 = ", 0, receive_";
  protected final String TEXT_44 = ");" + NL + "\t\t    \t\t\t\t}" + NL + "\t\t\t\t\t\t} catch(java.lang.Exception e_";
  protected final String TEXT_45 = ") {" + NL + "\t\t                \tif(out_";
  protected final String TEXT_46 = " != null){" + NL + "\t\t                \t\tout_";
  protected final String TEXT_47 = ".close();" + NL + "\t\t                \t}" + NL + "\t\t\t\t\t\t\t//only delete empty file when exception happen?this is old action,we keep it." + NL + "\t\t            \t\tif(file_";
  protected final String TEXT_48 = ".length() == 0){" + NL + "\t\t            \t\t\tfile_";
  protected final String TEXT_49 = ".delete();" + NL + "\t\t            \t\t}" + NL + "\t\t            \t\tthrow e_";
  protected final String TEXT_50 = ";" + NL + "\t\t\t\t\t\t} finally {" + NL + "\t\t                \tif(out_";
  protected final String TEXT_51 = " != null){" + NL + "\t\t                \t\tout_";
  protected final String TEXT_52 = ".close();" + NL + "\t\t                \t}" + NL + "\t\t                \t" + NL + "\t\t                \tif(is_";
  protected final String TEXT_53 = " != null) {" + NL + "\t\t                \t\tis_";
  protected final String TEXT_54 = ".close();" + NL + "\t\t                \t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tnb_file_";
  protected final String TEXT_55 = " ++ ;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_57 = " - Downloaded file \" + nb_file_";
  protected final String TEXT_58 = " +  \": \" + sourceFile_";
  protected final String TEXT_59 = " + \" successfully.\");" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_60 = " - Appended to \"+sourceFile_";
  protected final String TEXT_61 = "+\" at local directory \"+";
  protected final String TEXT_62 = "+\" successfully.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tif(nb_file_";
  protected final String TEXT_64 = ">0){" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_65 = "_STATUS\", \"File get OK.\");" + NL + "\t\t\t}else{" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_66 = "_STATUS\", \"No file transfered.\");" + NL + "\t\t\t}";
  protected final String TEXT_67 = NL + "\t\t    \tString parentPath_";
  protected final String TEXT_68 = " = new java.io.File(";
  protected final String TEXT_69 = ").getPath();" + NL + "\t\t\t\tjava.util.List<String> list_";
  protected final String TEXT_70 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\tfor (int i_";
  protected final String TEXT_71 = " = 0; i_";
  protected final String TEXT_72 = " < sourceFileNames_";
  protected final String TEXT_73 = ".length; i_";
  protected final String TEXT_74 = "++) {" + NL + "\t\t        \tString fileName_";
  protected final String TEXT_75 = " = sourceFileNames_";
  protected final String TEXT_76 = "[i_";
  protected final String TEXT_77 = "];" + NL + "\t\t            if (!new java.io.File((parentPath_";
  protected final String TEXT_78 = "), (fileName_";
  protected final String TEXT_79 = ")).exists()) {" + NL + "\t\t                list_";
  protected final String TEXT_80 = ".add(fileName_";
  protected final String TEXT_81 = ");" + NL + "\t\t            }" + NL + "\t\t        }" + NL + "\t\t        sourceFileNames_";
  protected final String TEXT_82 = " = (String[]) list_";
  protected final String TEXT_83 = ".toArray(new String[0]);";
  protected final String TEXT_84 = NL + "\t\t\tif(sourceFileNames_";
  protected final String TEXT_85 = "!=null && sourceFileNames_";
  protected final String TEXT_86 = ".length!=0){" + NL + "\t\t\t\tfor (String sourceFile_";
  protected final String TEXT_87 = " : sourceFileNames_";
  protected final String TEXT_88 = ") {" + NL + "\t\t\t\t\tif (sourceFile_";
  protected final String TEXT_89 = " != null&& sourceFile_";
  protected final String TEXT_90 = ".length() != 0) {";
  protected final String TEXT_91 = NL + "\t\t\t\t\t\t\tsourceFile_";
  protected final String TEXT_92 = " = sourceFile_";
  protected final String TEXT_93 = ".replaceAll(\"\\\\\\\\\",\"/\");";
  protected final String TEXT_94 = NL + "\t\t\t\t\t\tint index_";
  protected final String TEXT_95 = "=sourceFile_";
  protected final String TEXT_96 = ".lastIndexOf(\"/\");" + NL + "\t\t\t\t\t\tif(index_";
  protected final String TEXT_97 = " >0){" + NL + "\t\t\t\t\t\t\tdir_";
  protected final String TEXT_98 = " = new java.io.File(";
  protected final String TEXT_99 = ");" + NL + "\t\t\t\t\t\t\tString extension_";
  protected final String TEXT_100 = "=\tsourceFile_";
  protected final String TEXT_101 = ".substring(index_";
  protected final String TEXT_102 = ",sourceFile_";
  protected final String TEXT_103 = ".length());" + NL + "\t\t\t\t\t\t\tjava.io.File file_";
  protected final String TEXT_104 = " = new java.io.File(dir_";
  protected final String TEXT_105 = ", extension_";
  protected final String TEXT_106 = ");" + NL + "\t\t\t\t\t\t\tif(!file_";
  protected final String TEXT_107 = ".exists()){" + NL + "\t\t\t\t\t\t\t\tfile_";
  protected final String TEXT_108 = ".getParentFile().mkdirs();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tjava.io.FileOutputStream out_";
  protected final String TEXT_109 = " = null;" + NL + "\t\t    \t\t\t\t//copy action" + NL + "\t\t    \t\t\t\tjava.io.InputStream is_";
  protected final String TEXT_110 = " = null;" + NL + "\t\t    \t\t\t\tbyte[] buffer_";
  protected final String TEXT_111 = " = new byte[8192];" + NL + "\t\t    \t\t\t\tint receive_";
  protected final String TEXT_112 = " = -1;" + NL + "\t\t    \t\t\t\ttry {" + NL + "\t\t    \t\t\t\t\tout_";
  protected final String TEXT_113 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_114 = ", false);" + NL + "\t\t    \t\t\t\t\tis_";
  protected final String TEXT_115 = " = scp_";
  protected final String TEXT_116 = ".get(sourceFile_";
  protected final String TEXT_117 = ");" + NL + "\t\t    \t\t\t\t\t" + NL + "\t\t        \t\t\t\twhile((receive_";
  protected final String TEXT_118 = " = is_";
  protected final String TEXT_119 = ".read(buffer_";
  protected final String TEXT_120 = "))!=-1) {" + NL + "\t\t        \t\t\t\t\tout_";
  protected final String TEXT_121 = ".write(buffer_";
  protected final String TEXT_122 = ", 0, receive_";
  protected final String TEXT_123 = ");" + NL + "\t\t        \t\t\t\t}" + NL + "\t\t    \t\t\t\t} catch(java.lang.Exception e_";
  protected final String TEXT_124 = ") {" + NL + "\t\t                    \tif(out_";
  protected final String TEXT_125 = " != null){" + NL + "\t\t                    \t\tout_";
  protected final String TEXT_126 = ".close();" + NL + "\t\t                    \t}" + NL + "\t\t    \t\t\t\t\t//only delete empty file when exception happen?this is old action,we keep it." + NL + "\t\t                \t\tif(file_";
  protected final String TEXT_127 = ".length() == 0){" + NL + "\t\t                \t\t\tfile_";
  protected final String TEXT_128 = ".delete();" + NL + "\t\t                \t\t}" + NL + "\t\t                \t\tthrow e_";
  protected final String TEXT_129 = ";" + NL + "\t\t    \t\t\t\t} finally {" + NL + "\t\t                    \tif(out_";
  protected final String TEXT_130 = " != null){" + NL + "\t\t                    \t\tout_";
  protected final String TEXT_131 = ".close();" + NL + "\t\t                    \t}" + NL + "\t\t                    \tif(is_";
  protected final String TEXT_132 = " != null) {" + NL + "\t\t                    \t\tis_";
  protected final String TEXT_133 = ".close();" + NL + "\t\t                    \t}" + NL + "\t\t    \t\t\t\t}" + NL + "\t\t\t\t\t\t\tnb_file_";
  protected final String TEXT_134 = " ++ ;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_136 = " - Downloaded file \" + nb_file_";
  protected final String TEXT_137 = " +  \": \" + sourceFile_";
  protected final String TEXT_138 = " + \" successfully.\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\t\t\t\t\t\t\t log.info(\"";
  protected final String TEXT_140 = " - Overwrote or appended to \"+sourceFile_";
  protected final String TEXT_141 = "+\" at local directory \"+";
  protected final String TEXT_142 = "+\" successfully.\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\t\t\t\t\t\t log.info(\"";
  protected final String TEXT_144 = " - Overwrote to \"+sourceFile_";
  protected final String TEXT_145 = "+\" at local directory \"+";
  protected final String TEXT_146 = "+\" successfully.\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_147 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(nb_file_";
  protected final String TEXT_148 = ">0){" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_149 = "_STATUS\", \"File get OK.\");" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_150 = "_STATUS\", \"No file transfered.\");" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_151 = NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_152 = "){" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_153 = "_STATUS\", \"File get fail.\");" + NL + "\t\tthrow e_";
  protected final String TEXT_154 = ";" + NL + "\t}";
  protected final String TEXT_155 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();      
    String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");
    String replaceOption = ElementParameterParser.getValue(node,"__REPLACEOPTION__");
    List<Map<String, String>> filelist = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__FILELIST__");
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    boolean enforceUnixPath = ("true").equals(ElementParameterParser.getValue(node,"__FORCE_UNIX_PATH__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
		for (Map<String, String> file : filelist) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(file.get("SOURCE"));
    stringBuffer.append(TEXT_4);
              
        }

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
		if(("append").equals(replaceOption)){

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    
					if (!enforceUnixPath) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
					}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(localdir );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( localdir );
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    
		}else{
			boolean isDefaultAction = !("overwrite").equals(replaceOption);
			if(isDefaultAction) {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(localdir );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
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
    
			}

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    
						if (!enforceUnixPath) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    
						}

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(localdir );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
     if(isDefaultAction){ 
    stringBuffer.append(TEXT_139);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append( localdir );
    stringBuffer.append(TEXT_142);
    
								}else{
								
    stringBuffer.append(TEXT_143);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append( localdir );
    stringBuffer.append(TEXT_146);
    
								}
							}
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    
		}

    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(TEXT_155);
    return stringBuffer.toString();
  }
}
