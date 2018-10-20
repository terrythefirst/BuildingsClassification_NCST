package terry.com.buildingsclassification_ncst.MapContents;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.graphics.Point;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapBitmapsConstant {
    public static boolean loaded = false;

    public static int mapWidth=871;
    public static int mapHeight=998;
    public static int cols = 6;
    public static int rows = 6;
    public static int wholeMapWidth = mapWidth*cols;
    public static int wholeMapHeight = mapHeight*rows;
    public static ArrayList<Bitmap> bitmaps = new ArrayList<>();
    public static ArrayList<int[]> districtPolygons = new ArrayList<>();
    public static Map<String,Integer> districtCodeMap  = new HashMap<>();
    public static int[] districtCentralPoints;
    public static String[] districtNames = {
            "图书馆","科技楼和行政楼","大会堂",
            "核心教学区",
            "冀唐学院",
            "食堂",
            "游泳馆","校园湿地","东体育场入口","体育馆",
            "学术交流中心","南门","西南门",
            "大学生服务中心"
    };
    public static String[] districtCodes = {
            "LIB","FB","MB",
            "CTA",
            "JT",
            "CT",
            "SWB","WL","PEPE","PEB",
            "ACC","SG","SWG","SSC"
    };

    static {
        for(int i=0;i<districtCodes.length;i++)
            districtCodeMap.put(districtCodes[i],i);
        for(int i=0;i<districtCodes.length;i++)
            Log.e("Constant",districtCodes[i]+districtCodeMap.get(districtCodes[i])) ;
        districtPolygons.add( new int[]{//lib
//               2336,4508,
//                2467,4506,
//                2712,4467,
//                2951,4506,
//                3087,4521,
//                3088,4594,
//                3044,4794,
//                2831,4842,
//                2590,4845,
//                2378,4797,
//                2334,4589
                2322,4485,
                3090,4485,
                3090,4797,
                2322,4797
        });
        districtPolygons.add(new int[]{//科技楼
                2203,5369,
                2469,5369,
                2469,5616,
                2203,5616,
                -1,
                2957,5376,//行政楼
                3217,5376,
                3217,5617,
                2957,5617
        });
        districtPolygons.add(new int[]{//大会堂
                2551,2592,
                2842,2592,
                2842,2877,
                2551,2877
        });
        districtPolygons.add(new int[]{//核心教学区
                2307,3044,
                3128,3044,
                3128,4171,
                2307,4171
        });
//        districtPolygons.add(new int[]{//A
//                2348,3662,
//                2628,3662,
//                2628,3867,
//                2348,3867
//        });
//        districtPolygons.add(new int[]{//B
//                2801,3663,
//                3038,3663,
//                3038,3863,
//                2801,3863
//        });
//        districtPolygons.add(new int[]{//C
//                2359,3350,
//                2629,3350,
//                2629,3553,
//                2359,3553
//        });
//        districtPolygons.add(new int[]{//D
//                2798,3352,
//                3058,3352,
//                3058,3546,
//                2798,3546
//        });
//        districtPolygons.add(new int[]{//E
//                2319,3054,
//                2620,3054,
//                2620,3277,
//                2319,3277
//        });
//        districtPolygons.add(new int[]{//L
//                2789,3058,
//                3094,3058,
//                3094,3270,
//                2789,3270
//        });
//        districtPolygons.add(new int[]{//K
//                2324,3939,
//                2627,3939,
//                2627,4170,
//                2324,4170
//        });
//        districtPolygons.add(new int[]{//F
//                2792,3944,
//                3097,3944,
//                3097,4170,
//                2792,4170
//        });
        districtPolygons.add(new int[]{//冀唐
                875,2489,
                1691,2190,
                1921,2472,
                1925,2725,
                885,2718
        });
        districtPolygons.add(new int[]{//梅
                3497,4308,
                3790,4308,
                3790,4551,
                3497,4551,
                -1,//兰
                1677,4300,
                1920,4300,
                1920,4559,
                1677,4559,
                -1,//竹
                1503,2968,
                1693,2968,
                1693,3255,
                1503,3255,
                -1,//菊
                3471,2577,
                3877,2577,
                3877,2802,
                3471,2802
        });
        districtPolygons.add(new int[]{//游泳馆
                405,5244,
                648,5244,
                648,5442,
                405,5442
        });
        districtPolygons.add(new int[]{//湿地
                1840,1907,
                3161,1131,
                3376,1721,
                3375,2434,
                2731,2229,
                2063,2776,
                1775,2265
        });
        districtPolygons.add(new int[]{//东运口
                4570,3360,
                4672,3360,
                4672,3861,
                4570,3861
        });
        districtPolygons.add(new int[]{//体育馆
                4773,5097,
                4956,5227,
                4892,5490,
                4699,5366
        });
        districtPolygons.add(new int[]{//学术交流
                264,5523,
                559,5523,
                559,5621,
                264,5621
        });
        districtPolygons.add(new int[]{//南门
                2477,5725,
                2951,5725,
                2951,5863,
                2477,5863
        });
        districtPolygons.add(new int[]{//西南门
                34,4452,
                208,4452,
                208,4652,
                24,4652
        });
        districtPolygons.add(new int[]{//大学生服务中心
                1497,3385,//西大服
                1705,3385,
                1705,3556,
                1497,3556,
                -1,//东大服
                4059,3396,
                4271,3396,
                4271,3565,
                4059,3565
        });


        //中心点便于聚焦
        districtCentralPoints = new int[]{
            2715,4625,
                2378,5488,
                //3092,5487,
                2709,2709,
                2710,3622,
//                2513,3776,
//                2933,3769,
//                2495,3460,
//                2933,3451,
//                2433,3151,
//                2983,3167,
//                2501,4048,
//                2933,4058,

                1458,2569,
//                3645,4446,
//                1810,4437,
//                1605,3059,
                3646,2679,
                519,5317,
                2688,1970,
                4627,3619,
                4837,5301,
                436,5578,
                2711,5842,
                77,4555,
                1595,3464,
                //4154,3470
        };
    }
    public static Path getPath(int district,int offsetX,int offsetY){
        Path path = new Path();

        int[] coor = districtPolygons.get(district);
        path.moveTo(coor[0]+offsetX,coor[1]+offsetY);
        int firstMoveToPointX = coor[0]+offsetX,firstMoveToPointY = coor[1]+offsetY;
        for(int i=2;i<coor.length;i+=2){
            if(coor[i]==-1){
                path.lineTo(firstMoveToPointX,firstMoveToPointY);
                i++;
                path.moveTo(coor[i]+offsetX,coor[i+1]+offsetY);
                firstMoveToPointX = coor[i]+offsetX;
                firstMoveToPointY = coor[i+1]+offsetY;
                continue;
            }
            path.lineTo(coor[i]+offsetX,coor[i+1]+offsetY);
        }
        path.lineTo(firstMoveToPointX,firstMoveToPointY);
        return path;
    }
    public static Point getCentralPoint(int district){
        return new Point(districtCentralPoints[district*2],districtCentralPoints[district*2+1]);
    }
    public static void load_bitmaps(Context context) throws IOException{
        if(loaded)return;
        AssetManager am = context.getResources().getAssets();

        for(int i=1;i<=36;i++){
            try {
                InputStream is = am.open("map_fragments/ncst_part_map_"+i+".jpg");
                Bitmap temp = BitmapFactory.decodeStream(is);
                Log.i("load_bitmaps",""+i+" width:"+temp.getWidth()+" height:"+temp.getHeight());
                bitmaps.add(temp);
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }
        loaded = true;
    }
}
