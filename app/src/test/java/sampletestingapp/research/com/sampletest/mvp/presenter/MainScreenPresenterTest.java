package sampletestingapp.research.com.sampletest.mvp.presenter;

import android.os.Bundle;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import sampletestingapp.research.com.sampletest.BaseTest;
import sampletestingapp.research.com.sampletest.TestUtils;
import sampletestingapp.research.com.sampletest.mvp.model.IMainScreenModel;
import sampletestingapp.research.com.sampletest.mvp.view.IMainScreenView;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by dima on 10/16/16.
 */
public class MainScreenPresenterTest extends BaseTest {

    private IMainScreenView mView;

    private MainScreenPresenter mPresenter;
    @Captor
    private ArgumentCaptor<Subscription> mCaptor;

    @Inject
    protected IMainScreenModel mModel;

    @Before
    public void setUp() {
        super.setUp();
        mView = mock(IMainScreenView.class);
        mPresenter = new MainScreenPresenter(mView);
        mComponent.inject(this);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return mTestUtils.getItems();
            }
        }).when(mModel).loadData();
    }

    @Test
    public void testOnCreate() throws Exception {
        mPresenter.onCreate(null);
        mPresenter.onDestroy();
        verify(mModel).loadData();
        verify(mView).updateUI(mTestUtils.getItems());
    }

    @Test
    public void testOnSaveInstanceState() throws Exception {
        mPresenter.onCreate(null);
        Bundle b = Bundle.EMPTY;
        mPresenter.onSaveInstanceState(b);
        mPresenter.onDestroy();
        mPresenter.onCreate(b);

        verify(mModel, times(1)).loadData();
        verify(mView, times(2)).updateUI(mTestUtils.getItems());
    }

    @Test
    public void testOnDestroy() throws Exception {
        mPresenter = spy(new MainScreenPresenter(mView));
        mPresenter.onCreate(null);
        mPresenter.onDestroy();
        ArgumentCaptor<Subscription> captor = ArgumentCaptor.forClass(Subscription.class);
        verify(mPresenter).addSubscription(captor.capture());
        List<Subscription> list = captor.getAllValues();
        assertEquals(1, list.size());
        assertTrue(list.get(0).isUnsubscribed());
    }
}