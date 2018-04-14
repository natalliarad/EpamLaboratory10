package com.natallia.radaman.epamlabmasterdetail.hardCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content.
 */
public class HardCodeContent {

    public static final List<HardCodeItem> ITEMS = new ArrayList<HardCodeItem>();
    public static final Map<String, HardCodeItem> ITEM_MAP = new HashMap<String, HardCodeItem>();
    private static final int COUNT_ITEMS = 20;

    static {
        for (int i = 1; i <= COUNT_ITEMS; i++) {
            addItem(createHardCodeItem(i));
        }
    }

    private static void addItem(HardCodeItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static HardCodeItem createHardCodeItem(int position) {
        return new HardCodeItem(String.valueOf(position), "Item " + position, moreDetails
                (position), "ic_" + iconId(position) + ".xml");
    }

    private static String moreDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about selected item: \n").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details is presented here. And there. And anywhere.\n");
        }
        return builder.toString();
    }

    private static int iconId(int position) {
        if (COUNT_ITEMS % position > 7) {
            return 1;
        }
        return 2;
    }

    /**
     * A hard code item representing a piece of content.
     */
    public static class HardCodeItem {
        public final String id;
        public final String content;
        public final String details;
        public final String icon;

        public HardCodeItem(String id, String content, String details, String icon) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.icon = icon;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
