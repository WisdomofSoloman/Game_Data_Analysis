package org.example.playerdataanalysiswebservice.tables;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("cost")
public class PlayerCost {
    @TableId("id")
    private int user_id;
    @TableField("paid")
    private double pay_price;
    @TableField("pay_count")
    private Integer pay_count;

    public int getPay_count() {
        return pay_count;
    }

    public void setPay_count(Integer pay_count) {
        this.pay_count = pay_count;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public double getPay_price() {
        return pay_price;
    }

    public void setPay_price(double pay_price) {
        this.pay_price = pay_price;
    }
}
