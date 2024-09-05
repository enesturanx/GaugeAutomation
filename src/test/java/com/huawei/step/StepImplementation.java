package com.huawei.step;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import com.huawei.methods.Methods;


import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation {
    Methods methods;


    public StepImplementation(){
        methods = new Methods();
    }

    @Step("<key> go to url")
    public void goURL(String key){
        methods.goToURL(key);
    }

    @Step("wait <key> seconds")
    public void waitSecond(long second) {
        methods.waitSecond(second);
    }

    @Step("wait <key> miliseconds")
    public void waitMiliSecond(long milisecond) {
        methods.waitMiliSecond(milisecond);
    }

    @Step("<key> click the element")
    public void clickElement(String key){
        methods.clickElement(key);
    }

    @Step("send this <element> to <text> this text")
    public void writeText(String element, String text){
        methods.sendText(element,text);
    }





}
