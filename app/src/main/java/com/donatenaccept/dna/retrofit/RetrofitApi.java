package com.donatenaccept.dna.retrofit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;

import com.donatenaccept.dna.login.ModelRegistration;
import com.donatenaccept.dna.utils.Constants;
import com.donatenaccept.dna.utils.Utility;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by abhishekagarwal on 3/21/17.
 */

public class RetrofitApi {

    private ProgressDialog mProgressDialog;
    private static RetrofitApi retrofitApi = null;
    private ResponseListener mlistener;

    public static RetrofitApi getInstance() {

        if (retrofitApi != null)
            return retrofitApi;
        else
            return new RetrofitApi();
    }

    public interface ResponseListener {

        void _onNext(Object obj);

        void _onCompleted();

        void _onError(Throwable e);

    }


    // --------------------- Retrofit Api Methods ----------------------------------------------------------


    //----------------------------- Logout Api ----------------------------------

    public void signUpApi(final Activity mActivity, ResponseListener _mlistener, ModelRegistration modelRegistration) {
        this.mlistener = _mlistener;
        if (Utility.isInternetConnected(mActivity)) {
            final ProgressDialog progressDialog = new ProgressDialog(mActivity);
            progressDialog.setMessage("Please Wait");
            progressDialog.show();

            RetrofitClient.getClient().signUpApi(modelRegistration)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ModelResponseMain>() {
                        @Override
                        public void onCompleted() {
                            Log.e("response", "");
                            progressDialog.dismiss();
                            mlistener._onCompleted();
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("response", "");
                            progressDialog.dismiss();
                            mlistener._onError(e);
                        }

                        @Override
                        public void onNext(ModelResponseMain modelResponseMain) {
                            progressDialog.dismiss();
                            mlistener._onNext(modelResponseMain);
                        }
                    });
        }
    }
}
