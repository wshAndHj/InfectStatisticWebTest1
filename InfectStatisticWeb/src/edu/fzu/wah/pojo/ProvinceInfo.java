package edu.fzu.wah.pojo;

import java.util.Formatter;
import java.util.HashMap;

public class ProvinceInfo {
	private String name;//省名
    private int infectNum = 0;//感染数
    private int suspectedNum = 0;//疑似数
    private int diedNum = 0;//死亡数
    private int cureNum = 0;//治愈数
    private boolean doesRefered = false;//是否有日志提到

    public ProvinceInfo(String name){
        this.name = name;
    }

    public int getInfectNum() {
        return infectNum;
    }

    public int infectNumAdd(int num){
        return infectNum += num;
    }

    public int infectNumSub(int num){
        return infectNum -= num;
    }

    public int getSuspectedNum() {
        return suspectedNum;
    }

    public int suspectedAdd(int num){
        return suspectedNum += num;
    }

    public int suspectedSub(int num){
        return suspectedNum -= num;
    }

    public int getDiedNum() {
        return diedNum;
    }

    public int diedNumAdd(int num){
        return diedNum += num;
    }

    public int diedNumSub(int num){
        return diedNum -= num;
    }

    public int getCureNum() {
        return cureNum;
    }

    public int cureNumAdd(int num){
        return cureNum += num;
    }

    public int cureNumSub(int num){
        return cureNum -= num;
    }

    public String getName() {
        return name;
    }

    public boolean isDoesRefered() {
        return doesRefered;
    }

    public void setDoesRefered(boolean doesRefered) {
        this.doesRefered = doesRefered;
    }

    public void output(Formatter writer, HashMap<String, Integer> typeMap) {
        int infectDoesShow, suspectedDoesShow, cureDoesShow, diedDoesShow;
        infectDoesShow = typeMap.get("ip");
        suspectedDoesShow = typeMap.get("sp");
        cureDoesShow = typeMap.get("cure");
        diedDoesShow = typeMap.get("dead");
        writer.format(name + "  ");
        if (infectDoesShow > 0) {
            writer.format("感染患者:%d人  ", infectNum);
        }
        if (suspectedDoesShow > 0) {
            writer.format("疑似患者%d人  ", suspectedNum);
        }
        if (cureDoesShow > 0) {
            writer.format("治愈%d人  ", cureNum);
        }
        if (diedDoesShow > 0) {
            writer.format("死亡%d人  ", diedNum);
        }
        writer.format("\n");
    }
}
