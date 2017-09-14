package com.donatenaccept.dna.retrofit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.donatenaccept.dna._history.ResponseModelBloodHistory;
import com.donatenaccept.dna._memories.AddMemoryActivity;
import com.donatenaccept.dna._memories.ResponseModelAddMemory;
import com.donatenaccept.dna._memories.ResponseModelMemories;
import com.donatenaccept.dna._notifications.NotificationFragment;
import com.donatenaccept.dna._notifications.ResponseModelNotification;
import com.donatenaccept.dna.login.ModelRegistration;
import com.donatenaccept.dna.login.ModelRegistrationMain;
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

            RetrofitClient.getClient().signUpApi(Constants.token,
                    Constants.methodNameSignUp,
                    modelRegistration.getFull_name(),
                    modelRegistration.getUser_mobile(),
                    modelRegistration.getUser_email(),
                    modelRegistration.getPassword(),
                    modelRegistration.getUser_age(),
                    modelRegistration.getUser_blood_group_id(),
                    modelRegistration.getUser_lat(),
                    modelRegistration.getUser_long(),
                    modelRegistration.getRegistration_type(),
                    modelRegistration.getDevice_type(),
                    modelRegistration.getDevice_token()
            )
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ModelRegistrationMain>() {
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
                        public void onNext(ModelRegistrationMain modelResponseMain) {
                            progressDialog.dismiss();
                            mlistener._onNext(modelResponseMain);
                        }
                    });
        }
    }


    public void loginApi(final Activity mActivity, ResponseListener _mlistener, String userName, String password, String registrationType) {
        this.mlistener = _mlistener;
        if (Utility.isInternetConnected(mActivity)) {
            final ProgressDialog progressDialog = new ProgressDialog(mActivity);
            progressDialog.setMessage("Please Wait");
            progressDialog.show();

            RetrofitClient.getClient().loginApi(Constants.token,
                    Constants.methodNameLogin,
                    userName,
                    password,
                    registrationType
            )
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ModelRegistrationMain>() {
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
                        public void onNext(ModelRegistrationMain modelResponseMain) {
                            progressDialog.dismiss();
                            mlistener._onNext(modelResponseMain);
                        }
                    });
        }
    }

    public void getMemoriesApi(final Activity mActivity, ResponseListener _mlistener, String userId) {
        this.mlistener = _mlistener;
        if (Utility.isInternetConnected(mActivity)) {


            RetrofitClient.getClient().getMemoriesApi(Constants.token,
                    Constants.methodNameGetMemories,
                    userId
            )
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ResponseModelMemories>() {
                        @Override
                        public void onCompleted() {
                            Log.e("response", "");
                            mlistener._onCompleted();
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("response", "");
                            mlistener._onError(e);
                        }

                        @Override
                        public void onNext(ResponseModelMemories responseModelMemories) {
                            mlistener._onNext(responseModelMemories);
                        }
                    });
        }
    }

    public void addMemoriesApi(final Activity mActivity, ResponseListener _mlistener, String receiverId, String donorId, String image, String description) {
        this.mlistener = _mlistener;
        if (Utility.isInternetConnected(mActivity)) {


            RetrofitClient.getClient().addMemoriesApi(Constants.token,
                    Constants.methodNameAddMemories,
                    receiverId,
                    donorId,
                    image,
                    description

            )
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ResponseModelAddMemory>() {
                        @Override
                        public void onCompleted() {
                            Log.e("response", "");
                            mlistener._onCompleted();
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("response", "");
                            mlistener._onError(e);
                        }

                        @Override
                        public void onNext(ResponseModelAddMemory ResponseModelMemoriesData) {
                            mlistener._onNext(ResponseModelMemoriesData);
                        }
                    });
        }
    }


    public void getHistoryApi(final Activity mActivity, ResponseListener _mlistener, String userId) {
        this.mlistener = _mlistener;
        if (Utility.isInternetConnected(mActivity)) {


            RetrofitClient.getClient().getHistoryApi(Constants.token,
                    Constants.methodNameGetHistory,
                    userId
            )
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ResponseModelBloodHistory>() {
                        @Override
                        public void onCompleted() {
                            Log.e("response", "");
                            mlistener._onCompleted();
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("response", "");
                            mlistener._onError(e);
                        }

                        @Override
                        public void onNext(ResponseModelBloodHistory responseModelBloodHistory) {
                            mlistener._onNext(responseModelBloodHistory);
                        }
                    });
        }
    }

    public void getNotificationsApi(final Activity mActivity, ResponseListener _mlistener, String userId) {
        this.mlistener = _mlistener;
        if (Utility.isInternetConnected(mActivity)) {

            RetrofitClient.getClient().getNotificationsApi(Constants.token,
                    Constants.methodNameGetNotifications,
                    userId
            )
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ResponseModelNotification>() {
                        @Override
                        public void onCompleted() {
                            Log.e("response", "");
                            mlistener._onCompleted();
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("response", "");
                            mlistener._onError(e);
                        }

                        @Override
                        public void onNext(ResponseModelNotification responseModelNotification) {
                            mlistener._onNext(responseModelNotification);
                        }
                    });
        }
    }


}
