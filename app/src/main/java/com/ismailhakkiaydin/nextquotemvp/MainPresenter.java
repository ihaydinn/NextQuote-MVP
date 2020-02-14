package com.ismailhakkiaydin.nextquotemvp;

public class MainPresenter implements MainContract.Presenter, MainContract.GetQuoteInteractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetQuoteInteractor getQuoteInteractor;

    public MainPresenter(MainContract.MainView mainView, MainContract.GetQuoteInteractor getQuoteInteractor) {
        this.mainView = mainView;
        this.getQuoteInteractor = getQuoteInteractor;
    }

    @Override
    public void onButtonClick() {

        if (mainView != null) {
            mainView.showProgress();
        }
        getQuoteInteractor.getNextQuote(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onFinished(String string) {
        if (mainView != null){
            mainView.setQuote(string);
            mainView.hideProgress();
        }

    }
}
