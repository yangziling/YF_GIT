package com.yangziling.dialogloding;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * <b>Create Date:</b> 2018/1/2<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b>
 */
public class DialogUtils {

    /**
     * 创建自定义的Dialog
     */
    public static Dialog ShowDialog(Context context){
        /**
         * 加载View
         */
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_dialog, null);
        LinearLayout dialogView = (LinearLayout) view.findViewById(R.id.dialog_view);

        Dialog dialog = new Dialog(context,R.style.myDialogTheme);
        dialog.setContentView(dialogView);//dialog中加载的view示图
        dialog.setCanceledOnTouchOutside(false);


        Window window = dialog.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setGravity(Gravity.CENTER);
        window.setAttributes(layoutParams);
        dialog.show();
        return dialog;
    }

    public static Dialog GildeImage(Context context){

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.gidle_dialog, null);
        LinearLayout dialogView_ll = (LinearLayout) view.findViewById(R.id.gilde_ll);

        Dialog dialog = new Dialog(context,R.style.myDialogTheme);
        dialog.setContentView(dialogView_ll);//dialog中加载的view示图
        dialog.setCanceledOnTouchOutside(false);

        ImageView glide_img = (ImageView) dialog.findViewById(R.id.gilde_img);

        /**
         * gilde直接加载本地GIF图片
         */
//        Glide.with(context).load(R.drawable.loading1).into(glide_img);

        /**
         * gif图渲染完成之前，可以默认一个比较小的图片，但是网络正常时这个等待也就200-300毫秒。
         * 所以可以忽略的，如果网络很差，加载gif图比较慢时 为了友好性 最好加载个本地的图片作为友好提示
         */
        Glide.with(context).load(R.drawable.loading1)
                                .placeholder(R.mipmap.ic_launcher_round).into(glide_img);
        /**
         * 这里可以知行缓存 然后将缓存中的图片数据 添加到glide_img空间中
         */
//        Glide.with(context).load(存放图片的url).diskCacheStrategy(DiskCacheStrategy.ALL).into(glide_img);

        Window window = dialog.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setGravity(Gravity.CENTER);
        window.setAttributes(layoutParams);
        dialog.show();
        return dialog;
    }

    /**
     * 关闭dialog
     * @param mDialogUtils
     */
    public static void closeDialog(Dialog mDialogUtils) {
        if (mDialogUtils != null && mDialogUtils.isShowing()) {
            mDialogUtils.dismiss();
        }
    }

}
