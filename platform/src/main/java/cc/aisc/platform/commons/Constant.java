package cc.aisc.platform.commons;

/**
 * Created by sjf on 15-11-12.
 */
public abstract class Constant {
    /**
     * 应用的根目录，由spring负责初始化
     * */

    public static final String[] JSONCONFIG_EXCLUDES = {"categorySn", "updatedAt", "createdAt", "createdBy", "updatedBy", "version", "level","parent"};
    public static String webRoot = "";

    public static String uploadedFilePath = "/resources/static/UploadFiles";
    public static String mappingFilePath = "/resources/static/DataMapping";

    public static Integer MAX_NUM_OF_EMPTY_ROWS = 5;

    public static String GENDER_MALE = "男";
    public static String GENDER_FEMALE = "女";
    public static String MARRIED_TRUE = "已婚";
    public static String MARRIED_FALSE = "未婚";
    public static String EMPLOYED_TRUE = "在职";
    public static String EMPLOYED_FALSE = "离职";

    public static String [] BOOLEAN_TRUE = {"是", GENDER_MALE, MARRIED_TRUE, EMPLOYED_TRUE};
    public static String [] BOOLEAN_FALSE = {"否"};



    public static String DATE_TIME_FORMATTER = "yyyy-MM-dd HH:MM:SS";
/*
    public static String ENTITY_PACKAGE = "com.haiso.hr.entity";*/
}
