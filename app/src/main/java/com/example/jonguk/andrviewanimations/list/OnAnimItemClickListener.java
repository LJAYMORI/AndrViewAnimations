package com.example.jonguk.andrviewanimations.list;

/**
 * Created by Jonguk on 2017. 3. 14..
 */

public interface OnAnimItemClickListener {
    void onClickRemove(long id);
    void onClickAdd(int insertPosition);
    void onClickItem(long id);
}
