package sampletestingapp.research.com.sampletest.mvp.presenter;

import android.os.Bundle;

/**
 * Created by dima on 10/16/16.
 */
public interface IMainScreenPresenter {

    void onCreate(Bundle saveInstanceState);

    void onSaveInstanceState(Bundle saveInstanceState);

    void onDestroy();

}
