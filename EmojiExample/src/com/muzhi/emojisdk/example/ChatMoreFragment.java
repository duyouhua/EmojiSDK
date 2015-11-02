package com.muzhi.emojisdk.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.kymjs.kjframe.ui.SupportFragment;

import com.muzhi.emojisdk.utils.OnOperationListener;

/**
 * 聊天键盘功能界面
 *
 * @author jazzy
 */
public class ChatMoreFragment extends SupportFragment {

    private LinearLayout layout_image;
    private LinearLayout layout_photo;

    private OnOperationListener listener;

    @Override
    protected View inflaterView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = View.inflate(getActivity(), R.layout.chat_item_menu, null);
        return view;
    }

    @Override
    protected void initWidget(View parentView) {
        super.initWidget(parentView);
        layout_image = (LinearLayout) parentView.findViewById(R.id.chat_menu_images);
        layout_photo = (LinearLayout) parentView.findViewById(R.id.chat_menu_photo);

        layout_image.setOnClickListener(this);
        layout_photo.setOnClickListener(this);
    }

    public void setOnOperationListener(OnOperationListener onOperationListener) {
        this.listener = onOperationListener;
    }

    @Override
    protected void widgetClick(View v) {
        super.widgetClick(v);
        if (v == layout_image) {
            clickMenu(0);
        } else if (v == layout_photo) {
            clickMenu(1);
        }
    }

    private void clickMenu(int i) {
        if (listener != null) {
            listener.selectedFunction(i);
        }
    }
}
