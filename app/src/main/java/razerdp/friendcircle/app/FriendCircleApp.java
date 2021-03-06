package razerdp.friendcircle.app;

import android.app.Application;

import com.razerdp.github.com.common.manager.LocalHostManager;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import razerdp.friendcircle.config.Define;
import razerdp.github.com.lib.api.AppContext;
import razerdp.github.com.lib.manager.localphoto.LocalPhotoManager;

/**
 * Created by 大灯泡 on 2016/10/26.
 * <p>
 * app
 */

public class FriendCircleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.initARouter();
        initBmob();
        initLocalHostInfo();
        LocalPhotoManager.INSTANCE.registerContentObserver(null);
    }

    private void initBmob() {
        BmobConfig config = new BmobConfig.Builder(this)
                //设置appkey
                .setApplicationId(Define.BMOB_APPID)
                //请求超时时间（单位为秒）：默认15s
                .setConnectTimeout(15)
                //文件分片上传时每片的大小（单位字节），默认512*1024
                .setUploadBlockSize(1024 * 1024)
                //文件的过期时间(单位为秒)：默认1800s
                .setFileExpiration(1800)
                .build();
        Bmob.initialize(config);
    }

    private void initLocalHostInfo() {
        LocalHostManager.INSTANCE.init();
    }

}
