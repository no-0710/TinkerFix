package com.daspatial.tinkerfix.tinker;

import android.content.Context;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * Created by l.l on 2017/10/27.
 * 对Tinker的所有 api 封装
 *
 */

public class TinkerManager {
    private static boolean isInstalled = false;
    private static ApplicationLike mAppLike;

    /**
     * 外部调用，完成初始化
     * @param applicationLike ApplicationLike
     */
    public static void installTinker(ApplicationLike applicationLike){
        mAppLike = applicationLike;
        if (isInstalled)
            return;

        TinkerInstaller.install(mAppLike);
        isInstalled = true;
    }

    public static void loadPatch(String path){
        if (Tinker.isTinkerInstalled()){
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), path);
        }
    }

    private static Context getApplicationContext(){
        if (mAppLike != null){
            return mAppLike.getApplication().getApplicationContext();
        }else{
            return null;
        }
    }

}
