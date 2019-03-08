package com.example.shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.img)
    WebView img;
    @BindView(R.id.share)
    Button share;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String screen_name = intent.getStringExtra("screen_name");
        String profile_image_url = intent.getStringExtra("profile_image_url");
        name.setText(screen_name);
        img.loadUrl(profile_image_url);


        final UMImage image = new UMImage(HomeActivity.this, "http://b.hiphotos.baidu.com/zhidao/pic/item/63d9f2d3572c11df28e42e30602762d0f703c2e8.jpg");//网络图片
        final UMImage imagelocal = new UMImage(this, R.mipmap.ic_launcher);
        imagelocal.setThumb(new UMImage(this, R.mipmap.ic_launcher));
        imagelocal.setTitle("易宸锋好帅");

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "点了了", Toast.LENGTH_SHORT).show();

                new ShareAction(HomeActivity.this).setPlatform(SHARE_MEDIA.QQ)
                        .withText("hello")
                        .withMedia(new UMImage(HomeActivity.this,R.mipmap.ic_launcher))
                        .setCallback(shareListener)
                        .share();

            }
        });
    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(HomeActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(HomeActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(HomeActivity.this, "取消                                          了", Toast.LENGTH_LONG).show();

        }
    };
}
