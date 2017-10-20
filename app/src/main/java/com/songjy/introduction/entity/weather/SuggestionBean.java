package com.songjy.introduction.entity.weather;

/**
 * Created by songjiyuan
 * on 17/10/19 # 下午4:23.
 */

public class SuggestionBean {
    /**
     * air : {"brf":"很差","txt":"气象条件不利于空气污染物稀释、扩散和清除，请尽量避免在室外长时间活动。"}
     * comf : {"brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"}
     * cw : {"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
     * drsg : {"brf":"较舒适","txt":"建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"}
     * flu : {"brf":"少发","txt":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"}
     * sport : {"brf":"适宜","txt":"天气较好，赶快投身大自然参与户外运动，尽情感受运动的快乐吧。"}
     * trav : {"brf":"适宜","txt":"天气较好，但丝毫不会影响您出行的心情。温度适宜又有微风相伴，适宜旅游。"}
     * uv : {"brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}
     */

    private SuggestBean air;
    private SuggestBean comf;
    private SuggestBean cw;
    private SuggestBean drsg;
    private SuggestBean flu;
    private SuggestBean sport;
    private SuggestBean trav;
    private SuggestBean uv;

    public SuggestBean getAir() {
        return air;
    }

    public void setAir(SuggestBean air) {
        this.air = air;
    }

    public SuggestBean getComf() {
        return comf;
    }

    public void setComf(SuggestBean comf) {
        this.comf = comf;
    }

    public SuggestBean getCw() {
        return cw;
    }

    public void setCw(SuggestBean cw) {
        this.cw = cw;
    }

    public SuggestBean getDrsg() {
        return drsg;
    }

    public void setDrsg(SuggestBean drsg) {
        this.drsg = drsg;
    }

    public SuggestBean getFlu() {
        return flu;
    }

    public void setFlu(SuggestBean flu) {
        this.flu = flu;
    }

    public SuggestBean getSport() {
        return sport;
    }

    public void setSport(SuggestBean sport) {
        this.sport = sport;
    }

    public SuggestBean getTrav() {
        return trav;
    }

    public void setTrav(SuggestBean trav) {
        this.trav = trav;
    }

    public SuggestBean getUv() {
        return uv;
    }

    public void setUv(SuggestBean uv) {
        this.uv = uv;
    }
}
