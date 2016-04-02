package com.sfwr.eng.a04.parkfinder.blackboard;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by robert on 01-Apr-16.
 */
public interface ExpertView{
    public void setFinishListener(View.OnClickListener listener);

    public void removeFinishListener(View.OnClickListener listener);

    public void startNewCriteria();

    public void modifyCriteria();

}
