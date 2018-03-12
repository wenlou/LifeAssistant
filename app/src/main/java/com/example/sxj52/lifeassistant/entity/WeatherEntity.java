package com.example.sxj52.lifeassistant.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WeatherEntity implements Serializable {


    @SerializedName("HeWeather5")
    private List<HeWeather5Bean> HeWeather5;

    @Override
    public String toString() {
        return "WeatherEntity{" +
                "HeWeather5=" + HeWeather5 +
                '}';
    }

    public static WeatherEntity objectFromData(String str) {

        return new Gson().fromJson(str, WeatherEntity.class);
    }

    public List<HeWeather5Bean> getHeWeather5() {
        return HeWeather5;
    }

    public void setHeWeather5(List<HeWeather5Bean> HeWeather5) {
        this.HeWeather5 = HeWeather5;
    }

    public static class HeWeather5Bean {
        @Override
        public String toString() {
            return "HeWeather5Bean{" +
                    "aqi=" + aqi +
                    ", basic=" + basic +
                    ", now=" + now +
                    ", status='" + status + '\'' +
                    ", suggestion=" + suggestion +
                    ", dailyForecast=" + dailyForecast +
                    ", hourlyForecast=" + hourlyForecast +
                    '}';
        }

        /**
         * aqi : {"city":{"aqi":"228","qlty":"重度污染","pm25":"178","pm10":"182","no2":"56","so2":"12","co":"1.43","o3":"109"}}
         * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.90498734","lon":"116.4052887","update":{"loc":"2018-03-12 17:47","utc":"2018-03-12 09:47"}}
         * daily_forecast : [{"astro":{"mr":"03:19","ms":"13:16","sr":"06:31","ss":"18:18"},"cond":{"code_d":"103","code_n":"100","txt_d":"晴间多云","txt_n":"晴"},"date":"2018-03-12","hum":"47","pcpn":"0.0","pop":"0","pres":"1012","tmp":{"max":"14","min":"2"},"uv":"4","vis":"16","wind":{"deg":"0","dir":"无持续风向","sc":"1-2","spd":"5"}},{"astro":{"mr":"04:03","ms":"14:09","sr":"06:29","ss":"18:19"},"cond":{"code_d":"100","code_n":"101","txt_d":"晴","txt_n":"多云"},"date":"2018-03-13","hum":"35","pcpn":"0.0","pop":"0","pres":"1009","tmp":{"max":"17","min":"3"},"uv":"4","vis":"20","wind":{"deg":"191","dir":"南风","sc":"1-2","spd":"5"}},{"astro":{"mr":"04:43","ms":"15:05","sr":"06:27","ss":"18:20"},"cond":{"code_d":"101","code_n":"104","txt_d":"多云","txt_n":"阴"},"date":"2018-03-14","hum":"44","pcpn":"0.0","pop":"0","pres":"1013","tmp":{"max":"15","min":"5"},"uv":"4","vis":"20","wind":{"deg":"177","dir":"南风","sc":"1-2","spd":"4"}},{"astro":{"mr":"05:20","ms":"16:04","sr":"06:26","ss":"18:21"},"cond":{"code_d":"101","code_n":"100","txt_d":"多云","txt_n":"晴"},"date":"2018-03-15","hum":"40","pcpn":"0.0","pop":"0","pres":"1025","tmp":{"max":"9","min":"0"},"uv":"3","vis":"20","wind":{"deg":"38","dir":"东北风","sc":"3-4","spd":"11"}},{"astro":{"mr":"05:54","ms":"17:04","sr":"06:24","ss":"18:22"},"cond":{"code_d":"101","code_n":"104","txt_d":"多云","txt_n":"阴"},"date":"2018-03-16","hum":"21","pcpn":"0.0","pop":"0","pres":"1030","tmp":{"max":"8","min":"1"},"uv":"4","vis":"20","wind":{"deg":"189","dir":"南风","sc":"1-2","spd":"3"}},{"astro":{"mr":"06:25","ms":"18:05","sr":"06:23","ss":"18:23"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2018-03-17","hum":"24","pcpn":"0.3","pop":"84","pres":"1030","tmp":{"max":"9","min":"1"},"uv":"2","vis":"18","wind":{"deg":"172","dir":"南风","sc":"1-2","spd":"3"}},{"astro":{"mr":"06:57","ms":"19:08","sr":"06:21","ss":"18:24"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2018-03-18","hum":"31","pcpn":"0.1","pop":"82","pres":"1033","tmp":{"max":"12","min":"2"},"uv":"3","vis":"20","wind":{"deg":"179","dir":"南风","sc":"1-2","spd":"3"}}]
         * hourly_forecast : [{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-03-12 19:00","hum":"56","pop":"0","pres":"1010","tmp":"12","wind":{"deg":"71","dir":"东北风","sc":"1-2","spd":"4"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-03-12 22:00","hum":"76","pop":"0","pres":"1011","tmp":"7","wind":{"deg":"8","dir":"北风","sc":"1-2","spd":"6"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-03-13 01:00","hum":"78","pop":"0","pres":"1009","tmp":"6","wind":{"deg":"23","dir":"东北风","sc":"1-2","spd":"7"}},{"cond":{"code":"101","txt":"多云"},"date":"2018-03-13 04:00","hum":"79","pop":"0","pres":"1009","tmp":"3","wind":{"deg":"11","dir":"东北风","sc":"1-2","spd":"5"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-03-13 07:00","hum":"86","pop":"0","pres":"1010","tmp":"5","wind":{"deg":"348","dir":"西北风","sc":"1-2","spd":"3"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-03-13 10:00","hum":"66","pop":"0","pres":"1010","tmp":"7","wind":{"deg":"196","dir":"西南风","sc":"1-2","spd":"4"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-03-13 13:00","hum":"44","pop":"0","pres":"1009","tmp":"14","wind":{"deg":"143","dir":"东南风","sc":"1-2","spd":"5"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-03-13 16:00","hum":"56","pop":"0","pres":"1008","tmp":"16","wind":{"deg":"159","dir":"东南风","sc":"1-2","spd":"4"}}]
         * now : {"cond":{"code":"101","txt":"多云"},"fl":"5","hum":"42","pcpn":"0.0","pres":"1009","tmp":"11","vis":"5","wind":{"deg":"210","dir":"西南风","sc":"1-2","spd":"7"}}
         * status : ok
         * suggestion : {"air":{"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"},"comf":{"brf":"较舒适","txt":"白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。"},"cw":{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"drsg":{"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"},"flu":{"brf":"少发","txt":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"},"sport":{"brf":"较适宜","txt":"天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。"},"trav":{"brf":"适宜","txt":"天气较好，温度适宜，是个好天气哦。这样的天气适宜旅游，您可以尽情地享受大自然的风光。"},"uv":{"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}}
         */

        @SerializedName("aqi")
        private AqiBean aqi;
        @SerializedName("basic")
        private BasicBean basic;
        @SerializedName("now")
        private NowBean now;
        @SerializedName("status")
        private String status;
        @SerializedName("suggestion")
        private SuggestionBean suggestion;
        @SerializedName("daily_forecast")
        private List<DailyForecastBean> dailyForecast;
        @SerializedName("hourly_forecast")
        private List<HourlyForecastBean> hourlyForecast;

        public static HeWeather5Bean objectFromData(String str) {

            return new Gson().fromJson(str, HeWeather5Bean.class);
        }

        public AqiBean getAqi() {
            return aqi;
        }

        public void setAqi(AqiBean aqi) {
            this.aqi = aqi;
        }

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public SuggestionBean getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(SuggestionBean suggestion) {
            this.suggestion = suggestion;
        }

        public List<DailyForecastBean> getDailyForecast() {
            return dailyForecast;
        }

        public void setDailyForecast(List<DailyForecastBean> dailyForecast) {
            this.dailyForecast = dailyForecast;
        }

        public List<HourlyForecastBean> getHourlyForecast() {
            return hourlyForecast;
        }

        public void setHourlyForecast(List<HourlyForecastBean> hourlyForecast) {
            this.hourlyForecast = hourlyForecast;
        }

        public static class AqiBean {
            @Override
            public String toString() {
                return "AqiBean{" +
                        "city=" + city +
                        '}';
            }

            /**
             * city : {"aqi":"228","qlty":"重度污染","pm25":"178","pm10":"182","no2":"56","so2":"12","co":"1.43","o3":"109"}
             */

            @SerializedName("city")
            private CityBean city;

            public static AqiBean objectFromData(String str) {

                return new Gson().fromJson(str, AqiBean.class);
            }

            public CityBean getCity() {
                return city;
            }

            public void setCity(CityBean city) {
                this.city = city;
            }

            public static class CityBean {
                /**
                 * aqi : 228
                 * qlty : 重度污染
                 * pm25 : 178
                 * pm10 : 182
                 * no2 : 56
                 * so2 : 12
                 * co : 1.43
                 * o3 : 109
                 */

                @SerializedName("aqi")
                private String aqi;
                @SerializedName("qlty")
                private String qlty;
                @SerializedName("pm25")
                private String pm25;
                @SerializedName("pm10")
                private String pm10;
                @SerializedName("no2")
                private String no2;
                @SerializedName("so2")
                private String so2;
                @SerializedName("co")
                private String co;
                @SerializedName("o3")
                private String o3;

                public static CityBean objectFromData(String str) {

                    return new Gson().fromJson(str, CityBean.class);
                }

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getQlty() {
                    return qlty;
                }

                public void setQlty(String qlty) {
                    this.qlty = qlty;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getNo2() {
                    return no2;
                }

                public void setNo2(String no2) {
                    this.no2 = no2;
                }

                public String getSo2() {
                    return so2;
                }

                public void setSo2(String so2) {
                    this.so2 = so2;
                }

                public String getCo() {
                    return co;
                }

                public void setCo(String co) {
                    this.co = co;
                }

                public String getO3() {
                    return o3;
                }

                public void setO3(String o3) {
                    this.o3 = o3;
                }
            }
        }

        public static class BasicBean {
            @Override
            public String toString() {
                return "BasicBean{" +
                        "city='" + city + '\'' +
                        ", cnty='" + cnty + '\'' +
                        ", id='" + id + '\'' +
                        ", lat='" + lat + '\'' +
                        ", lon='" + lon + '\'' +
                        ", update=" + update +
                        '}';
            }

            /**
             * city : 北京
             * cnty : 中国
             * id : CN101010100
             * lat : 39.90498734
             * lon : 116.4052887
             * update : {"loc":"2018-03-12 17:47","utc":"2018-03-12 09:47"}
             */

            @SerializedName("city")
            private String city;
            @SerializedName("cnty")
            private String cnty;
            @SerializedName("id")
            private String id;
            @SerializedName("lat")
            private String lat;
            @SerializedName("lon")
            private String lon;
            @SerializedName("update")
            private UpdateBean update;

            public static BasicBean objectFromData(String str) {

                return new Gson().fromJson(str, BasicBean.class);
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public UpdateBean getUpdate() {
                return update;
            }

            public void setUpdate(UpdateBean update) {
                this.update = update;
            }

            public static class UpdateBean {
                @Override
                public String toString() {
                    return "UpdateBean{" +
                            "loc='" + loc + '\'' +
                            ", utc='" + utc + '\'' +
                            '}';
                }

                /**
                 * loc : 2018-03-12 17:47
                 * utc : 2018-03-12 09:47
                 */

                @SerializedName("loc")
                private String loc;
                @SerializedName("utc")
                private String utc;

                public static UpdateBean objectFromData(String str) {

                    return new Gson().fromJson(str, UpdateBean.class);
                }

                public String getLoc() {
                    return loc;
                }

                public void setLoc(String loc) {
                    this.loc = loc;
                }

                public String getUtc() {
                    return utc;
                }

                public void setUtc(String utc) {
                    this.utc = utc;
                }
            }
        }

        public static class NowBean {
            @Override
            public String toString() {
                return "NowBean{" +
                        "cond=" + cond +
                        ", fl='" + fl + '\'' +
                        ", hum='" + hum + '\'' +
                        ", pcpn='" + pcpn + '\'' +
                        ", pres='" + pres + '\'' +
                        ", tmp='" + tmp + '\'' +
                        ", vis='" + vis + '\'' +
                        ", wind=" + wind +
                        '}';
            }

            /**
             * cond : {"code":"101","txt":"多云"}
             * fl : 5
             * hum : 42
             * pcpn : 0.0
             * pres : 1009
             * tmp : 11
             * vis : 5
             * wind : {"deg":"210","dir":"西南风","sc":"1-2","spd":"7"}
             */

            @SerializedName("cond")
            private CondBean cond;
            @SerializedName("fl")
            private String fl;
            @SerializedName("hum")
            private String hum;
            @SerializedName("pcpn")
            private String pcpn;
            @SerializedName("pres")
            private String pres;
            @SerializedName("tmp")
            private String tmp;
            @SerializedName("vis")
            private String vis;
            @SerializedName("wind")
            private WindBean wind;

            public static NowBean objectFromData(String str) {

                return new Gson().fromJson(str, NowBean.class);
            }

            public CondBean getCond() {
                return cond;
            }

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class CondBean {
                @Override
                public String toString() {
                    return "CondBean{" +
                            "code='" + code + '\'' +
                            ", txt='" + txt + '\'' +
                            '}';
                }

                /**
                 * code : 101
                 * txt : 多云
                 */

                @SerializedName("code")
                private String code;
                @SerializedName("txt")
                private String txt;

                public static CondBean objectFromData(String str) {

                    return new Gson().fromJson(str, CondBean.class);
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class WindBean {
                @Override
                public String toString() {
                    return "WindBean{" +
                            "deg='" + deg + '\'' +
                            ", dir='" + dir + '\'' +
                            ", sc='" + sc + '\'' +
                            ", spd='" + spd + '\'' +
                            '}';
                }

                /**
                 * deg : 210
                 * dir : 西南风
                 * sc : 1-2
                 * spd : 7
                 */

                @SerializedName("deg")
                private String deg;
                @SerializedName("dir")
                private String dir;
                @SerializedName("sc")
                private String sc;
                @SerializedName("spd")
                private String spd;

                public static WindBean objectFromData(String str) {

                    return new Gson().fromJson(str, WindBean.class);
                }

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }

        public static class SuggestionBean {
            @Override
            public String toString() {
                return "SuggestionBean{" +
                        "air=" + air +
                        ", comf=" + comf +
                        ", cw=" + cw +
                        ", drsg=" + drsg +
                        ", flu=" + flu +
                        ", sport=" + sport +
                        ", trav=" + trav +
                        ", uv=" + uv +
                        '}';
            }

            /**
             * air : {"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"}
             * comf : {"brf":"较舒适","txt":"白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。"}
             * cw : {"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
             * drsg : {"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"}
             * flu : {"brf":"少发","txt":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"}
             * sport : {"brf":"较适宜","txt":"天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。"}
             * trav : {"brf":"适宜","txt":"天气较好，温度适宜，是个好天气哦。这样的天气适宜旅游，您可以尽情地享受大自然的风光。"}
             * uv : {"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}
             */

            @SerializedName("air")
            private AirBean air;
            @SerializedName("comf")
            private ComfBean comf;
            @SerializedName("cw")
            private CwBean cw;
            @SerializedName("drsg")
            private DrsgBean drsg;
            @SerializedName("flu")
            private FluBean flu;
            @SerializedName("sport")
            private SportBean sport;
            @SerializedName("trav")
            private TravBean trav;
            @SerializedName("uv")
            private UvBean uv;

            public static SuggestionBean objectFromData(String str) {

                return new Gson().fromJson(str, SuggestionBean.class);
            }

            public AirBean getAir() {
                return air;
            }

            public void setAir(AirBean air) {
                this.air = air;
            }

            public ComfBean getComf() {
                return comf;
            }

            public void setComf(ComfBean comf) {
                this.comf = comf;
            }

            public CwBean getCw() {
                return cw;
            }

            public void setCw(CwBean cw) {
                this.cw = cw;
            }

            public DrsgBean getDrsg() {
                return drsg;
            }

            public void setDrsg(DrsgBean drsg) {
                this.drsg = drsg;
            }

            public FluBean getFlu() {
                return flu;
            }

            public void setFlu(FluBean flu) {
                this.flu = flu;
            }

            public SportBean getSport() {
                return sport;
            }

            public void setSport(SportBean sport) {
                this.sport = sport;
            }

            public TravBean getTrav() {
                return trav;
            }

            public void setTrav(TravBean trav) {
                this.trav = trav;
            }

            public UvBean getUv() {
                return uv;
            }

            public void setUv(UvBean uv) {
                this.uv = uv;
            }

            public static class AirBean {
                /**
                 * brf : 中
                 * txt : 气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。
                 */

                @SerializedName("brf")
                private String brf;
                @SerializedName("txt")
                private String txt;

                public static AirBean objectFromData(String str) {

                    return new Gson().fromJson(str, AirBean.class);
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class ComfBean {
                @Override
                public String toString() {
                    return "ComfBean{" +
                            "brf='" + brf + '\'' +
                            ", txt='" + txt + '\'' +
                            '}';
                }

                /**
                 * brf : 较舒适
                 * txt : 白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。
                 */

                @SerializedName("brf")
                private String brf;
                @SerializedName("txt")
                private String txt;

                public static ComfBean objectFromData(String str) {

                    return new Gson().fromJson(str, ComfBean.class);
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class CwBean {
                @Override
                public String toString() {
                    return "CwBean{" +
                            "brf='" + brf + '\'' +
                            ", txt='" + txt + '\'' +
                            '}';
                }

                /**
                 * brf : 较适宜
                 * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
                 */

                @SerializedName("brf")
                private String brf;
                @SerializedName("txt")
                private String txt;

                public static CwBean objectFromData(String str) {

                    return new Gson().fromJson(str, CwBean.class);
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class DrsgBean {
                /**
                 * brf : 较冷
                 * txt : 建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。
                 */

                @SerializedName("brf")
                private String brf;
                @SerializedName("txt")
                private String txt;

                public static DrsgBean objectFromData(String str) {

                    return new Gson().fromJson(str, DrsgBean.class);
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class FluBean {
                /**
                 * brf : 少发
                 * txt : 各项气象条件适宜，无明显降温过程，发生感冒机率较低。
                 */

                @SerializedName("brf")
                private String brf;
                @SerializedName("txt")
                private String txt;

                public static FluBean objectFromData(String str) {

                    return new Gson().fromJson(str, FluBean.class);
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class SportBean {
                /**
                 * brf : 较适宜
                 * txt : 天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。
                 */

                @SerializedName("brf")
                private String brf;
                @SerializedName("txt")
                private String txt;

                public static SportBean objectFromData(String str) {

                    return new Gson().fromJson(str, SportBean.class);
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class TravBean {
                /**
                 * brf : 适宜
                 * txt : 天气较好，温度适宜，是个好天气哦。这样的天气适宜旅游，您可以尽情地享受大自然的风光。
                 */

                @SerializedName("brf")
                private String brf;
                @SerializedName("txt")
                private String txt;

                public static TravBean objectFromData(String str) {

                    return new Gson().fromJson(str, TravBean.class);
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class UvBean {
                /**
                 * brf : 中等
                 * txt : 属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。
                 */

                @SerializedName("brf")
                private String brf;
                @SerializedName("txt")
                private String txt;

                public static UvBean objectFromData(String str) {

                    return new Gson().fromJson(str, UvBean.class);
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }
        }

        public static class DailyForecastBean {
            /**
             * astro : {"mr":"03:19","ms":"13:16","sr":"06:31","ss":"18:18"}
             * cond : {"code_d":"103","code_n":"100","txt_d":"晴间多云","txt_n":"晴"}
             * date : 2018-03-12
             * hum : 47
             * pcpn : 0.0
             * pop : 0
             * pres : 1012
             * tmp : {"max":"14","min":"2"}
             * uv : 4
             * vis : 16
             * wind : {"deg":"0","dir":"无持续风向","sc":"1-2","spd":"5"}
             */

            @SerializedName("astro")
            private AstroBean astro;
            @SerializedName("cond")
            private CondBeanX cond;
            @SerializedName("date")
            private String date;
            @SerializedName("hum")
            private String hum;
            @SerializedName("pcpn")
            private String pcpn;
            @SerializedName("pop")
            private String pop;
            @SerializedName("pres")
            private String pres;
            @SerializedName("tmp")
            private TmpBean tmp;
            @SerializedName("uv")
            private String uv;
            @SerializedName("vis")
            private String vis;
            @SerializedName("wind")
            private WindBeanX wind;

            public static DailyForecastBean objectFromData(String str) {

                return new Gson().fromJson(str, DailyForecastBean.class);
            }

            public AstroBean getAstro() {
                return astro;
            }

            public void setAstro(AstroBean astro) {
                this.astro = astro;
            }

            public CondBeanX getCond() {
                return cond;
            }

            public void setCond(CondBeanX cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public TmpBean getTmp() {
                return tmp;
            }

            public void setTmp(TmpBean tmp) {
                this.tmp = tmp;
            }

            public String getUv() {
                return uv;
            }

            public void setUv(String uv) {
                this.uv = uv;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindBeanX getWind() {
                return wind;
            }

            public void setWind(WindBeanX wind) {
                this.wind = wind;
            }

            public static class AstroBean {
                /**
                 * mr : 03:19
                 * ms : 13:16
                 * sr : 06:31
                 * ss : 18:18
                 */

                @SerializedName("mr")
                private String mr;
                @SerializedName("ms")
                private String ms;
                @SerializedName("sr")
                private String sr;
                @SerializedName("ss")
                private String ss;

                public static AstroBean objectFromData(String str) {

                    return new Gson().fromJson(str, AstroBean.class);
                }

                public String getMr() {
                    return mr;
                }

                public void setMr(String mr) {
                    this.mr = mr;
                }

                public String getMs() {
                    return ms;
                }

                public void setMs(String ms) {
                    this.ms = ms;
                }

                public String getSr() {
                    return sr;
                }

                public void setSr(String sr) {
                    this.sr = sr;
                }

                public String getSs() {
                    return ss;
                }

                public void setSs(String ss) {
                    this.ss = ss;
                }
            }

            public static class CondBeanX {
                /**
                 * code_d : 103
                 * code_n : 100
                 * txt_d : 晴间多云
                 * txt_n : 晴
                 */

                @SerializedName("code_d")
                private String codeD;
                @SerializedName("code_n")
                private String codeN;
                @SerializedName("txt_d")
                private String txtD;
                @SerializedName("txt_n")
                private String txtN;

                public static CondBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, CondBeanX.class);
                }

                public String getCodeD() {
                    return codeD;
                }

                public void setCodeD(String codeD) {
                    this.codeD = codeD;
                }

                public String getCodeN() {
                    return codeN;
                }

                public void setCodeN(String codeN) {
                    this.codeN = codeN;
                }

                public String getTxtD() {
                    return txtD;
                }

                public void setTxtD(String txtD) {
                    this.txtD = txtD;
                }

                public String getTxtN() {
                    return txtN;
                }

                public void setTxtN(String txtN) {
                    this.txtN = txtN;
                }
            }

            public static class TmpBean {
                /**
                 * max : 14
                 * min : 2
                 */

                @SerializedName("max")
                private String max;
                @SerializedName("min")
                private String min;

                public static TmpBean objectFromData(String str) {

                    return new Gson().fromJson(str, TmpBean.class);
                }

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }
            }

            public static class WindBeanX {
                /**
                 * deg : 0
                 * dir : 无持续风向
                 * sc : 1-2
                 * spd : 5
                 */

                @SerializedName("deg")
                private String deg;
                @SerializedName("dir")
                private String dir;
                @SerializedName("sc")
                private String sc;
                @SerializedName("spd")
                private String spd;

                public static WindBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, WindBeanX.class);
                }

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }

        public static class HourlyForecastBean {
            /**
             * cond : {"code":"103","txt":"晴间多云"}
             * date : 2018-03-12 19:00
             * hum : 56
             * pop : 0
             * pres : 1010
             * tmp : 12
             * wind : {"deg":"71","dir":"东北风","sc":"1-2","spd":"4"}
             */

            @SerializedName("cond")
            private CondBeanXX cond;
            @SerializedName("date")
            private String date;
            @SerializedName("hum")
            private String hum;
            @SerializedName("pop")
            private String pop;
            @SerializedName("pres")
            private String pres;
            @SerializedName("tmp")
            private String tmp;
            @SerializedName("wind")
            private WindBeanXX wind;

            public static HourlyForecastBean objectFromData(String str) {

                return new Gson().fromJson(str, HourlyForecastBean.class);
            }

            public CondBeanXX getCond() {
                return cond;
            }

            public void setCond(CondBeanXX cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public WindBeanXX getWind() {
                return wind;
            }

            public void setWind(WindBeanXX wind) {
                this.wind = wind;
            }

            public static class CondBeanXX {
                /**
                 * code : 103
                 * txt : 晴间多云
                 */

                @SerializedName("code")
                private String code;
                @SerializedName("txt")
                private String txt;

                public static CondBeanXX objectFromData(String str) {

                    return new Gson().fromJson(str, CondBeanXX.class);
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class WindBeanXX {
                /**
                 * deg : 71
                 * dir : 东北风
                 * sc : 1-2
                 * spd : 4
                 */

                @SerializedName("deg")
                private String deg;
                @SerializedName("dir")
                private String dir;
                @SerializedName("sc")
                private String sc;
                @SerializedName("spd")
                private String spd;

                public static WindBeanXX objectFromData(String str) {

                    return new Gson().fromJson(str, WindBeanXX.class);
                }

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }
    }
}
