package com.countriesinfo.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel {

    @SerializedName("list")
    private List<Country> list;

    public List<Country> getCountry() {
        return list;
    }

    public ResponseModel setCountry(List<Country> list) {
        this.list = list;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseModel that = (ResponseModel) o;

        return list != null ? list.equals(that.list) : that.list == null;

    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "list=" + list +
                '}';
    }
}