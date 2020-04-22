package controller;

import com.lutenglong.config.ConsulConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Autowired
    private ConsulConfigInfo consulConfigInfo;

    @RequestMapping("getConfig")
    public Object getConfig(){
        return consulConfigInfo;
    }
}
