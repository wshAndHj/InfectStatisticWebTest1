package edu.fzu.wah.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ProcessParameter {
	private ArrayList<String> provinceList;//省份列表
    private HashMap<String, Integer> typeMap;//查询的类别ip、sp、cure、dead
    private String outputPath;//输出的目标文件路径
    private File logDir;//日志文件夹
    private Date date = null;//查询截止日期


    public void processParameters(String []args){
        List list = Arrays.asList(args);

        int dateIndex = list.indexOf("-date");//截止日期.
        String dateString = "";
        if (dateIndex > 0) {//如果有传入-date参数
            dateString = args[dateIndex + 1];
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = null;
        if (dateIndex >= 0) {
            try {
                date = simpleDateFormat.parse(dateString);
            } catch (ParseException e) {
                System.out.println("时间参数非法");
                System.exit(-1);
            }
        }

        int dirIndex = list.indexOf("-log");//日志文件目录
        if (dirIndex < 0) {
            System.out.println("错误：没有传入日志文件路径");
            System.exit(-1);
        }
        String dirPath = args[dirIndex + 1];//日志文件夹路径
        logDir = new File(dirPath);//日志文件夹

        int outputIndex = list.indexOf("-out");//输出文件目录
        if (outputIndex < 0) {
            System.out.println("错误：没有传入输出文件路径");
            return;
        }
        outputPath = args[outputIndex + 1];

        int provinceListIndex = list.indexOf("-province");//传入参数中-province的下标索引
        int provinceListLastIndex = findLastIndex(args, provinceListIndex);//查询的最后一个省份的下标索引
        provinceList = new ArrayList<String>();//省份列表
        if (provinceListIndex >= 0) {//有传入-province参数
            for (int i = provinceListIndex + 1; i <= provinceListLastIndex; i++) {
                provinceList.add(args[i]);
            }
        }

        typeMap = new HashMap<>();//查询的类别ip、sp、cure、dead
        int typeIndex = list.indexOf("-type");
        int typeLastIndex = findLastIndex(args, typeIndex);
        int t = typeIndex > 0 ? 0 : 1;//是否有传入-type参数 t=0:有  t=1:没有
        typeMap.put("ip", t);
        typeMap.put("sp", t);
        typeMap.put("cure", t);
        typeMap.put("dead", t);
        if (typeIndex >= 0) {//有传入-type参数
            for (int i = typeIndex + 1; i <= typeLastIndex; i++) {
                typeMap.put(args[i], 1);
            }
        }
    }

    public void statistic(){
        //开始统计
        InfectStatistic infectStatistic = new InfectStatistic();
        infectStatistic.statistic(logDir, date);
        infectStatistic.output(outputPath, provinceList, typeMap);
    }


    public int findLastIndex(String[] list, int begin) {
        int len = list.length;
        int index = begin + 1;
        while (index < len && list[index].charAt(0) != '-') {
            index++;
        }
        return index - 1;
    }

    public ArrayList<String> getProvinceList() {
        return provinceList;
    }

    public HashMap<String, Integer> getTypeMap() {
        return typeMap;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public File getLogDir() {
        return logDir;
    }

    public Date getDate() {
        return date;
    }
}
