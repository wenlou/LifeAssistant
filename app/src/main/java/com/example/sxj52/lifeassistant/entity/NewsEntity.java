package com.example.sxj52.lifeassistant.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class NewsEntity extends BaseEntity{

    @SerializedName("uniquekey")
    private String uniquekey;
    @SerializedName("title")
    private String title;
    @SerializedName("date")
    private String date;
    @SerializedName("category")
    private String category;
    @SerializedName("url")
    private String url;
    @SerializedName("thumbnail_pic_s")
    private String thumbnail_pic_s;
    @SerializedName("thumbnail_pic_s02")
    private String thumbnail_pic_s02;
    @SerializedName("thumbnail_pic_s03")
    private String thumbnail_pic_s03;
    @SerializedName("author_name")
    private String author_name;
    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"uniquekey":"5e98955414c97ad47bbb90d312ff39fb","title":"【新春走基层】听耄耋老者讲述中国故事：隐于深山的航天动力","date":"2018-02-21 15:05","category":"头条","author_name":"中青在线","url":"http://mini.eastday.com/mobile/180221150550062.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180221/20180221150550_eb84fa93ac4ab7787a636c139b958fd6_6_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180221/20180221150550_eb84fa93ac4ab7787a636c139b958fd6_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180221/20180221150550_eb84fa93ac4ab7787a636c139b958fd6_1_mwpm_03200403.jpg"},{"uniquekey":"dc4f95195e735918bdb048b0133c55a4","title":"北京地铁公司圆满完成2018年春节运输保障任务","date":"2018-02-21 15:17","category":"头条","author_name":"千龙网","url":"http://mini.eastday.com/mobile/180221151706494.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180221/20180221151706_162f772d8a314dc0f45144792a099bbf_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180221/20180221151706_162f772d8a314dc0f45144792a099bbf_2_mwpm_03200403.jpg"},{"uniquekey":"ee36b1d82e670cce80bbee6585af3a96","title":"美制F35战机不败神话破灭？爷爷级俄制导弹或立大功","date":"2018-02-21 14:49","category":"头条","author_name":"扒姐观察室","url":"http://mini.eastday.com/mobile/180221144959383.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180221/20180221_b5333c9b2a577ea8f370c0fdaacd5f9e_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180221/20180221_c851c27e476e110a7b98f89b573d9aa8_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180221/20180221_ccbb20de7cef4043fc76c8d82107689c_cover_mwpm_03200403.jpg"},{"uniquekey":"9d7c4dd5c4d55244dfe4bd0d1ee92ca0","title":"大S瘦了20斤后自信满满，素颜与粉丝开心合影比杉菜时期更美了","date":"2018-02-21 14:47","category":"头条","author_name":"腾讯娱乐","url":"http://mini.eastday.com/mobile/180221144740375.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180221/20180221144740_c2074d5a16ab0194d28e16494079d41a_1_mwpm_03200403.jpg"},{"uniquekey":"6fca14302ee78c06f48a488f316e92d1","title":"中国赴韩游客数遭\u201c腰斩\u201d 韩国旅游业笑不起来","date":"2018-02-21 14:47","category":"头条","author_name":"海外网","url":"http://mini.eastday.com/mobile/180221144732107.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180221/20180221144732_f08d4724dc97dfaffcdc232f796864ff_1_mwpm_03200403.jpg"},{"uniquekey":"1fca86e9bc85cc847cf19a317fcbb1cf","title":"陕西西安 无人机灯光秀 空中拜大年","date":"2018-02-21 14:40","category":"头条","author_name":"央视网","url":"http://mini.eastday.com/mobile/180221144010737.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180221/20180221144010_a343b2525d599f4e0932d321850d09b3_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180221/20180221144010_a343b2525d599f4e0932d321850d09b3_1_mwpm_03200403.jpg"},{"uniquekey":"568825cd3c43f8e1eb2aef35b9194d57","title":"看年俗 品年味 江西 多彩花灯闹新春","date":"2018-02-21 14:40","category":"头条","author_name":"央视网","url":"http://mini.eastday.com/mobile/180221144009882.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180221/20180221144009_bef5988ec172ed5d13eb13cba4b7f550_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20180221/20180221144009_bef5988ec172ed5d13eb13cba4b7f550_1_mwpm_03200403.jpg"},{"uniquekey":"65523c802c987a4498eeb2885abde850","title":"过节不添\u201c赌\u201d！东莞大岭山警方抓获17名涉赌人员","date":"2018-02-21 14:35","category":"头条","author_name":"南方新闻网","url":"http://mini.eastday.com/mobile/180221143508307.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180221/20180221143508_7b75667fbe12803c9e2314e888e8d740_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180221/20180221143508_7b75667fbe12803c9e2314e888e8d740_1_mwpm_03200403.jpg"},{"uniquekey":"a01408313f7631f5b99d0c7e648eae01","title":"台网友神理论：大陆移动支付强是因基础设施差！","date":"2018-02-21 14:27","category":"头条","author_name":"看看新闻网","url":"http://mini.eastday.com/mobile/180221142706662.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180221/20180221142706_fae3cd1c81b61d239be623a0b4b9ff6e_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20180221/20180221142706_fae3cd1c81b61d239be623a0b4b9ff6e_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20180221/20180221142706_fae3cd1c81b61d239be623a0b4b9ff6e_1_mwpm_03200403.jpg"},{"uniquekey":"1f57507d2a4c5eb69fe01ada31ddc65c","title":"文化差异闹乌龙！菲律宾超市把冥币当新年饰品挂满店","date":"2018-02-21 14:21","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180221142109285.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180221/20180221142109_9fd221ca42bec884fc6b663231ff068c_1_mwpm_03200403.jpg"},{"uniquekey":"591d2c30de1933a843ca12030ad99474","title":"德国小镇山寨春节过了90年 居民热闹过年自称中国人\u200b","date":"2018-02-21 14:18","category":"头条","author_name":"新闻重案组","url":"http://mini.eastday.com/mobile/180221141830849.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180221/20180221_df3659c97ac4378b6061572509d6e212_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180221/20180221_0341d2c11f4b7a45ed9eb6750970c9bb_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180221/20180221_6e5eb559cf32e15c79302e459fff08ed_mwpm_03200403.jpg"},{"uniquekey":"3bdeef9f7ed60b237499992f56680529","title":"当小短腿柯基遇上了新朋友：第一反应是\"装死\"？","date":"2018-02-21 14:17","category":"头条","author_name":"看看新闻网","url":"http://mini.eastday.com/mobile/180221141701970.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180221/20180221141701_3a30c829d55a55141aa36f3e0eee1df7_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20180221/20180221141701_3a30c829d55a55141aa36f3e0eee1df7_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20180221/20180221141701_3a30c829d55a55141aa36f3e0eee1df7_3_mwpm_03200403.jpg"},{"uniquekey":"b4c9a8e32222b3cefd60a5f43c2b8645","title":"假期最后一波：百度\u201c全民VIP\u201d会员大片免费看","date":"2018-02-21 14:06","category":"头条","author_name":"光明网","url":"http://mini.eastday.com/mobile/180221140623473.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180221/20180221140623_e5b323a685f9a7ba9fe97941a91af9ac_6_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20180221/20180221140623_e5b323a685f9a7ba9fe97941a91af9ac_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20180221/20180221140623_e5b323a685f9a7ba9fe97941a91af9ac_5_mwpm_03200403.jpg"},{"uniquekey":"0dcb54f787b10cf5de58c4cac014f837","title":"\u201c蓝色旋律·海上丝绸之路\u201d音乐会在悉尼中国文化中心奏响","date":"2018-02-21 14:06","category":"头条","author_name":"人民网","url":"http://mini.eastday.com/mobile/180221140614894.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180221/20180221140614_c3ac9f568e350fbb68db544f1fc4960a_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180221/20180221140614_633521e23b3b780c9293ef9641b32f03_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180221/20180221140614_15dd8a21072e635b25ac99076fdc07fb_7_mwpm_03200403.jpg"},{"uniquekey":"04ca288bbe9ff321d58be67bf30d98e0","title":"中国龙江剧在新西兰北帕市上演","date":"2018-02-21 14:06","category":"头条","author_name":"人民网","url":"http://mini.eastday.com/mobile/180221140613931.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180221/20180221140613_ec8b392811dc1c97ca346025e53fd9c1_7_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20180221/20180221140613_528e3eb675c14619f79aee281f55a849_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20180221/20180221140613_09629e0ac4f713e2040456bb50ea296d_5_mwpm_03200403.jpg"},{"uniquekey":"7d67b29488af8e3b20f97021065a163f","title":"去磐安感受不一样的风景 华东第一的玻璃天桥开放","date":"2018-02-21 14:01","category":"头条","author_name":"新蓝网","url":"http://mini.eastday.com/mobile/180221140117692.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180221/20180221140117_aa345922830a0e18ea6ac4d47c0fb053_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20180221/20180221140117_aa345922830a0e18ea6ac4d47c0fb053_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20180221/20180221140117_aa345922830a0e18ea6ac4d47c0fb053_2_mwpm_03200403.jpg"},{"uniquekey":"127aaea7bc9ed2251a9c28737c8b952f","title":"春运顺风车今迎来返程高峰 仅嘀嗒出行预计运送超100万人","date":"2018-02-21 13:56","category":"头条","author_name":"新民网","url":"http://mini.eastday.com/mobile/180221135628434.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180221/20180221135628_17622a62ad14fb0c05e035b9b9c93091_1_mwpm_03200403.jpg"},{"uniquekey":"c0237c10e2fe73d5c2f771e26f89bf6d","title":"浙江图书馆365天不熄灯 文化灯塔里的文化年味","date":"2018-02-21 13:55","category":"头条","author_name":"浙江在线","url":"http://mini.eastday.com/mobile/180221135554872.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180221/20180221135554_8c1afd3d5da9a2ee2efde109c091cbf7_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180221/20180221135554_8c1afd3d5da9a2ee2efde109c091cbf7_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20180221/20180221135554_8c1afd3d5da9a2ee2efde109c091cbf7_2_mwpm_03200403.jpg"},{"uniquekey":"dc60dd696f8875b895cc043d55f6ea3a","title":"18岁美少女每月花近万元整容 只为让自己更像芭比娃娃","date":"2018-02-21 13:51","category":"头条","author_name":"国外那些事儿","url":"http://mini.eastday.com/mobile/180221135153926.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180221/20180221_4165b29633859bb1717a02ef0209d7b6_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180221/20180221_cd62f14c5c97188780065a2a323e1c49_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180221/20180221_68afdf6baea7ad79b7a08c5fddb2dc68_cover_mwpm_03200403.jpg"},{"uniquekey":"0fd833bfd4d55350858ed84838811235","title":"【暖新闻】草根\u201c环保站长\u201d建立公益团体 引领志愿者队伍共创\u201c绿色家园\u201d","date":"2018-02-21 13:50","category":"头条","author_name":"中国江苏网","url":"http://mini.eastday.com/mobile/180221135013287.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180221/20180221135013_9fb08472ff65c3d9146192f83c44494e_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180221/20180221135013_9fb08472ff65c3d9146192f83c44494e_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180221/20180221135013_9fb08472ff65c3d9146192f83c44494e_2_mwpm_03200403.jpg"},{"uniquekey":"226e44e4fca0f8b0de7d66930dddb4be","title":"A股\u201c欢度\u201d春节 全球股市普涨 节后A股开门红值得期待","date":"2018-02-21 13:48","category":"头条","author_name":"中国证券报·中证网综合","url":"http://mini.eastday.com/mobile/180221134848021.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180221/20180221134848_e2429062a81fe5e81c7c0ed3c593d329_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20180221/20180221134848_e2429062a81fe5e81c7c0ed3c593d329_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20180221/20180221134848_e2429062a81fe5e81c7c0ed3c593d329_5_mwpm_03200403.jpg"},{"uniquekey":"9c27fe462df4cbdfb81d2a3385741bae","title":"一谈恋爱就会全身心付出的三大星座，总是被伤害！","date":"2018-02-21 13:43","category":"头条","author_name":"萌听","url":"http://mini.eastday.com/mobile/180221134342225.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180221/20180221134342_06b25bef2ae008d96788e5fcbf081806_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180221/20180221134342_06b25bef2ae008d96788e5fcbf081806_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180221/20180221134342_06b25bef2ae008d96788e5fcbf081806_1_mwpm_03200403.jpg"},{"uniquekey":"5c3c9a6d51f3926527bb066a10fc44f4","title":"\"通俄门\"调查俄富豪女婿认罪 离特朗普再进一步?","date":"2018-02-21 13:36","category":"头条","author_name":"看看新闻网","url":"http://mini.eastday.com/mobile/180221133645343.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180221/20180221133645_c732f2f797b4ac946baa72f8621f0465_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180221/20180221133645_c732f2f797b4ac946baa72f8621f0465_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180221/20180221133645_c732f2f797b4ac946baa72f8621f0465_1_mwpm_03200403.jpg"},{"uniquekey":"9a8fe5d3903053f938d3717549449677","title":"超过6.8亿人次参与，\u201c牵妈妈的手\u201d留住今年春节最暖心的记忆","date":"2018-02-21 13:24","category":"头条","author_name":"光明网","url":"http://mini.eastday.com/mobile/180221132411843.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180221/20180221132411_1f48aa92da1aba976128b86c096c5193_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180221/20180221132411_1f48aa92da1aba976128b86c096c5193_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180221/20180221132411_1f48aa92da1aba976128b86c096c5193_1_mwpm_03200403.jpg"},{"uniquekey":"2ba45a87f99f61d41ff4434a9cadd952","title":"【十九大·理论新视野】牛先锋：深化对共产党执政规律的认识-中国社会科学网","date":"2018-02-21 13:15","category":"头条","author_name":"中青在线","url":"http://mini.eastday.com/mobile/180221131517919.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180221/20180221131517_64d4105bf78306d37eee6ca9ef3b1be6_1_mwpm_03200403.jpg"},{"uniquekey":"23f447c5009bb2bc89b67f5550c0fa56","title":"兵马俑在美展出拇指被盗 记者实地调查后发现......","date":"2018-02-21 13:14","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180221131432616.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180221/20180221131432_e3917192f08bb4bfdc5c1d2ef34276d4_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180221/20180221131432_e3917192f08bb4bfdc5c1d2ef34276d4_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180221/20180221131432_e3917192f08bb4bfdc5c1d2ef34276d4_2_mwpm_03200403.jpg"},{"uniquekey":"1f339f1f666af4c3745211b9f09601d5","title":"揭秘《还珠格格》第三部换人内幕，琼瑶：这是我最后悔的事情！","date":"2018-02-21 13:12","category":"头条","author_name":"北青网","url":"http://mini.eastday.com/mobile/180221131254437.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180221/20180221131254_7fde8f9fb973e0051e50c17140a54cfb_6_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180221/20180221131254_60514656a1e60b9c9faa741bcd8587d1_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180221/20180221131254_6cf3564dfdfde933709887ff88e4633d_3_mwpm_03200403.jpg"},{"uniquekey":"d6a1da9f40292e4396671e5500e6d8ec","title":"打树花 庆新年","date":"2018-02-21 13:12","category":"头条","author_name":"人民网","url":"http://mini.eastday.com/mobile/180221131239159.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180221/20180221131239_5668f3497cf6c723782dc3c748093e22_1_mwpm_03200403.jpg"},{"uniquekey":"8c3c044cef7b564cd9321977d7ddb7b6","title":"美佛州众议院否决控枪令 校园枪击案学生赴州府集会","date":"2018-02-21 13:11","category":"头条","author_name":"中国青年网","url":"http://mini.eastday.com/mobile/180221131103391.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180221/20180221131103_9ed7e87be9e23df3fd3d4a71b48b4257_1_mwpm_03200403.jpg"},{"uniquekey":"276328edaa03719abb5e7f936dbfde7c","title":"陕西榆林发生命案 女婿酒后因琐事纠纷杀死岳父","date":"2018-02-21 13:05","category":"头条","author_name":"大众网","url":"http://mini.eastday.com/mobile/180221130526227.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180221/20180221130526_8010135d05869c29f571d43b000b1658_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180221/20180221130526_8010135d05869c29f571d43b000b1658_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180221/20180221130526_8010135d05869c29f571d43b000b1658_3_mwpm_03200403.jpg"}]}
     * error_code : 0
     */

    @SerializedName("reason")
    private String reason;
    @SerializedName("result")
    private ResultBean result;
    @SerializedName("error_code")
    private int errorCode;

    public static NewsEntity objectFromData(String str) {

        return new Gson().fromJson(str, NewsEntity.class);
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getThumbnail_pic_s02() {
        return thumbnail_pic_s02;
    }

    public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
    }

    public String getThumbnail_pic_s03() {
        return thumbnail_pic_s03;
    }

    public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
        this.thumbnail_pic_s03 = thumbnail_pic_s03;
    }

    @Override
    public String toString() {
        return "NewsEntity{" +
                "uniquekey='" + uniquekey + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", url='" + url + '\'' +
                ", thumbnail_pic_s='" + thumbnail_pic_s + '\'' +
                ", thumbnail_pic_s02='" + thumbnail_pic_s02 + '\'' +
                ", thumbnail_pic_s03='" + thumbnail_pic_s03 + '\'' +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public static class ResultBean {
        /**
         * stat : 1
         * data : [{"uniquekey":"5e98955414c97ad47bbb90d312ff39fb","title":"【新春走基层】听耄耋老者讲述中国故事：隐于深山的航天动力","date":"2018-02-21 15:05","category":"头条","author_name":"中青在线","url":"http://mini.eastday.com/mobile/180221150550062.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180221/20180221150550_eb84fa93ac4ab7787a636c139b958fd6_6_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180221/20180221150550_eb84fa93ac4ab7787a636c139b958fd6_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180221/20180221150550_eb84fa93ac4ab7787a636c139b958fd6_1_mwpm_03200403.jpg"},{"uniquekey":"dc4f95195e735918bdb048b0133c55a4","title":"北京地铁公司圆满完成2018年春节运输保障任务","date":"2018-02-21 15:17","category":"头条","author_name":"千龙网","url":"http://mini.eastday.com/mobile/180221151706494.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180221/20180221151706_162f772d8a314dc0f45144792a099bbf_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180221/20180221151706_162f772d8a314dc0f45144792a099bbf_2_mwpm_03200403.jpg"},{"uniquekey":"ee36b1d82e670cce80bbee6585af3a96","title":"美制F35战机不败神话破灭？爷爷级俄制导弹或立大功","date":"2018-02-21 14:49","category":"头条","author_name":"扒姐观察室","url":"http://mini.eastday.com/mobile/180221144959383.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180221/20180221_b5333c9b2a577ea8f370c0fdaacd5f9e_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180221/20180221_c851c27e476e110a7b98f89b573d9aa8_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180221/20180221_ccbb20de7cef4043fc76c8d82107689c_cover_mwpm_03200403.jpg"},{"uniquekey":"9d7c4dd5c4d55244dfe4bd0d1ee92ca0","title":"大S瘦了20斤后自信满满，素颜与粉丝开心合影比杉菜时期更美了","date":"2018-02-21 14:47","category":"头条","author_name":"腾讯娱乐","url":"http://mini.eastday.com/mobile/180221144740375.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180221/20180221144740_c2074d5a16ab0194d28e16494079d41a_1_mwpm_03200403.jpg"},{"uniquekey":"6fca14302ee78c06f48a488f316e92d1","title":"中国赴韩游客数遭\u201c腰斩\u201d 韩国旅游业笑不起来","date":"2018-02-21 14:47","category":"头条","author_name":"海外网","url":"http://mini.eastday.com/mobile/180221144732107.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180221/20180221144732_f08d4724dc97dfaffcdc232f796864ff_1_mwpm_03200403.jpg"},{"uniquekey":"1fca86e9bc85cc847cf19a317fcbb1cf","title":"陕西西安 无人机灯光秀 空中拜大年","date":"2018-02-21 14:40","category":"头条","author_name":"央视网","url":"http://mini.eastday.com/mobile/180221144010737.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180221/20180221144010_a343b2525d599f4e0932d321850d09b3_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180221/20180221144010_a343b2525d599f4e0932d321850d09b3_1_mwpm_03200403.jpg"},{"uniquekey":"568825cd3c43f8e1eb2aef35b9194d57","title":"看年俗 品年味 江西 多彩花灯闹新春","date":"2018-02-21 14:40","category":"头条","author_name":"央视网","url":"http://mini.eastday.com/mobile/180221144009882.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180221/20180221144009_bef5988ec172ed5d13eb13cba4b7f550_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20180221/20180221144009_bef5988ec172ed5d13eb13cba4b7f550_1_mwpm_03200403.jpg"},{"uniquekey":"65523c802c987a4498eeb2885abde850","title":"过节不添\u201c赌\u201d！东莞大岭山警方抓获17名涉赌人员","date":"2018-02-21 14:35","category":"头条","author_name":"南方新闻网","url":"http://mini.eastday.com/mobile/180221143508307.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180221/20180221143508_7b75667fbe12803c9e2314e888e8d740_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180221/20180221143508_7b75667fbe12803c9e2314e888e8d740_1_mwpm_03200403.jpg"},{"uniquekey":"a01408313f7631f5b99d0c7e648eae01","title":"台网友神理论：大陆移动支付强是因基础设施差！","date":"2018-02-21 14:27","category":"头条","author_name":"看看新闻网","url":"http://mini.eastday.com/mobile/180221142706662.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180221/20180221142706_fae3cd1c81b61d239be623a0b4b9ff6e_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20180221/20180221142706_fae3cd1c81b61d239be623a0b4b9ff6e_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20180221/20180221142706_fae3cd1c81b61d239be623a0b4b9ff6e_1_mwpm_03200403.jpg"},{"uniquekey":"1f57507d2a4c5eb69fe01ada31ddc65c","title":"文化差异闹乌龙！菲律宾超市把冥币当新年饰品挂满店","date":"2018-02-21 14:21","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180221142109285.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180221/20180221142109_9fd221ca42bec884fc6b663231ff068c_1_mwpm_03200403.jpg"},{"uniquekey":"591d2c30de1933a843ca12030ad99474","title":"德国小镇山寨春节过了90年 居民热闹过年自称中国人\u200b","date":"2018-02-21 14:18","category":"头条","author_name":"新闻重案组","url":"http://mini.eastday.com/mobile/180221141830849.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180221/20180221_df3659c97ac4378b6061572509d6e212_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180221/20180221_0341d2c11f4b7a45ed9eb6750970c9bb_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180221/20180221_6e5eb559cf32e15c79302e459fff08ed_mwpm_03200403.jpg"},{"uniquekey":"3bdeef9f7ed60b237499992f56680529","title":"当小短腿柯基遇上了新朋友：第一反应是\"装死\"？","date":"2018-02-21 14:17","category":"头条","author_name":"看看新闻网","url":"http://mini.eastday.com/mobile/180221141701970.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180221/20180221141701_3a30c829d55a55141aa36f3e0eee1df7_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20180221/20180221141701_3a30c829d55a55141aa36f3e0eee1df7_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20180221/20180221141701_3a30c829d55a55141aa36f3e0eee1df7_3_mwpm_03200403.jpg"},{"uniquekey":"b4c9a8e32222b3cefd60a5f43c2b8645","title":"假期最后一波：百度\u201c全民VIP\u201d会员大片免费看","date":"2018-02-21 14:06","category":"头条","author_name":"光明网","url":"http://mini.eastday.com/mobile/180221140623473.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180221/20180221140623_e5b323a685f9a7ba9fe97941a91af9ac_6_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20180221/20180221140623_e5b323a685f9a7ba9fe97941a91af9ac_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20180221/20180221140623_e5b323a685f9a7ba9fe97941a91af9ac_5_mwpm_03200403.jpg"},{"uniquekey":"0dcb54f787b10cf5de58c4cac014f837","title":"\u201c蓝色旋律·海上丝绸之路\u201d音乐会在悉尼中国文化中心奏响","date":"2018-02-21 14:06","category":"头条","author_name":"人民网","url":"http://mini.eastday.com/mobile/180221140614894.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180221/20180221140614_c3ac9f568e350fbb68db544f1fc4960a_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180221/20180221140614_633521e23b3b780c9293ef9641b32f03_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180221/20180221140614_15dd8a21072e635b25ac99076fdc07fb_7_mwpm_03200403.jpg"},{"uniquekey":"04ca288bbe9ff321d58be67bf30d98e0","title":"中国龙江剧在新西兰北帕市上演","date":"2018-02-21 14:06","category":"头条","author_name":"人民网","url":"http://mini.eastday.com/mobile/180221140613931.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180221/20180221140613_ec8b392811dc1c97ca346025e53fd9c1_7_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20180221/20180221140613_528e3eb675c14619f79aee281f55a849_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20180221/20180221140613_09629e0ac4f713e2040456bb50ea296d_5_mwpm_03200403.jpg"},{"uniquekey":"7d67b29488af8e3b20f97021065a163f","title":"去磐安感受不一样的风景 华东第一的玻璃天桥开放","date":"2018-02-21 14:01","category":"头条","author_name":"新蓝网","url":"http://mini.eastday.com/mobile/180221140117692.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180221/20180221140117_aa345922830a0e18ea6ac4d47c0fb053_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20180221/20180221140117_aa345922830a0e18ea6ac4d47c0fb053_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20180221/20180221140117_aa345922830a0e18ea6ac4d47c0fb053_2_mwpm_03200403.jpg"},{"uniquekey":"127aaea7bc9ed2251a9c28737c8b952f","title":"春运顺风车今迎来返程高峰 仅嘀嗒出行预计运送超100万人","date":"2018-02-21 13:56","category":"头条","author_name":"新民网","url":"http://mini.eastday.com/mobile/180221135628434.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180221/20180221135628_17622a62ad14fb0c05e035b9b9c93091_1_mwpm_03200403.jpg"},{"uniquekey":"c0237c10e2fe73d5c2f771e26f89bf6d","title":"浙江图书馆365天不熄灯 文化灯塔里的文化年味","date":"2018-02-21 13:55","category":"头条","author_name":"浙江在线","url":"http://mini.eastday.com/mobile/180221135554872.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180221/20180221135554_8c1afd3d5da9a2ee2efde109c091cbf7_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180221/20180221135554_8c1afd3d5da9a2ee2efde109c091cbf7_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20180221/20180221135554_8c1afd3d5da9a2ee2efde109c091cbf7_2_mwpm_03200403.jpg"},{"uniquekey":"dc60dd696f8875b895cc043d55f6ea3a","title":"18岁美少女每月花近万元整容 只为让自己更像芭比娃娃","date":"2018-02-21 13:51","category":"头条","author_name":"国外那些事儿","url":"http://mini.eastday.com/mobile/180221135153926.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180221/20180221_4165b29633859bb1717a02ef0209d7b6_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180221/20180221_cd62f14c5c97188780065a2a323e1c49_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180221/20180221_68afdf6baea7ad79b7a08c5fddb2dc68_cover_mwpm_03200403.jpg"},{"uniquekey":"0fd833bfd4d55350858ed84838811235","title":"【暖新闻】草根\u201c环保站长\u201d建立公益团体 引领志愿者队伍共创\u201c绿色家园\u201d","date":"2018-02-21 13:50","category":"头条","author_name":"中国江苏网","url":"http://mini.eastday.com/mobile/180221135013287.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180221/20180221135013_9fb08472ff65c3d9146192f83c44494e_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180221/20180221135013_9fb08472ff65c3d9146192f83c44494e_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180221/20180221135013_9fb08472ff65c3d9146192f83c44494e_2_mwpm_03200403.jpg"},{"uniquekey":"226e44e4fca0f8b0de7d66930dddb4be","title":"A股\u201c欢度\u201d春节 全球股市普涨 节后A股开门红值得期待","date":"2018-02-21 13:48","category":"头条","author_name":"中国证券报·中证网综合","url":"http://mini.eastday.com/mobile/180221134848021.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180221/20180221134848_e2429062a81fe5e81c7c0ed3c593d329_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20180221/20180221134848_e2429062a81fe5e81c7c0ed3c593d329_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20180221/20180221134848_e2429062a81fe5e81c7c0ed3c593d329_5_mwpm_03200403.jpg"},{"uniquekey":"9c27fe462df4cbdfb81d2a3385741bae","title":"一谈恋爱就会全身心付出的三大星座，总是被伤害！","date":"2018-02-21 13:43","category":"头条","author_name":"萌听","url":"http://mini.eastday.com/mobile/180221134342225.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180221/20180221134342_06b25bef2ae008d96788e5fcbf081806_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180221/20180221134342_06b25bef2ae008d96788e5fcbf081806_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180221/20180221134342_06b25bef2ae008d96788e5fcbf081806_1_mwpm_03200403.jpg"},{"uniquekey":"5c3c9a6d51f3926527bb066a10fc44f4","title":"\"通俄门\"调查俄富豪女婿认罪 离特朗普再进一步?","date":"2018-02-21 13:36","category":"头条","author_name":"看看新闻网","url":"http://mini.eastday.com/mobile/180221133645343.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180221/20180221133645_c732f2f797b4ac946baa72f8621f0465_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180221/20180221133645_c732f2f797b4ac946baa72f8621f0465_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180221/20180221133645_c732f2f797b4ac946baa72f8621f0465_1_mwpm_03200403.jpg"},{"uniquekey":"9a8fe5d3903053f938d3717549449677","title":"超过6.8亿人次参与，\u201c牵妈妈的手\u201d留住今年春节最暖心的记忆","date":"2018-02-21 13:24","category":"头条","author_name":"光明网","url":"http://mini.eastday.com/mobile/180221132411843.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180221/20180221132411_1f48aa92da1aba976128b86c096c5193_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180221/20180221132411_1f48aa92da1aba976128b86c096c5193_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180221/20180221132411_1f48aa92da1aba976128b86c096c5193_1_mwpm_03200403.jpg"},{"uniquekey":"2ba45a87f99f61d41ff4434a9cadd952","title":"【十九大·理论新视野】牛先锋：深化对共产党执政规律的认识-中国社会科学网","date":"2018-02-21 13:15","category":"头条","author_name":"中青在线","url":"http://mini.eastday.com/mobile/180221131517919.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180221/20180221131517_64d4105bf78306d37eee6ca9ef3b1be6_1_mwpm_03200403.jpg"},{"uniquekey":"23f447c5009bb2bc89b67f5550c0fa56","title":"兵马俑在美展出拇指被盗 记者实地调查后发现......","date":"2018-02-21 13:14","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180221131432616.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180221/20180221131432_e3917192f08bb4bfdc5c1d2ef34276d4_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180221/20180221131432_e3917192f08bb4bfdc5c1d2ef34276d4_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180221/20180221131432_e3917192f08bb4bfdc5c1d2ef34276d4_2_mwpm_03200403.jpg"},{"uniquekey":"1f339f1f666af4c3745211b9f09601d5","title":"揭秘《还珠格格》第三部换人内幕，琼瑶：这是我最后悔的事情！","date":"2018-02-21 13:12","category":"头条","author_name":"北青网","url":"http://mini.eastday.com/mobile/180221131254437.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180221/20180221131254_7fde8f9fb973e0051e50c17140a54cfb_6_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180221/20180221131254_60514656a1e60b9c9faa741bcd8587d1_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180221/20180221131254_6cf3564dfdfde933709887ff88e4633d_3_mwpm_03200403.jpg"},{"uniquekey":"d6a1da9f40292e4396671e5500e6d8ec","title":"打树花 庆新年","date":"2018-02-21 13:12","category":"头条","author_name":"人民网","url":"http://mini.eastday.com/mobile/180221131239159.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180221/20180221131239_5668f3497cf6c723782dc3c748093e22_1_mwpm_03200403.jpg"},{"uniquekey":"8c3c044cef7b564cd9321977d7ddb7b6","title":"美佛州众议院否决控枪令 校园枪击案学生赴州府集会","date":"2018-02-21 13:11","category":"头条","author_name":"中国青年网","url":"http://mini.eastday.com/mobile/180221131103391.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180221/20180221131103_9ed7e87be9e23df3fd3d4a71b48b4257_1_mwpm_03200403.jpg"},{"uniquekey":"276328edaa03719abb5e7f936dbfde7c","title":"陕西榆林发生命案 女婿酒后因琐事纠纷杀死岳父","date":"2018-02-21 13:05","category":"头条","author_name":"大众网","url":"http://mini.eastday.com/mobile/180221130526227.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180221/20180221130526_8010135d05869c29f571d43b000b1658_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180221/20180221130526_8010135d05869c29f571d43b000b1658_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180221/20180221130526_8010135d05869c29f571d43b000b1658_3_mwpm_03200403.jpg"}]
         */

        @SerializedName("stat")
        private String stat;
        @SerializedName("data")
        private List<NewsEntity> data;

        public static ResultBean objectFromData(String str) {

            return new Gson().fromJson(str, ResultBean.class);
        }

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<NewsEntity> getData() {
            return data;
        }

        public void setData(List<NewsEntity> data) {
            this.data = data;
        }
    }
}
