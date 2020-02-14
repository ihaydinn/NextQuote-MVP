package com.ismailhakkiaydin.nextquotemvp;

public interface MainContract {

    interface MainView{

        void showProgress();
        void hideProgress();
        void setQuote(String quote);
    }

    interface Presenter{
        void onButtonClick();
        void onDestroy();

    }

    interface GetQuoteInteractor{

        interface OnFinishedListener{
            void onFinished(String string);
        }
        void getNextQuote(OnFinishedListener onFinishedListener);
    }

}
