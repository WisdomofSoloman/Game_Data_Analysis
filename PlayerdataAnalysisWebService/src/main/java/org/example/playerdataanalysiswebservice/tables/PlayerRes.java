package org.example.playerdataanalysiswebservice.tables;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("resource")
public class PlayerRes {
    @TableId("id")
    private int user_id;
    @TableField("wood_add_value")
    private Integer wood_value;
    @TableField("stone_add_value")
    private Integer stone_count;
    @TableField("ivory_add_value")
    private Integer ivory_value;
    @TableField("meat_add_value")
    private Integer meat_value;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Integer getWood_value() {
        return wood_value;
    }

    public void setWood_value(Integer wood_value) {
        this.wood_value = wood_value;
    }

    public Integer getStone_count() {
        return stone_count;
    }

    public void setStone_count(Integer stone_count) {
        this.stone_count = stone_count;
    }

    public Integer getIvory_value() {
        return ivory_value;
    }

    public void setIvory_value(Integer ivory_value) {
        this.ivory_value = ivory_value;
    }

    public Integer getMeat_value() {
        return meat_value;
    }

    public void setMeat_value(Integer meat_value) {
        this.meat_value = meat_value;
    }
}
