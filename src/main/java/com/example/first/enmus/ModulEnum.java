package com.example.first.enmus;

/**
 * @author hu
 * @date 2020/4/11 21:56
 */
public enum ModulEnum {

    OTC("OTC","1"),
    PAY("PAY","2")

    ;
    private String ModulName;
    private String ModulId;

    ModulEnum(String modulName, String modulId) {
        ModulName = modulName;
        ModulId = modulId;
    }

    public String getModulName() {
        return ModulName;
    }

    public void setModulName(String modulName) {
        ModulName = modulName;
    }

    public String getModulId() {
        return ModulId;
    }

    public void setModulId(String modulId) {
        ModulId = modulId;
    }
}
