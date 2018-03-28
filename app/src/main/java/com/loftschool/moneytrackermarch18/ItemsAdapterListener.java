package com.loftschool.moneytrackermarch18;

import com.loftschool.moneytrackermarch18.api.Item;

public interface ItemsAdapterListener {
    void onItemClick(Item item, int position);
    void onItemLongLick(Item item, int position);
}
