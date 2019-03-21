package com.xin.xiaoxinzone.model;

import java.util.List;

/**
 * @author llq
 * @time 2018/6/20  15:58.
 * @faction
 * @description
 * @modify
 */
public class YearDataModel {

    /**
     * name : 水瓶座
     * date : 2018年
     * year : 2018
     * mima : {"info":"放平心态 选择未来","text":["对大多数水瓶座而言，未来一年是不缺风光，却需要自己放平心态，为未来做出选择的一年。命主星土星还将在你们的朋友宫和愿望宫停留几乎整年，你将继续检验和审视自己的朋友圈，抛离\u201c不良资产\u201d，只选择那些与你可以真正\u201c同甘苦共富贵\u201d的朋友共同前进。木天拱持续作用你的人际宫位，也将改变你过去两年一贯深居简出的状态，令当下被无形\u201c禁锢\u201d的状态终于破局，有选择地活跃于各个社交舞台之上，并借助他人之力实现个人价值和水平的提升。对水瓶座来说，难点将不在外界环境好坏（因为已经在2016年形成良性循环），而在于自己可否以坦然心态接受他人的好意，以及明白不切实际的想法必须抛弃才可能更好地出发。木星持续发力也会让你更加明确自己应该选择怎样的方向，抽丝剥茧只留下那些真正适合自己的选择和内涵，进入真正合适自身的领域，尤其利好出版、旅行、考试、出国、高等教育等等行业。"]}
     * career : ["理论上，木星来到水瓶座的事业宫，会给水瓶座带来很多事业职场当中的好机会，利于升职。不过，土星也进入了水瓶座的隐秘宫，这个星象，会给水瓶座带来精神上和心灵上，甚至身体上的压力。土星在水瓶座的隐秘宫要停留2年半左右。往往，对于任何人，土星进入隐秘宫，都是容易感受到压力，心情郁闷，身体病痛感增加，甚至发生间歇性抑郁的状况。2018年，升职机会存在的水瓶座，是否能突破内心的限制，以积极的态度争取职场竞争的胜利呢？很多的水瓶座在2018年，可能会被某种利益欲望所驱使，为了职场地位而做出一些超过自己能力范围的事情。我在这里提醒你，过度的消耗，可能会导致其健康方面出现隐患。立冬后，水瓶座的事业机遇来临，很容易成为别人眼中出众的人物。"]
     * love : ["感情上，2018年对于水瓶座来说，是非常大的挑战。日月蚀多次影响你的一对一的关系。对于婚恋中的水瓶座而言，感情中的危机随时爆发。力不从心，无聊乏味的感觉常常让你心生忧郁。水瓶座人在年初，会展现出极强的魅力，在情爱方面也有某些冲动，单身者有机会获得倾慕，而有伴者，可能会出现隐秘性恋情。这种感觉，是出于自恋自爱，情欲提升，想要获得更多赞美。这个期间，作为水瓶座的伴侣，一定要给到他们足够的体贴照顾，无微不至的崇拜和喜爱，否则他们释放的吸引力，就有可能嫁接在其他人的身上。爱意会在4、5月份更加浓烈，也伴随着旧人旧事的搅扰。单身的水瓶座如果把握好年初的机遇，到了年底就有机会坐实关系，并成受到众人的祝福。"]
     * health : ["学生党水瓶座本年度的状态明显稳定。不过在年中几个月是容易出现反复状况的。由于受到土星在隐秘宫的原因，心理压力大，求胜心强，反而会导致焦虑。不要用力太猛，适可而止，有张又驰就好。这样才能抓住机会，在年底给到自己一份满意的答卷。健康方面要留意骨骼，脊柱、颈椎、皮肤、牙齿、淋巴系统，免疫系统等。"]
     * finance : ["对于水瓶座而言，2017年为钱操劳奔波。2018年这种状态好了很多。上半年，财富的增长性提升，理财机遇好。下半年后，花钱的地方多，债务借贷等容易出现复杂状况，小心破财。"]
     * luckeyStone : 蓝玉髓
     * future :
     * resultcode : 200
     * error_code : 0
     */

    private String name;
    private String date;
    private int year;
    private MimaBean mima;
    private String luckeyStone;
    private String future;
    private String resultcode;
    private int error_code;
    private List<String> career;
    private List<String> love;
    private List<String> health;
    private List<String> finance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public MimaBean getMima() {
        return mima;
    }

    public void setMima(MimaBean mima) {
        this.mima = mima;
    }

    public String getLuckeyStone() {
        return luckeyStone;
    }

    public void setLuckeyStone(String luckeyStone) {
        this.luckeyStone = luckeyStone;
    }

    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<String> getCareer() {
        return career;
    }

    public void setCareer(List<String> career) {
        this.career = career;
    }

    public List<String> getLove() {
        return love;
    }

    public void setLove(List<String> love) {
        this.love = love;
    }

    public List<String> getHealth() {
        return health;
    }

    public void setHealth(List<String> health) {
        this.health = health;
    }

    public List<String> getFinance() {
        return finance;
    }

    public void setFinance(List<String> finance) {
        this.finance = finance;
    }

    public static class MimaBean {
        /**
         * info : 放平心态 选择未来
         * text : ["对大多数水瓶座而言，未来一年是不缺风光，却需要自己放平心态，为未来做出选择的一年。命主星土星还将在你们的朋友宫和愿望宫停留几乎整年，你将继续检验和审视自己的朋友圈，抛离\u201c不良资产\u201d，只选择那些与你可以真正\u201c同甘苦共富贵\u201d的朋友共同前进。木天拱持续作用你的人际宫位，也将改变你过去两年一贯深居简出的状态，令当下被无形\u201c禁锢\u201d的状态终于破局，有选择地活跃于各个社交舞台之上，并借助他人之力实现个人价值和水平的提升。对水瓶座来说，难点将不在外界环境好坏（因为已经在2016年形成良性循环），而在于自己可否以坦然心态接受他人的好意，以及明白不切实际的想法必须抛弃才可能更好地出发。木星持续发力也会让你更加明确自己应该选择怎样的方向，抽丝剥茧只留下那些真正适合自己的选择和内涵，进入真正合适自身的领域，尤其利好出版、旅行、考试、出国、高等教育等等行业。"]
         */

        private String info;
        private List<String> text;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public List<String> getText() {
            return text;
        }

        public void setText(List<String> text) {
            this.text = text;
        }
    }
}
