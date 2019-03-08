package com.example.shop.model;

public interface ILoginModel
{
    public void getLoginModel(String url,NetCallBack netCallBack);
    public interface NetCallBack
    {
        void loadSuccess(Object object);
        void loadFail();
    }
}
