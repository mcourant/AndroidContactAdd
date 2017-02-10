package com.example.maximecours.mescontact.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by Rweisha-PC on 10/02/2017.
 */

public class ItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private PeopleAdapter mAdapter;

    public ItemTouchHelperCallback(PeopleAdapter mAdapter){
        this.mAdapter = mAdapter;
    }

    @Override
    public boolean isLongPressDragEnabled(){return false;}

    @Override
    public boolean isItemViewSwipeEnabled(){return true;}

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

        int dragFlagsUpDown = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int dragFlagsLeftRight = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlagsUpDown, dragFlagsLeftRight);

    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }
}
