package cn.maitian.model;

public class DataResponse<D> extends BaseResponse {
    public D data;

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}