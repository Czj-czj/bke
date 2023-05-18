package com.ncepu.bigdata.entity;

public class Res {
    private boolean isRight;
    private String result;

    public Res(){
        isRight=false;
        result=null;
    }
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }
}
