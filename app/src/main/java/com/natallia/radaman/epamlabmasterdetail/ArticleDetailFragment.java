package com.natallia.radaman.epamlabmasterdetail;

import android.app.Activity;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.natallia.radaman.epamlabmasterdetail.hardCode.HardCodeContent;

import java.io.File;

/**
 * A fragment representing a single Article detail screen.
 * This fragment is either contained in a {@link ArticleListActivity}
 * in two-pane mode (on tablets) or a {@link ArticleDetailActivity}
 * on handsets.
 */
public class ArticleDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";

    private HardCodeContent.HardCodeItem mItem;

    public ArticleDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = HardCodeContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.article_detail, container, false);
        if (mItem != null) {
            ImageView img = rootView.findViewById(R.id.icon_view);
            if (Integer.valueOf(mItem.id) % 2 == 0)
                img.setImageResource(R.drawable.ic_1);
            else img.setImageResource(R.drawable.ic_2);
            ((TextView) rootView.findViewById(R.id.article_detail)).setText(mItem.details);
        }
        return rootView;
    }
}
