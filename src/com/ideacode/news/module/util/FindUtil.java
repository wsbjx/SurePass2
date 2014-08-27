package com.ideacode.news.module.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.ksoap2.serialization.SoapObject;

import android.content.Context;
import android.util.Log;

import com.ideacode.news.app.AppContext;
import com.ideacode.news.app.AppException;
import com.ideacode.news.bean.Mood;
import com.ideacode.news.bean.Paging;
import com.ideacode.news.common.util.StringUtils;
import com.ideacode.news.net.SoapWebServiceUtil;

public class FindUtil
{
    
    private static final String TAG = "FindUtil";
    
    public static ArrayList<Mood> getPopMoodForList(Context context, Paging p, boolean isRefresh) throws AppException
    {
        ArrayList<Mood> moodList = new ArrayList<Mood>();
        String key = "pop_moodlist_" + p.getPage();
        AppContext appContext = (AppContext) context.getApplicationContext();
        if(appContext.isNetworkConnected() && (!appContext.isReadDataCache(key) || isRefresh))
        {
            HashMap params = new HashMap();
            params.put("maxresult", p.getCount());
            params.put("currentpage", p.getPage());
            
            SoapWebServiceUtil moodSoap = new SoapWebServiceUtil("Find", "getPopMoodForList", params);
            SoapObject soapObject = moodSoap.getRespondData();
            Log.i(TAG, soapObject.toString());
            
            for(int i = 0; i < soapObject.getPropertyCount(); i++)
            {
                Mood mood = new Mood();
                SoapObject childSoapObject = (SoapObject) soapObject.getProperty(i);
                mood.setMoodId(Integer.parseInt(childSoapObject.getPropertyAsString("moodId")));
                mood.setUserId(Long.parseLong(childSoapObject.getPropertyAsString("userId")));
                mood.setUserName(childSoapObject.getPropertyAsString("userName"));
                mood.setMoodContent(childSoapObject.getPropertyAsString("moodContent"));
                mood.setMoodPraiseCount(Integer.parseInt(childSoapObject
                                .getPropertyAsString("moodPrapackage com.ideacode.news.module.util;\n"
                                                + "\n"
                                                + "import java.util.ArrayList;\n"
                                                + "import java.util.HashMap;\n"
                                                + "import java.util.Map;\n"
                                                + "\n"
                                                + "import org.ksoap2.serialization.SoapObject;\n"
                                                + "\n"
                                                + "import android.content.Context;\n"
                                                + "import android.util.Log;\n"
                                                + "\n"
                                                + "import com.ideacode.news.app.AppContext;\n"
                                                + "import com.ideacode.news.app.AppException;\n"
                                                + "import com.ideacode.news.bean.Mood;\n"
                                                + "import com.ideacode.news.bean.Paging;\n"
                                                + "import com.ideacode.news.common.util.StringUtils;\n"
                                                + "import com.ideacode.news.net.SoapWebServiceUtil;\n"
                                                + "\n"
                                                + "public class FindUtil {\n"
                                                + "\n"
                                                + "    private static final String TAG = \"FindUtil\";\n"
                                                + "\n"
                                                + "    public static ArrayList<Mood> getPopMoodForList(Context context, Paging p, boolean isRefresh) throws AppException {\n"
                                                + "        ArrayList<Mood> moodList = new ArrayList<Mood>();\n"
                                                + "        String key = \"pop_moodlist_\" + p.getPage();\n"
                                                + "        AppContext appContext = (AppContext) context.getApplicationContext();\n"
                                                + "        if (appContext.isNetworkConnected() && (!appContext.isReadDataCache(key) || isRefresh)) {\n"
                                                + "            HashMap params = new HashMap();\n"
                                                + "            params.put(\"maxresult\", p.getCount());\n"
                                                + "            params.put(\"currentpage\", p.getPage());\n"
                                                + "\n"
                                                + "            SoapWebServiceUtil moodSoap = new SoapWebServiceUtil(\"Find\", \"getPopMoodForList\", params);\n"
                                                + "            SoapObject soapObject = moodSoap.getRespondData();\n"
                                                + "            Log.i(TAG, soapObject.toString());\n"
                                                + "\n"
                                                + "            for (int i = 0; i < soapObject.getPropertyCount(); i++) {\n"
                                                + "                Mood mood = new Mood();\n"
                                                + "                SoapObject childSoapObject = (SoapObject) soapObject.getProperty(i);\n"
                                                + "                mood.setMoodId(Integer.parseInt(childSoapObject.getPropertyAsString(\"moodId\")));\n"
                                                + "                mood.setUserId(Long.parseLong(childSoapObject.getPropertyAsString(\"userId\")));\n"
                                                + "                mood.setUserName(childSoapObject.getPropertyAsString(\"userName\"));\n"
                                                + "                mood.setMoodContent(childSoapObject.getPropertyAsString(\"moodContent\"));\n"
                                                + "                mood.setMoodPraiseCount(Integer.parseInt(childSoapObject.getPropertyAsString(\"moodPraiseCount\")));\n"
                                                + "                mood.setMoodBelittleCount(Integer.parseInt(childSoapObject.getPropertyAsString(\"moodBelittleCount\")));\n"
                                                + "                mood.setMoodLocation(StringUtils.formatSoapNullString(childSoapObject.getPropertyAsString(\"moodLocation\")));\n"
                                                + "                mood.setMoodCreateDate(StringUtils.formatSoapDateTime(childSoapObject.getPropertyAsString(\"moodCreattime\")));\n"
                                                + "                mood.setHeatFlag(StringUtils.formatBoolean(childSoapObject.getPropertyAsString(\"heatFlag\")));\n"
                                                + "\n"
                                                + "                moodList.add(mood);\n"
                                                + "            }\n"
                                                + "            appContext.saveObject(moodList, key);\n"
                                                + "        } else {\n"
                                                + "            moodList = (ArrayList<Mood>) appContext.readObject(key);\n"
                                                + "            if (moodList == null)\n"
                                                + "                moodList = new ArrayList<Mood>();\n"
                                                + "        }\n"
                                                + "        return moodList;\n"
                                                + "    }\n"
                                                + "\n"
                                                + "    public static ArrayList<Map<String, Object>> getPopFavouriteForList(Context context, Paging p, boolean isRefresh) throws AppException {\n"
                                                + "        ArrayList<Map<String, Object>> favouriteList = new ArrayList<Map<String, Object>>();\n"
                                                + "        String key = \"pop_favouritelist_\" + p.getPage();\n"
                                                + "        AppContext appContext = (AppContext) context.getApplicationContext();\n"
                                                + "        if (appContext.isNetworkConnected() && (!appContext.isReadDataCache(key) || isRefresh)) {\n"
                                                + "            HashMap params = new HashMap();\n"
                                                + "            params.put(\"maxresult\", p.getCount());\n"
                                                + "            params.put(\"currentpage\", p.getPage());\n"
                                                + "            SoapWebServiceUtil favouriteSoap = new SoapWebServiceUtil(\"Find\", \"getPopFavouriteForList\", params);\n"
                                                + "            SoapObject soapObject = favouriteSoap.getRespondData();\n"
                                                + "            Log.i(TAG, soapObject.toString());\n"
                                                + "\n"
                                                + "            for (int i = 0; i < soapObject.getPropertyCount(); i++) {\n"
                                                + "                Map<String, Object> newsTitle = new HashMap<String, Object>();\n"
                                                + "                SoapObject childSoapObject = (SoapObject) soapObject.getProperty(i);\n"
                                                + "                newsTitle.put(\"date\", StringUtils.formatSoapDateTime(childSoapObject.getPropertyAsString(\"favouritelistCreatdate\")));\n"
                                                + "                newsTitle.put(\"url\", childSoapObject.getPropertyAsString(\"favouritelistUrl\"));\n"
                                                + "                newsTitle.put(\"title\", childSoapObject.getPropertyAsString(\"favouritelistTitle\"));\n"
                                                + "                newsTitle.put(\"newsType\", childSoapObject.getPropertyAsString(\"favouritelistNewstype\"));\n"
                                                + "                newsTitle.put(\"heatFlag\", StringUtils.formatBoolean(childSoapObject.getPropertyAsString(\"heatFlag\")));\n"
                                                + "                \n"
                                                + "                favouriteList.add(newsTitle);\n"
                                                + "            }\n"
                                                + "            appContext.saveObject(favouriteList, key);\n"
                                                + "        } else {\n"
                                                + "            favouriteList = (ArrayList<Map<String, Object>>) appContext.readObject(key);\n"
                                                + "            if (favouriteList == null)\n"
                                                + "                favouriteList = new ArrayList<Map<String, Object>>();\n"
                                                + "        }\n" + "        return favouriteList;\n" + "    }\n" + "\n"
                                                + "}\niseCount")));
                mood.setMoodBelittleCount(Integer.parseInt(childSoapObject.getPropertyAsString("moodBelittleCount")));
                mood.setMoodLocation(StringUtils.formatSoapNullString(childSoapObject
                                .getPropertyAsString("moodLocation")));
                mood.setMoodCreateDate(StringUtils.formatSoapDateTime(childSoapObject
                                .getPropertyAsString("moodCreattime")));
                mood.setHeatFlag(StringUtils.formatBoolean(childSoapObject.getPropertyAsString("heatFlag")));
                
                moodList.add(mood);
            }
            appContext.saveObject(moodList, key);
        }
        else
        {
            moodList = (ArrayList<Mood>) appContext.readObject(key);
            if(moodList == null)
                moodList = new ArrayList<Mood>();
        }
        return moodList;
    }
    
    public static ArrayList<Map<String, Object>> getPopFavouriteForList(Context context, Paging p, boolean isRefresh)
                    throws AppException
    {
        ArrayList<Map<String, Object>> favouriteList = new ArrayList<Map<String, Object>>();
        String key = "pop_favouritelist_" + p.getPage();
        AppContext appContext = (AppContext) context.getApplicationContext();
        if(appContext.isNetworkConnected() && (!appContext.isReadDataCache(key) || isRefresh))
        {
            HashMap params = new HashMap();
            params.put("maxresult", p.getCount());
            params.put("currentpage", p.getPage());
            SoapWebServiceUtil favouriteSoap = new SoapWebServiceUtil("Find", "getPopFavouriteForList", params);
            SoapObject soapObject = favouriteSoap.getRespondData();
            Log.i(TAG, soapObject.toString());
            
            for(int i = 0; i < soapObject.getPropertyCount(); i++)
            {
                Map<String, Object> newsTitle = new HashMap<String, Object>();
                SoapObject childSoapObject = (SoapObject) soapObject.getProperty(i);
                newsTitle.put("date", StringUtils.formatSoapDateTime(childSoapObject
                                .getPropertyAsString("favouritelistCreatdate")));
                newsTitle.put("url", childSoapObject.getPropertyAsString("favouritelistUrl"));
                newsTitle.put("title", childSoapObject.getPropertyAsString("favouritelistTitle"));
                newsTitle.put("newsType", childSoapObject.getPropertyAsString("favouritelistNewstype"));
                newsTitle.put("heatFlag", StringUtils.formatBoolean(childSoapObject.getPropertyAsString("heatFlag")));
                
                favouriteList.add(newsTitle);
            }
            appContext.saveObject(favouriteList, key);
        }
        else
        {
            favouriteList = (ArrayList<Map<String, Object>>) appContext.readObject(key);
            if(favouriteList == null)
                favouriteList = new ArrayList<Map<String, Object>>();
        }
        return favouriteList;
    }
    
}
