package edu.tongji.demo;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args){
        String str = "{ \n" +
                "    \"_id\" : \"526501916509\", \n" +
                "    \"保修卡\" : \"1件\", \n" +
                "    \"尺寸规格\" : [\n" +
                "        {\n" +
                "            \"k\" : \"尺寸\", \n" +
                "            \"v\" : \"543x360x580mm\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"包装尺寸\", \n" +
                "            \"v\" : \"570x395x615mm\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"毛重\", \n" +
                "            \"v\" : \"13kg\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"净重\", \n" +
                "            \"v\" : \"10kg\"\n" +
                "        }\n" +
                "    ], \n" +
                "    \"洗衣机\" : \"1件\", \n" +
                "    \"进水管\" : \"1件\", \n" +
                "    \"其他参数\" : [\n" +
                "        {\n" +
                "            \"k\" : \"功率\", \n" +
                "            \"v\" : \"240W\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"上市时间\", \n" +
                "            \"v\" : \"2015-12\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"电机类型\", \n" +
                "            \"v\" : \"普通电机\"\n" +
                "        }\n" +
                "    ], \n" +
                "    \"洗衣能力\" : [\n" +
                "        {\n" +
                "            \"k\" : \"洗涤公斤量\", \n" +
                "            \"v\" : \"2.5kg\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"脱水功率\", \n" +
                "            \"v\" : \"120W\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"洗衣程序\", \n" +
                "            \"v\" : \"单排单洗单漂单甩标准洗\"\n" +
                "        }\n" +
                "    ], \n" +
                "    \"说明书\" : \"1件\", \n" +
                "    \"基本参数\" : [\n" +
                "        {\n" +
                "            \"k\" : \"洗衣机品牌\", \n" +
                "            \"v\" : \"小鸭牌\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"型号\", \n" +
                "            \"v\" : \"XPB25-2825S\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"能效等级\", \n" +
                "            \"v\" : \"五级\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"使用方式\", \n" +
                "            \"v\" : \"半自动\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"排水方式\", \n" +
                "            \"v\" : \"下排水\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"颜色分类\", \n" +
                "            \"v\" : \"白色\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"开合方式\", \n" +
                "            \"v\" : \"顶开式\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"产品类型\", \n" +
                "            \"v\" : \"迷你洗衣机\"\n" +
                "        }\n" +
                "    ], \n" +
                "    \"材质\" : [\n" +
                "        {\n" +
                "            \"k\" : \"箱体材质\", \n" +
                "            \"v\" : \"塑料\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"内桶材质\", \n" +
                "            \"v\" : \"不锈钢\"\n" +
                "        }\n" +
                "    ]\n" +
                "}\n" +
                "{ \n" +
                "    \"_id\" : \"527262311820\", \n" +
                "    \"尺寸规格\" : [\n" +
                "        {\n" +
                "            \"k\" : \"包装尺寸\", \n" +
                "            \"v\" : \"644x639x982mm\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"净重\", \n" +
                "            \"v\" : \"35kg\"\n" +
                "        }\n" +
                "    ], \n" +
                "    \"洗衣机\" : \"1件\", \n" +
                "    \"使用说明书（含保修卡）\" : \"1件\", \n" +
                "    \"进水管\" : \"1件\", \n" +
                "    \"其他参数\" : [\n" +
                "        {\n" +
                "            \"k\" : \"功率\", \n" +
                "            \"v\" : \"390W\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"上市时间\", \n" +
                "            \"v\" : \"2016-2\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"电机类型\", \n" +
                "            \"v\" : \"变频电机\"\n" +
                "        }\n" +
                "    ], \n" +
                "    \"隔音板\" : \"1件\", \n" +
                "    \"洗衣能力\" : [\n" +
                "        {\n" +
                "            \"k\" : \"洗涤公斤量\", \n" +
                "            \"v\" : \"8kg\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"脱水功率\", \n" +
                "            \"v\" : \"390W\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"洗衣程序\", \n" +
                "            \"v\" : \"羊毛洗快洗筒自洁\"\n" +
                "        }\n" +
                "    ], \n" +
                "    \"基本参数\" : [\n" +
                "        {\n" +
                "            \"k\" : \"洗衣机品牌\", \n" +
                "            \"v\" : \"Littleswan/小天鹅\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"智能类型\", \n" +
                "            \"v\" : \"阿里小智\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"能效等级\", \n" +
                "            \"v\" : \"一级\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"使用方式\", \n" +
                "            \"v\" : \"全自动\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"排水方式\", \n" +
                "            \"v\" : \"下排水\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"颜色分类\", \n" +
                "            \"v\" : \"灰色\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"开合方式\", \n" +
                "            \"v\" : \"顶开式\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"产品类型\", \n" +
                "            \"v\" : \"单缸洗衣机\"\n" +
                "        }\n" +
                "    ], \n" +
                "    \"材质\" : [\n" +
                "        {\n" +
                "            \"k\" : \"箱体材质\", \n" +
                "            \"v\" : \"镀锌钢板\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"k\" : \"内桶材质\", \n" +
                "            \"v\" : \"不锈钢\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
//        JSONObject jsonObject = JSONObject.fromObject(str);
//        String temp = jsonObject.
//
//
//    }
//    public List<String> parseIson(String temp){
//        ArrayList<String> list = new ArrayList<>();
//        if(temp.substring(0, 1).equals("[")){
//            temp = temp.substring(1, temp.length() - 1);
//
//            int tag = 0;
//            for(int i = 0; i < temp.length(); i++){
//                if(temp.substring(i,i+1).equals("}")){
//                    list.add(temp.substring(tag, i+1));
//                    while(!temp.substring(i,i+1).equals("{") && i < temp.length()){
//                        i++;
//                        if(i == temp.length())
//                            break;
//                    }
//                    if(i == temp.length())
//                        break;
//                    else{
//                        tag = i;
//                    }
//                }
//            }
//        }else{
//
//        }
    }
}
