package com.ytbig.model;

/**
 * {"id":null,"createTime":null,"modifyTime":null,"openId":"MTE4MTI3Mm1jMDYyNmUzMzUxNzQ2NmUwNA==","nickname":"王后端","headimgurl":"https://nj-files.oss-cn-hangzhou.aliyuncs.com/head/mc_ic_head_default.png","status":null,"peopleid":2724992,"posCode":"0201","positions":null,"classid":"220335,","gradeid":"220324,"}
 */

public class UserInfo {

    private String id;
    private String createTime;
    private String modifyTime;
    private String openId;
    private String nickname;
    private String headimgurl;
    private String status;
    private long peopleid;
    private String posCode;
    private String positions;
    private String classid;
    private String gradeid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getPeopleid() {
        return peopleid;
    }

    public void setPeopleid(long peopleid) {
        this.peopleid = peopleid;
    }

    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getGradeid() {
        return gradeid;
    }

    public void setGradeid(String gradeid) {
        this.gradeid = gradeid;
    }
}
