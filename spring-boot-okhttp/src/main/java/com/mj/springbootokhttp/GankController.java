package com.mj.springbootokhttp;

import okhttp3.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GankController {

    OkHttpClient client = new OkHttpClient();

    @RequestMapping("/gank")
    public Object getGank() throws IOException {
        String url = "http://gank.io/api/data/Android/10/1";

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
