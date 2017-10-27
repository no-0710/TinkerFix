package com.daspatial.tinkerfix.tinker;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by l.l on 2017/10/27.
 * 自定义的 ApplicationLike
 * DefaultLifeCycle 注解： 生成 Application 类
 */
@DefaultLifeCycle(application = ".MyThinkerApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class CustomTinkerApplicationLike extends ApplicationLike{

    public CustomTinkerApplicationLike(Application application, int tinkerFlags,
                                       boolean tinkerLoadVerifyFlag,
                                       long applicationStartElapsedTime,
                                       long applicationStartMillisTime,
                                       Intent tinkerResultIntent) {

        super(application, tinkerFlags, tinkerLoadVerifyFlag,
                applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);

        // 使应用支持分包
        MultiDex.install(base);
        TinkerManager.installTinker(this);
    }
}
